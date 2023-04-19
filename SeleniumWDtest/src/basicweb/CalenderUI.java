package basicweb;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CalenderUI {

	public static void main(String[] args) throws InterruptedException {
		// init
		System.setProperty("webdriver.chrome.driver", "E:\\sourcecode\\drivers\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://www.path2usa.com/travel-companion/");
//		driver.manage().window().maximize();

		// do action
//		Thread.sleep(3000);
		Actions a = new Actions(driver);
		WebElement calender = driver.findElement(By.xpath("//input[@id=\"form-field-travel_comp_date\"]"));
		WebElement week = driver.findElement(By.xpath("//select[@id=\"form-field-travel_comp_date_between\"]"));
		Select select = new Select(week);
		select.selectByValue("3W");
		
//		a.moveToElement(driver.findElement(By.xpath("//select[@id=\"form-field-travel_comp_airline\"]"))).click().perform();
		
		calender.sendKeys(Keys.ENTER);
//		calender.sendKeys("04/10/2023");
		
		List<WebElement> days = driver.findElements(By.xpath("//div[contains(@class,'flatpickr-day')]//span"));
//		for(int i=0;i< days.size();i++) {
////			System.out.println(days.get(i).getText());
//			String text = days.get(i).getText();
//			if(text.equalsIgnoreCase("23")) {
////				System.out.println("index: "+i);
////				System.out.println(days.get(i).getText());
////				a.moveToElement(days.get(i)).click().build().perform();
//				days.get(i).click();
////				driver.findElements(By.xpath("//div[contains(@class,'flatpickr-day')]//span")).get(i).click();
//				break;
//			};
//		};
//		driver.quit();
	}

}
