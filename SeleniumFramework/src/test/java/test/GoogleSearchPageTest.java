package test;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.GoogleSearchPage;

public class GoogleSearchPageTest {
	
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
		GoogleSearchPage.text_search(driver).sendKeys("Automation step by step");
		GoogleSearchPage.button_search(driver).sendKeys(Keys.RETURN);
		driver.close();
		System.out.println("Test completed successfully");
		
	}
}
