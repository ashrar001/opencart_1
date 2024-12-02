package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
public HomePage(WebDriver driver) {
	super(driver);
}
@FindBy(xpath = "//span[text()='My Account']")
WebElement myAccout;
@FindBy(xpath = "(//a[text()='Register'])[1]")
WebElement register;
@FindBy(xpath = "(//a[text()='Login'])[1]")
WebElement login;

public void clickMyAccount() {
	myAccout.click();
}
public void clickRegister() {
	register.click();
}
public void clickLogin() {
	login.click();
}
}
