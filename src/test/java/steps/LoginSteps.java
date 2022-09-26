package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.LoginPage;

import static org.testng.Assert.assertTrue;

public class LoginSteps {

    LoginPage loginPage;
    HomePage homePage;
    public LoginSteps(WebDriver driver){
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
    }
    @Step("Login")
    public void login(String login, String password){
        loginPage.open();
        loginPage.login(login, password);
        assertTrue(homePage.isOpened());
    }
}
