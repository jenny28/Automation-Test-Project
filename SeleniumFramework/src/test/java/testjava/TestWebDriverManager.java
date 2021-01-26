package testjava;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
 
public class TestWebDriverManager {
	
	public static void main(String[] args) throws Exception {
		
		WebDriverManager.chromedriver().driverVersion("87.0").setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://google.com.pe/");
		WebElement textbox=driver.findElement(By.cssSelector("#tsf > div:nth-child(2) > div.A8SBwf > div.RNNXgb > div > div.a4bIc > input"));
		textbox.sendKeys("automation step by step");
		Thread.sleep(3000);
		driver.close();
		driver.quit();
	}

}
