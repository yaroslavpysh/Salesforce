package pages;

import io.qameta.allure.Step;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
@Log4j2
public class HomePage extends BasePage {
    private final By TITLE_HOME = By.cssSelector("[title=Home]");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Step("Opening 'Home Page'")
    public void open() {
        driver.get(BASE_URL + "lightning/setup/SetupOneHome/home");
    }

    public boolean isOpened() {
        return waitForVisibility(TITLE_HOME);
    }

}