package basicweb;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WindowHandle {

	public static void main(String[] args) {
		// init
		System.setProperty("webdriver.chrome.driver", "E:\\sourcecode\\drivers\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://rahulshettyacademy.com/loginpagePractise/#");

		//do action
		WebElement link = driver.findElement(By.className("blinkingText"));
		link.click();
		Set<String> windows = driver.getWindowHandles(); //[parentID, childID]
		Iterator<String> it = windows.iterator();
		String parentID = it.next();
		String childID = it.next();
		driver.switchTo().window(childID);
		//System.out.println(driver.findElement(By.xpath("//p[@class=\"im-para red\"]")).getText());
		String email = driver.findElement(By.xpath("//p[@class=\"im-para red\"]")).getText().split("at")[1].trim().split(" ")[0];
		//System.out.println(email);
		driver.switchTo().window(parentID);
		driver.findElement(By.xpath("//input[@id=\"username\"]")).sendKeys(email);

	}
}

