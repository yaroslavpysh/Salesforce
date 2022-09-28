package wrappers;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
@Log4j2
public class DropDown {
    WebDriver driver;
    String label;

    public DropDown(String label, WebDriver driver) {
        this.label = label;
        this.driver = driver;

    }

    public void select(String text) {
        log.info("Filling field {}", label);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(By.xpath(String.format
                ("//label[text()='%s']/..//button", label))));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(By.xpath(String.format
                ("//label[text()='%s']/..//span[text()='%s']", label, text))));

    }
}
