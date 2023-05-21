package selenium;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Topic_01_CheckEnvironments {

	WebDriver driver;

	// Pre-condition
	@BeforeClass
	public void beforeClass() {

		System.setProperty("webdriver.chrome.driver",
				"/Users/tanhungvo/Documents/SeleniumWebDrider/chromedriver_mac64/chromedriver");
		driver = new ChromeDriver();
		driver.get("https://www.guru99.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	// Action of Testcase
	@Test
	public void TC_01_CheckUrl() {
		String homePageUrl = driver.getCurrentUrl();
		System.out.println("Home page Url = " + homePageUrl);
		Assert.assertEquals(homePageUrl, "https://www.guru99.com/");
	}

	@Test
	public void TC_01_CheckTitle() {
		String homePageTitle = driver.getTitle();
		System.out.println("Home page Title = " + homePageTitle);
		Assert.assertEquals(homePageTitle, "Meet Guru99 – Free Training Tutorials & Video for IT Courses");
	}

	// Post-condition
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
