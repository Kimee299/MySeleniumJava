package test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Day2 {

//	@BeforeTest
//	public void beforeTest() {
//		System.out.println("@BeforeTest Day2");
//	}
//
//	@AfterTest
//	public void afterTest() {
//		System.out.println("@AfterTest Day2...");
//	}
//	@Parameters ({"URL","APIkey"}) 
	@Test(groups = {"group_Day2"})
//	public void Day2_f1(String url, String key) {
		public void Day2_f1() {
		// TODO Auto-generated method stub
		System.out.println("Day2_f1:group_Day2"); 
//		System.out.println(url);
//		System.out.println(key);
	}

	@Test(groups = {"group_Day2"})
	public void Day2_f2() {
		// TODO Auto-generated method stub
		System.out.println("Day2_f2: group_Day2"); 
	}
//	@Test
//	public void a() {
//		System.out.println(123%10);
//		System.out.println(123/10);
//	}
}
