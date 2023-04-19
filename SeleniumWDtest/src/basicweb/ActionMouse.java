package basicweb;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class ActionMouse {

	public static void main(String[] args) {
		// init
		System.setProperty("webdriver.chrome.driver", "E:\\sourcecode\\drivers\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://www.amazon.com/");
		
		//do action
		Actions action = new Actions(driver);
		WebElement language_btn = driver.findElement(By.id("icp-nav-flyout"));
		action.moveToElement(language_btn).build().perform();
		WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
		action.moveToElement(searchBox).click().keyDown(Keys.SHIFT).sendKeys("Hello kitty");
//		action.moveToElement(searchBox).doubleClick().build().perform();
//		searchBox.sendKeys("HELLO KITTY");
		action.moveToElement(searchBox).contextClick().build().perform();
		
		
		
		
	}

}
