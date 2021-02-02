package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNG_Demo2 {
	
	static WebDriver driver = null;
     
	@BeforeTest
	public void setUpTest() {
		String projectPath=System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"\\lib\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@Test
	public static void googleSearch2(){
		// go to google
		driver.get("https://google.com/");
		// enter text in search textbox
		driver.findElement(By.name("q")).sendKeys("Automation step by step");
		driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
		
	}
	
	@Test
	public static void googleSearch3() throws InterruptedException{
		// go to google
		driver.get("https://google.com/");
		Thread.sleep(3000);
		// enter text in search textbox
		driver.findElement(By.name("q")).sendKeys("Automation step by step");
		driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
		
	}
	
	@AfterTest
	public void TearDownTest() {
		driver.close();
		driver.quit();
		System.out.println("Test completed successfully");	
	}
}
