package wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class DropDown {
    WebDriver driver;
    String label;

    public DropDown(String label, WebDriver driver) {
        this.label = label;
        this.driver = driver;

    }
    //        driver.findElement(By.xpath(String.format("//label[text()='%s']/..//span[text()='%s']", label, text))).click();
    //        driver.findElement(By.xpath(String.format("//label[text()='%s']/..//button", label))).click();

    public void select(String text) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(By.xpath(String.format
                ("//label[text()='%s']/..//button", label))));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(By.xpath(String.format
                ("//label[text()='%s']/..//span[text()='%s']", label, text))));

    }
}
