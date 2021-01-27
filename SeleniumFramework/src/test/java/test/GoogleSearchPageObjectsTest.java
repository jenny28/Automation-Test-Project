package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.GoogleSearchPageObjects;

public class GoogleSearchPageObjectsTest {
	
	static WebDriver driver=null;
	
	public static void main(String[] args) throws InterruptedException {
		 googleSearchTest();
	}

	public static void googleSearchTest() throws InterruptedException {
	String projectPath=System.getProperty("user.dir");
	System.setProperty("webdriver.chrome.driver", projectPath+"\\lib\\drivers\\chromedriver.exe");
	driver = new ChromeDriver();
	
	GoogleSearchPageObjects searchPageObj= new GoogleSearchPageObjects(driver);
	
	driver.get("https://google.com");
	
	searchPageObj.setTextinSearchBox("A B C D");
	Thread.sleep(3000);
	searchPageObj.clickSearchbutton();
	driver.close();
	}
}
