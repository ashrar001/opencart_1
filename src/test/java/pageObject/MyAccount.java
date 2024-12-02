package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccount extends BasePage{
    public MyAccount(WebDriver driver){
	super(driver);
}
	@FindBy(xpath="//h2[text()='My Account']")
	WebElement validateMyAccount;
	
	@FindBy(xpath = "(//a[text()='Logout'])[2]")
	WebElement logout;
	public boolean isMyAccountDisplay() {
		try {
		return (validateMyAccount.isDisplayed());
		}
		catch(Exception e) {
			return false;
		}
	}
	public void logoutLink() {
		logout.click();
	}
}
