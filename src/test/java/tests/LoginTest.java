package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(description = "Checking successful login")
    public void login() {
        loginPage.open();
        loginPage.login("yaroslav_pysh@company.sandbox", "password11");
        Assert.assertTrue(homePage.isOpened(), "Title 'Home' was not displayed");
    }
}
