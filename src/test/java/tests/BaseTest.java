package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import pages.CreateAccountPage;
import pages.CreateContactPage;
import pages.HomePage;
import pages.LoginPage;

import java.time.Duration;
@Listeners(TestListener.class)
public class BaseTest {
    WebDriver driver;
    LoginPage loginPage;
    CreateContactPage createContactPage;
    CreateAccountPage createAccountPage;
    HomePage homePage;


    @Parameters({"browser"})
    @BeforeMethod
    public void setup(@Optional("chrome") String browser) {
        if(browser.equals("chrome")){
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
//            options.addArguments("--headless");
            driver = new ChromeDriver(options);//не забывать (options)

        } else if(browser.equals("firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--headless");
        }
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        loginPage = new LoginPage(driver);
        createContactPage = new CreateContactPage(driver);
        homePage = new HomePage(driver);
        createAccountPage = new CreateAccountPage(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void close() {
       if(driver != null){
           driver.quit();
       }
    }
}
