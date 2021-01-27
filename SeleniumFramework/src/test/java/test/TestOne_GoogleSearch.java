package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestOne_GoogleSearch {
	
	public static void main(String[] args) {
		googleSearch();
	}
	
	public static void googleSearch(){
		
		String projectPath=System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"\\lib\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		// go to google
		driver.get("https://google.com/");
		// enter text in search textbox
		driver.findElement(By.name("q")).sendKeys("Automation step by step");
		driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
		driver.close();
		System.out.println("Test completed successfully");
		
	}
}
