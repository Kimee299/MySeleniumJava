package basicweb;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.asynchttpclient.util.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class CountLinks {

	public static void main(String[] args) throws InterruptedException {
		// init
		System.setProperty("webdriver.chrome.driver", "E:\\sourcecode\\drivers\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		// do action
		WebElement footer = driver.findElement(By.id("gf-BIG"));
//		List<WebElement> pr_links = footer.findElements(By.cssSelector("a"));
//		for(int i=0; i<pr_links.size();i++) {
//			System.out.print(i+1 +": ");
//			System.out.println(pr_links.get(i).getText());
//		}

		List<WebElement> h3 = driver.findElements(By.xpath("//div[@id=\"gf-BIG\"]/table/tbody/tr/td//h3"));

//		print out all a tagname in footer
//		for (int i = 0; i < h3.size(); i++) {
//			System.out.print(i + 1 + ": ");
//			System.out.println(h3.get(i).getText());
//			List<WebElement> li = driver
//					.findElements(By.xpath("//div[@id=\"gf-BIG\"]/table/tbody/tr/td[" + (i + 1) + "]//li"));
//			for (int j = 0; j < li.size(); j++) {
//				if (j == 0)
//					continue;
//				System.out.print((i + 1) + "-" + j + ": ");
//				System.out.println(li.get(j).getText());
//			}
//			System.out.println("=======");
//		}
		
//		click on each link and check if its opening?
		List<WebElement> links = footer.findElements(By.tagName("a"));
		int k = 1;
		for(int i=0;i<links.size();i++) {
			String tmp = links.get(i).getAttribute("href");
			if (tmp.equalsIgnoreCase("https://rahulshettyacademy.com/AutomationPractice/#")){
				continue;
			}
//					tmp == "https://rahulshettyacademy.com/AutomationPractice/#") {
//				};
			System.out.print((i+1)+": "+links.get(i).getText()+": ");
			System.out.println(links.get(i).getAttribute("href"));
			
			String newTabs = Keys.chord(Keys.CONTROL,Keys.ENTER);
			links.get(i).sendKeys(newTabs);			
//			Thread.sleep(3000);
		};
//		Set<String> windows = driver.getWindowHandles();
//		Iterator<String> it = windows.iterator();
//		String parent = it.next();
//		while (it.hasNext()) {
//			driver.switchTo().window(it.next());
//			System.out.print(k+":"+ driver.getTitle()+": ");
//			System.out.println(driver.getCurrentUrl());			
//			k++;
//			driver.close();
//			driver.switchTo().window(parent);
//		};
//		System.out.println("========");
//		System.out.println();
		
//		driver.quit();
	}

}
