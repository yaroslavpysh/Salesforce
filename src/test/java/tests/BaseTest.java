package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.*;
import pages.CreateAccountPage;
import pages.CreateContactPage;
import pages.HomePage;
import pages.LoginPage;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

@Listeners(TestListener.class)
public class BaseTest {
    WebDriver driver;
    LoginPage loginPage;
    CreateContactPage createContactPage;
    CreateAccountPage createAccountPage;
    HomePage homePage;



    @Parameters({"browser"})
    @BeforeMethod(description = "Opening Browser")
    public void setup(@Optional("chrome") String browser, ITestContext testContext) {
        if(browser.equals("chrome")){
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            driver = new ChromeDriver(options);//не забывать (options)
        } else if(browser.equals("firefox")){
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--headless");
            driver = new FirefoxDriver(options);
        }
        testContext.setAttribute("driver", driver);
        WebDriverWait wait = new WebDriverWait(driver, 10);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        loginPage = new LoginPage(driver);
        createContactPage = new CreateContactPage(driver);
        homePage = new HomePage(driver);
        createAccountPage = new CreateAccountPage(driver);
    }

    @AfterMethod(alwaysRun = true, description = "Close Browser")
    public void close() {
       if(driver != null){
           driver.quit();
       }
    }
}
