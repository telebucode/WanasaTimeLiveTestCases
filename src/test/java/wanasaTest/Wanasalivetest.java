package wanasaTest;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import utils.BrowserFunctions;
import utils.CommonMethods;
import wanasa.homepagelive;
import wanasa.homepagelive;

public class Wanasalivetest extends  BrowserFunctions {
	
	homepagelive ss = new homepagelive();
	
	
	@Test(priority = 0)
	public void verifysignup() throws InterruptedException {
		// ss.alertadvt();
		logger_ss = extent.createTest("verifysignup");		
		String sucessmsg = ss.signup();
		logger_ss.log(Status.INFO, "signup done as a new user.");
		Assert.assertEquals(sucessmsg, "You have successfully registered. We have sent a verification email to you.");
		driver.navigate().to(CommonMethods.passingData("url"));
		logger_ss.log(Status.INFO, "signup done successfully.");
	}

	 @Test(priority = 1)
	    public void verifyforgotpassword() throws InterruptedException {
		logger_ss = extent.createTest("verifyforgotpassword");
		String checksuccessmsg = ss.forgotpassword();
		Assert.assertEquals(checksuccessmsg, "We have sent a mail to you.Please check your mail.");
		logger_ss.log(Status.INFO, "Successfully verified forgot password.");

	}

	@Test(priority = 2)
	public void verifylogin() throws InterruptedException {
		logger_ss = extent.createTest("verifylogin");
		driver.navigate().to(CommonMethods.passingData("url"));
		//// ss.alertadvt();
		ss.clickSignInButton();
		logger_ss.log(Status.INFO, "Login with valid credentials.");
		String afterlogin = ss.signinWanasaTimeCredentials();
		logger_ss.log(Status.INFO, "Login success with valid credentials.");
		Assert.assertEquals(afterlogin, CommonMethods.passingData("url"));
		ss.logout();
		logger_ss.log(Status.INFO, "Logout done.");
		logger_ss.log(Status.INFO, "Successfully verified login functionality.");

	}

	@Test(priority = 3)
	public void verifygoogLogin() throws InterruptedException {
		logger_ss = extent.createTest("googLogin testing stared.");
		// ss.logout();
		driver.navigate().to(CommonMethods.passingData("url"));
		ss.clickSignInButton();
		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String afterlogin = ss.googleLogin();
		Assert.assertEquals(afterlogin, "https://www.wanasatime.com/EventsHome.aspx#");
		logger_ss.log(Status.INFO,"googLogin done Successfully.");
		Thread.sleep(3000);
		CommonMethods.explicitWaitForElementVisibility(ss.menu);
		ss.logout();
		logger_ss.log(Status.INFO, "Logout done.");
		Thread.sleep(2000);
		logger_ss.log(Status.INFO, "Successfully verified googLogin.");
	}

	@Test(priority = 4)
	public void verifyfooterlinks() throws InterruptedException {
		logger_ss = extent.createTest("verify all footerlinks");
		ss.footerlinksaboutus();
		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL,"https://www.wanasatime.com/AboutUs.aspx");
		logger_ss.log(Status.INFO,"verified Aboutus link Successfully");
		/*ss.footerlinksAdvertiseWithUs();   
		String Advt = driver.getCurrentUrl();
		Assert.assertEquals(Advt, CommonMethods.passingData("url"));*/
		ss.footerlinksfaq(); 
		String FAQ = driver.getCurrentUrl();
		Assert.assertEquals(FAQ,"https://www.wanasatime.com/FAQs.aspx");
		logger_ss.log(Status.INFO,"verified FAQ link Successfully.");
		ss.footerlinkstc();
		String TC = driver.getCurrentUrl();
		Assert.assertEquals(TC,"https://www.wanasatime.com/Terms.aspx");
		logger_ss.log(Status.INFO,"verified T&C link Successfully.");
		ss.footerlinkprivacy();
		String privacy = driver.getCurrentUrl();		
		Assert.assertEquals(privacy,"https://www.wanasatime.com/Privacy.aspx");
		logger_ss.log(Status.INFO,"verified Privacy Policy link Successfully.");
		ss.footerlinkcontactus();
		String contactus = driver.getCurrentUrl();
		Assert.assertEquals(contactus, "https://www.wanasatime.com/ContactUs.aspx");
		logger_ss.log(Status.INFO,"verified ContactUs link Successfully.");
		ss.footerlinkplanspricing();
		String pricing = driver.getCurrentUrl();
		Assert.assertEquals(pricing,"https://www.wanasatime.com/PlansPricing.aspx");
		logger_ss.log(Status.INFO,"verified PlansPricing link Successfully.");
		logger_ss.log(Status.INFO, "Successfully verified footerlinks.");
	}
	
	////@Test(priority = 5) 
	public void verifypricemovie() throws InterruptedException
	{
		logger_ss = extent.createTest("verifypricemovie");
		ss.countrySelection();	
		logger_ss.log(Status.INFO,"Country selection done.");
		boolean r = ss.pricecompareMoviebooking();
		Assert.assertEquals(r, true);
		logger_ss.log(Status.INFO, "Successfully verified verifypricemovie.");
	}
	//@Test(priority = 6)
	public void verifypriceevent() throws InterruptedException
	{
		logger_ss = extent.createTest("verifypriceevent");
		ss.countrySelection();
		logger_ss.log(Status.INFO,"Country selection done.");
		boolean r = ss.pricecompare();
		Assert.assertEquals(r, true);
		logger_ss.log(Status.INFO, "Successfully verified verifypriceevent");
	
	}
	
	@Test(priority = 8)
	public void verifycontactus() throws InterruptedException {
		logger_ss = extent.createTest("verifycontactus");
		driver.navigate().to(CommonMethods.passingData("url"));
		ss.countrySelection();
		logger_ss.log(Status.INFO,"Country selection done.");
		String msg = ss.contactus();
		Assert.assertEquals(msg, "Thanks for providing your information we will get back to you soon");
		logger_ss.log(Status.INFO, "Successfully verified contactus.");
	}

	@Test(priority = 9)
	public void verifySMiconclick() throws InterruptedException {
		logger_ss = extent.createTest("verifySMiconclick");
		driver.navigate().to(CommonMethods.passingData("url"));
		// ss.alertadvt();
		int cocunt = ss.SMiconclick();
		Assert.assertEquals(cocunt, 5);
		logger_ss.log(Status.INFO, "Successfully verified SMiconclick.");
	}

	@Test(priority = 10)
	public void verifyplaystoreclick() throws InterruptedException {
		logger_ss = extent.createTest("verifyplaystoreclick");
		driver.navigate().to(CommonMethods.passingData("url"));
		String s = ss.playstoreclick();
		Assert.assertEquals(s, "https://play.google.com/store/apps/details?id=com.mobile.android.wanasatime&hl=en_US");
		logger_ss.log(Status.INFO, "Successfully verified playstoreclick");
	}

	
	@Test(priority = 11)
	public void verifyappstoreclick() throws InterruptedException {
		logger_ss = extent.createTest("verifyappstoreclick");
		driver.navigate().to(CommonMethods.passingData("url"));
		String s = ss.appstoreclick();
		Assert.assertEquals(s, "https://apps.apple.com/us/app/wanasatime/id1187788688");
		logger_ss.log(Status.INFO, "Successfully verified appstoreclick");
	}


	// user

	
	//edit user details including profile pic
	@Test(priority = 15)
	public void verifyuseroperations() throws Exception
	{
		logger_ss = extent.createTest("verifyuseroperations");
		driver.navigate().to(CommonMethods.passingData("url"));
		ss.login();
		logger_ss.log(Status.INFO, "Login success with valid credentials.");
		ss.edituser();
		logger_ss.log(Status.INFO, "Successfully verified verifyuseroperations");
	}

	@Test(priority = 20)
	public void verifysearchbookingistory() throws InterruptedException {
		logger_ss = extent.createTest("searchbookingistory");
		ss.searchbookingistory();
		logger_ss.log(Status.INFO, "Successfully verified searchbookingistory");
	
	}

	@Test(priority = 21)
	public void evouchersFileter() throws Exception {
		logger_ss = extent.createTest("verifyEvouchersFilter");
		boolean bol = ss.evouchersFilters();
		Assert.assertEquals(bol, true);
		logger_ss.log(Status.INFO, "Filter Applied Successfully Based on Evouchers");
		ss.logout();
		logger_ss.log(Status.INFO, "logout done Successfully.");
	}


	//verify the social media icons click
	@Test(priority = 29)
	public void verifysocialmediaiconclick() throws InterruptedException {
		logger_ss = extent.createTest("verifysocialmediaiconclick");
		ss.socialmediaiconclick();
		logger_ss.log(Status.INFO, "Successfully verifysocialmediaiconclick.");
	}
	
	// Movies Filter based on Mall Selection
		@Test(priority = 31)
		public void filterMoviesLocations() throws InterruptedException {
			 driver.navigate().to(CommonMethods.passingData("url"));
			logger_ss = extent.createTest("verifyMovieLoactons");
			ss.countrySelection();
			logger_ss.log(Status.INFO,"Country selection done.");
			boolean bool = ss.moviesFilter();
			Assert.assertEquals(bool, true);
			logger_ss.log(Status.INFO, "Filter Applied Successfully Based on Mall");
		}

		// Movies Filter based on Genre Selection

		@Test(priority = 32)
		public void filterMoviesGenre() throws InterruptedException {
			logger_ss = extent.createTest("verifyMovieLoactons");
			ss.countrySelection();
			logger_ss.log(Status.INFO,"Country selection done.");
			boolean bool = ss.moviesGenre();
			Assert.assertEquals(bool, true);
			logger_ss.log(Status.INFO, "Filter Applied Successfully Based on Genre");
			// System.out.println("Count of the Movies"+);
		}

		// Movies Filter Based on Language

		@Test(priority = 32)
		public void filterMoviesLang() throws InterruptedException {
			logger_ss = extent.createTest("verifyMovieLanguage");
			ss.countrySelection();
			logger_ss.log(Status.INFO,"Country selection done.");
			boolean bool = ss.moviesLanguage();
			Assert.assertEquals(bool, true);
			logger_ss.log(Status.INFO, "Filter Applied Successfully Based on Language");
		}

		// Movies Filter Based on Mall,Genre and Languages

		@Test(priority = 33)
		public void moviesAllFilters() throws InterruptedException {
			logger_ss = extent.createTest("verifyMovieLanguage");
			ss.countrySelection();
			logger_ss.log(Status.INFO,"Country selection done.");
			// ss.moviesFilter();
			// ss.moviesGenre();
			boolean bool = ss.movieAllFilters();
			Assert.assertEquals(bool, true);
			logger_ss.log(Status.INFO, "Filter Applied Successfully Based on Mall,Genre and Language");

		}

		// Movies Filter Based on Timings
		@Test(priority = 34)
		public void movieTimeingsFilter() throws InterruptedException {
			logger_ss = extent.createTest("verifyMovieTime");
			ss.countrySelection();
			logger_ss.log(Status.INFO,"Country selection done.");
			// ss.moviesFilter();
			// ss.moviesGenre();
			boolean bool = ss.movieFilterTime();
			Assert.assertEquals(bool, true);
			logger_ss.log(Status.INFO, "Filter Applied Successfully Based on Timing");

		}
		 // Filter based on Theater

		@Test(priority = 35)
		public void verifyfilterTheater() throws InterruptedException
		{
		logger_ss = extent.createTest("verifyMovieTheater");
		        ss.countrySelection();
		        logger_ss.log(Status.INFO,"Country selection done.");
		        //ss.moviesFilter();
		       // ss.moviesGenre();
		        ss.thearterFilter();
		       // Assert.assertEquals(bool,true);
		        logger_ss.log(Status.INFO, "Filter Applied Successfully Based on Theater");

		}

		// Events Filter Based on Event Types
		@Test(priority = 36)
		public void verifyeventTypeFilter() throws InterruptedException {
			logger_ss = extent.createTest("verifyEventType");
			ss.countrySelection();
			logger_ss.log(Status.INFO,"Country selection done.");
			boolean bol = ss.eventFilterType();
			Assert.assertEquals(bol, true);
			logger_ss.log(Status.INFO, "Filter Applied Successfully Based on Event Type");

		}

		// Events Filter Based on Event Category
		@Test(priority = 37)  
		public void verifyeventCatFilter() throws InterruptedException {
			logger_ss = extent.createTest("verifyEventCategory");
			ss.countrySelection();
			logger_ss.log(Status.INFO,"Country selection done.");
			boolean bol = ss.eventFilterCategory();
			Assert.assertEquals(bol, true);
			logger_ss.log(Status.INFO, "Filter Applied Successfully Based on Event Category");

		}
	
}
