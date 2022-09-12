package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import wrappers.DropDown;
import wrappers.Input;

public class CreateContactPage extends BasePage{

    public CreateContactPage(WebDriver driver){
        super(driver);
    }
    private final By SUBTITLE = By.xpath("//span[@class='slds-var-p-right_x-small' and text()='Contacts']");
    private final By NEW_BUTTON = By.cssSelector("[title=New]");
    private final By CONTACTS_BUTTON = By.xpath("//a[@title='Contacts']/span");

    public void open() {
        driver.get(BASE_URL + "lightning/o/Contact/list?filterName=Recent");
        driver.findElement(CONTACTS_BUTTON).click();
    }

    public boolean isOpened() {
        return waitForVisibility(SUBTITLE);
    }

    public void create(String lastName, String phone, String firstName, String mobile, String salutation){
        driver.findElement(NEW_BUTTON).click();
        new Input("Last Name", driver).write(lastName);
        new Input("Phone", driver).write(phone);
        new Input("First Name", driver).write(firstName);
        new Input("Mobile", driver).write(mobile);
        new DropDown("Salutation", driver).select(salutation);
    }

}
