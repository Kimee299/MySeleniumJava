package basicweb;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.locators.RelativeLocator;

public class RelativeLocation {

	public static void main(String[] args) throws Exception {
		// init
		System.setProperty("webdriver.chrome.driver", "E:\\sourcecode\\drivers\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		// relative location
//		driver.get("https://vi-vn.facebook.com/");
//		WebElement email = driver.findElement(By.xpath("//input[@id=\"email\"]"));
//		driver.findElement(RelativeLocator.with(By.tagName("input")).below(email)).sendKeys("12345");

		// invoke multi windows/tabs
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
//		driver.switchTo().newWindow(WindowType.WINDOW);
		WebElement obj = driver.findElement(By.xpath("//div[@id=\"checkbox-example\"]//fieldset"));
		String filename1 = obj.getAttribute("class").split(" ")[0];
		if (filename1.trim().length() == 0) {
			filename1 = obj.getTagName();
		}
		;
		String filename = driver.getTitle() + "_" + filename1;

		// partial screenshot
		File srcFile = obj.getScreenshotAs(OutputType.FILE);
		File desc = new File("C:\\Users\\DELL\\Pictures\\selenium_image\\" + filename + ".png");
		FileUtils.copyFile(srcFile, desc);

		driver.quit();
	}

}
