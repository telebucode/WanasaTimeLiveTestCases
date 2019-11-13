package wanasa;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import utils.BrowserFunctions;
import utils.CommonMethods;

public class homepagelive extends BrowserFunctions {
	By advts = By.xpath(" //div[@class='modal-content']/img[1]");
	By advtsclose = By.xpath("//button[@class='close']//img");

	public void alertadvt() {
		boolean advtsexists = driver.findElement(advts).isDisplayed();
		if (advtsexists == true) {
			/*
			 * WebElement advt = driver.findElement(advts); Actions a = new
			 * Actions(driver); a.moveToElement(advt);
			 */
			CommonMethods.explicitWaitForElementVisibility(advtsclose);
			driver.findElement(advtsclose).click();
			System.out.println("Advts closed");
		}
	}

	// select region
	By location = By.xpath("//span[@class='fa fa-map-marker']");
	By region = By.className("region");

	// Bahrain

	public void countrySelection() throws InterruptedException {
		// CommonMethods.clickMethod(location);
		driver.findElement(location).click();
		List<WebElement> listcountry = driver.findElements(region);
		listcountry.get(0).click();
		//
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	// Qatar

	public void countrySelectionqar() throws InterruptedException {
		// CommonMethods.clickMethod(location);
		driver.findElement(location).click();
		List<WebElement> listcountry = driver.findElements(region);
		listcountry.get(1).click();

	}

	// Signin

	By signinclick = By.id("anchorLogin");
	By signinemail = By.id("email");
	By signinpassword = By.id("password");
	By loginclick = By.id("LoginSubmit");
	By logout = By.id("Logout");
	By errormsgemptypwd = By.className("toast-message");
	By advertisingneedsmsg = By.xpath("//div[contains(@class,'toast-message') and contains(.,'Thanks for providing your information we will get back to you soon')]");
	By erremtypwd = By.xpath("//*[contains(@class,'toast-message') and contains(text(),'Enter a password')]");
	By erridpwdwrong = By.xpath("//*[contains(@class,'toast-message') and contains(text(),'Invalid credentials')]");
	By afterloginverify = By.className("user-profile-name-container");

	public String singInWithEmptyPassword() throws InterruptedException {
		// clickSignInButton();
		driver.findElement(signinemail).sendKeys(CommonMethods.passingData("EnterMail"));
		driver.findElement(signinpassword).sendKeys("");
		driver.findElement(loginclick).click();
		return driver.findElement(erremtypwd).getText();
	}

	public String singInWithincorrectcredentials() throws InterruptedException {
		driver.findElement(signinemail).clear();
		driver.findElement(signinemail).sendKeys("test0000@gmail.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(signinpassword).sendKeys("874283748");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(loginclick).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver.findElement(erridpwdwrong).getText();
	}

	public String signinWanasaTimeCredentials() {
		try {

			driver.findElement(signinemail).clear();
			driver.findElement(signinpassword).clear();
			driver.findElement(signinemail).sendKeys(CommonMethods.passingData("EnterMail"));
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElement(signinpassword).sendKeys(CommonMethods.passingData("Password"));
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElement(loginclick).click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		} catch (Exception ex) {

		}
		String url = driver.getCurrentUrl();
		return url;
	}

	public void login() {
		driver.findElement(signinclick).click();
		driver.findElement(signinemail).sendKeys(CommonMethods.passingData("EnterMail"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(signinpassword).sendKeys(CommonMethods.passingData("Password"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(loginclick).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public void logout() throws InterruptedException {
		//driver.navigate().to("http://staging.wanasatime.com");
		driver.findElement(menu).click();
		Thread.sleep(2000);
		driver.findElement(logout).click();
	}

	public String successMsg() {
		return driver.findElement(successMsg).getText();
	}

	public void signin() {
		driver.findElement(signinemail).clear();
		driver.findElement(signinpassword).clear();
		driver.findElement(signinemail).sendKeys(CommonMethods.passingData("EnterMail"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(signinpassword).sendKeys(CommonMethods.passingData("Password"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(loginclick).click();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	// Footerlinks

	By aboutus = By.linkText("About");
	By AdvertiseWithUs = By.linkText("Advertise With Us");
	By FAQ = By.linkText("FAQs");
	By TC = By.linkText("Terms & Conditions");
	By privacy = By.linkText("Privacy Policy");
	By contactus = By.linkText("Contact us");
	By planspricing = By.linkText("Plans & Pricing");

	public void footerlinksaboutus() throws InterruptedException {

		driver.navigate().to(CommonMethods.passingData("url"));
		//
		driver.findElement(aboutus).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public void footerlinksAdvertiseWithUs() throws InterruptedException {

		// driver.navigate().to("http://staging.wanasatime.com/");
		driver.findElement(AdvertiseWithUs).click();
		//
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public void footerlinksfaq() throws InterruptedException {
		// driver.navigate().to("http://staging.wanasatime.com/");
		driver.findElement(FAQ).click();
		//
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public void footerlinkstc() throws InterruptedException {
		// driver.navigate().to("http://staging.wanasatime.com/");
		driver.findElement(TC).click();
		//
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public void footerlinkprivacy() throws InterruptedException {
		// driver.navigate().to("http://staging.wanasatime.com/");
		driver.findElement(privacy).click();
		//
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public void footerlinkcontactus() throws InterruptedException {
		// driver.navigate().to("http://staging.wanasatime.com/");
		driver.findElement(contactus).click();
		//
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public void footerlinkplanspricing() throws InterruptedException {
		// driver.navigate().to("http://staging.wanasatime.com/");
		driver.findElement(planspricing).click();
		//
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	// Confirmation.aspx

	By txtPaymentMobile = By.id("txtPaymentMobile");
	By txtPaymentEmail = By.id("txtPaymentEmail");
	By ticketconfirmtext = By.xpath("//*[@id='successMsg']//h4");
	By tktcanceltext = By.xpath("//*[@id='failedMsg']//h4");

	// Signup

	By sinupclick = By.id("lnkSignUp");
	By username = By.id("RegisterUser");
	By email = By.id("RegisterEmail");
	// By prefix = By.className("btn selected-country-code-btn");
	By cprefix = By.id("countrydropup");
	By prefix = By.xpath("//*[@id='Phone']//*[@data-toggle='dropdown']");
	By mobilenumber = By.id("re-phone");
	By password = By.id("re-password");
	By repassword = By.id("confirmPassword");
	By signupclick = By.id("userSignUp");
	By signupsuccess = By.xpath(
			"//*[contains(@class,'toast-message') and contains(text(),'You have successfully registered. We have sent a verification email to you.')]");

	public String signup() throws InterruptedException {

		clickSignInButton();
		Thread.sleep(2000);
		driver.findElement(sinupclick).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		CommonMethods cm = new CommonMethods();
		driver.findElement(username).sendKeys(cm.getSaltString1());
		driver.findElement(email).sendKeys(cm.getSaltString1() + "@gmail.com");
		driver.findElement(prefix).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Actions ACT = new Actions(driver);
		ACT.moveToElement(driver.findElement(By.xpath("//*[@id='countrydropup']//*[@style='padding: 5px 20px;']")))
				.perform();
		driver.findElement(By.xpath("//*[@id='countrydropup']//*[@style='padding: 5px 20px;']")).click();
		driver.findElement(By.id("customCountryPrefix")).sendKeys("91");
		driver.findElement(mobilenumber).sendKeys("9848" + cm.getSaltString());
		driver.findElement(password).sendKeys("pallavi22");
		driver.findElement(repassword).sendKeys("pallavi22");
		driver.findElement(signupclick).click();

		return driver.findElement(signupsuccess).getText();

	}

	// Forgot password

	By forgotclick = By.id("lnkForgot");
	By enteremail = By.id("txtForgotEmail");
	By click = By.id("btnForgot");
	By forgotpwdsuccessmsg = By.xpath(
			"//*[contains(@class,'toast-message') and contains(text(),'We have sent a mail to you.Please check your mail.')]");

	public String forgotpassword() throws InterruptedException {
		// WebDriverWait wait=new WebDriverWait(driver, 20);
		driver.findElement(signinclick).click();
		Thread.sleep(2000);
		driver.findElement(forgotclick).click();
		driver.findElement(enteremail).sendKeys(CommonMethods.passingData("EnterMail"));
		/*
		 * WebElement ele2=
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
		 * "enteremail")));
		 * (ele2).sendKeys(CommonMethods.passingData("EnterMail"));
		 */
		driver.findElement(click).click();
		return driver.findElement(forgotpwdsuccessmsg).getText();
	}

	// Bahrain musicband href="night-life/bahrain-music-band"

	By eventbookBHDMusic = By.xpath("//h4[contains(text(),'Bahrain music band')]");
	By Eventbookclickimg = By
			.xpath("//*[@src='http://staging.wanasatime.com/EventPosters/bmb_0905201910540917879.jpg']");
	By okButtonOnOverlay = By.id("btnAccept");
	By eventbookingclick = By.id("bookBtnForOtherevents");
	By dateselection = By.xpath("//*[@recurringid='4792']");
	By next = By.id("BookingNext");
	By selectcategoryfree = By.xpath("//*[@categoryid='5395']");
	By selectcategorygold = By.xpath("//span[contains(text(),'GOLD')]");
	By ticketcountsubvipaudlut1 = By.xpath("//div[@id='Subcat']//div[1]//button[1]");
	By ticketcountsubvipaudlut3 =  By.xpath("//div[@id='Subcat']//div[1]//button[3]");
	By ticketcountsubvipchild2 = By.xpath("//div[@id='Subcat']//div[2]//button[1]");
	By btnproceed = By.id("btnProceed");
	By proceed	  =	By.id("proceed");
	By sucatplatchild = By.id("340");
	By btnproceedfinal = By.id("btnProceed");
	By btnforpay = By.id("btnProceed");

	By successMsg = By.xpath("//*[@id='successMsg']//h4[1]");

	// E-Voucher
	By evoucheraplybtn = By.id("btnCouponApply");
	By errorvoucher = By.xpath("//[*contains(@class,'toast-message') and contains(text(),'Enter a E-Voucher Code')]");
	By errorinvalidevoucher = By
			.xpath("//div[contains(@class,'toast-message') and contains(text(),'Invalid E-Voucher')]");
	By voucherapplymulmsg = By.xpath("//div[contains(@class,'toast-message') and contains(.,'Voucher already used')]");
	////div[contains(@class, 'measure-tab') and contains(.//span, 'someText')]
	//By voucherapplymulmsg = By.xpath("//div(@class='toast toast-error')");
	// Free ticket toast-message Only One Voucher Per Transaction

	public String BookTicketevents() {
		try {
			CommonMethods.explicitWaitForElementVisibility(eventstab);
			driver.findElement(eventstab).click();
			// driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
			// driver.navigate().to("http://staging.wanasatime.com/night-life/bahrain-music-band");
			//
			driver.findElement(eventbookBHDMusic).click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElement(eventbookingclick).click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			//driver.findElement(okButtonOnOverlay).click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			//driver.findElement(dateselection).click();
			//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElement(next).click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			//driver.findElement(selectcategoryfree).click();
			//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElement(btnproceedfinal).click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			// driver.findElement(txtPaymentMobile).sendKeys(CommonMethods.passingData("mobile"));
			// driver.findElement(txtPaymentEmail).sendKeys(CommonMethods.passingData("EnterMail"));
			driver.findElement(btnforpay).click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		} catch (Exception e) {
		}
		return driver.findElement(ticketconfirmtext).getText();
	}

	// Ticket Booking with Debit card Method multi subcat

	public String eventticketBookingWithDebitCard() throws InterruptedException {

		CommonMethods.explicitWaitForElementVisibility(eventstab);
		driver.findElement(eventstab).click();
		// driver.navigate().to("http://staging.wanasatime.com/night-life/bahrain-music-band");
		//
		driver.findElement(bhdmusiceventclick).click();
		driver.findElement(eventbookingclick).click();
		//driver.findElement(okButtonOnOverlay).click();
		//driver.findElement(dateselection).click();
		driver.findElement(next).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(selectcategorygold).click();
		driver.findElement(ticketcountsubvipaudlut1).click();
		driver.findElement(btnproceedfinal).click();
		// driver.findElement(txtPaymentMobile).sendKeys(CommonMethods.passingData("mobile"));
		// driver.findElement(txtPaymentEmail).sendKeys(CommonMethods.passingData("EnterMail"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		debitpayevents();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver.findElement(ticketconfirmtext).getText();
	}

	public String BookTicketeventsVoucher() throws InterruptedException {

		CommonMethods.explicitWaitForElementVisibility(eventstab);
		driver.findElement(eventstab).click();
		// driver.navigate().to("http://staging.wanasatime.com/night-life/bahrain-music-band");
		//
		driver.findElement(bhdmusiceventclick).click();
		driver.findElement(eventbookingclick).click();
		//driver.findElement(okButtonOnOverlay).click();
		//driver.findElement(dateselection).click();
		driver.findElement(next).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(selectcategorygold).click();
		driver.findElement(ticketcountsubvipaudlut1).click();
		driver.findElement(btnproceedfinal).click();
	    driver.findElement(txtPaymentMobile).sendKeys(CommonMethods.passingData("mobile"));
		//driver.findElement(txtPaymentEmail).clear();
		driver.findElement(txtPaymentEmail).sendKeys(CommonMethods.passingData("vemail"));
		driver.findElement(voucher).click();
		driver.findElement(voucher).sendKeys(CommonMethods.passingData("evoucher"));
		driver.findElement(evoucheraplybtn).click();
		Thread.sleep(3000);
		driver.findElement(btnforpay).click();
		return driver.findElement(ticketconfirmtext).getText();
	}

	public String BookTicketeventspartial() throws InterruptedException {

		CommonMethods.explicitWaitForElementVisibility(eventstab);
		driver.findElement(eventstab).click();
		// driver.navigate().to("http://staging.wanasatime.com/night-life/bahrain-music-band");
		//
		driver.findElement(bhdmusiceventclick).click();
		driver.findElement(eventbookingclick).click();
		//driver.findElement(okButtonOnOverlay).click();
		//driver.findElement(dateselection).click();
		driver.findElement(next).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(selectcategorygold).click();
		driver.findElement(ticketcountsubvipaudlut3).click();
		driver.findElement(btnproceedfinal).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);		
		driver.findElement(txtPaymentMobile).sendKeys(CommonMethods.passingData("mobile"));
		//driver.findElement(txtPaymentEmail).clear();
		driver.findElement(txtPaymentEmail).sendKeys(CommonMethods.passingData("vemail"));
		driver.findElement(voucher).sendKeys(CommonMethods.passingData("evoucherP"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(evoucheraplybtn).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		debitpayevents();
		return driver.findElement(ticketconfirmtext).getText();
	}

	// promocode/voucher ---- coupon code nagative case (any one should be
	// applied

	//By bhdmusiceventclick = By.xpath("//div[@id='eventsContainer']//div[1]//div[1]//figure[1]//a[1]");
	By bhdmusiceventclick = By.xpath("//*[@href='night-life/BHD-nightlife-music']");
	 //div[8]//div[1]//a[1]//figure[1]//img[1] 

	public String vouchermultiple() throws InterruptedException {

		driver.findElement(eventstab).click();
		// driver.navigate().to("http://staging.wanasatime.com/night-life/bahrain-music-band");
		//
		driver.findElement(bhdmusiceventclick).click();
		driver.findElement(eventbookingclick).click();
		//driver.findElement(okButtonOnOverlay).click();
		//driver.findElement(dateselection).click();
		driver.findElement(next).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(selectcategorygold).click();
		driver.findElement(ticketcountsubvipaudlut1).click();
		driver.findElement(btnproceedfinal).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(txtPaymentEmail).clear();
		driver.findElement(txtPaymentMobile).sendKeys(CommonMethods.passingData("mobile"));
		driver.findElement(txtPaymentEmail).sendKeys(CommonMethods.passingData("vemail"));
		driver.findElement(voucher).sendKeys(CommonMethods.passingData("vouchermulapply"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(evoucheraplybtn).click();
		Thread.sleep(6000);
		//driver.findElement(voucher).clear();
		driver.findElement(voucher).sendKeys(CommonMethods.passingData("vouchermulapply"));
		Thread.sleep(6000);
		driver.findElement(evoucheraplybtn).click();
		Thread.sleep(6000);
		return driver.findElement(voucherapplymulmsg).getText();		
	}

	// Event ticket book -Qatar

	By littlesing = By.xpath("//*[@href='events/little-singers']");
	By silvercat = By.xpath("//div[@id='EventCatgeory']//button[2]");
	By custname = By.id("txtCustomerName");
	By visacard = By.id("card_type_001");
	By master = By.id("card_type_002");
	By cardnum = By.id("card_number");
	By expmonth = By.id("card_expiry_month");
	By expyear = By.id("card_expiry_year");
	By cvv = By.id("card_cvn");
	By pay = By.xpath("//input[@name='commit']");

	// (Single day event book with CBQ-visa) - Qatar

	public String eventbookvisa() throws InterruptedException {
		driver.findElement(custname).sendKeys("pallavi");
		driver.findElement(txtPaymentMobile).sendKeys(CommonMethods.passingData("mobile"));
		driver.findElement(txtPaymentEmail).sendKeys(CommonMethods.passingData("EnterMail"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,600)");
		driver.findElement(btnforpay).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(visacard).click();
		driver.findElement(cardnum).sendKeys(CommonMethods.passingData("visaCBQ"));
		driver.findElement(expmonth).click();
		Select month = new Select(driver.findElement(expmonth));
		month.selectByValue("04");
		driver.findElement(expyear).click();
		Select year = new Select(driver.findElement(expyear));
		year.selectByValue("2021");
		driver.findElement(cvv).sendKeys("123");
		driver.findElement(pay).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		return driver.findElement(ticketconfirmtext).getText();
	}

	// (Multiple day event book with CBQ-Mastercard) - Qatar

	By parent = By.xpath("//*[@href='science-and-technology/ParentTrainig']");
	By bookingdate = By.xpath("//*[@recurringid='1969']");
	By bookingdateslot = By.xpath("//*[@recurringid='1970']");
	By silvercate = By.xpath("//div[@class='Block2']//button[2]");

	public String eventbookmaster() throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,600)");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(littlesing).click();
		driver.findElement(eventbookingclick).click();
		driver.findElement(next).click();
		//driver.findElement(okButtonOnOverlay).click();
		//driver.findElement(silvercat).click();
		driver.findElement(btnproceedfinal).click();
		driver.findElement(custname).sendKeys("pallavi");
		// driver.findElement(txtPaymentMobile).sendKeys(CommonMethods.passingData("mobile"));
		// driver.findElement(txtPaymentEmail).sendKeys(CommonMethods.passingData("EnterMail"));
		driver.findElement(btnforpay).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(master).click();
		driver.findElement(cardnum).sendKeys(CommonMethods.passingData("masterBQ"));
		driver.findElement(expmonth).click();
		Select month = new Select(driver.findElement(expmonth));
		month.selectByValue("04");
		driver.findElement(expyear).click();
		Select year = new Select(driver.findElement(expyear));
		year.selectByValue("2021");
		driver.findElement(cvv).sendKeys("123");
		driver.findElement(pay).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		return driver.findElement(ticketconfirmtext).getText();
	}

	// By Fb login = By.id("loginBtn1");

	public void clickSignInButton() {
		CommonMethods.explicitWaitForElementVisibility(signinclick);
		driver.findElement(signinclick).click();

	}

	// Debitcard locators

	By debitcardbtn = By.xpath("//*[@id='btnDebitCard']");
	By cardnumber = By.id("Ecom_Payment_Card_Number_id");
	By cardname = By.id("Ecom_Payment_Card_Name_id");
	By pinNumber = By.name("Ecom_Payment_Pin");
	By expiryMonth = By.name("Ecom_Payment_Card_ExpDate_Month");
	By expiryYear = By.name("Ecom_Payment_Card_ExpDate_Year");
	By pin1 = By.xpath("//*[@id='table2']/tbody/tr/td/input[@name='1']");
	By pin2 = By.xpath("//*[@id='table2']/tbody/tr/td/input[@name='2']");
	By pin3 = By.xpath("//*[@id='table2']/tbody/tr/td/input[@name='3']");
	By pin4 = By.xpath("//*[@id='table2']/tbody/tr/td/input[@name='4']");
	By pinEnter = By.name("Enter");
	By submit = By.id("EntrySubmitAction_id");
	By conform = By.name("ConfirmAction");

	// Google Sign in Locators

	// By menug = By.id("userMenu");
	By logoutg = By.id("Logout");
	By googleLogin = By.id("btnGoogle");
	By googleEmail = By.id("identifierId");
	By gNext = By.xpath("//*[contains(@class,'RveJvd snByac') and contains(text(),'Next')]");
	By googlePswd = By.name("password");
	By gpNext = By.xpath("//*[contains(@class,'RveJvd snByac') and contains(text(),'Next')]");
	By advanced = By.xpath("//*[@jsname='BO4nrb']");
	By goToWanasaTime = By.xpath("//*[@jsname='ehL7e']");
	By allow = By.xpath("//*[contains(@class,'RveJvd snByac') and contains(text(),'Allow')]");

	// Google Login method

	public String googleLogin() throws InterruptedException {

		driver.findElement(googleLogin).click();
		Thread.sleep(4000);
		
        /*Set<String> AllwindowHandles = driver.getWindowHandles();
		String w1 = (String) AllwindowHandles.toArray()[0];
		String w2 = (String) AllwindowHandles.toArray()[1];
		//logger.info("Checking the status of " + Convert.ToString(w2));
		Thread.sleep(4000);
		driver.switchTo().window(w2);*/
		
		Thread.sleep(4000);
		driver.findElement(googleEmail).sendKeys(CommonMethods.passingData("googEmail"));
		driver.findElement(gNext).click();
		driver.findElement(googlePswd).sendKeys(CommonMethods.passingData("googPswd"));
		Thread.sleep(4000);
		driver.findElement(gpNext).click();
		Thread.sleep(4000);
		//driver.findElement(advanced).click();
		//driver.findElement(goToWanasaTime).click();
		//driver.findElement(allow).click();
		//driver.switchTo().window(w1);
		// Thread.sleep(2000);
		// CommonMethods.explicitWaitForElementVisibility(menu1);
		String url = driver.getCurrentUrl();
		return url;
	}

	// Movies

	By moviestab = By.id("tabMovies");
	By eventstab = By.xpath("//a[@id='tabEvents']");
	By vijaymovie = By.xpath("//*[@href='MovieInfo.aspx?MovieId=17']");
	By movielist = By.xpath(
			"//*[@src='http://staging.wanasatime.com/movie_images/NADI_ELREGAL_EL_SERIA200219092849_thumbnail.jpg']");
	By moviesbookbutton = By.id("bookTickets");
	By moviedateselection = By.xpath("//h3[contains(text(),'22')]");
	By showtimeselection = By.xpath("//*[@showid='8241']");
	By alertmovieok = By.id("btnAccept");
	By numberofseatselection = By.linkText("2");
	By ticketcount2 = By.xpath("//*[@class='nav nav-pills members']/li/a");
	By seatselectionOkclick = By.id("btnOk");

	// By seatlayoutselect = By.xpath("//*[@title='Row-G Seat-08']");

	// By seatlayoutselect =
	// By.xpath("//*[@id='seatNumber']//td[contains(@class,'seat available')]");
	By seatlayoutselect = By.xpath("//td[contains(@class,'seat available')]");
	By error = By.xpath("*//[@id='seat_error']");
	By proceedbutton = By.id("btnPay");
	By proceedpaymovie = By.id("btnPay");
	By voucher = By.id("eVoucher");
	By moviespayproceed = By.id("btnPaymentProceed");
	By ticketsuccess = By.xpath("//*[@id='onSuccess']/h4");

	/*
	 * public String movieticketbooking() throws InterruptedException {
	 * 
	 * driver.findElement(moviestab).click(); //
	 * driver.navigate().to("http://staging.wanasatime.com/Movies.aspx");
	 * driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
	 * driver.findElement(movielist).click();
	 * driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
	 * driver.findElement(moviesbookbutton).click();
	 * driver.findElement(moviedateselection).click();
	 * driver.findElement(showtimeselection).click();
	 * driver.findElement(alertmovieok).click(); Thread.sleep(4000);
	 * List<WebElement> seatselection = driver.findElements(ticketcount2);
	 * System.out.println("Max seat can book by you :"+seatselection.size());
	 * for(WebElement seat : seatselection) { String seatnumber =
	 * seat.getText(); System.out.println(seatnumber);
	 * if(seatnumber.equalsIgnoreCase("1")) { seat.click(); Thread.sleep(4000);
	 * driver.findElement(seatselectionOkclick).click();
	 * 
	 * } }
	 * 
	 * Thread.sleep(2000); List<WebElement> seatsselection =
	 * driver.findElements(seatlayoutselect);
	 * System.out.println("Avalaible seats are :" +seatsselection.size());
	 * for(WebElement seat11 : seatsselection) { Actions a = new
	 * Actions(driver); a.moveToElement(seat11).build().perform();
	 * seat11.click();
	 * driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
	 * 
	 * WebElement paybutton = driver.findElement(proceedbutton); boolean pp =
	 * paybutton.isDisplayed(); if(pp==true) { paybutton.click();
	 * //driver.findElement(txtPaymentMobile).sendKeys(CommonMethods.passingData
	 * ("mobile"));
	 * //driver.findElement(txtPaymentEmail).sendKeys(CommonMethods.passingData(
	 * "EnterMail")); debitpaymovies(); Thread.sleep(2000);
	 * System.out.println("done"); break; }
	 * 
	 * else { System.out.
	 * println("Notification is diplayed as: 'Please select a seat beside the selected seat(s)'"
	 * ); seat11.click(); }
	 * 
	 * }
	 * 
	 * return driver.findElement(ticketsuccess).getText();
	 * 
	 * }
	 * 
	 * //By movieclick = By.partialLinkText("Movies"); By movieclick =
	 * By.id("tabMovies"); By nowplayinglist =
	 * By.xpath("//div[@id='moviesContainer']/div"); By bookbutton =
	 * By.partialLinkText("Book"); By showdates =
	 * By.xpath("//tr[@id='movieShowDates']/td/h3"); By showtimes = By.
	 * xpath("//div[@class='boxTheatre']//div[@class='col-md-7 timings text-right mobLeft']//button"
	 * ); //By multiplex = By.xpath("//div[@id='showTimingsDiv']//div//b");
	 * 
	 * 
	 * 
	 * public void movietabselection() { driver.findElement(movieclick).click();
	 * }
	 * 
	 * 
	 * 
	 * 
	 * public void nowplayingmovieselection() throws InterruptedException {
	 * //driver.findElement(movieclick).click();
	 * //System.out.println("Movie is clicked");
	 * 
	 * List<WebElement> nowplayinglists = driver.findElements(nowplayinglist);
	 * System.out.println("Now Showing Movie Count :" +nowplayinglists.size());
	 * 
	 * for(WebElement nowplayingsinglemovie : nowplayinglists) { String
	 * movienamexx =
	 * nowplayingsinglemovie.findElement(By.xpath("./div/div/h4/a")).getText();
	 * System.out.println("Movie Name is " +movienamexx);
	 * 
	 * String movienamefromlist = movienamexx.toLowerCase(); String
	 * movienamefromjson =
	 * CommonMethods.passingData("movienamevv").toLowerCase();
	 * if(movienamefromlist.contains(movienamefromjson)) {
	 * nowplayingsinglemovie.click();
	 * driver.findElement(moviesbookbutton).click(); List<WebElement> Mshowdates
	 * = driver.findElements(showdates); System.out.println("all show dates:"
	 * +Mshowdates.size());
	 * 
	 * 
	 * for(WebElement movieshowdates : Mshowdates ) { String msd =
	 * movieshowdates.getText(); System.out.println("Showdate " +msd);
	 * if(msd.equalsIgnoreCase(CommonMethods.passingData("MovieBookingDate"))) {
	 * movieshowdates.click(); System.out.println("selected"); List<WebElement>
	 * Stimes = driver.findElements(showtimes);
	 * System.out.println("showtimes"+Stimes.size()); for (WebElement
	 * ShowTimings : Stimes) { String ST = ShowTimings.getText();
	 * System.out.println("Selectebledate " +ST);
	 * if(ST.equalsIgnoreCase(CommonMethods.passingData("MovieBokkingTime"))) {
	 * System.out.println(); ShowTimings.click();
	 * driver.findElement(alertmovieok).click();
	 * 
	 * //Total Number of Seat that user can select
	 * 
	 * List<WebElement> seatselection = driver.findElements(ticketcount2);
	 * System.out.println("Max seat can book by you :"+seatselection.size());
	 * 
	 * //for loop to select the seat based on user wish
	 * 
	 * for(int i=1;i<=seatselection.size();i++) { String s1 =
	 * "//*[@class='nav nav-pills members']/li["; int s2=i; String s3="]/a";
	 * 
	 * 
	 * String s4= Integer.toString(s2);
	 * 
	 * 
	 * WebElement seat1 = driver.findElement(By.xpath(s1+s4+s3));
	 * 
	 * String seatnumber123 = seat1.getAttribute("href"); String[] xxx =
	 * seatnumber123.split("person"); int count = xxx.length; String seatnumber
	 * = xxx[1]; System.out.println("Seat Number is : " +seatnumber);
	 * 
	 * if(seatnumber.equalsIgnoreCase(CommonMethods.passingData("numberofseats")
	 * )) { System.out.println("@-----------"); Actions aaa = new
	 * Actions(driver);
	 * 
	 * Thread.sleep(3000); aaa.moveToElement(seat1).build().perform();
	 * Thread.sleep(3000); seat1.click();
	 * 
	 * Thread.sleep(5000); driver.findElement(seatselectionOkclick).click();
	 * break;
	 * 
	 * }
	 * 
	 * }
	 * 
	 * Thread.sleep(2000); List<WebElement> seatsselection =
	 * driver.findElements(seatlayoutselect);
	 * System.out.println("Avalaible seats are :" +seatsselection.size());
	 * for(WebElement seat11 : seatsselection) { Actions a = new
	 * Actions(driver); a.moveToElement(seat11).build().perform();
	 * seat11.click();
	 * driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
	 * WebElement paybutton = driver.findElement(proceedbutton); boolean pp =
	 * paybutton.isDisplayed(); if(pp==true) { paybutton.click();
	 * driver.findElement(txtPaymentMobile).sendKeys(CommonMethods.passingData(
	 * "mobile"));
	 * driver.findElement(txtPaymentEmail).sendKeys(CommonMethods.passingData(
	 * "EnterMail")); //debitpaymovies(); Thread.sleep(2000);
	 * System.out.println("done"); break; }
	 * 
	 * else { System.out.
	 * println("Notification is diplayed as: 'Please select a seat beside the selected seat(s)'"
	 * ); seat11.click(); }
	 * 
	 * } break; } } break; } } break; }
	 * 
	 * } }
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * //More than seat selection then opt ...
	 * 
	 * public void movieseatselectionerrorpopup() throws InterruptedException {
	 * 
	 * driver.findElement(movieclick).click();
	 * 
	 * List<WebElement> nowplayinglists = driver.findElements(nowplayinglist);
	 * System.out.println("Now Showing Movie Count :" +nowplayinglists.size());
	 * 
	 * for(WebElement nowplayingsinglemovie : nowplayinglists) {
	 * 
	 * int flag=0; String movienamexx =
	 * nowplayingsinglemovie.findElement(By.xpath("./div/div/h4/a")).getText();
	 * System.out.println("Movie Name is " +movienamexx);
	 * 
	 * String aa = movienamexx.toLowerCase(); String bb =
	 * CommonMethods.passingData("movienamevv").toLowerCase();
	 * if(aa.contains(bb)) { nowplayingsinglemovie.click();
	 * driver.findElement(moviesbookbutton).click(); List<WebElement> Mshowdates
	 * = driver.findElements(showdates); System.out.println("all show dates:"
	 * +Mshowdates.size());
	 * 
	 * 
	 * for(WebElement movieshowdates : Mshowdates ) { String msd =
	 * movieshowdates.getText(); System.out.println("Showdate " +msd);
	 * if(msd.equalsIgnoreCase(CommonMethods.passingData("MovieBookingDate"))) {
	 * movieshowdates.click(); System.out.println("selected"); List<WebElement>
	 * Stimes = driver.findElements(showtimes);
	 * System.out.println("showtimes"+Stimes.size()); for (WebElement
	 * ShowTimings : Stimes) { String ST = ShowTimings.getText();
	 * System.out.println("Selectebledate " +ST);
	 * if(ST.equalsIgnoreCase(CommonMethods.passingData("MovieBokkingTime"))) {
	 * System.out.println(); ShowTimings.click();
	 * driver.findElement(alertmovieok).click();
	 * 
	 * //Total Number of Seat that user can select
	 * 
	 * List<WebElement> seatselection = driver.findElements(ticketcount2);
	 * System.out.println("Max seat can book by you :"+seatselection.size());
	 * WebElement seat1; //for loop to select the seat based on user wish
	 * 
	 * for(int i=1;i<=seatselection.size();i++) { String s11 =
	 * "//*[@class='nav nav-pills members']/li["; int s22=i; String s33="]/a";
	 * 
	 * 
	 * String s44= Integer.toString(s22);
	 * 
	 * 
	 * seat1 = driver.findElement(By.xpath(s11+s44+s33));
	 * 
	 * String seatnumber12345 = seat1.getAttribute("href"); String[] xxx =
	 * seatnumber12345.split("person"); int count = xxx.length; String
	 * seatnumber = xxx[1]; System.out.println("Seat Number is : " +seatnumber);
	 * 
	 * if(seatnumber.equalsIgnoreCase(CommonMethods.passingData("numberofseats")
	 * )) { System.out.println("@-----------"); Thread.sleep(3000);
	 * seat1.click(); Thread.sleep(5000);
	 * driver.findElement(seatselectionOkclick).click();
	 * 
	 * List<WebElement> seatsselection = driver.findElements(seatlayoutselect);
	 * System.out.println("Avalaible seats are :" +seatsselection.size());
	 * 
	 * for(WebElement seat11 : seatsselection) { System.out.println("////////"
	 * +seat11); Actions a = new Actions(driver);
	 * 
	 * Thread.sleep(3000); a.moveToElement(seat11).build().perform();
	 * seat11.click();
	 * 
	 * 
	 * for(int k=0;k<=seatsselection.size();k++) { String
	 * m1="//td[contains(@class,'seat available')]["; String m3="]"; int m2 =
	 * Integer.parseInt(seatnumber)+1; System.out.println("M2 is" +m2); String
	 * m4 = Integer.toString(m2);
	 * 
	 * driver.findElement(By.xpath(m1+m4+m3)).click(); //Thread.sleep(1000);
	 * 
	 * WebElement tm =
	 * driver.findElement(By.xpath("//div[@class='toast toast-error']/div"));
	 * boolean tmm = tm.isDisplayed(); if(tmm==true) { String toastmessage =
	 * tm.getText(); System.out.println("Toast Message :" +toastmessage);
	 * flag=1; break;
	 * 
	 * } } if(flag==1) { break; }
	 * 
	 * }
	 * 
	 * } if(flag==1) { break; }
	 * 
	 * 
	 * } } if(flag==1) { break; } } }
	 * 
	 * if(flag==1) { break; } }
	 * 
	 * } if(flag==1) { break; } }
	 * 
	 * 
	 * 
	 * }
	 * 
	 * 
	 * 
	 * 
	 * // Seat Class Type --> Xpath :
	 * 
	 * By classtype = By.xpath("//*[@id='noOfSeats']/div[2]/table/tbody/tr/td");
	 * 
	 * List<WebElement> classgrade;
	 * 
	 * 
	 * 
	 * 
	 * 
	 * public void pricecomparemovies() throws InterruptedException {
	 * 
	 * 
	 * driver.findElement(movieclick).click();
	 * 
	 * List<WebElement> nowplayinglists = driver.findElements(nowplayinglist);
	 * System.out.println("Now Showing Movie Count :" +nowplayinglists.size());
	 * 
	 * for(WebElement nowplayingsinglemovie : nowplayinglists) {
	 * 
	 * int flag=0; String movienamexx =
	 * nowplayingsinglemovie.findElement(By.xpath("./div/div/h4/a")).getText();
	 * System.out.println("Movie Name is " +movienamexx);
	 * 
	 * String aa = movienamexx.toLowerCase(); String bb =
	 * CommonMethods.passingData("movienamevv").toLowerCase();
	 * if(aa.contains(bb)) { nowplayingsinglemovie.click();
	 * driver.findElement(moviesbookbutton).click(); List<WebElement> Mshowdates
	 * = driver.findElements(showdates); System.out.println("all show dates:"
	 * +Mshowdates.size());
	 * 
	 * 
	 * for(WebElement movieshowdates : Mshowdates ) { String msd =
	 * movieshowdates.getText(); System.out.println("Showdate " +msd);
	 * if(msd.equalsIgnoreCase(CommonMethods.passingData("MovieBookingDate"))) {
	 * movieshowdates.click(); System.out.println("selected"); List<WebElement>
	 * Stimes = driver.findElements(showtimes);
	 * System.out.println("showtimes"+Stimes.size()); for (WebElement
	 * ShowTimings : Stimes) { String ST = ShowTimings.getText();
	 * System.out.println("Selectebledate " +ST);
	 * if(ST.equalsIgnoreCase(CommonMethods.passingData("MovieBokkingTime"))) {
	 * System.out.println(); ShowTimings.click();
	 * driver.findElement(alertmovieok).click();
	 * 
	 * //Total Number of Seat that user can select
	 * 
	 * List<WebElement> seatselection = driver.findElements(ticketcount2);
	 * System.out.println("Max seat can book by you :"+seatselection.size());
	 * WebElement seat1; //for loop to select the seat based on user wish
	 * 
	 * for(int i=1;i<=seatselection.size();i++) { String s11 =
	 * "//*[@class='nav nav-pills members']/li["; int s22=i; String s33="]/a";
	 * 
	 * 
	 * String s44= Integer.toString(s22);
	 * 
	 * 
	 * seat1 = driver.findElement(By.xpath(s11+s44+s33));
	 * 
	 * String seatnumber12345 = seat1.getAttribute("href"); String[] xxx =
	 * seatnumber12345.split("person"); int count = xxx.length; String
	 * seatnumber = xxx[1]; System.out.println("Seat Number is : " +seatnumber);
	 * 
	 * if(seatnumber.equalsIgnoreCase(CommonMethods.passingData("numberofseats")
	 * )) { System.out.println("@-----------"); Thread.sleep(3000);
	 * seat1.click(); Thread.sleep(5000);
	 * driver.findElement(seatselectionOkclick).click();
	 * 
	 * List<WebElement> seatsselection = driver.findElements(seatlayoutselect);
	 * System.out.println("Avalaible seats are :" +seatsselection.size());
	 * 
	 * for(WebElement seat11 : seatsselection) { System.out.println("////////"
	 * +seat11); Actions a = new Actions(driver);
	 * 
	 * Thread.sleep(3000); a.moveToElement(seat11).build().perform();
	 * seat11.click(); WebElement proceedpaybtn =
	 * driver.findElement(By.id("btnPay")); if(proceedpaybtn.isDisplayed()) {
	 * WebElement ticketnumber = driver.findElement(By.id("TicketsSelected"));
	 * String ticketprice = ticketnumber.getText();
	 * System.out.println("No. of Tickets selected * Price is : " +ticketprice);
	 * String tp = ticketprice.trim(); System.out.println("-----------" +tp);
	 * 
	 * String[] ticketdetails = ticketprice.split(" "); int ll =
	 * ticketdetails.length; System.out.println(ll);
	 * System.out.println("Number of Tickets selected : " +ticketdetails[0] +
	 * "---" + ticketdetails[4] + "---" + ticketdetails[7]);
	 * System.out.println("=======" +ticketdetails[0]);
	 * System.out.println("=======" +CommonMethods.passingData("numberofseats")
	 * );
	 * 
	 * 
	 * if(CommonMethods.passingData("numberofseats").equalsIgnoreCase(
	 * ticketdetails[0])) { System.out.println("}}}}]"); float totalprice =
	 * (Float.parseFloat(ticketdetails[4]) * Integer.parseInt(seatnumber));
	 * System.out.println("@]]]]]]"+totalprice); //float totalprice1=
	 * Math.round((totalprice*100.0)/100.0);
	 * 
	 * String roundedTotalPrice=String.format("%.2f", totalprice);
	 * 
	 * 
	 * System.out.println("Total price after rounded"+roundedTotalPrice); String
	 * priceis = ticketnumber.findElement(By.xpath("./b")).getText();
	 * System.out.println("Ticket from web" +priceis);
	 * 
	 * String pricefinal = priceis.split(" ")[1].trim();
	 * 
	 * 
	 * 
	 * 
	 * if(roundedTotalPrice.trim().equals(pricefinal)) {
	 * System.out.println("Prices are Same"); }
	 * 
	 * else { System.out.println("+++++++++++++++"); }
	 * 
	 * }
	 * 
	 * else {
	 * System.out.println("SeatNumber and Ticket details are getting mismatch");
	 * }
	 * 
	 * flag=1; //String totalprice = driver.findElement(b) break;
	 * 
	 * 
	 * }
	 * 
	 * else { seat11.click(); }
	 * 
	 * 
	 * }
	 * 
	 * } if(flag==1) { break; }
	 * 
	 * 
	 * } } if(flag==1) { break; } } }
	 * 
	 * if(flag==1) { break; } }
	 * 
	 * } if(flag==1) { break; } }
	 * 
	 * 
	 * }
	 * 
	 * public void changeticketsnumberfromseatlayoutpage() throws
	 * InterruptedException {
	 * 
	 * 
	 * driver.findElement(movieclick).click();
	 * 
	 * List<WebElement> nowplayinglists = driver.findElements(nowplayinglist);
	 * System.out.println("Now Showing Movie Count :" +nowplayinglists.size());
	 * 
	 * for(WebElement nowplayingsinglemovie : nowplayinglists) {
	 * 
	 * int flag=0; String movienamexx =
	 * nowplayingsinglemovie.findElement(By.xpath("./div/div/h4/a")).getText();
	 * System.out.println("Movie Name is " +movienamexx);
	 * 
	 * String aa = movienamexx.toLowerCase(); String bb =
	 * CommonMethods.passingData("movienamevv").toLowerCase();
	 * if(aa.contains(bb)) { nowplayingsinglemovie.click();
	 * driver.findElement(moviesbookbutton).click(); List<WebElement> Mshowdates
	 * = driver.findElements(showdates); System.out.println("all show dates:"
	 * +Mshowdates.size());
	 * 
	 * 
	 * for(WebElement movieshowdates : Mshowdates ) { String msd =
	 * movieshowdates.getText(); System.out.println("Showdate " +msd);
	 * if(msd.equalsIgnoreCase(CommonMethods.passingData("MovieBookingDate"))) {
	 * movieshowdates.click(); System.out.println("selected"); List<WebElement>
	 * Stimes = driver.findElements(showtimes);
	 * System.out.println("showtimes"+Stimes.size()); for (WebElement
	 * ShowTimings : Stimes) { String ST = ShowTimings.getText();
	 * System.out.println("Selectebledate " +ST);
	 * if(ST.equalsIgnoreCase(CommonMethods.passingData("MovieBokkingTime"))) {
	 * System.out.println(); ShowTimings.click();
	 * driver.findElement(alertmovieok).click();
	 * 
	 * //Total Number of Seat that user can select
	 * 
	 * List<WebElement> seatselection = driver.findElements(ticketcount2);
	 * System.out.println("Max seat can book by you :"+seatselection.size());
	 * WebElement seat1; //for loop to select the seat based on user wish
	 * 
	 * for(int i=1;i<=seatselection.size();i++) { String s11 =
	 * "//*[@class='nav nav-pills members']/li["; int s22=i; String s33="]/a";
	 * String s55="]";
	 * 
	 * String s44= Integer.toString(s22);
	 * 
	 * 
	 * seat1 = driver.findElement(By.xpath(s11+s44+s33));
	 * 
	 * String seatnumber12345 = seat1.getAttribute("href");
	 * System.out.println("Seatnumber12345" +seatnumber12345); String[] xxx =
	 * seatnumber12345.split("person"); int count = xxx.length; String
	 * seatnumber = xxx[1]; System.out.println("Seat Number is : " +seatnumber);
	 * 
	 * if(seatnumber.equalsIgnoreCase(CommonMethods.passingData("numberofseats")
	 * )) { System.out.println("@-----------");
	 * 
	 * Thread.sleep(3000); seat1.click(); Thread.sleep(5000);
	 * driver.findElement(seatselectionOkclick).click(); Thread.sleep(3000);
	 * 
	 * driver.findElement(By.id("noOfTicketsSpan")).click(); String changenumber
	 * = CommonMethods.passingData("changeinnumberofseats"); s22 =
	 * Integer.parseInt(changenumber); System.out.println("//////" +s22);
	 * 
	 * s44= Integer.toString(s22);
	 * 
	 * WebElement seatvalue = driver.findElement(By.xpath(s11+s44+s33));
	 * System.out.println("---------++++ " +seatvalue);
	 * 
	 * String seatnum = seatvalue.getAttribute("href");
	 * System.out.println("Seatnum : " +seatnum);
	 * 
	 * String[] persnvalue123 = seatnum.split("person"); int count123 =
	 * persnvalue123.length; String seatchangevalu = persnvalue123[1];
	 * System.out.println("[[[[[" +count123);
	 * 
	 * //String seatnumberxxx = persnvalue123[1];
	 * System.out.println("Seat Number is : " +seatchangevalu);
	 * 
	 * 
	 * if(seatchangevalu.equalsIgnoreCase(changenumber)) {
	 * 
	 * System.out.println("------------##"); Thread.sleep(5000);
	 * seatvalue.click(); driver.findElement(seatselectionOkclick).click();
	 * 
	 * Thread.sleep(5000); List<WebElement> seatsselection =
	 * driver.findElements(seatlayoutselect);
	 * System.out.println("Avalaible seats are :" +seatsselection.size());
	 * 
	 * for(WebElement seat11 : seatsselection) { System.out.println("////////"
	 * +seat11); Actions a = new Actions(driver);
	 * 
	 * Thread.sleep(3000); a.moveToElement(seat11).build().perform();
	 * seat11.click(); Thread.sleep(10000); WebElement proceedpaybtn =
	 * driver.findElement(By.id("btnPay")); if(proceedpaybtn.isDisplayed()) {
	 * WebElement ticketnumber123 =
	 * driver.findElement(By.id("TicketsSelected")); String ticketprice123 =
	 * ticketnumber123.getText();
	 * System.out.println("No. of Tickets selected * Price is : "
	 * +ticketprice123); String tp = ticketprice.trim();
	 * System.out.println("-----------" +tp);
	 * 
	 * String[] ticketdetails123 = ticketprice123.split(" "); int ll =
	 * ticketdetails123.length; System.out.println(ll);
	 * System.out.println("Number of Tickets selected : " +ticketdetails123[0] +
	 * "---" + ticketdetails123[4] + "---" + ticketdetails123[7]);
	 * System.out.println("=======" +ticketdetails123[0]);
	 * System.out.println("======="
	 * +CommonMethods.passingData("changeinnumberofseats") );
	 * 
	 * 
	 * if(CommonMethods.passingData("changeinnumberofseats").equalsIgnoreCase(
	 * ticketdetails123[0])) { System.out.println("}}}}]------");
	 * 
	 * float cc = (Float.parseFloat(ticketdetails123[4]));
	 * System.out.println("CC is " +cc); int c1 =
	 * Integer.parseInt(seatchangevalu); System.out.println("c1" +c1);
	 * 
	 * float totalprice123 = cc * c1;
	 * System.out.println("@]]]]]]"+totalprice123); //float totalprice1=
	 * Math.round((totalprice*100.0)/100.0);
	 * 
	 * String roundedTotalPrice123=String.format("%.2f", totalprice123);
	 * 
	 * 
	 * System.out.println("Total price after rounded"+roundedTotalPrice123);
	 * String priceis123 =
	 * ticketnumber123.findElement(By.xpath("./b")).getText();
	 * System.out.println("Ticket from web" +priceis123);
	 * 
	 * String pricefinal123 = priceis123.split(" ")[1].trim();
	 * 
	 * 
	 * 
	 * 
	 * if(roundedTotalPrice123.trim().equals(pricefinal123)) {
	 * System.out.println("Prices are Same"); }
	 * 
	 * else { System.out.println("+++++++++++++++"); }
	 * 
	 * }
	 * 
	 * else {
	 * System.out.println("SeatNumber and Ticket details are getting mismatch");
	 * }
	 * 
	 * flag=1; //String totalprice = driver.findElement(b) break;
	 * 
	 * 
	 * }
	 * 
	 * 
	 * 
	 * break; }
	 * 
	 * flag=1;
	 * 
	 * }
	 * 
	 * if(flag==1) { break; }
	 * 
	 * } if(flag==1) { break; }
	 * 
	 * 
	 * } } if(flag==1) { break; } } }
	 * 
	 * if(flag==1) { break; } }
	 * 
	 * } if(flag==1) { break; } }
	 * 
	 * 
	 * }
	 * 
	 * 
	 * 
	 */

	// ==============================================

	// By movieclick = By.partialLinkText("Movies");
	By movieclick = By.id("tabMovies");
	By nowplayinglist = By.xpath("//div[@id='moviesContainer']/div");
	By bookbutton = By.partialLinkText("Book");
	By showdates = By.xpath("//tr[@id='movieShowDates']/td/h3");
	By showtimes = By.xpath("//div[@class='boxTheatre']//div[@class='col-md-7 timings text-right mobLeft']//button");
	// By multiplex = By.xpath("//div[@id='showTimingsDiv']//div//b");

	public void movietabselection() throws InterruptedException {
		driver.findElement(movieclick).click();
	Thread.sleep(2000);
	}

	// #2 : Now pLaying list ->

	public void nowplayingmovieselection() throws InterruptedException {

		List<WebElement> nowplayinglists = driver.findElements(nowplayinglist);
		System.out.println("Now Showing Movie Count :" + nowplayinglists.size());

		for (WebElement nowplayingsinglemovie : nowplayinglists) {
			String movienamexx = nowplayingsinglemovie.findElement(By.xpath("./div/div/h4/a")).getText();
			System.out.println("Movie Name is " + movienamexx);
			// String movienamefromlist = movienamexx.toLowerCase();
			// String movienamefromjson =
			// CommonMethods.passingData("movienamevv").toLowerCase();
			 String movienamefromjson = CommonMethods.passingData("movienamevv");
			// System.out.println(CommonMethods.passingData("movienamevv"));
			if (movienamexx.contains(movienamefromjson)) {
				nowplayingsinglemovie.click();
				driver.findElement(moviesbookbutton).click();
				break;

			}

		}

	}

	public void moviedateselection() {

		// List of Show Date Details :
		List<WebElement> Mshowdates = driver.findElements(showdates);
		System.out.println("all show dates:" + Mshowdates.size());

		for (WebElement movieshowdates : Mshowdates) {
			String msd = movieshowdates.getText();
			System.out.println("Showdate " + msd);
			if (msd.equalsIgnoreCase(CommonMethods.passingData("MovieBookingDate"))) {
				movieshowdates.click();
				System.out.println("selected");
				break;

			}
		}
	}

	public void movietimeselection() {

		// List of Show Time Details :

		List<WebElement> Stimes = driver.findElements(showtimes);
		System.out.println("showtimes" + Stimes.size());
		for (WebElement ShowTimings : Stimes) {
			String ST = ShowTimings.getText();
			System.out.println("Selectebledate " + ST);
			if (ST.equalsIgnoreCase(CommonMethods.passingData("MovieBokkingTime"))) {
				System.out.println();
				ShowTimings.click();
				driver.findElement(alertmovieok).click();
				break;
			}
		}
	}

	String seatnumber;

	public void numberoftickets() throws InterruptedException {

		// Total Number of Seat that user can select (1, 2 ,3 ,4 , 5, 6)

		List<WebElement> seatselection = driver.findElements(ticketcount2);
		System.out.println("Max seat can book by you :" + seatselection.size());

		// for loop to select the seat based on user wish

		for (int i = 1; i <= seatselection.size(); i++) {
			String s1 = "//*[@class='nav nav-pills members']/li[";
			int s2 = i;
			String s3 = "]/a";
			String s4 = Integer.toString(s2);
			WebElement seat1 = driver.findElement(By.xpath(s1 + s4 + s3));
			String seatnumber123 = seat1.getAttribute("href");
			String[] person = seatnumber123.split("person");
			int count = person.length;
			seatnumber = person[1];
			System.out.println("Seat Number is : " + seatnumber);
			if (seatnumber.equalsIgnoreCase(CommonMethods.passingData("numberofseats"))) {
				System.out.println("@-----------");
				Actions aaa = new Actions(driver);

				Thread.sleep(3000);
				aaa.moveToElement(seat1).build().perform();
				Thread.sleep(3000);
				seat1.click();
				Thread.sleep(5000);
				driver.findElement(seatselectionOkclick).click();
				break;

			}

		}

	}

	public void movieseatselection() throws InterruptedException {

		// User Can Select the Available Seat
		Thread.sleep(2000);
		List<WebElement> seatsselection = driver.findElements(seatlayoutselect);
		System.out.println("Avalaible seats are :" + seatsselection.size());
		for (WebElement seat11 : seatsselection) {
			Actions a = new Actions(driver);
			a.moveToElement(seat11).build().perform();
			seat11.click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			WebElement paybutton = driver.findElement(proceedbutton);
			boolean pp = paybutton.isDisplayed();
			if (pp == true) {
				paybutton.click();
				driver.findElement(txtPaymentMobile).sendKeys(CommonMethods.passingData("mobile"));
				driver.findElement(txtPaymentEmail).sendKeys(CommonMethods.passingData("EnterMail"));
				debitpaymovies();
				Thread.sleep(2000);
				System.out.println("done");
				break;
			}

			else {
				System.out.println("Notification is diplayed as: 'Please select a seat beside the selected seat(s)'");
				Thread.sleep(3000);
				seat11.click();
				Thread.sleep(3000);
			}

		}
	}
	
	public void movieseatselectionvoucher() throws InterruptedException {

		// User Can Select the Available Seat
		Thread.sleep(2000);
		List<WebElement> seatsselection = driver.findElements(seatlayoutselect);
		System.out.println("Avalaible seats are :" + seatsselection.size());
		for (WebElement seat11 : seatsselection) {
			Actions a = new Actions(driver);
			a.moveToElement(seat11).build().perform();
			seat11.click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			WebElement paybutton = driver.findElement(proceedbutton);
			boolean pp = paybutton.isDisplayed();
			if (pp == true) {
				paybutton.click();				
				driver.findElement(txtPaymentEmail).clear();
				driver.findElement(txtPaymentMobile).sendKeys(CommonMethods.passingData("mobile"));
				driver.findElement(txtPaymentEmail).sendKeys(CommonMethods.passingData("vemail"));
				driver.findElement(voucher).sendKeys(CommonMethods.passingData("vouchermulapply"));
				driver.findElement(evoucheraplybtn).click();
				Thread.sleep(3000);
				CommonMethods.explicitWaitForElementVisibility(moviespayproceed);
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElement(moviespayproceed).click();
				Thread.sleep(3000);
				System.out.println("done");
				break;
			}

			else {
				System.out.println("Notification is diplayed as: 'Please select a seat beside the selected seat(s)'");
				Thread.sleep(3000);
				seat11.click();
				Thread.sleep(3000);
			}

		}
	}

	// More than seat selection then opt ...

	public String Moviebookingwithdebitcard() throws InterruptedException {

		//HomePage hp = new HomePage();
		movietabselection();
		nowplayingmovieselection();
		moviedateselection();
		movietimeselection();
		numberoftickets();
		movieseatselection();
		return driver.findElement(ticketsuccess).getText();
	}
	
	public String Moviebookingwithvchr() throws InterruptedException {

		//HomePage hp = new HomePage();
		movietabselection();
		nowplayingmovieselection();
		moviedateselection();
		movietimeselection();
		numberoftickets();
		movieseatselectionvoucher();
		return driver.findElement(ticketsuccess).getText();
	}

	// Price Comparison Method :

	public void pricecomparemovies() throws InterruptedException {
		/*
		 * HomePage hp = new HomePage(); hp.movietabselection();
		 * hp.nowplayingmovieselection(); hp.moviedateselection();
		 * hp.movietimeselection(); hp.numberoftickets();
		 * hp.movieseatselection();
		 */
		WebElement proceedpaybtn = driver.findElement(By.id("btnPay"));

		if (proceedpaybtn.isDisplayed()) {
			WebElement ticketnumber = driver.findElement(By.id("TicketsSelected"));
			String ticketprice = ticketnumber.getText();
			System.out.println("No. of Tickets selected * Price is : " + ticketprice);
			String[] ticketdetails = ticketprice.split(" ");
			int ll = ticketdetails.length;
			System.out.println(ll);
			System.out.println("Number of Tickets selected : " + ticketdetails[0] + "---" + ticketdetails[4] + "---"
					+ ticketdetails[7]);
			System.out.println("=======" + ticketdetails[0]);
			System.out.println("=======" + CommonMethods.passingData("numberofseats"));

			if (CommonMethods.passingData("numberofseats").equalsIgnoreCase(ticketdetails[0])) {

				// seatnumber is global variable ;

				float totalprice = (Float.parseFloat(ticketdetails[4]) * Integer.parseInt(seatnumber));
				System.out.println("@]]]]]]" + totalprice);
				String roundedTotalPrice = String.format("%.2f", totalprice);
				System.out.println("Total price after rounded" + roundedTotalPrice);
				String priceis = ticketnumber.findElement(By.xpath("./b")).getText();
				System.out.println("Ticket from web" + priceis);

				String pricefinal = priceis.split(" ")[1].trim();

				if (roundedTotalPrice.trim().equals(pricefinal)) {
					System.out.println("Prices are Same");
				}

				else {
					System.out.println("+++++++++++++++");
				}

			}

			else {
				System.out.println("SeatNumber and Ticket details are getting mismatch");
			}

		}

	}

	// Change Seat number and Price comparison Method

	// pallavi.domreddy

	public void changeticketsnumberfromseatlayoutpage() throws InterruptedException {

		homepagelive hp = new homepagelive();
		hp.movietabselection();
		hp.nowplayingmovieselection();
		hp.moviedateselection();
		hp.movietimeselection();
		/*
		 * hp.numberoftickets(); hp.movieseatselection();
		 */

		// Total Number of Seat that user can select
		int flag = 1;
		List<WebElement> seatselection = driver.findElements(ticketcount2);
		System.out.println("Max seat can book by you :" + seatselection.size());
		WebElement seat1;
		// for loop to select the seat based on user wish

		for (int i = 1; i <= seatselection.size(); i++) {
			String s11 = "//*[@class='nav nav-pills members']/li[";
			int s22 = i;
			String s33 = "]/a";
			String s55 = "]";

			String s44 = Integer.toString(s22);

			seat1 = driver.findElement(By.xpath(s11 + s44 + s33));

			String seatnumber12345 = seat1.getAttribute("href");
			System.out.println("Seatnumber12345" + seatnumber12345);
			String[] xxx = seatnumber12345.split("person");
			int count = xxx.length;
			String seatnumber = xxx[1];
			System.out.println("Seat Number is : " + seatnumber);

			if (seatnumber.equalsIgnoreCase(CommonMethods.passingData("numberofseats"))) {
				System.out.println("@-----------");

				Thread.sleep(3000);
				seat1.click();
				Thread.sleep(5000);
				driver.findElement(seatselectionOkclick).click();
				Thread.sleep(3000);

				driver.findElement(By.id("noOfTicketsSpan")).click();
				String changenumber = CommonMethods.passingData("changeinnumberofseats");
				s22 = Integer.parseInt(changenumber);
				System.out.println("//////" + s22);

				s44 = Integer.toString(s22);

				WebElement seatvalue = driver.findElement(By.xpath(s11 + s44 + s33));
				System.out.println("---------++++ " + seatvalue);

				String seatnum = seatvalue.getAttribute("href");
				System.out.println("Seatnum : " + seatnum);

				String[] persnvalue123 = seatnum.split("person");
				int count123 = persnvalue123.length;
				String seatchangevalu = persnvalue123[1];
				System.out.println("[[[[[" + count123);

				// String seatnumberxxx = persnvalue123[1];
				System.out.println("Seat Number is : " + seatchangevalu);

				if (seatchangevalu.equalsIgnoreCase(changenumber)) {

					System.out.println("------------##");
					Thread.sleep(5000);
					seatvalue.click();
					driver.findElement(seatselectionOkclick).click();

					Thread.sleep(5000);
					List<WebElement> seatsselection = driver.findElements(seatlayoutselect);
					System.out.println("Avalaible seats are :" + seatsselection.size());

					for (WebElement seat11 : seatsselection) {
						System.out.println("////////" + seat11);
						Actions a = new Actions(driver);

						Thread.sleep(3000);
						a.moveToElement(seat11).build().perform();
						seat11.click();
						Thread.sleep(10000);
						WebElement proceedpaybtn = driver.findElement(By.id("btnPay"));
						if (proceedpaybtn.isDisplayed()) {
							WebElement ticketnumber123 = driver.findElement(By.id("TicketsSelected"));
							String ticketprice123 = ticketnumber123.getText();
							System.out.println("No. of Tickets selected * Price is : " + ticketprice123);
							/*
							 * String tp = ticketprice.trim();
							 * System.out.println("-----------" +tp);
							 */

							String[] ticketdetails123 = ticketprice123.split(" ");
							int ll = ticketdetails123.length;
							System.out.println(ll);
							System.out.println("Number of Tickets selected : " + ticketdetails123[0] + "---"
									+ ticketdetails123[4] + "---" + ticketdetails123[7]);
							System.out.println("=======" + ticketdetails123[0]);
							System.out.println("=======" + CommonMethods.passingData("changeinnumberofseats"));

							if (CommonMethods.passingData("changeinnumberofseats")
									.equalsIgnoreCase(ticketdetails123[0])) {
								System.out.println("}}}}]------");

								float cc = (Float.parseFloat(ticketdetails123[4]));
								System.out.println("CC is " + cc);
								int c1 = Integer.parseInt(seatchangevalu);
								System.out.println("c1" + c1);

								float totalprice123 = cc * c1;
								System.out.println("@]]]]]]" + totalprice123);
								// float totalprice1=
								// Math.round((totalprice*100.0)/100.0);

								String roundedTotalPrice123 = String.format("%.2f", totalprice123);

								System.out.println("Total price after rounded" + roundedTotalPrice123);
								String priceis123 = ticketnumber123.findElement(By.xpath("./b")).getText();
								System.out.println("Ticket from web" + priceis123);

								String pricefinal123 = priceis123.split(" ")[1].trim();

								if (roundedTotalPrice123.trim().equals(pricefinal123)) {
									System.out.println("Prices are Same");
								}

								else {
									System.out.println("+++++++++++++++");
								}

							}

							else {
								System.out.println("SeatNumber and Ticket details are getting mismatch");
							}

							flag = 1;
							// String totalprice = driver.findElement(b)
							break;

						}

						break;
					}

					flag = 1;

				}

				if (flag == 1) {
					break;
				}

			}

		}

	}

	// Quick booking

	// By quickbookclick =
	// By.xpath("//*[@class='quick-booking-input-docker']/h4");

	By movieslist = By.id("MoviesList");
	By selectmall = By.id("CinemaList");
	By selectdate = By.id("ShowDates");
	By selecttime = By.id("ShowTimes");
	By booknow = By.id("BookNow");

	public String quickbooking() throws InterruptedException

	{
		// driver.findElement(quickbookclick).click();
		 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		Select movies = new Select(driver.findElement(movieslist));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		movies.selectByVisibleText("21 ST NOOTTAANDU");
		Select malls = new Select(driver.findElement(selectmall));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		malls.selectByVisibleText("Cineco Seef - Seef Area");
		Select date = new Select(driver.findElement(selectdate));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		date.selectByVisibleText("Saturday, 9 Nov");
		Select time = new Select(driver.findElement(selecttime));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		time.selectByVisibleText("11:00PM-Cinema 10");
		driver.findElement(booknow).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(alertmovieok).click();
		Thread.sleep(4000);
		List<WebElement> seatselection = driver.findElements(ticketcount2);
		System.out.println("Max seat can book by you :" + seatselection.size());
		for (WebElement seat : seatselection) {
			String seatnumber = seat.getText();
			if (seatnumber.equalsIgnoreCase("1")) {
				seat.click();
				Thread.sleep(4000);
				driver.findElement(seatselectionOkclick).click();

			}
		}

		Thread.sleep(2000);
		List<WebElement> seatsselection = driver.findElements(seatlayoutselect);
		System.out.println("Avalaible seats are :" + seatsselection.size());
		for (WebElement seat11 : seatsselection) {
			Actions a = new Actions(driver);
			a.moveToElement(seat11).build().perform();
			seat11.click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			WebElement paybutton = driver.findElement(proceedbutton);
			boolean pp = paybutton.isDisplayed();
			if (pp == true) {
				paybutton.click();
				 driver.findElement(txtPaymentMobile).sendKeys(CommonMethods.passingData("mobile"));
				 driver.findElement(txtPaymentEmail).sendKeys(CommonMethods.passingData("EnterMail"));

				debitpaymovies();
				Thread.sleep(4000);
				System.out.println("done");
				break;
			}

			else {
				System.out.println("Notification is diplayed as: 'Please select a seat beside the selected seat(s)'");
				seat11.click();
			}

		}

		return driver.findElement(ticketsuccess).getText();
	}

	// Debit card pay

	public void debitpayevents() throws InterruptedException {
		driver.findElement(txtPaymentMobile).sendKeys(CommonMethods.passingData("mobile"));
		driver.findElement(txtPaymentEmail).sendKeys(CommonMethods.passingData("EnterMail"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		CommonMethods.explicitWaitForClickableElement(driver, driver.findElement(debitcardbtn));
		driver.findElement(debitcardbtn).click();
		// Thread.sleep(2000);
		driver.findElement(btnforpay).click();
		CommonMethods.explicitWaitForElementVisibility(cardnumber);
		driver.findElement(cardnumber).sendKeys(CommonMethods.passingData("CardNumber"));
		//driver.findElement(By.id("Ecom_Payment_Card_Verification_id")).sendKeys("123");
		 Thread.sleep(2000);
		driver.findElement(expiryMonth).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Select oSelect = new Select(driver.findElement(expiryMonth));
		oSelect.selectByIndex(11);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(expiryYear).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Select oSelect1 = new Select(driver.findElement(expiryYear));
		oSelect1.selectByIndex(10);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(cardname).sendKeys(CommonMethods.passingData("CardName"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(pinNumber).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//driver.findElement(pinNumber).sendKeys("1234");
		driver.findElement(pin1).click();
		driver.findElement(pin2).click();
		driver.findElement(pin3).click();
		driver.findElement(pin4).click();
		driver.findElement(pinEnter).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(submit).click();
		driver.findElement(conform).click();
	}
	
	
	public void debitpayeventsold() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		CommonMethods.explicitWaitForClickableElement(driver, driver.findElement(debitcardbtn));
		driver.findElement(debitcardbtn).click();
		// Thread.sleep(2000);
		driver.findElement(btnforpay).click();
		CommonMethods.explicitWaitForElementVisibility(cardnumber);
		driver.findElement(cardnumber).sendKeys(CommonMethods.passingData("CardNumber"));
		// Thread.sleep(2000);
		driver.findElement(expiryMonth).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Select oSelect = new Select(driver.findElement(expiryMonth));
		oSelect.selectByIndex(11);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(expiryYear).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Select oSelect1 = new Select(driver.findElement(expiryYear));
		oSelect1.selectByIndex(10);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(cardname).sendKeys(CommonMethods.passingData("CardName"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(pinNumber).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(pin1).click();
		driver.findElement(pin2).click();
		driver.findElement(pin3).click();
		driver.findElement(pin4).click();
		driver.findElement(pinEnter).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(submit).click();
		driver.findElement(conform).click();
	}

	// Debit pay movies

	public void debitpaymovies() throws InterruptedException {

		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		CommonMethods.explicitWaitForClickableElement(driver, driver.findElement(debitcardbtn));
		 driver.findElement(debitcardbtn).click();
		CommonMethods.explicitWaitForElementVisibility(moviespayproceed);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(moviespayproceed).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		CommonMethods.explicitWaitForElementVisibility(cardnumber);
		driver.findElement(cardnumber).sendKeys(CommonMethods.passingData("CardNumber"));
		driver.findElement(expiryMonth).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Select oSelect = new Select(driver.findElement(expiryMonth));
		oSelect.selectByIndex(11);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(expiryYear).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Select oSelect1 = new Select(driver.findElement(expiryYear));
		oSelect1.selectByIndex(10);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(cardname).sendKeys(CommonMethods.passingData("CardName"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(pinNumber).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(pin1).click();
		driver.findElement(pin2).click();
		driver.findElement(pin3).click();
		driver.findElement(pin4).click();
		driver.findElement(pinEnter).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(submit).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(conform).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	// Contact us (Bahrain)

	By fname = By.id("firstName");
	By lname = By.id("secondName");
	By Email = By.id("emailId");
	By cnum = By.id("contactNumber");
	By cname = By.id("companyName");
	By cmts = By.id("comments");
	By checkbox = By.xpath("//input[@id='isEventOrganizer']");
	By sendbutton = By.id("btnSendQuery");
//	By sendsuccess = By.className("toast-message");
	By contactsuccessmsg = By.xpath("//div[contains(@class,'toast-message') and contains(.,'Thanks for providing your information we will get back to you soon')]");

	// Thanks for providing your information we will get back to you soon
	// //toaster-message //toast-close-button

	public String contactus() {
		driver.findElement(contactus).click();
		driver.findElement(fname).sendKeys("pallavi");
		driver.findElement(lname).sendKeys("domreddy");
		driver.findElement(Email).sendKeys("pallavidomreddy@gmail.com");
		driver.findElement(cnum).sendKeys("32368745");
		driver.findElement(cname).sendKeys("smscountry");
		driver.findElement(cmts).sendKeys("test test");
		driver.findElement(sendbutton).click();
		return driver.findElement(contactsuccessmsg).getText();
	}

	// icon clicks bhd
	By fbicon = By.id("faceboolink");
	By insta = By.id("instalink");
	By youtube = By.id("youtublink");
	By fbid = By.id("u_0_3");
	By smlinks = By.xpath("//*[@class='social text-center']/a");

	public int SMiconclick() throws InterruptedException {
		Thread.sleep(2000);
		// driver.findElement(location).click();
		WebElement xx = driver.findElement(By.xpath("//span[@class='fa fa-map-marker']"));
		Actions a = new Actions(driver);
		a.moveToElement(xx).build().perform();
		Thread.sleep(2000);
		List<WebElement> s3 = driver.findElements(By.xpath("//li[@class='dropdown liLocation']/ul/li"));
		// System.out.println("List of locations" +s3.size());

		for (WebElement s4 : s3) {
			String s5 = s4.findElement(By.xpath("./a")).getText();
			// System.out.println("Country Name " +s5);
			String s6 = CommonMethods.passingData("loc");
			// System.out.println("For Json:" +s6);
			if (s6.equalsIgnoreCase(s5)) {
				s4.click();
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
				List<WebElement> slinks = driver.findElements(smlinks);
				for (WebElement sl : slinks) {
					sl.click();
					//
					Thread.sleep(4000);
					ArrayList iconclick = new ArrayList(driver.getWindowHandles());
					System.out.println("Size of windows opened" + iconclick.size());
					driver.switchTo().window((String) iconclick.get(1));
					String s1 = driver.getCurrentUrl();

					System.out.println(s1);
					// driver.close();
					driver.switchTo().window((String) iconclick.get(0));
					String s2 = driver.getCurrentUrl();
					System.out.println(s2);
				}
				break;
			}

		}
		ArrayList fbclick = new ArrayList(driver.getWindowHandles());
		int windowsopened = fbclick.size();
		return windowsopened;

	}

	// play/app store click

	By playstore = By.xpath("//*[@class='col-md-3 store']/a[1]");
	By appstore = By.xpath("//*[@class='col-md-3 store']/a[2]");

	public String playstoreclick() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		driver.findElement(playstore).click();
		String s1 = driver.getCurrentUrl();
		System.out.println(s1);
		return s1;

	}

	public String appstoreclick() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		driver.findElement(appstore).click();
		String s1 = driver.getCurrentUrl();
		System.out.println(s1);
		return s1;

	}

	// advertisingneeds
	By name1 = By.id("txtFirstName");
	By name2 = By.id("txtLastName");
	By advtemail = By.id("txtEmail");
	By advtmobile = By.id("txtPhoneNum");
	By addescription = By.id("txtDescription");
	By advtsubmit = By.id("btnSubmit");
	By advtsuccessmsg = By.xpath("//*[contains(@class,'toast-message') and contains(text(),'Thanks for providing your information we will get back to you soon.')]");
    By advertisingneedssuccesmsg =  By.xpath("//div[contains(@class,'toast-message') and contains(.,'Thanks for providing your information we will get back to you soon.')]");
	public String advertisingneeds() throws InterruptedException {
		driver.findElement(AdvertiseWithUs).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		driver.findElement(name1).sendKeys("pallavi");
		driver.findElement(name2).sendKeys("domreddy");
		driver.findElement(advtemail).sendKeys("pallavi.domreddy@smscountry.com");
		driver.findElement(advtmobile).sendKeys("7396206647");
		driver.findElement(addescription).sendKeys("test desc");
		driver.findElement(advtsubmit).click();
		Thread.sleep(2000);
		return driver.findElement(advtsuccessmsg).getText();
	}

	// Advertise With Us Query Page

	By advertiseWithUs = By.xpath("//*[@id='advertiseWithUs']");
	By adverFName = By.id("txtFirstName");
	By adverLName = By.id("txtLastName");
	By adverEmail = By.id("txtEmail");
	By prefixAd = By.xpath("/html/body/div[1]/main/section[4]/div/form/div[1]/div/div");
	By bhdCountryCode = By.xpath("//*[@class='imagemodal11'][1]//*[@countryphcode='973']");
	By phoneNumText = By.id("txtPhoneNum");
	By descrip = By.id("txtDescription");
	By submitBtn = By.id("btnSubmit");
	By successAdd = By.xpath(
			"//*[contains(@class,'toast-message') and contains(text(),'Thanks for providing your information we will get back to you soon.')]");

	public String queryAdvertise() {
		// driver.navigate().to("http://staging.wanasatime.com");
		driver.findElement(advertiseWithUs).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		driver.findElement(adverFName).sendKeys("Manjusha");
		driver.findElement(adverLName).sendKeys("Konala");
		driver.findElement(adverEmail).sendKeys(CommonMethods.passingData("EnterMail"));
		driver.findElement(prefixAd).click();
		driver.findElement(bhdCountryCode).click();
		driver.findElement(phoneNumText).sendKeys("33456789");
		driver.findElement(descrip).sendKeys("I want to Advertise from your Platform");
		driver.findElement(submitBtn).click();
		String ur = driver.getCurrentUrl();
		return ur;
	}

	// Any Query in Plans and Pricing...

	By plansandpricing = By.xpath("//*[@href='/PlansPricing.aspx']");
	By anyQuery = By.xpath("//*[@class='text-center']//*[@class='anyQuery']");
	By userEmail = By.id("userE-mail");
	By userMessage = By.id("userMessage");
	By subBtn = By.id("submitQuery");
	By thanksmsg	=	By.xpath("//*[@id='lblsubmitQuery']");

	public String plansAndPricingQuery() throws InterruptedException

	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		driver.findElement(plansandpricing).click();
		driver.findElement(anyQuery).click();
		driver.findElement(userEmail).sendKeys(CommonMethods.passingData("EnterMail"));
		driver.findElement(userMessage).sendKeys("I want to know the plans and pricing Details");
		driver.findElement(subBtn).click();
		// String u=driver.getCurrentUrl();
		Thread.sleep(1000);
		//CommonMethods.explicitWaitForElementVisibility(thanksmsg);
		return driver.findElement(thanksmsg).getText();

	}

	// user
	// menu s

	By menu2 = By.xpath("//*[@id='icon-m-hamburger'][1]");
	public By menu = By.xpath("//button[@id='userMenu']//*[@id='icon-m-hamburger']");
	By menu1 = By.id("userMenu");
	By profileclick = By.xpath("//a[@id='myProfile']");
	By BookingHistory = By.xpath("//a[@id='bookingHistory']");
	By Evouchers = By.id("eVouchers");
	// By AdvertiseWithUs = By.linkText("Advertise With Us");
	// By logout = By.id("Logout");

	// profile edit

	By buyerFName = By.id("buyerFName");
	By buyerLName = By.id("buyerLName");

	// Profile Pic Locators

	By profilepic = By.id("picEditIcon");
	By profilesavebtn = By.id("btnSaveImage");

	// genderdropdown

	By gender = By.id("buyerGender");
	By buyerState = By.id("buyerState");
	By buyerCity = By.id("buyerCity");
	By updateBuyerProfile = By.id("updateBuyerProfile");
	By userdob = By.id("buyerDOB");
	By changePasswordBtn = By.id("changePasswordBtn");

	public void edituser() throws Exception {
		//signinWanasaTimeCredentials();
		driver.findElement(menu1).click();
		Thread.sleep(2000);
		driver.findElement(profileclick).click();
		Thread.sleep(2000);
		/*driver.findElement(profilepic).click();
		Thread.sleep(2000);
		StringSelection ss = new StringSelection("C:\\Users\\Smsc_Tech\\Desktop\\kangana.jpg");
		Thread.sleep(8000);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(14000);
		driver.findElement(profilesavebtn).click();*/
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(buyerLName).clear();
		Thread.sleep(3000);
		driver.findElement(buyerLName).sendKeys("domreddy");
		Thread.sleep(3000);
		WebElement testDropDown = driver.findElement(By.id("buyerGender"));
		Select gender = new Select(testDropDown);
		gender.selectByValue("Female");
		//driver.findElement(userdob).clear();
		/*
		 * List<WebElement> dob=driver.findElements(By.id("buyerDOB"));
		 * 
		 * for(WebElement ele:dob) {
		 * 
		 * String date=ele.getText();
		 * 
		 * if(date.equalsIgnoreCase("12/08/1995")) { ele.click(); break; } }
		 */
	/*	JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('buyerDOB').value='" + CommonMethods.passingData("userDOB") + "'");
		driver.findElement(userdob).click();*/
		driver.findElement(buyerState).clear();
		Thread.sleep(3000);
		driver.findElement(buyerState).sendKeys("hyd");
		driver.findElement(buyerCity).clear();
		Thread.sleep(3000);
		driver.findElement(buyerCity).sendKeys("hyd");
		driver.findElement(updateBuyerProfile).click();
		Thread.sleep(6000);

	}

	// change password
	By oldPassword = By.id("oldPassword");
	By newpassword = By.id("newPassword");
	By ConfirmPassword = By.id("cnfrmPassword");
	By BtnupdatePassword = By.id("updatePassword");
	By pwdupdateclose = By.xpath("//button[contains(@class,'mr_10')]");
	// By successmsgpwd = By.xpath("//*[contains(@class,'toast-message') and
	// contains(text(),'Password Changed Successfully')]");
	By successmsgp = By.xpath("//*[contains(@class,'toast-message')]");

	// pallavi
	public String passwordchange() throws InterruptedException {
		/*
		 * Thread.sleep(5000);
		 * CommonMethods.explicitWaitForElementVisibility(menu1);
		 * driver.findElement(menu1).click();
		 * //driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		 * CommonMethods.explicitWaitForElementVisibility(profileclick);
		 * driver.findElement(profileclick).click();
		 */
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(changePasswordBtn).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(oldPassword).sendKeys(CommonMethods.passingData("Password"));
		driver.findElement(newpassword).sendKeys(CommonMethods.passingData("newpwdchange"));
		driver.findElement(ConfirmPassword).sendKeys(CommonMethods.passingData("newpwdchange"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(BtnupdatePassword).click();
		CommonMethods.explicitWaitForElementVisibility(successmsgp);
		return driver.findElement(successmsgp).getText();

	}

	public void pwdcahngeclose() throws InterruptedException {
		/*
		 * Thread.sleep(5000);
		 * CommonMethods.explicitWaitForElementVisibility(menu1);
		 * driver.findElement(menu1).click();
		 * //driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		 * CommonMethods.explicitWaitForElementVisibility(profileclick);
		 * driver.findElement(profileclick).click();
		 */
		driver.findElement(changePasswordBtn).click();
		driver.findElement(pwdupdateclose).click();
	}

	// preferences

	By preclick = By.xpath("//a[contains(text(),'Preferences')]");
	// By movies =
	// By.xpath("//div[@id='preferences']//h5[contains(text(),'Movies')]");
	By checkboxclickmovies = By.xpath("//*[@id='movieDiv']/div[3]/label/input");
	By checkboxclickevents = By.xpath("//*[@id='eventsDiv']/div[3]/label/input");
	By checkboxclicksports = By.xpath("//*[@id='sportsDiv']/div[2]/label/input");
	By preupadte = By.id("btnUpdatePreferences");
	// toast toast-success
	By prefersuccess = By
			.xpath("//*[contains(@class,'toast toast-success') and contains(text(),'Preferences Saved Successfully')]");

	public String preferences() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		/*
		 * Thread.sleep(5000);
		 * CommonMethods.explicitWaitForElementVisibility(menu1);
		 * driver.findElement(menu1).click();
		 * CommonMethods.explicitWaitForElementVisibility(profileclick);
		 * driver.findElement(profileclick).click();
		 */
		driver.findElement(preclick).click();
		driver.findElement(checkboxclickmovies).click();
		driver.findElement(checkboxclickevents).click();
		// js.executeScript("window.scrollBy(0,300)");
		// driver.findElement(checkboxclicksports).click();
		driver.findElement(preupadte).click();
		return driver.findElement(successmsgp).getText();
	}

	// notifications
	By notclilck = By.xpath("//a[contains(text(),'Notifications')] ");
	By DeactivateAccountsms = By.xpath("//div[@id='notification']//div//div[1]//div[1]//div[2]//label");
	By notupdate = By.id("btnESUpdate");
	By notsuccess = By.xpath(
			"//*[contains(@class,'toast toast-success') and contains(text(),'Notifications Saved Successfully')]");

	public String notifications() throws InterruptedException {
		/*
		 * Thread.sleep(5000);
		 * CommonMethods.explicitWaitForElementVisibility(menu1);
		 * driver.findElement(menu1).click();
		 * CommonMethods.explicitWaitForElementVisibility(profileclick);
		 * driver.findElement(profileclick).click();
		 * CommonMethods.explicitWaitForElementVisibility(notclilck);
		 */
		driver.findElement(notclilck).click();
		driver.findElement(DeactivateAccountsms).click();
		driver.findElement(notupdate).click();
		CommonMethods.explicitWaitForElementVisibility(successmsgp);
		return driver.findElement(successmsgp).getText();
	}

	// booking history

	By mvebookings = By.linkText("MOVIES");
	By Eventbookings = By.linkText("EVENTS");
	By Allbookings = By.linkText("ALL");;
	By Apply = By.id("btnApply");
	By fromdate = By.id("fromDate");
	By todate = By.id("toDate");
	By calprevclick = By.xpath("//div[@class='datepicker-days']//th[@class='prev']");
	By clickyear = By.xpath("//*[@class=' table-condensed']//*[@class='datepicker-switch']");
	By selectyr = By.xpath(" //div[@class='datepicker-years']//td//span[contains(text(),'2018')]");
	By selectmonth = By.xpath("//div[@class='datepicker-months']//td//span[contains(text(),'Dec')]");
	By searchapply = By.id("btnApply");

	public void searchbookingistory() throws InterruptedException {
		driver.findElement(menu1).click();
		Thread.sleep(2000);
		driver.findElement(BookingHistory).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// todaybookings
		WebElement testDropDown = driver.findElement(By.id("filterSelection"));
		Select moviesstatus = new Select(testDropDown);
		moviesstatus.selectByValue("3");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('fromDate').value='" + CommonMethods.passingData("fromdate") + "'");
		js.executeScript("document.getElementById('toDate').value='" + CommonMethods.passingData("todate") + "'");
		driver.findElement(searchapply).click();
		Thread.sleep(6000);
	}

	// Negative Cases

	// events

	// Single day Event Cancel and Back Button

	By tabEvents = By.id("tabEvents");

	By back = By.id("btnBack");
	By cancel = By.xpath("//*[@class='text-center mt_30 mb_20']//button[1]");
	By catSelectionChild = By.id("403");
	By catSelectionParent = By.id("404");
	By btnCreditCard = By.id("btnCreditCard");
	By cancelBtnCreditCard = By.xpath("//*[@class='col-xs-12 text-right hidden-xs']//*[@class='cancelButton']");
	By ticketFailure = By.xpath("//*[@id='failedMsg']//h4");

	public boolean singleDayBackBtnBahrain() {
		driver.findElement(tabEvents).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		driver.findElement(eventbookBHDMusic).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(eventbookingclick).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//driver.findElement(okButtonOnOverlay).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(dateselection).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(next).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//driver.findElement(selectcategoryfree).click();
		driver.findElement(back).click();
		CommonMethods.explicitWaitForElementVisibility(next);
		return driver.findElement(next).isDisplayed();
	}

	public boolean singleDayCancelBtnBahrain() {
		driver.findElement(tabEvents).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		driver.findElement(eventbookBHDMusic).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(eventbookingclick).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//driver.findElement(okButtonOnOverlay).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.findElement(dateselection).click();
		// driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		// driver.findElement(next).click();
		// driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		// driver.findElement(selectcategoryfree).click();
		driver.findElement(cancel).click();
		return driver.findElement(eventbookingclick).isDisplayed();

	}

	// Cancel in credit Card

	public String cancelBtnInCreditCard() throws InterruptedException {
		driver.findElement(tabEvents).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		driver.findElement(eventbookBHDMusic).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(eventbookingclick).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//driver.findElement(okButtonOnOverlay).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//driver.findElement(dateselection).click();
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(next).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(selectcategorygold).click();
		driver.findElement(ticketcountsubvipaudlut1).click();
		driver.findElement(ticketcountsubvipchild2).click();
		CommonMethods.explicitWaitForElementVisibility(btnproceed);
		driver.findElement(btnproceed).click();
		// driver.findElement(custname).sendKeys(CommonMethods.passingData("name"));
		driver.findElement(txtPaymentMobile).sendKeys(CommonMethods.passingData("mobile"));
		driver.findElement(txtPaymentEmail).sendKeys(CommonMethods.passingData("EnterMail"));
		CommonMethods.explicitWaitForElementVisibility(btnproceedfinal);
		driver.findElement(btnproceedfinal).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(cancelBtnCreditCard).click();
		Thread.sleep(2000);
		CommonMethods.explicitWaitForElementVisibility(ticketFailure);
		return driver.findElement(ticketFailure).getText();
	}

	// Back button in Seat selection Page Naal Event Qatar

	By naalEvent = By.xpath("//*[@href='arts-and-culture/hollywood-popup-comedy']");
	By catsilver = By.id("silver");
	By goBack = By.id("goBack");

	public boolean backinSeatLayoutPage() {
		CommonMethods.explicitWaitForElementVisibility(naalEvent);
		driver.findElement(naalEvent).click();
		driver.findElement(eventbookingclick).click();
		driver.findElement(catsilver).click();
		//CommonMethods.explicitWaitForElementVisibility(next);
		driver.findElement(seatselectionOkclick).click();
		//driver.findElement(btnproceed).click();
		driver.findElement(goBack).click();
		return driver.findElement(seatselectionOkclick).isDisplayed();
	}

	// proceed button without selecting seat layout

	By proceedToPay = By.id("proceed");
	By withoutSeat = By
			.xpath("//*[contains(@class,'toast-message') and contains(text(),'Please select your tickets')]");

	public String proceedInSeatLayoutWithOutSelectingSeat() {
		CommonMethods.explicitWaitForElementVisibility(naalEvent);
		driver.findElement(naalEvent).click();
		driver.findElement(eventbookingclick).click();
		driver.findElement(catsilver).click();
		//CommonMethods.explicitWaitForElementVisibility(next);
		driver.findElement(seatselectionOkclick).click();		
		driver.findElement(proceed).click();	
		return driver.findElement(withoutSeat).getText();
	}

	// Cancel Button in Payment GateWay Page CBQ

	By festivalAround = By.xpath("//*[@href='arts-and-culture/festivals-around-theworld']");
	By yesbtnAfterCancel = By.xpath("//span[contains(@class,'ui-button-text')][contains(text(),'Yes')]");
	By subCatAdult = By.xpath("//button[@id='326'][1]");
	By subCatChild = By.xpath("//button[@id='327'][2]");
	By cancelinPayment = By.xpath("//*[@id='payment_details']/input[1]");
	By withOutSelectingSeat = By.xpath(
			"//*[contains(@class,'toast-message') and contains(text(),'Select No.Of Tickets you want to book')]");
  	public String cancelBtnInPaymentPage() {
		
		driver.findElement(littlesing).click();
		driver.findElement(eventbookingclick).click();
		//driver.findElement(okButtonOnOverlay).click();
		driver.findElement(next).click();
		driver.findElement(silvercat).click();
		driver.findElement(btnproceedfinal).click();
		driver.findElement(custname).sendKeys(CommonMethods.passingData("name"));
		driver.findElement(txtPaymentMobile).sendKeys(CommonMethods.passingData("mobile"));
		driver.findElement(txtPaymentEmail).sendKeys(CommonMethods.passingData("EnterMail"));
		driver.findElement(btnproceedfinal).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(cancelinPayment).click();
		driver.findElement(yesbtnAfterCancel).click();
		return driver.findElement(ticketFailure).getText();
	}

	public String eventticketBookingWithDebitCard1() throws InterruptedException {

		CommonMethods.explicitWaitForElementVisibility(eventstab);
		driver.findElement(eventstab).click();
		// driver.navigate().to("http://staging.wanasatime.com/night-life/bahrain-music-band");
		//
		driver.findElement(bhdmusiceventclick).click();
		driver.findElement(eventbookingclick).click();
		//driver.findElement(okButtonOnOverlay).click();
		//driver.findElement(dateselection).click();
		driver.findElement(next).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(selectcategorygold).click();
		driver.findElement(ticketcountsubvipaudlut1).click();
		driver.findElement(btnproceedfinal).click();
		// driver.findElement(txtPaymentMobile).sendKeys(CommonMethods.passingData("mobile"));
		// driver.findElement(txtPaymentEmail).sendKeys(CommonMethods.passingData("EnterMail"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		debitpayevents();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver.findElement(ticketconfirmtext).getText();
	}
	// Proceed Btn without Selecting sub Categories

	public String withoutSubCategories() {
		
		
		CommonMethods.explicitWaitForElementVisibility(eventstab);
		driver.findElement(eventstab).click();
		// driver.navigate().to("http://staging.wanasatime.com/night-life/bahrain-music-band");
		//
		driver.findElement(bhdmusiceventclick).click();
		driver.findElement(eventbookingclick).click();
		//driver.findElement(okButtonOnOverlay).click();
		//driver.findElement(dateselection).click();
		driver.findElement(next).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(selectcategorygold).click();				
		driver.findElement(btnproceed).click();
		return driver.findElement(withOutSelectingSeat).getText();
	}

	public void socialmediaiconclick() throws InterruptedException {
		Thread.sleep(2000);
		// driver.findElement(location).click();
		WebElement xx = driver.findElement(By.xpath("//span[@class='fa fa-map-marker']"));
		Actions a = new Actions(driver);
		a.moveToElement(xx).build().perform();
		Thread.sleep(2000);
		List<WebElement> s3 = driver.findElements(By.xpath("//li[@class='dropdown liLocation']/ul/li"));
		// System.out.println("List of locations" +s3.size());

		for (WebElement s4 : s3) {
			String s5 = s4.findElement(By.xpath("./a")).getText();

			// System.out.println("Country Name " +s5);
			String s6 = CommonMethods.passingData("loc");
			// System.out.println("For Json:" +s6);
			if (s6.equalsIgnoreCase(s5)) {
				s4.click();
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
				List<WebElement> slinks = driver.findElements(smlinks);
				for (WebElement sl : slinks) {
					sl.click();

					Thread.sleep(4000);
					ArrayList fbclick = new ArrayList(driver.getWindowHandles());
					System.out.println("Size of windows opened" + fbclick.size());
					driver.switchTo().window((String) fbclick.get(1));
					// String s1 = driver.getCurrentUrl();
					// System.out.println(s1);
					driver.close();
					driver.switchTo().window((String) fbclick.get(0));
					// String s2 = driver.getCurrentUrl();
					// System.out.println(s2);
				}
				break;
			}
		}
	}

	// Movies Filter based on Mall Selection

	By moviesTab = By.id("tabMovies");
	By moreMovies = By.id("lnkMoreMovies");
	By cinemasFil = By.id("cinemas");
	By cinemasFilter = By.xpath("//*[@id='ddlCinemas']/a");
	By allMoviesCont = By.xpath("//*[@id='moviesContainer']/div");
	By seefCinema = By.xpath("//*[@id='ddlCinemas']//*[@cinemaid='1']");

	public boolean moviesFilter() throws InterruptedException {
		driver.findElement(moviesTab).click();
		// driver.findElement(moreMovies).click();
		WebElement xx = driver.findElement(By.id("cinemas"));
		Actions a = new Actions(driver);
		a.moveToElement(xx).build().perform();
		List<WebElement> moviesfilterlist = driver.findElements(cinemasFilter);
		// System.out.println("Moview Filter list size"
		// +moviesfilterlist.size());

		for (int i = 1; i <= moviesfilterlist.size(); i++) {

			String s1 = "//div[@id='ddlCinemas']/a[";
			int s2 = i;
			String s3 = "]";

			String s4 = Integer.toString(s2);

			WebElement eachmoviefilter = driver.findElement(By.xpath(s1 + s4 + s3));

			// System.out.println(eachmoviefliter);

			String moviefiltername = eachmoviefilter.getText();
			// System.out.println("moviefiltername" +moviefiltername);
			if (moviefiltername.contains(CommonMethods.passingData("cinemaLocation"))) {
				eachmoviefilter.click();
			}

		}

		List<WebElement> nowShowing = driver.findElements(allMoviesCont);
		System.out.println("nowShowing list size" + nowShowing.size());
		Thread.sleep(3000);

		if (nowShowing.size() >= 1) {
			return true;
		}
		return false;

	}
	// Movies filter based on Genre

	By genre = By.id("genre");
	By allGenreList = By.xpath("//*[@id='ddlGenresList']/a");

	public boolean moviesGenre() throws InterruptedException {
		driver.findElement(moviesTab).click();
		WebElement gen = driver.findElement(By.id("genre"));
		Actions a = new Actions(driver);
		a.moveToElement(gen).build().perform();
		List<WebElement> allGenreListA = driver.findElements(allGenreList);

		for (int i = 1; i <= allGenreListA.size(); i++) {

			String s1 = "//*[@id='ddlGenresList']/a[";
			int s2 = i;
			String s3 = "]";

			String s4 = Integer.toString(s2);

			WebElement genremoviefilter = driver.findElement(By.xpath(s1 + s4 + s3));

			String moviefilternamegenre = genremoviefilter.getText();
			if (moviefilternamegenre.contains(CommonMethods.passingData("genreName"))) {
				genremoviefilter.click();
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				// Thread.sleep(2000);

			}
		}

		List<WebElement> nowShowing1 = driver.findElements(allMoviesCont);
		System.out.println("nowShowing list size" + nowShowing1.size());

		if (nowShowing1.size() >= 1) {
			// System.out.println("Count of Movies"+nowShowing1);
			return true;
		}

		return false;

	}

	// Movies Filter Based on Language

	By language = By.id("lang");
	By allLanguages = By.xpath("//*[@id='ddlLanguage']/a");

	public boolean moviesLanguage() throws InterruptedException {
		driver.findElement(moviesTab).click();
		WebElement lan = driver.findElement(By.id("lang"));
		Actions a = new Actions(driver);
		a.moveToElement(lan).build().perform();
		List<WebElement> allLanguageList = driver.findElements(allLanguages);

		for (int i = 1; i <= allLanguageList.size(); i++) {

			String s1 = "//*[@id='ddlLanguage']/a[";
			int s2 = i;
			String s3 = "]";

			String s4 = Integer.toString(s2);

			WebElement movieLangfilter = driver.findElement(By.xpath(s1 + s4 + s3));

			String moviefilternameLang = movieLangfilter.getText();
			if (moviefilternameLang.contains(CommonMethods.passingData("LangName"))) {
				movieLangfilter.click();
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				// Thread.sleep(2000);

			}
		}

		List<WebElement> nowShowingLang = driver.findElements(allMoviesCont);
		System.out.println("nowShowing list size" + nowShowingLang.size());

		if (nowShowingLang.size() >= 1) {
			// System.out.println("Count of Movies"+nowShowing1);
			return true;
		}

		return false;

	}

	// Movies Filter Based on Mall,Genre and Language

	public boolean movieAllFilters() {
		driver.findElement(moviesTab).click();
		WebElement mall = driver.findElement(By.id("cinemas"));
		Actions a = new Actions(driver);
		a.moveToElement(mall).build().perform();
		List<WebElement> moviesfilterlist = driver.findElements(cinemasFilter);
		for (int i = 1; i <= moviesfilterlist.size(); i++) {

			String s1 = "//div[@id='ddlCinemas']/a[";
			int s2 = i;
			String s3 = "]";

			String s4 = Integer.toString(s2);

			WebElement eachmoviefilter = driver.findElement(By.xpath(s1 + s4 + s3));

			String moviefiltername = eachmoviefilter.getText();
			// System.out.println("moviefiltername" +moviefiltername);
			if (moviefiltername.contains(CommonMethods.passingData("cinemaLocation"))) {
				eachmoviefilter.click();
			}

		}

		List<WebElement> nowShowing = driver.findElements(allMoviesCont);
		System.out.println("nowShowing list size" + nowShowing.size());
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		if (nowShowing.size() >= 1) {
			// return true;
		}
		WebElement gen = driver.findElement(By.id("genre"));
		// Actions a1 = new Actions(driver);
		a.moveToElement(gen).build().perform();
		List<WebElement> allGenreListA = driver.findElements(allGenreList);
		for (int i = 1; i <= allGenreListA.size(); i++) {

			String s1 = "//*[@id='ddlGenresList']/a[";
			int s2 = i;
			String s3 = "]";

			String s4 = Integer.toString(s2);

			WebElement genremoviefilter = driver.findElement(By.xpath(s1 + s4 + s3));

			String moviefilternamegenre = genremoviefilter.getText();
			if (moviefilternamegenre.contains(CommonMethods.passingData("genreName"))) {
				genremoviefilter.click();
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				// Thread.sleep(2000);

			}
		}

		List<WebElement> nowShowing1 = driver.findElements(allMoviesCont);
		System.out.println("nowShowing list size" + nowShowing1.size());

		if (nowShowing1.size() >= 1) {
			// System.out.println("Count of Movies"+nowShowing1);
			// return true;
		}
		WebElement lan = driver.findElement(By.id("lang"));
		// Actions a2 = new Actions(driver);
		a.moveToElement(lan).build().perform();
		List<WebElement> allLanguageList = driver.findElements(allLanguages);

		for (int i = 1; i <= allLanguageList.size(); i++) {

			String s1 = "//*[@id='ddlLanguage']/a[";
			int s2 = i;
			String s3 = "]";

			String s4 = Integer.toString(s2);

			WebElement movieLangfilter = driver.findElement(By.xpath(s1 + s4 + s3));

			String moviefilternameLang = movieLangfilter.getText();
			if (moviefilternameLang.contains(CommonMethods.passingData("LangName"))) {
				movieLangfilter.click();
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				// Thread.sleep(2000);

			}
		}

		List<WebElement> nowShowingLang = driver.findElements(allMoviesCont);
		System.out.println("nowShowing list size" + nowShowingLang.size());

		if (nowShowingLang.size() >= 1) {
			// System.out.println("Count of Movies"+nowShowing1);
			return true;
		}

		return false;

	}

	// Movie filters Based on Time(ex:Morning,AfterNoon)

	By firstMovieFromList = By.xpath("//*[@id='moviesContainer']/div[1]");
	By bookTickets = By.id("bookTickets");
	By timings = By.id("TimingsDiv");
	By allTimings = By.xpath("//*[@class='dropdown-menu timeTypes']/li");
	By thearterSection = By.className("theatreName");

	public boolean movieFilterTime() throws InterruptedException {
		driver.findElement(moviesTab).click();
		driver.findElement(firstMovieFromList).click();
		driver.findElement(bookTickets).click();
		WebElement timingsFil = driver.findElement(timings);
		Thread.sleep(4000);
		Actions hov = new Actions(driver);
		hov.moveToElement(timingsFil).click().build().perform();

		Thread.sleep(6000);
		List<WebElement> allTimingsFil = driver.findElements(allTimings);
		for (WebElement timings : allTimingsFil) {
			WebElement showTiming = timings.findElement(By.xpath("./a"));
			String session = showTiming.getText();
			if (session.contains(CommonMethods.passingData("timeFilter"))) {
				Thread.sleep(6000);
				showTiming.click();
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			}
		}
		List<WebElement> nowShowingTimings = driver.findElements(thearterSection);
		System.out.println("nowShowingTimings list size" + nowShowingTimings.size());

		if (nowShowingTimings.size() >= 0) {
			System.out.println("Count of Movies" + nowShowingTimings.size());
			
			return true;
		}

		return false;
	}

	// Events Filter Based on Event Type
	By eventTypesAll = By.xpath("//*[@id='EventTypes']/li");
	By eventsAlign = By.className("Events_align");

	public boolean eventFilterType() throws InterruptedException {
		driver.findElement(eventstab).click();
		List<WebElement> allTypesFil = driver.findElements(eventTypesAll);
		System.out.println("size of event types :" + allTypesFil.size());
		for (WebElement types : allTypesFil) {
			WebElement eventTypes = types.findElement(By.xpath("./a"));
			String session = eventTypes.getText();
			System.out.println("session type" + session);
			String s1 = session.toLowerCase();
			String s2 = CommonMethods.passingData("typeFilterEvent").toLowerCase();

			if (s1.contains(s2)) {
				Actions a = new Actions(driver);
				a.moveToElement(eventTypes).build().perform();
				eventTypes.click();
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				break;
			}
		}
		List<WebElement> showingEvents = driver.findElements(eventsAlign);
		System.out.println("showingEvents list size" + showingEvents.size());

		if (showingEvents.size() >= 0) {
			System.out.println("Count of Events" + showingEvents.size());
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			// Thread.sleep(6000);
			return true;
		}

		return false;
	}

	// Events Filter Based on Category

	By category = By.id("Category");
	By eventCategoryList = By.xpath("//*[@id='eventCategory']/a");

	public boolean eventFilterCategory() throws InterruptedException {
		driver.findElement(eventstab).click();
		driver.findElement(category).click();
		// JavascriptExecutor js = (JavascriptExecutor) driver;
		// js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		List<WebElement> allTypesFilCate = driver.findElements(eventCategoryList);
		System.out.println("size of event categories :" + allTypesFilCate.size());
		for (int i = 1; i <= allTypesFilCate.size(); i++) {

			String s1 = "//*[@id='eventCategory']/a[";
			int s2 = i;
			String s3 = "]";

			String s4 = Integer.toString(s2);

			WebElement eventCatfilter = driver.findElement(By.xpath(s1 + s4 + s3));

			String eventfilterCat = eventCatfilter.getText();
			if (eventfilterCat.contains(CommonMethods.passingData("catFilter"))) {
				eventCatfilter.click();
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				Thread.sleep(2000);

			}
		}

		List<WebElement> showingEvents = driver.findElements(eventsAlign);
		System.out.println("showingEvents list size" + showingEvents.size());

		if (showingEvents.size() >= 0) {
			System.out.println("Count of Events" + showingEvents.size());
			// System.out.println("Event Name"+showingEvents);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		    Thread.sleep(2000);
			return true;
		}

		return false;
	}
	
	
	
	
	//Filter based on Cinema Theater
	By container = By.xpath("//section[contains(@class,'theatreName')]/div/button");
	By threaterlocation = By.xpath("//div[@id='showTimingsDiv']/div");	
	
	public void thearterFilter() throws InterruptedException
	{
	driver.findElement(moviesTab).click();
	driver.findElement(firstMovieFromList).click();
	driver.findElement(bookTickets).click();
	//WebElement theatFil=driver.findElement(container);
	//Actions hov=new Actions(driver);
	//hov.moveToElement(theatFil).build().perform();
	System.out.println("done");
	List<WebElement> allTheatFil=driver.findElements(container);
	System.out.println("Threater size :" +allTheatFil.size());

	//Thread.sleep(3000);

	//List<WebElement> all = driver.findElements(By.xpath("//div[contains(@class,'col-md-4 showName')]/div/b"));

	Actions a = new Actions(driver);
	a.sendKeys(Keys.END).build().perform();
	List<WebElement> all = driver.findElements(By.xpath("//div[contains(@class,'col-md-4 showName')]/div/b"));
	System.out.println("Cinema & Mukta :" +all.size());

	for(WebElement  theat : allTheatFil)
	{

		String session = theat.getText();
		System.out.println("Session " +session);
		if(session.contains(CommonMethods.passingData("theaterName")))
		{
	
		Thread.sleep(3000);
	
		theat.click();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	
		List<WebElement> nowShowingTheaters = driver.findElements(threaterlocation);
	
		System.out.println("nowShowingTheaters list size ---------" +nowShowingTheaters.size());
	}
	}
    }

	
	
	
	// Filters in E-vouchers Screen

	By evouchers = By.xpath("//a[@id='eVouchers']");
	By statusSelect = By.xpath("//*[@id='statusSelection']/option");
	By fromDate = By.id("fromDate");
	By toDate = By.id("toDate");
	By applybtn = By.id("searchDates");
	By signinMenuClick = By.id("icon-m-hamburger");
	By evouchersData = By.className("e-vouchers__item");

	public boolean evouchersFilters() throws Exception {
		driver.findElement(menu1).click();
		Thread.sleep(2000);
		driver.findElement(evouchers).click();
		WebElement testDropDown = driver.findElement(By.xpath("//*[@id='statusSelection']"));
		Select evoucher = new Select(testDropDown);
		evoucher.selectByValue("1");
		// date selection
		// String fdate= CommonMethods.passingData("fromdate");
		// System.out.println("From Date from json :" +fdate);
		// js.executeScript("document.getElementById('fromDate').value='"+fdate+"'");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('fromDate').value='" + CommonMethods.passingData("fromdate") + "'");
		js.executeScript("document.getElementById('toDate').value='" + CommonMethods.passingData("todate") + "'");
		driver.findElement(applybtn).click();
		List<WebElement> showingvouchers = driver.findElements(evouchersData);
		System.out.println("showingEvouchers list size" + showingvouchers.size());

		if (showingvouchers.size() >= 0) {
			System.out.println("Count of Evouchers" + showingvouchers.size());
			// System.out.println("Event Name"+showingEvents);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			Thread.sleep(6000);
			return true;
		}

		return false;
	}
	
	
	// events booking dynamic
	
	By eventtab = By.id("tabEvents");
	By eventlist = By.xpath("//div[@id='AlleventsContainer']/div");
	By eventname = By.xpath("//div[@class='wt_content']/h4");
	By eventdates = By.id("eventDate");
	By booktickets = By.id("bookBtnForOtherevents");
	By selectDate = By.xpath("//div[@id='EventDates']/button");
	By timesslots = By.xpath("//div[@id='EventTimes']/div/button");
	By nextbutton = By.id("BookingNext");
	By eventcategorys = By.xpath("//div[@id='EventCatgeory']/button");
	By subcategory = By.xpath("//div[@id='Subcat']/b");
	By proceddbutton = By.id("btnProceed");
	//By subcat = By.xpath("");
	
	By Amountpay = By.xpath("//span[@id='totalAmount']");
	
	By seatlayoutimg = By.xpath("//map[@name='MapForDesktop']/area");
	By seatlayout = By.xpath("//div[@class='seat available']");
	By proceedButtonInSeatLayout1 = By.id("proceed");
	
	
	/*WebElement prcbutton ;
	//ProceedButton Method
		public WebElement proceedButton()
		{
			WebElement prcbutton1 = driver.findElement(proceddbutton);
				return	prcbutton1;
		}
	*/
	
	public void eventtabClick()
	{
		driver.findElement(eventtab).click();
	}
	
	//Event Booking Method
	public void eventselection(String evename)
	{
		List<WebElement> allevents = driver.findElements(eventlist);
		System.out.println("All Events List " +allevents.size());
	
		for(WebElement singleevent : allevents)
		{
			
			String evnname = singleevent.findElement(By.xpath("./div/a/div/h4")).getText();
					
			if(evnname.equalsIgnoreCase(evename))
				
			{
				singleevent.findElement(By.xpath("./div/a")).click();
				break;
			}
			
		}
		
	}	
	
	public void bookTicket()
	{
		driver.findElement(booktickets).click();
		if(driver.findElement(By.xpath("//*[@id='ageconfirm']/div/div/div[1]/h4")).isDisplayed())
		{
			driver.findElement(By.xpath("//*[@id='btnAccept']")).click();
		}
	}
	
	
	//Select Date method
	public String selectEventDate(String evedate,String eveTime,String evecategory,String subcat,String ticketCount,String seatsection) throws InterruptedException
	{
		Thread.sleep(5000);
		String dates= driver.findElement(eventdates).getText();
		
		System.out.println("----"+dates);
		String msg = "";
		if(dates.contains("-"))
		{
			bookTicket();
			msg = multipleDaysEventOrSeatLayoutBooking(evedate,eveTime,evecategory,subcat,ticketCount,seatsection);
			
		}	
		else
		{
			
				bookTicket();
				Thread.sleep(3000);
				msg = singleDayEventOrSeatLayoutBooking(eveTime,evecategory,subcat,ticketCount,seatsection);
				Thread.sleep(3000);
											
		}
		return msg;		
	}	
		
	
	public String singleDayEventOrSeatLayoutBooking(String eveTime,String evecategory,String subcat,String ticketCount,String seatsection) throws InterruptedException
	{
		String msg = "";
		
			System.out.println("x1");
			
			List<WebElement> timeslotdetails = driver.findElements(By.xpath("//div[@id='EventTimes']/div/button"));
			System.out.println("Timne slots "+timeslotdetails.size());
			
			if(timeslotdetails.size()>1)
			{
				timeSlot(eveTime);
				nextButton();
				
			}
			
			
			
			//WebElement prcbutton1 = driver.findElement(proceddbutton);
			
			List<WebElement> prcbut = driver.findElements(proceddbutton);
			System.out.println("Size of button" +prcbut);
	
			if(prcbut.size()>=1)
			{
	
					Thread.sleep(3000);					
					selectCategory(evecategory);
					Thread.sleep(3000);
					msg = subCategory(subcat,ticketCount,seatsection);

			}	
		
			else
			{
				Thread.sleep(3000);
				System.out.println("x1 else");
					String url1 = driver.getCurrentUrl();
					System.out.println("SeatLayout : " +url1);
				
					List<WebElement> seattypes = driver.findElements(seatlayoutimg);
					System.out.println("Seat Types are :" +seattypes.size());
					
					if(url1.contains("SeatLayoutPreview.aspx"))
					{
					
						for(WebElement seattype : seattypes)
						{
							String seattypename = seattype.getAttribute("title");
							System.out.println("Seatype Name :" +seattypename);
							
							if(seattypename.equalsIgnoreCase(seatsection))
							{
								seattype.click();
								break;
														
							}
						}
					}
						
					Thread.sleep(3000);
					
					List<WebElement> ticketcountdetails = driver.findElements(By.xpath("//ul[@class='nav nav-pills members']/li/a"));
						System.out.println("Size of Ticket details are :"+ticketcountdetails.size());
						
						for(WebElement ticketnumber : ticketcountdetails)
						{
								String ticket = ticketnumber.getText();
								
								System.out.println("ticket -----" +ticket);
								if(ticket.equalsIgnoreCase(CommonMethods.passingData("Ticketcount")))
									{
										ticketnumber.click();
										driver.findElement(By.id("btnOk")).click();
										Thread.sleep(5000);
										seatLayoutSection(ticketCount);
										break;
									}
								else
									{
										System.out.println("Select number of seat are not available may be max or min got selected");
									}
							
						}
							
				
							
			}
		
		
		
		return msg;
		
		
	}
	
	
	
	
	public String multipleDaysEventOrSeatLayoutBooking(String evedate,String eveTime,String evecategory,String subcat,String ticketCount,String seatsection) throws InterruptedException
	{
		System.out.println("x1*****");
		
		Thread.sleep(3000);
	
		List<WebElement> nextbuttons = driver.findElements(next);
		System.out.println("Size of buttonnnnnnn  " +nextbuttons.size());
		
		
		
		
		String msg = "";
		//int k=1;
		if(nextbuttons.size()>=1)
		{
			
			System.out.println("x1 IF");
			Thread.sleep(5000);
				List<WebElement> caldates = driver.findElements(selectDate);
				System.out.println("*****" +caldates.size());
				for(WebElement caldate:caldates)
				{
					String date1 = caldate.findElement(By.xpath("./span[2]")).getText();
					if(date1.contains(evedate))
					{
						caldate.click();
						timeSlot(eveTime);
						nextButton();
						Thread.sleep(3000);
						selectCategory(evecategory);
						Thread.sleep(3000);						
						 msg = subCategory(subcat,ticketCount,seatsection); 
						break;
					}
				}
		}
		
		else if(nextbuttons.size()<1)
		{
			selectCategory(evecategory);
			msg = subCategory(subcat,ticketCount,seatsection); 
		}
				
		else
		{
			Thread.sleep(3000);
			System.out.println("x1 else");
				String url1 = driver.getCurrentUrl();
				System.out.println("SeatLayout : " +url1);
			
				List<WebElement> seattypes = driver.findElements(seatlayoutimg);
				System.out.println("Seat Types are :" +seattypes.size());
				
				if(url1.contains("SeatLayoutPreview.aspx"))
				{
				
					for(WebElement seattype : seattypes)
					{
						String seattypename = seattype.getAttribute("title");
						System.out.println("Seatype Name :" +seattypename);
						
						if(seattypename.equalsIgnoreCase(seatsection))
						{
							seattype.click();
							break;
													
						}
					}
				}
					
				Thread.sleep(3000);
				
				List<WebElement> ticketcountdetails = driver.findElements(By.xpath("//ul[@class='nav nav-pills members']/li/a"));
					System.out.println("Size of Ticket details are :"+ticketcountdetails.size());
					
					for(WebElement ticketnumber : ticketcountdetails)
					{
							String ticket = ticketnumber.getText();
							
							System.out.println("ticket -----" +ticket);
							if(ticket.equalsIgnoreCase(ticketCount))
								{
									ticketnumber.findElement(By.xpath("./following::li")).click();
									driver.findElement(By.id("btnOk")).click();
									seatLayoutSection(ticketCount);
									break;
								}
							else
								{
									System.out.println("Select number of seat are not available may be max or min got selected");
								}
						
					}
						
			
						
		}
	
	return msg;
	
	}
	
	public void seatLayoutSection(String ticketCount) throws InterruptedException
	{
		
		List<WebElement> totalSeatAvailable = driver.findElements(seatlayout);
		System.out.println("Total seat Avaialble :" +totalSeatAvailable.size());
		for(WebElement seatAvailable : totalSeatAvailable)
		{
			
			seatAvailable.click();
			List<WebElement> totalSeatAvailable1 = driver.findElements(seatlayout);
			System.out.println("Total seat Avaialble inside:" +totalSeatAvailable1.size());
			
			
			int ticketcount1 = totalSeatAvailable.size();
			int ticketcount2 = totalSeatAvailable1.size();
			
			System.out.println("TicketCount1" +ticketcount1);
			System.out.println("TicketCount2" +ticketcount2);
			
			int noOfTicketSelected = Integer.parseInt(ticketCount);
			
			if(ticketcount2 <= ticketcount1  - noOfTicketSelected)
			{
				Thread.sleep(3000);
				driver.findElement(By.id("proceed")).click();
				Thread.sleep(3000);
				break;
			}
			
			else
			{
				System.out.println("ticket else ---");
				seatAvailable.click();
				Thread.sleep(3000);
			}
			
						
		}
		
	}
	
	
	String sourcepath = "user.dir";
	File file ;
	FileInputStream fis;
	Properties prop ;
	public void configFile() throws IOException
	{
	
	 file = new File(sourcepath+"/Config.properties");
	 fis = new FileInputStream(file);
	 prop = new Properties();
	 prop.load(fis);
		 
	}

	
	//Time selection 
	public void timeSlot(String eveTime)
	{
		System.out.println("***** Time slots *****" + eveTime);
		List<WebElement> times = driver.findElements(timesslots);
		System.out.println("Time slots :" +times.size());
		
		
		for(WebElement time : times)
		{
			String timedisplay = time.findElement(By.xpath("./span")).getText();
			System.out.println("------" +timedisplay);
			if(timedisplay.contains(eveTime))
			{
				time.click();
				
			}
		}
	}
	
	//Next Button
	public void nextButton()
	{
		driver.findElement(nextbutton).click();
	}

	
	//SelectCategory Method
	
	public void selectCategory(String evecategory)
	{
		List<WebElement> eventcategories = driver.findElements(eventcategorys);
		System.out.println("Event categories :" +eventcategories.size());
		
		for(WebElement category : eventcategories)
		{
			String eventname = category.findElement(By.xpath("./span")).getText();
			
			System.out.println("------" +eventname);
			if(eventname.equalsIgnoreCase(evecategory))
			{
				category.click();
				break;
			}
		}
	}

	
	//SubCategory Method subcatselecion(any of subcat)
	public String subCategory(String subcat,String ticketCount,String seatsection) throws InterruptedException
	{
		List<WebElement> subcategories  = driver.findElements(subcategory);
		System.out.println("Total subcategories" +subcategories.size());
		for(WebElement subcat1 : subcategories )
		{
			String bordername = subcat1.getText();
			System.out.println("------@@@" +bordername);
			if(bordername.contains(subcat))
			{
				List<WebElement> subcattktcount = subcat1.findElements(By.xpath("./following-sibling::div/button"));
				System.out.println("Subcat ticket count :" +subcattktcount.size());
				
				for(WebElement subcattkt :subcattktcount )
				{
					
					String ticketnumber = subcattkt.getText();
				
					if(ticketnumber.equalsIgnoreCase(ticketCount))
					{
						subcattkt.click();
						Thread.sleep(2000);
						
							driver.findElement(proceddbutton).click();
							break;
					}	
				}	
			break;	
			}
		}
				
		
					String urlchk  = driver.getCurrentUrl();
							System.out.println("Url Check" +urlchk);
							
							if(urlchk.contains("EventSeatLayout.aspx"))
							{
								seatLayoutSection(ticketCount);
								
							}
							else
							{
								 
								
								String  amt = driver.findElement(Amountpay).getText();
								String[] amt1 = amt.split(" ");
								//String part1 = amt1[0];
								String part2 = amt1[1];
																
								if(Integer.parseInt(part2)>0)
								{
									System.out.println("iffff");
									
									String country =driver.findElement(By.xpath(" //span[@class='moviesLocationsAutoFill'] ")).getText();
									if(country.contains("Bahrain"))
									{
										debitpayeventsold();
									}
									else if (country.contains("Qatar"))
									{
										eventbookvisa();
									}
									else
									{
										
									}
									 
								}
								else
								{
									System.out.println("elseeee");
									String country =driver.findElement(By.xpath(" //span[@class='moviesLocationsAutoFill'] ")).getText();
									if(country.contains("Bahrain"))
									{
										driver.findElement(txtPaymentMobile).sendKeys(CommonMethods.passingData("mobile"));
										driver.findElement(txtPaymentEmail).sendKeys(CommonMethods.passingData("EnterMail"));
									}
									else if (country.contains("Qatar"))
									{
										driver.findElement(custname).sendKeys("pallavi");
										driver.findElement(txtPaymentMobile).sendKeys(CommonMethods.passingData("mobile"));
										driver.findElement(txtPaymentEmail).sendKeys(CommonMethods.passingData("EnterMail"));
									}
									
									
									driver.findElement(proceddbutton).click();
								}
							}
			
		
		return driver.findElement(ticketconfirmtext).getText();
	}

	
	
	//multi subcat selection(all subcat)
	public void allsubCategory() throws InterruptedException
	{
		List<WebElement> subcategories  = driver.findElements(By.xpath("//div[@id='Subcat']/div"));
		System.out.println("-----Total subcategories" +subcategories.size());
		
			for(int j=1 ; j<=subcategories.size();j++)
			{
				String x1 = "//div[@id='Subcat']/div["+j+"]";
				
				WebElement ticketcount = driver.findElement(By.xpath(x1));
				
				List<WebElement> totaltickets = ticketcount.findElements(By.xpath("./button"));
				System.out.println("Total tickets ---"+totaltickets.size());
				for(WebElement tc : totaltickets)
				{
				
					String ticketnumber = tc.getText();
					System.out.println("Tick----" +ticketnumber);
					if(ticketnumber.equalsIgnoreCase(CommonMethods.passingData("Ticketcount")))
					{
						tc.click();
						break;
						
					}
				}
				
			}
			
			String  amt = driver.findElement(Amountpay).getText();
			String chars = "123456789";
			if(amt.contains(chars))
			{
				 driver.findElement(txtPaymentMobile).sendKeys(CommonMethods.passingData("mobile"));
				 driver.findElement(txtPaymentEmail).sendKeys(CommonMethods.passingData("EnterMail"));
				 debitpayevents();
			}
			else
			{
				driver.findElement(proceddbutton).click();
			}
				
			
			
			
	}
	

	// Download Ticket Pdf for Events

	By downloadPdf = By.id("downloadTicket");

	public void downloadPdf()
	{
	driver.findElement(downloadPdf).click();
	//return driver.getCurrentUrl();

	}

	// Print Booking Info

	By printBooking =  By.id("printTicket");
	By print = By.className("action-button");


	public void printBookingInfo()
	{
	driver.findElement(printBooking).click();

	}


	By resend =   By.id("resendTicket");
	By resendPop = By.xpath("//*[contains(@class,'toast-message') and contains(text(),'Email and SMS sent Succesfully')]");

	public String resendTicket()
	{

	driver.findElement(resend).click();

	return driver.findElement(resendPop).getText();
	}

	
	//Resend Ticket negitive case

	By resendNegiPop  =  By.xpath("//*[contains(@class,'toast-message') and contains(text(),'Five Atempts Already completed, Please contact administrator')]");

	public String resendTicketNegitive()
	{
	for(int i=1;i<=6;i++)
	{
	driver.findElement(resend).click();

	System.out.println(i);
	}
	return driver.findElement(resendNegiPop).getText();
	}
	
	
	
	
	
	
	/*public void mutipleSeatSelectionInDiffCategory() throws InterruptedException
	{
		
		Thread.sleep(5000);
		String dates= driver.findElement(eventdates).getText();
		
		System.out.println("----"+dates);
		
		if(dates.contains("-"))
		{
			bookTicket();
			Thread.sleep(5000);
			List<WebElement> caldates = driver.findElements(selectDate);
			System.out.println("*****" +caldates);
			for(WebElement caldate:caldates)
			{
				String date1 = caldate.findElement(By.xpath("./span[2]")).getText();
				if(date1.contains(CommonMethods.passingData("Eventdate")))
				{
					caldate.click();
					timeSlot();
					nextButton();
					Thread.sleep(3000);
					List<WebElement> subcategories  = driver.findElements(subcategory);
					System.out.println("Total subcategories" +subcategories.size());
					
					if(subcategories.size()>1)
					{
						for(WebElement sub : subcategories)
						{
							String subname = sub.getText();
							
							if(subname.contains(CommonMethods.passingData("subcategoryselection")))
								{
									
									List<WebElement> subcattktcount = sub.findElements(By.xpath("./following-sibling::div/button"));
									System.out.println("Subcat ticket count :" +subcattktcount.size());
								
									for(WebElement subcattkt :subcattktcount )
									{
									
										String ticketnumber = subcattkt.getText();
								
										if(ticketnumber.equalsIgnoreCase(CommonMethods.passingData("Ticketcount")))
											{
											subcattkt.click();
											break;
											}
									}	
									
									
								}
						}
					}
					
				}
				
				else
				{
				
					bookTicket();
					Thread.sleep(3000);
					subCategory();
					
					
				}
			}
		}
		
	}
	*/
	
	
	public void eventselection1()
	{
		List<WebElement> allevents = driver.findElements(eventlist);
		System.out.println("All Events List " +allevents.size());
	
		for(WebElement singleevent : allevents)
		{
			
			String evnname = singleevent.findElement(By.xpath("./div/a/div/h4")).getText();
					
			if(evnname.equalsIgnoreCase(CommonMethods.passingData("eventname")))
				
			{
				System.out.println("eventclicked");
				singleevent.findElement(By.xpath("./div/a")).click();
				break;
			}
			
		}
		
	}
	
	
	public void timeSlot1()
	{
		//System.out.println("***** Time slots *****" + eveTime);
		List<WebElement> times = driver.findElements(timesslots);
		System.out.println("Time slots :" +times.size());
		
		
		for(WebElement time : times)
		{
			String timedisplay = time.findElement(By.xpath("./span")).getText();
			System.out.println("------" +timedisplay);
			if(timedisplay.contains(CommonMethods.passingData("EventTime")))
			{
				time.click();
				
			}
		}
	}
	
	
	public boolean pricecompare() throws InterruptedException
	{		
		
		eventtabClick();
		eventselection1();
		boolean result= pricecom();
		return result;
		
	}
	
	
	public boolean pricecom() throws InterruptedException
	{
		Thread.sleep(3000);
		boolean result=false;
		String dates= driver.findElement(eventdates).getText();
		List<WebElement> nextbuttons = driver.findElements(next);
		if(dates.contains("-"))
		{
			bookTicket();
			Thread.sleep(3000);
			if(nextbuttons.size()>=1)
			{

					List<WebElement> caldates = driver.findElements(selectDate);
					System.out.println("*****" +caldates.size());
					for(WebElement caldate:caldates)
					{
						String date1 = caldate.findElement(By.xpath("./span[2]")).getText();
						if(date1.contains(CommonMethods.passingData("Eventdate")))
						{							
							caldate.click();
							Thread.sleep(2000);
							timeSlot1();
							Thread.sleep(2000);
							nextButton();
							Thread.sleep(2000);
							selectCategory1();							
						    result = subCategory1();
							break;
						}
					}
			
				
			}
			
			
			
		}
		else
		{
			
		}
		return result;
	}
	
	
	
	public void selectCategory1()
	{
		System.out.println("category");
		List<WebElement> eventcategories = driver.findElements(eventcategorys);
		System.out.println("Event categories :" +eventcategories.size());
		
		for(WebElement category : eventcategories)
		{
			String eventname = category.findElement(By.xpath("./span")).getText();
			
			System.out.println("------" +eventname);
			if(eventname.equalsIgnoreCase(CommonMethods.passingData("Category")))
			{
				System.out.println("category click");
				category.click();
				
				break;
			}
		}
	}
	
	By sutot= By.id("totalTicketsAmount");
	
	public boolean  subCategory1() throws InterruptedException
	{
		System.out.println("subcat1");
		float price;
		double finalprice = 0.000;
		int count;
	//	double subtotal=0.000;
		List<WebElement> subcategories  = driver.findElements(subcategory);
		System.out.println("Total subcategories" +subcategories.size());
		for(WebElement subcat1 : subcategories )
		{
			String bordername = subcat1.getText();
			//String  amt = driver.findElement(Amountpay).getText();			
			
			if(bordername.contains(CommonMethods.passingData("subcategoryselection")))
			{	
				String[] subsplit = bordername.split("-");
				//String part1 = subsplit[0];
				String part2 = subsplit[1].trim();
				
				String[] myprice  = part2.split(" ");
				String myprice1 = myprice[0];
				//String myprice2 = myprice[1]; 
				
				price = Integer.parseInt(myprice1);
				
				List<WebElement> subcattktcount = subcat1.findElements(By.xpath("./following-sibling::div/button"));
				System.out.println("Subcat ticket count :" +subcattktcount.size());
				
				for(WebElement subcattkt :subcattktcount )
				{
					
					String ticketnumber = subcattkt.getText();				
					if(ticketnumber.equalsIgnoreCase(CommonMethods.passingData("Ticketcount")))
					{
						subcattkt.click();
						Thread.sleep(2000);
						count= Integer.parseInt(ticketnumber);
						Thread.sleep(2000);		
						finalprice= price*count;						
						break;
					}	
				}	
			break;	
			}
		}
		driver.findElement(proceddbutton).click();
		Thread.sleep(3000);		
		String  amt = driver.findElement(sutot).getText();
		String[] subtotamt  = amt.split(" ");
		//String pr1 = subtotamt[0];
		String pr2 = subtotamt[1]; 
		double  finalpricepayment = Integer.parseInt(pr2);
		if(finalprice==finalpricepayment)
		{
			return true;
		}
		
		else
		{
			return false;
		}
		
	}
	
	///price compare for movies
	
	public boolean pricecompareMoviebooking() throws InterruptedException {

		countrySelection();
		movietabselection();
		nowplayingmovieselection();
		moviedateselection();
		movietimeselection();
		numberoftickets();		
		boolean result= moviespricecomp();
		return result;		
	}
	
	public boolean moviespricecomp() throws InterruptedException 
	{
		WebElement paybutton = driver.findElement(proceedbutton);
		//boolean result=false;
		//String costcomp1=null;
		 double  price = 0;
		 double finalprice=0;
		// User Can Select the Available Seat
		Thread.sleep(2000);
		List<WebElement> seatsselection = driver.findElements(seatlayoutselect);
		System.out.println("Avalaible seats are :" + seatsselection.size());
		for (WebElement seat11 : seatsselection) {
			Actions a = new Actions(driver);
			a.moveToElement(seat11).build().perform();
			seat11.click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);			
			boolean pp = paybutton.isDisplayed();
			if (pp == true) {
				String tktcost = driver.findElement(By.id("TicketsSelected")).getText();
				String[] cost = tktcost.split(": BHD");
			    String costcomp1 = cost[1].trim();
			    System.out.println("tttt");
			     price = Double.parseDouble(costcomp1);	
			     System.out.println(price);
			     paybutton.click();	
			     Thread.sleep(2000);
			     System.out.println("done");
				 break;
				 
			}
			else {
				System.out.println("Notification is diplayed as: 'Please select a seat beside the selected seat(s)'");
				Thread.sleep(3000);
				seat11.click();
				Thread.sleep(3000);
			}

		}
		Thread.sleep(4000);
	    String subtotprice = driver.findElement(By.xpath("//table//tr[8]/td[2]")).getText();
	    String[] FP= subtotprice.split("BHD. ");
	    String FP2=FP[1];	    
	    finalprice = Double.parseDouble(FP2);
	    if(price==finalprice)
		{
			return true;
		}
		
		else
		{
			return false;
		}
		
	}

	
	
	
	
	
}


