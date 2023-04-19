package basicweb;

import org.testng.Assert;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxDriverLogLevel;
import org.openqa.selenium.firefox.FirefoxOptions;

public class MyFirstClass {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "E:\\sourcecode\\drivers\\chromedriver.exe");
		//WebDriver driver = new ChromeDriver();
		//Create a map to store  preferences 
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("profile.default_content_setting_values.notifications", 1);
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		// set ExperimentalOption - prefs 
		options.setExperimentalOption("prefs", prefs);
		
		ChromeDriver driver = new ChromeDriver(options);
		//driver.get("https://www.google.com/");
		
		//implicit wait 2s
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		
		driver.get("https://vi-vn.facebook.com/");
		driver.findElement(By.id("email")).sendKeys("abc@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("123456");
		driver.findElement(By.name("login")).click();
		//System.out.println(driver.findElement(By.className("_9ay7")).getText());
		//driver.findElement(By.cssSelector("div._97w3")).click();
		
		//driver.findElement(By.linkText("Quên mật khẩu?")).click();
		//driver.findElement(By.xpath("//div[@class='_9ay7']//a[contains(text(),'Quên mật khẩu?')]")).click();
		//driver.findElement(By.id("identify_email")).sendKeys("abc@gmail.com");
		//driver.findElement(By.id("did_submit")).click();
		
		//cssSelector
		//driver.findElement(By.cssSelector("input[type='text']:nth-child(2)"));
		Assert.assertEquals(driver.findElement(By.className("_9ay7")).getText(),"Mật khẩu bạn đã nhập không chính xác. Quên mật khẩu?");
		
		/*parsing pw from text (use split())
		 * String textSP = "pw is 'Abc123'";
		 * System.out.println(textSP.split("'")[1].split("'")[0]);
		 */
		driver.manage().window().maximize();
		driver.navigate().to("https://google.com");
		Thread.sleep(2000);
		//driver.manage().window().minimize();
		driver.navigate().back();
		Thread.sleep(3000);
		driver.navigate().forward();
		
//		Thread.sleep(3000);
//		driver.close();
	}

}