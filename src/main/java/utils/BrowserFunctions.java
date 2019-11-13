package utils;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class BrowserFunctions {

	public static String Url = CommonMethods.passingData("url");  
	public static WebDriver driver;
	public ExtentReports extent;
	public ExtentTest logger_ss;
	// public static Logger logger = Logger.getLogger(AudioTest.class);
	public static String downloadFilepath;// =
											// "D:\\grpTalk\\TestDataFiles\\downloads\\";
	StringBuilder sb = new StringBuilder();
	public static String testcasename;

	@BeforeTest
	@Parameters("browser")
	public void setup(@Optional("IamOptional") String browser) throws Exception {

		if (browser.equalsIgnoreCase("firefox")) {
			ExtentHtmlReporter reporter = new ExtentHtmlReporter("WanasaTime_Report_On_Firefox.html");
			extent = new ExtentReports();
			extent.attachReporter(reporter);
			logger_ss = extent.createTest("BeforeTest");
			System.setProperty("webdriver.gecko.driver",
					"D:\\WanasaTimeLive\\WanasaTimeLiveTestCases\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
			logger_ss.log(Status.INFO, "Firefox Browser Launched Successfully");
		}

		else if (browser.equalsIgnoreCase("chrome")) {
			System.out.println(Url);
			ExtentHtmlReporter reporter = new ExtentHtmlReporter("WanasaTime_Report_On_Firefox.html");
			extent = new ExtentReports();
			extent.attachReporter(reporter);
			logger_ss = extent.createTest("BeforeTest");
			System.setProperty("webdriver.chrome.driver",
					"D:\\WanasaTimeLive\\WanasaTimeLiveTestCases\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			logger_ss.log(Status.INFO, "Chrome Browser Launched Successfully");
		}

		else if (browser.equalsIgnoreCase("Edge")) {
			ExtentHtmlReporter reporter = new ExtentHtmlReporter("WanasaTime_Report_On_Firefox.html");
			extent = new ExtentReports();
			extent.attachReporter(reporter);
			logger_ss = extent.createTest("BeforeTest");
			System.setProperty("webdriver.edge.driver",
					"D:\\WanasaTimeLive\\WanasaTimeLiveTestCases\\Drivers\\MicrosoftWebDriver.exe");
			driver = new EdgeDriver();
			logger_ss.log(Status.INFO, "Edge Browser Launched Successfully");
		} else {
			// throw new Exception("Browser is not correct");
			ExtentHtmlReporter reporter = new ExtentHtmlReporter("WanasaTime_Report_On_Firefox.html");
			extent = new ExtentReports();
			extent.attachReporter(reporter);
			logger_ss = extent.createTest("BeforeTest");
			System.setProperty("webdriver.chrome.driver",
					"D:\\WanasaTimeLive\\WanasaTimeLiveTestCases\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			logger_ss.log(Status.INFO, "Chrome Browser Launched Successfully");
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		driver.get(Url);

		logger_ss.log(Status.INFO, "WanasaTime home page opend successfully");
		System.out.println("WanasaTime home page opend successfully");
		Thread.sleep(5000);
	}

	@AfterMethod
	public void tearDown(ITestResult result) throws IOException, InterruptedException {
		testcasename = result.getName();
		System.out.println("Test case name:" + testcasename);

		if (ITestResult.FAILURE == result.getStatus()) {
			System.out.println("::::++++++");
			CommonMethods.getScreenshot();
		}

		if (result.getStatus() == ITestResult.FAILURE) {
			System.out.println("TestCase failed");
			String temp = CommonMethods.getScreenshot();
			logger_ss.fail(result.getThrowable().getMessage(),
					MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
		} else {
			System.out.println("TestCase passed");
		}
		extent.flush();
	}

	@AfterTest
	@Parameters("browser")
	public void closeBrowser1(@Optional("IamOptional") String browser) throws Exception {
		driver.quit();
	}
}