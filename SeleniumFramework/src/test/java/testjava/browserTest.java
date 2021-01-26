package testjava;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class browserTest {
	
	public static void main(String[] args) throws Exception {
		
		 //location to the project
//		String projectPath=System.getProperty("user.dir");
//		System.out.println("project path" + projectPath);

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\jenny\\git\\TestProject\\SeleniumFramework\\lib\\drivers\\chromedriver.exe");
		//WebDriver driver1=new FirefoxDriver();
		WebDriver driver = new ChromeDriver();
		//WebDriver driver=new InternetExplorerDriver();
		driver.get("https://google.com/");
		driver.findElement(By.xpath("//input[@class=\"gLFyf gsfi\"]")).sendKeys("automation step by step");
		
		List<WebElement> listOfInputElements = driver.findElements(By.xpath("//input"));
		int count =listOfInputElements.size();
		System.out.println("Count of elements:  "+listOfInputElements.size());
		
	    Thread.sleep(3000);
		driver.close();
	    driver.quit();		
	    
	}

}
