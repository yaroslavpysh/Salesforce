package pages;
import dto.Account;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import wrappers.DropDown;
import wrappers.Input;
import wrappers.TextArea;

@Log4j2
public class CreateAccountPage extends BasePage {
    private final By SUBTITLE = By.xpath("//span[@class='slds-var-p-right_x-small' and text()='Accounts']");
    private final By ACCOUNTS_BUTTON = By.xpath("//a[@title='Accounts']/span");
    private final By NEW_BUTTON = By.cssSelector("[title=New]");


    public CreateAccountPage(WebDriver driver) {
        super(driver);
    }

    @Step("Opening 'Account Page'")
    public void open() {
        log.info("Open page Account page");
        driver.get(BASE_URL + "lightning/o/Account/list?filterName=Recent");

//        driver.findElement(ACCOUNTS_BUTTON).click();
    }

    public boolean isOpened() {
        return waitForVisibility(SUBTITLE);
    }

    @Step("Creating new account: {account.accountName}")
        public void create(Account account){
        log.info("Creating account: '{}'", account.getAccountName());
        driver.findElement(NEW_BUTTON).click();
        new Input("Account Name", driver).write(account.getAccountName());
        new Input("Phone", driver).write(account.getPhone());
        new Input("Fax", driver).write(account.getFax());
        new Input("Account Number", driver).write(account.getAccountNumber());
        new Input("Website", driver).write(account.getWebSite());
        new Input("Account Site", driver).write(account.getAccountSite());
        new DropDown("Type", driver).select(account.getType());
        new DropDown("Ownership", driver).select(account.getOwnership());
        new DropDown("Industry", driver).select(account.getIndustry());
        new Input("SIC Code", driver).write(account.getSicCode());
        new TextArea("Billing Street", driver).write(account.getBillingCity());
        new TextArea("Shipping Street", driver).write(account.getShippingStreet());
        new Input("Billing City", driver).write(account.getBillingCity());
        new DropDown("Customer Priority", driver).select(account.getCustomerPriority());
        new Input("SLA Expiration Date", driver).write(account.getSlaExpirationDate());
        new DropDown("Upsell Opportunity", driver).select(account.getUpsellOpportunity());
        new DropDown("Active", driver).select(account.getActive());
        new TextArea("Description", driver).write(account.getDescription());

    }

}
