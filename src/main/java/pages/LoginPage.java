package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import core.ActionDriver;

public class LoginPage extends ActionDriver {

	@FindBy(xpath = "(//*[@id='i_textfield'])[2]")
	static WebElement getUsername;

	@FindBy(id = "i_submit")
	static WebElement getSubmitBtn;

	@FindBy(xpath = "//input[@name='password']")
	static WebElement getPassword;

	public LoginPage(WebDriver driver) throws Exception {
		super(driver);
		PageFactory.initElements(driver,this);
		if (!isElementPresent(getUsername)) {
			throw new Exception("User is not on LoginPage and is on " + getTitle());
		}
	}

	public UserPage signIn(String username, String password) throws Exception {

		type(getUsername, username);
		type(getPassword, password);
		click(getSubmitBtn);
		return new UserPage(driver);
	}

	

}
