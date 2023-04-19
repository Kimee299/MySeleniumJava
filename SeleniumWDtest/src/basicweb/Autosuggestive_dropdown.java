package basicweb;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class Autosuggestive_dropdown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		//Create a map to store  preferences 
		System.setProperty("webdriver.chrome.driver", "E:\\sourcecode\\drivers\\chromedriver.exe");
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("profile.default_content_setting_values.notifications", 1);
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		// set ExperimentalOption-prefs 
		options.setExperimentalOption("prefs", prefs);
		
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://www.bachhoaxanh.com/");
		WebElement search_input = driver.findElement(By.id("text-search"));
		search_input.sendKeys("milo");
		search_input.sendKeys(Keys.ENTER);
//		WebElement search_btn = driver.findElement(By.xpath("(//button[@type='submit'])[1]"));
		Assert.assertFalse(true);
		
		
	}

}
