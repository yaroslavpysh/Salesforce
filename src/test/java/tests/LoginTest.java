package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CreateContactPage;

import java.time.Duration;
import java.util.WeakHashMap;

public class LoginTest extends BaseTest {

    @Test(description = "Checking successful login")
    public void login() {
        loginPage.open();
        loginPage.login("yaroslav_pysh@company.sandbox", "password11");
        Assert.assertTrue(homePage.isOpened(), "Title 'Home' was not displayed");
    }
}
