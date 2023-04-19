package basicweb;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.apache.commons.io.FileUtils;

public class HandleHTTPS {

	public static void main(String[] args) throws Exception {
		// init
		System.setProperty("webdriver.chrome.driver", "E:\\sourcecode\\drivers\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.setAcceptInsecureCerts(true);
//		options.addExtensions(null);
		Proxy proxy = new Proxy();
		proxy.setHttpProxy("ipadress:4444");
		options.setCapability("proxy", proxy);
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://expired.badssl.com/");
//		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
//		driver.manage().window().maximize();
//		driver.manage().deleteAllCookies();
		// do action
		System.out.println(driver.getTitle());
		int index = 1;
		//take screenshots
		TakeSnapShot.takeSnapShot(driver,"C:\\Users\\DELL\\Pictures\\selenium_image\\evidence"+index+".png");
		
		driver.quit();
	}

}
