package basicweb;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TakeSnapShot {

	public static void takeSnapShot (WebDriver webdriver, String filePath) throws Exception {
		// convert webdriver obj to TakesScreenshot
		TakesScreenshot scrShot = ((TakesScreenshot) webdriver);
		
		//call method to create image file
		File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
		
		
		//move file to desc
		File desc = new File(filePath);
		
		//copy file to desc
		FileUtils.copyFile(srcFile, desc);
//		FileUtils.copyFileToDirectory(srcFile, desc);
//		FileUtils.copyFileToDirectory(srcFile, desc, false);

	}

}
