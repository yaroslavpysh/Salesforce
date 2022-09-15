package tests;

import org.testng.annotations.Test;


public class AccountTest extends BaseTest {

    @Test
    public void accountCreation() {
        loginPage.open();
        loginPage.login("yaroslav_pysh@company.sandbox", "password11");
        createAccountPage.open();
        createAccountPage.isOpened();
        createAccountPage.create("Yaroslav", "+375266666666", "+375266666666", "2555",
                "www.bla.com", "5", "Prospect", "Public", "Education", "234",
                "Nezavis", "Prospect", "Minsk", "9/27/2023", "Low", "No",
                "No", "bablablablabla");
//        Assert.assertTrue();

    }
}
