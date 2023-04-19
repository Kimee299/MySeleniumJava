package basicweb;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class BrokenLink {

	public static void main(String[] args) throws MalformedURLException, IOException {
		// init
		System.setProperty("webdriver.chrome.driver", "E:\\sourcecode\\drivers\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		// do action
		WebElement footer = driver.findElement(By.xpath("//div[@id=\"gf-BIG\"]"));
		
		List<WebElement> links = footer.findElements(By.tagName("a"));
		SoftAssert a = new SoftAssert();
//		int k = 1;
//		for(int i=0;i<links.size();i++) {
//			String tmp = links.get(i).getAttribute("href");
		for (WebElement link : links) {
//			System.out.print((i+1)+": "+links.get(i).getText()+": ");
//			System.out.println(links.get(i).getAttribute("href"));
			
//			String context = links.get(i).getText();
//			String link = links.get(i).getAttribute("href");
			
			//detect broken link by status code
			HttpURLConnection conn = (HttpURLConnection) new URL(link.getAttribute("href")).openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			int resCode = conn.getResponseCode();
			Assert.assertTrue(resCode < 400, link.getText() +": "+ link.getAttribute("href")+" ("+resCode+")" );
			
//			if (conn.getResponseCode() > 400) {
//				System.out.print("NG "+(i+1)+ "/ " +links.get(i).getText() + " : ");
//				System.out.println(links.get(i).getAttribute("href")+" ("+conn.getResponseCode()+")");
				
//			};
//			else{
//				System.out.print("OK "+(i+1)+ "/ " +links.get(i).getText() + " : ");
//				System.out.println(links.get(i).getAttribute("href")+" ("+conn.getResponseCode()+")");
//			};
		};
		a.assertAll();
		
		driver.quit();
	}

}
