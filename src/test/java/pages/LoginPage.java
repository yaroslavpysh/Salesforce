package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private final By USERNAME_INPUT = By.id("username");
    private final By PASSWORD_INPUT = By.id("password");
    private final By LOGIN_BUTTON = By.id("Login");


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Opening 'Login Page'")
    public void open() {
        driver.get(BASE_URL);
    }

    public boolean isOpened() {
        return waitForVisibility(LOGIN_BUTTON);
    }

    @Step("Login by '{userName}' using password '{password}'")
    public void login(String userName, String password) {

        driver.findElement(USERNAME_INPUT).sendKeys(userName);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();

    }

}