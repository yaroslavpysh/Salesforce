package wrappers;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.v85.webaudio.WebAudio;
@Log4j2
public class TextArea {
    WebDriver driver;
    String label;

    public TextArea (String label, WebDriver driver){
        this.label = label;
        this.driver = driver;

    }

    public void write(String text){
        log.info("Write text into text area {}", label);
        driver.findElement(By.xpath(String.format("//label[text()='%s']/..//textarea", label))).sendKeys(text);

    }
}
