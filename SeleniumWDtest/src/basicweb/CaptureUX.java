package basicweb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CaptureUX {

	public static void main(String[] args) {
		// init
		System.setProperty("webdriver.chrome.driver", "E:\\sourcecode\\drivers\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		
		//capture height
		WebElement logo = driver.findElement(By.xpath("//img[@class=\"logoClass\"]"));
		long height = logo.getRect().getDimension().getHeight();
		System.out.println("height: "+height);
		long width = logo.getRect().getDimension().getWidth();
		System.out.println("width: "+width);
		long X = logo.getRect().getX();
		System.out.println("X: "+X);
		long Y = logo.getRect().getY();
		System.out.println("Y: "+Y);
		
		
		driver.quit();
	}

}
