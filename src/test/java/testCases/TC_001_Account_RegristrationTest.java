package testCases;


import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObject.AccountRegristrationPage;
import pageObject.HomePage;
import testBase.BaseClass;

public class TC_001_Account_RegristrationTest extends BaseClass{
	
	@Test(groups = {"Sanity","Master"})
	public void verify_account_regristration() {
		
		logger.info("**** Stating TC_001_Account_RegristrationTest *****");
		try {
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		logger.info(" click on my account link ");
		hp.clickRegister();
		logger.info(" click on my register link");
		AccountRegristrationPage ap = new AccountRegristrationPage(driver);
		logger.info(" provide customer details ");
		ap.setfname(randomString().toUpperCase());
		ap.setlname(randomString().toLowerCase());
		ap.setEmail(randomString()+"@gmail.com");
		ap.setTelephone(randomNumeric());
		String pass=randomAlphaNumeric();
		ap.setPassword(pass);
		ap.setconfrmPass(pass);
		ap.setchkbx();
		ap.setButton();
		// validation
		logger.info("validating expected matching with actual");
		String actual = ap.getAccountConferMessage();
		if(actual.equals("Your Account Has Been Created!")) {
			Assert.assertTrue(true);	
		}
		else {
			logger.error("test failed....");
			logger.debug("debug logs...");
			Assert.assertTrue(false);
		}
		}
		catch(Exception e) {
			
			Assert.fail();
		}
		logger.info("****** Finished TC_001_Account_RegristrationTest *****");
	}
}
