package basicweb;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class ScrollingGrid {

	public static void main(String[] args) throws InterruptedException {
		// init
		System.setProperty("webdriver.chrome.driver", "E:\\sourcecode\\drivers\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		// do action
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(3000);
		js.executeScript(
				"document.querySelector('.tableFixHead').scrollTop = document.querySelector('.tableFixHead').scrollHeight");

		// print th
		List<WebElement> ths = driver.findElements(By.xpath("//div[@class=\"tableFixHead\"]//th"));
		for (int i = 0; i < ths.size(); i++) {
//			System.out.println((i+1)+": "+ths.get(i).getText());
			if (i == ths.size() - 1) {
				System.out.println((ths.get(i).getText()));
				break;
			}
			;
			System.out.print((ths.get(i).getText() + " | "));
		}
		;
		System.out.println("=================================");
		
		// print td
		List<WebElement> trs = driver.findElements(By.xpath("//div[@class=\"tableFixHead\"]//tbody/tr")); // 9tr
		int index = 1;
		for (int j = 0; j < trs.size(); j++) {
			List<WebElement> tds = driver
					.findElements(By.xpath("//div[@class=\"tableFixHead\"]//tbody/tr[" + (j + 1) + "]/td")); // 4td
			System.out.print(index + ": ");
			for (int k = 0; k < tds.size(); k++) {
				if (k == tds.size() - 1) {
					System.out.println(tds.get(k).getText());
					
					break;
				};
				System.out.print(tds.get(k).getText() + " | ");
			};
			index++;
		};
		
		//print sum Amount
		int total = 0;
		List<WebElement> amount_td = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
		for(int i=0;i<amount_td.size();i++) {
			total = total + Integer.parseInt(amount_td.get(i).getText());
		};
		System.out.println(total);
		
		//compare with text string
		String total_text = driver.findElement(By.xpath("//div[@class=\"totalAmount\"]")).getText();
//		if(total == Integer.parseInt(total_text.split(":")[1].trim())) {
//			System.out.println("test OK");
//		}else{
//			System.out.println("test NG");
//		};
		Assert.assertEquals(Integer.parseInt(total_text.split(":")[1].trim()), total);
		
		driver.quit();
	}

}
