package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.MyAccount;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003_LoginDDT extends BaseClass{
 
	@Test(dataProvider ="LoginData",dataProviderClass=DataProviders.class)
	public void verify_loginDDT(String un,String pass,String res){
		logger.info("**** staring TC_003_LoginDDT *****");
		try {
		//HomePage
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		//LoginPage
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(un);
		lp.setPassword(pass);
		lp.setButton();
		//MyAccount
		MyAccount macc=new MyAccount(driver);
		boolean actual=macc.isMyAccountDisplay();
		if(res.equalsIgnoreCase("valid")) {
			if(actual==true) {
				macc.logoutLink();
				Assert.assertTrue(true);
			}
			else {
				Assert.assertTrue(false);
			}
		}
		else if(res.equalsIgnoreCase("invalid")){
			if(actual==true) {
				macc.logoutLink();
				Assert.assertTrue(false);
			}
			else {
				Assert.assertTrue(true);
			}
		}
		}
		catch(Exception e) {
			Assert.fail();
		}
		logger.info("**** finished TC_003_LoginDDT *****");
	}
}
