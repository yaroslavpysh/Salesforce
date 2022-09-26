package tests;

import dto.Contact;
import org.testng.annotations.Test;
import pages.CreateContactPage;

public class ContactTest extends BaseTest{

    @Test(description = "Checking filling of fields on 'Account page'")
    public void contactCreation(){
        loginPage.open();
        loginPage.login("yaroslav_pysh@company.sandbox", "password11");
        createContactPage.open();
        createContactPage.isOpened();
        Contact contact = new Contact();
        new CreateContactPage(driver).create(contact);
    }
}


