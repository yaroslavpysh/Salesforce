package tests;

import dto.Account;
import org.testng.annotations.Test;
import pages.CreateAccountPage;


public class AccountTest extends BaseTest {

    @Test(description = "Checking filling of fields on 'Account page'")
    public void accountCreation() {
        loginPage.open();
        loginPage.login("yaroslav_pysh@company.sandbox", "password11");
        createAccountPage.open();
        createAccountPage.isOpened();
        Account account = new Account();
        new CreateAccountPage(driver).create(account);

    }
}
