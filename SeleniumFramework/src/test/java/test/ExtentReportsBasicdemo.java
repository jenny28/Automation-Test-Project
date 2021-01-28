package test;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportsBasicdemo {
	
	  static WebDriver driver=null;
	
	public static void main(String[] args) throws Exception {
		
		SimpleDateFormat format= new SimpleDateFormat("dd-MM-yyy HH-mm-ss");
		Date date= new Date();
		String actualdate=format.format(date);
		
		String projectPath=System.getProperty("user.dir");
		String reportPath=projectPath+"/Reports/ExecutionReport_"+actualdate+".html";
		ExtentHtmlReporter htmlreporter = new ExtentHtmlReporter(reportPath);
		
		ExtentReports extent = new ExtentReports();
        extent.attachReporter(htmlreporter);
        
     // creates a toggle for the given test, adds all log events under it    
        ExtentTest test1 = extent.createTest("Google search Test One", "this is a test to validate google search funcionality");
        
		System.setProperty("webdriver.chrome.driver", projectPath+"\\lib\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		
		test1.log(Status.INFO, "Starting test case");
		driver.get("https://google.com");
		test1.pass("Navigates to google.com");
		
		driver.findElement(By.name("q")).sendKeys("Automation");
		test1.pass("Entered the text in searchbox");
		Thread.sleep(3000);
		driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
		test1.pass("Pressed keyboard enter key");
	
	
        // test with snapshot
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String screenshotPath=projectPath+"/Reports/Screenshots/"+actualdate+".jpg";
		File dest = new File (screenshotPath);
		
		FileUtils.copyFile(src, dest);
		
		test1.addScreenCaptureFromPath(screenshotPath,"test case");
        // calling flush writes everything to the log file
		
		driver.close();
		driver.quit();
		test1.pass("Close the browser");
		
		test1.info("Test completed");
        extent.flush();
	}

}
