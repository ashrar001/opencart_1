package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
	public LoginPage(WebDriver driver){
		super(driver);
	}
	@FindBy(xpath="//input[@name='email']")
	WebElement email;
	@FindBy(xpath = "//input[@name='password']")
	WebElement password;
	@FindBy(xpath="//input[@type='submit']")
	WebElement button;
	
	public void setEmail(String mail) {
		email.sendKeys(mail);
	}
	public void setPassword(String pass) {
		password.sendKeys(pass);
	}
	public void setButton() {
		button.click();
	}
}
