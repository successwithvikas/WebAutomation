package test;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import core.OpenAndCloseBrowser;
import listeners.CustomListeners;
import pages.LoginPage;
import pages.UserPage;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.model.SeverityLevel;

@Listeners(CustomListeners.class)
public class LoginPageTest extends OpenAndCloseBrowser{
	
	
    @Features("Test Login")
    @Stories("Login with valid credentials")
    @Step("User open Test demo, enter credentials, click on submit button")
    @Severity(SeverityLevel.CRITICAL)
	@Test(dataProviderClass=dataprovider.DataProviderForLogin.class,dataProvider="getCredentails")
	public void loginFunctionality(String username, String password) throws Exception{
		
    	LoginPage loginPage=new LoginPage(driver);
		UserPage userPage = loginPage.signIn(username, password);
		assert userPage.verifyUser("Welcome, friend!"):"Expected: failed";
		
	}
    
   
}
