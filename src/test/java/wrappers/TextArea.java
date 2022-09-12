package wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.v85.webaudio.WebAudio;

public class TextArea {
    WebDriver driver;
    String label;

    public TextArea (String label, WebDriver driver){
        this.label = label;
        this.driver = driver;

    }

    public void write(String text){
        driver.findElement(By.xpath(String.format("//label[text()='%s']/..//textarea", label))).sendKeys(text);

    }
}
