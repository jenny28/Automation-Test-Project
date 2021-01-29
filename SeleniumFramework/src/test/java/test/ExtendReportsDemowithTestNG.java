package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtendReportsDemowithTestNG {
	
	ExtentHtmlReporter htmlreporter ;
	ExtentReports extent;
	WebDriver driver=null;
	
	@BeforeSuite
	public void setUp() {
		htmlreporter=new ExtentHtmlReporter("extent.html");
		extent=new ExtentReports();
		extent.attachReporter(htmlreporter);
	}
	
	@BeforeTest
	public void setUpTest() {
		String projectPath=System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"\\lib\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@Test
	public void test1() throws Exception {
		ExtentTest test=extent.createTest("MyFirsttest","Sample description");
		
		driver.get("https://google.com");
		test.pass("Navigated to google.com");
		// log(Status, details)
        test.log(Status.INFO, "This step shows usage of log(status, details)");

        // info(details)
        test.info("This step shows usage of info(details)");
        
        // log with snapshot
        test.fail("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
        
        // test with snapshot
        test.addScreenCaptureFromPath("screenshot.png");
	}
	
	@AfterTest
	public void TearDownTest() {
		driver.close();
		driver.quit();
		System.out.println("Test completed successfully");	
	}

	
	@AfterSuite
	public void tearDown() {
		extent.flush();
	}

}
