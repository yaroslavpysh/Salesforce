package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    private final By TITLE_HOME = By.cssSelector("[title=Home]");


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(BASE_URL + "lightning/setup/SetupOneHome/home");
    }

    public boolean isOpened() {
        return waitForVisibility(TITLE_HOME);
    }

}