package pages;

import dto.Contact;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import wrappers.DropDown;
import wrappers.Input;

@Log4j2
public class CreateContactPage extends BasePage{

    private final By SUBTITLE = By.xpath("//span[@class='slds-var-p-right_x-small' and text()='Contacts']");
    private final By NEW_BUTTON = By.cssSelector("[title=New]");
    private final By CONTACTS_BUTTON = By.xpath("//a[@title='Contacts']/span");

    public CreateContactPage(WebDriver driver){
        super(driver);
    }

    @Step("Opening 'Account Page'")
    public void open() {
        log.info("Open contact page");
        driver.get(BASE_URL + "lightning/o/Contact/list?filterName=Recent");

//        driver.findElement(CONTACTS_BUTTON).click();

    }

    public boolean isOpened() {
        return waitForVisibility(SUBTITLE);
    }

    @Step("Creating new contact: {contact.lastName}")
    public void create(Contact contact){
        log.info("Creating contact: '{}'", contact);
        driver.findElement(NEW_BUTTON).click();
        new Input("Last Name", driver).write(contact.getLastName());
        new Input("Phone", driver).write(contact.getPhone());
        new Input("First Name", driver).write(contact.getFirstName());
        new Input("Mobile", driver).write(contact.getMobile());
        new DropDown("Salutation", driver).select(contact.getSalutation());
    }

}
