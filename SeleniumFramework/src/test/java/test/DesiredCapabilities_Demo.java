package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DesiredCapabilities_Demo {
	
	  static WebDriver driver=null;

	public static void main(String[] args) throws InterruptedException {
		String projectPath=System.getProperty("user.dir");

		DesiredCapabilities caps=new DesiredCapabilities();
		caps.setCapability("ignoreProtectedModeSettings", true);
		caps.setCapability(CapabilityType.BROWSER_NAME, "internet explorer");
		 
		
		System.setProperty("webdriver.ie.driver", projectPath+"\\lib\\drivers\\IEDriverServer.exe");
		driver = new InternetExplorerDriver(caps);
		
		driver.get("https://google.com");
		Thread.sleep(3000);
        driver.findElement(By.name("q")).sendKeys("ABCD");
        driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
        
		driver.close();
		driver.quit();
		
	}

}
