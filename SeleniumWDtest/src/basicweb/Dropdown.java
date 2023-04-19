package basicweb;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class Dropdown {

	public static void main(String[] args) {
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
		driver.get("https://taimuihongsg.com/dat-hen-kham-benh/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//WebElement staticDropdown = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[4]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/select[1]"));
		
		//WebElement location = driver.findElement(By.xpath("//div[@data-type='location']/div/select"));
		
		
		Select location_op = new Select(driver.findElement(By.xpath("//div[@data-type='location']//div/select")));
		//location_op.selectByIndex(2);
		location_op.selectByValue("2");
		System.out.println(location_op.getFirstSelectedOption().getText());
		
		Select service_op = new Select(driver.findElement(By.xpath("//div[@data-type='service']//div/select")));
		service_op.selectByValue("16");
		//service_op.selectByVisibleText("Khám Nội soi Tai Mũi Họng");
		//System.out.println(service_op.getFirstSelectedOption().getText());
		System.out.println(service_op.getFirstSelectedOption().getText());
		
		Select staff_op = new Select(driver.findElement(By.xpath("//div[@data-type='staff']//div/select")));
		staff_op.selectByValue("30");
		System.out.println(staff_op.getFirstSelectedOption().getText());
	}

}
