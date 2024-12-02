package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegristrationPage extends BasePage{
public AccountRegristrationPage(WebDriver driver) {
	super(driver);
}
@FindBy(xpath = "//input[@name='firstname']")
WebElement firstName;
@FindBy(xpath = "//input[@name='lastname']")
WebElement lastName;
@FindBy(xpath = "//input[@name='email']")
WebElement email;
@FindBy(xpath = "//input[@name='telephone']")
WebElement telephone;
@FindBy(xpath = "//input[@name='password']")
WebElement password;
@FindBy(xpath="//input[@name='confirm']")
WebElement confrmPassword;
@FindBy(xpath="//input[@name='agree']")
WebElement checkBox;
@FindBy(xpath = "//input[@type='submit']")
WebElement button;
@FindBy(xpath="//h1[text()='Your Account Has Been Created!']")
WebElement accountCreated;

public void setfname(String fname) {
	firstName.sendKeys(fname);
}
public void setlname(String lname) {
	lastName.sendKeys(lname);
}
public void setEmail(String mail) {
	email.sendKeys(mail);
}
public void setTelephone(String tele) {
	telephone.sendKeys(tele);
}
public void setPassword(String pass) {
	password.sendKeys(pass);
}
public void setconfrmPass(String pass) {
	confrmPassword.sendKeys(pass);
}
public void setchkbx() {
	checkBox.click();
}
public void setButton() {
	button.click();
}
public String getAccountConferMessage() {
	try {
		return (accountCreated.getText());
	}
	catch(Exception e) {
		return (e.getMessage());
	}
}
}
