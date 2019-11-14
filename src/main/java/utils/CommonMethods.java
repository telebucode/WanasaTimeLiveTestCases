package utils;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Random;
//import wanasa.HomePageTest;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonMethods extends BrowserFunctions{
	
	//HomePageTest htest = new HomePageTest();
	public static void clickMethod(By loactor) throws InterruptedException{
		By lc=loactor;
		Thread.sleep(1000);
		driver.findElement(lc).click();
	}
	
	public void getTextMethod(By loactor){
		driver.findElement(loactor).getText();
	}
	
	public static boolean isDisplayedMethod(By loactor){
		explicitWaitForElementVisibility(loactor);
		return driver.findElement(loactor).isDisplayed();
	}
	
	public static void sendKeysMethod(By loactor,String text)
	{
		driver.findElement(loactor).sendKeys(passingData(text));
	}
	
	public static void handleAlert()throws InterruptedException{
        if(isAlertPresent()){
            Alert alert = driver.switchTo().alert();
            Thread.sleep(1000);
            alert.accept();
            Thread.sleep(2000);
           // System.out.println("successfully closed the alert");
            driver.navigate().to(Url);
          }
    }
	
    public static boolean isAlertPresent()  throws InterruptedException{
        boolean foundAlert = false;
        WebDriverWait wait = new WebDriverWait(driver, 5);
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            foundAlert = true;
        } catch (TimeoutException eTO) {
            foundAlert = false;
           // System.out.println("Alert is not present");
        }
        return foundAlert;
    }
	
	public static void explicitWaitForElementVisibility(By locator){
		By element = locator;
		WebDriverWait wait= new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
	}
	
	public static void explicitWaitForClickableElement(WebDriver driver,WebElement ele){
		WebElement element = ele;
		WebDriverWait wait= new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public static void explicitWaitForAlert(WebDriver driver){
		WebDriverWait wait= new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.alertIsPresent());
	}
	static String s;
	public static String passingData(String text){
    	JSONParser parser = new JSONParser();
    	JSONObject jsonObject=new JSONObject();
        try {
        	Object object = parser.parse(new FileReader("D:\\WanasaTimeLive\\WanasaTimeLiveTestCases\\src\\main\\java\\utils\\TestData1.json"));
	    	jsonObject = (JSONObject)object;
	    	s=(String)jsonObject.get(text);						
        } 
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
		return s;
	}
	
		
	private static final ExpectedCondition<Alert> TRUE = null;
	
	public static String getScreenshot()
	{
		DateFormat date = new SimpleDateFormat("dd-MM-YYYY_HH-mm-ss");
		Date d = new Date();
		String dd = date.format(d);
		
		//System.out.println("Date is"+dd);
	
		
		TakesScreenshot ts=(TakesScreenshot) driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		//String filename = new Simpl
		//String path=System.getProperty("user.dir")+"/Screenshot/"+System.currentTimeMillis()+".png";
		String path=System.getProperty("user.dir")+"/Screenshot/"+BrowserFunctions.testcasename+dd+".png";
		
		File destination=new File(path);
		try 
		{
			FileUtils.copyFile(src, destination);
		} catch (IOException e) 
		{
			System.out.println("Capture Failed "+e.getMessage());
		}
		return path;
	}
	
	public static void getUploadFile(String filepath) throws InterruptedException, AWTException {
		String s= filepath;
		Thread.sleep(2000);
		setClipboardData(s);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
	}
	
	public static void setClipboardData(String string) throws InterruptedException {
		StringSelection stringSelection = new StringSelection(string);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
		Thread.sleep(2000);
	}
	
	
	public String getSaltString1() {
	       String SALTCHARS = "abcdefghijklmnopqrstuvwxyz0123456789";
	       StringBuilder salt = new StringBuilder();
	       Random rnd = new Random();
	       while (salt.length() < 10) { // length of the random string.
	           int index = (int) (rnd.nextFloat() * SALTCHARS.length());
	           salt.append(SALTCHARS.charAt(index));
	       }
	       String saltStr = salt.toString();
	       return saltStr;
	}
	
	public String getSaltString() {
	       String SALTCHARS = "0123456789";
	       StringBuilder salt = new StringBuilder();
	       Random rnd = new Random();
	       while (salt.length() < 6) { // length of the random string.
	           int index = (int) (rnd.nextFloat() * SALTCHARS.length());
	           salt.append(SALTCHARS.charAt(index));
	       }
	       String saltStr = salt.toString();
	       return saltStr;
	}
	
	
	
	static String sourcepath = "user.dir";
	static File file ;
	static FileInputStream fis;
	static Properties prop ;
	public static Properties configFile() throws IOException
	{
	
	 file = new File(sourcepath+"/Config.properties");
	 fis = new FileInputStream(file);
	 prop = new Properties();
	 prop.load(fis);
	 
	 return prop;
		 
	}
	
	
}

