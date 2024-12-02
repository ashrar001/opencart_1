package testCases;



import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.MyAccount;
import testBase.BaseClass;



public class TC_002_LoginTest extends BaseClass{
	@Test(groups = {"Sanity","Regression","Master"})
	public void verifyLogin() {
		logger.info("****** staring TC_002_LoginTest ******");
		try {
			logger.info("**** enter into homepage *****");
			HomePage hp=new HomePage(driver);
			hp.clickMyAccount();
			hp.clickLogin();
			logger.info("**** enter into loginpage *****");
			LoginPage lp=new LoginPage(driver);
			lp.setEmail(p.getProperty("email"));
			lp.setPassword(p.getProperty("password"));
			lp.setButton();
			logger.info("**** enter into myaccount page *****");
			MyAccount macc=new MyAccount(driver);
			boolean actual=macc.isMyAccountDisplay();
			Assert.assertEquals(actual, true,"Login Failed");
			
		}
		catch(Exception e) {
			Assert.fail();
		}
		logger.info("**** finished  TC_002_LoginTest *****");
		
	}
	
}
