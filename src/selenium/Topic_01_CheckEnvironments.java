package selenium;

import org.testng.annotations.*;
import org.testng.annotations.BeforeClass;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

@Test
public class Topic_01_CheckEnvironments {

	public WebDriver driver;

	@BeforeClass
	public void beforeClass() {

		String driverPath = "/Users/tanhungvo/Documents/SeleniumWebDrider/chromedriver-mac-arm64/chromedriver";
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		
		driver.get("https://artventure.sipher.gg/workspace");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public void TC_01_SignInWithGoogle() throws InterruptedException {
		driver.findElement(By.xpath("//*[text()='Sign in with Google']")).click();
		Thread.sleep(6000);		
		
		String mainWindowHandle = driver.getWindowHandle(); // Store the current window handle
		Set<String> windowHandles = driver.getWindowHandles(); // Get all window handles
		for (String handle : windowHandles) {
		    if (!handle.equals(mainWindowHandle)) {
		        driver.switchTo().window(handle); // Switch to the pop-up window
		        WebElement emailField = driver.findElement(By.xpath("//input[@type='email']"));
		        emailField.sendKeys("tester.dad@atherlabs.com");
		        driver.findElement(By.xpath("//*[text()='Next']")).click();
				Thread.sleep(6000);					        			

		    	WebElement passwordField = driver.findElement(By.xpath("//input[@type='password']"));
		        passwordField.sendKeys("Playsipher@123");
				driver.findElement(By.xpath("//*[text()='Next']")).click();
				Thread.sleep(3000);	
				
				break;
			}		    
		}
		driver.switchTo().window(mainWindowHandle);
	}

	public void TC_02_OpenRecipesPage() throws InterruptedException {
		driver.findElement(By.xpath("//*[starts-with(text(),'Recipes')]")).click();
		Thread.sleep(5000);
		
	}
	
	public void TC_03_Check_Outpainting_LCM() {
		driver.findElement(By.xpath("//p[1][starts-with(text(),'Outpainting LCM')]")).click();
		
		driver.findElement(By.xpath("//p[@class='text-atherGray-300 text-center'][text()='Upload images or Drag & Drop ']")).click();
	}
	
	@AfterClass
	public void afterClass() {
		//driver.quit();
	}

}
