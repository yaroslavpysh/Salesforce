package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import wrappers.DropDown;
import wrappers.Input;
import wrappers.TextArea;

public class CreateAccountPage extends BasePage {
    private final By SUBTITLE = By.xpath("//span[@class='slds-var-p-right_x-small' and text()='Accounts']");
    private final By ACCOUNTS_BUTTON = By.xpath("//a[@title='Accounts']/span");
    private final By NEW_BUTTON = By.cssSelector("[title=New]");


    public CreateAccountPage(WebDriver driver) {
        super(driver);
    }

    @Step("Opening 'Account Page'")
    public void open() {
        driver.get(BASE_URL + "lightning/o/Account/list?filterName=Recent");

//        driver.findElement(ACCOUNTS_BUTTON).click();
    }

    public boolean isOpened() {
        return waitForVisibility(SUBTITLE);
    }

    @Step("Filling fields on 'Account Page'")
    public void create(String accountName, String phone, String fax, String accountNumber, String webSite, String accountSite, String type,
                       String ownership, String industry, String sicCode, String billingStreet, String shippingStreet,
                       String billingCity, String slaExpirationDate, String customerPriority, String upsellOpportunity, String active, String description) {

        driver.findElement(NEW_BUTTON).click();
        new Input("Account Name", driver).write(accountName);
        new Input("Phone", driver).write(phone);
        new Input("Fax", driver).write(fax);
        new Input("Account Number", driver).write(accountNumber);
        new Input("Website", driver).write(webSite);
        new Input("Account Site", driver).write(accountSite);
        new DropDown("Type", driver).select(type);
        new DropDown("Ownership", driver).select(ownership);
        new DropDown("Industry", driver).select(industry);
        new Input("SIC Code", driver).write(sicCode);
        new TextArea("Billing Street", driver).write(billingStreet);
        new TextArea("Shipping Street", driver).write(shippingStreet);
        new Input("Billing City", driver).write(billingCity);
        new DropDown("Customer Priority", driver).select(customerPriority);
        new Input("SLA Expiration Date", driver).write(slaExpirationDate);
        new DropDown("Upsell Opportunity", driver).select(upsellOpportunity);
        new DropDown("Active", driver).select(active);
        new TextArea("Description", driver).write(description);

    }

}
