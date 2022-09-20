package tests;


import org.testng.annotations.Test;

public class ContactTest extends BaseTest{

    @Test(description = "Checking filling of fields on 'Account page'")
    public void contactCreation(){
        loginPage.open();
        loginPage.login("yaroslav_pysh@company.sandbox", "password11");
        createContactPage.open();
        createContactPage.isOpened();
        createContactPage.create("Pyshnik", "+3752966666666", "Yaroslav", "+375296666666", "Mr.");
//        Assert.assertTrue();

    }
}


