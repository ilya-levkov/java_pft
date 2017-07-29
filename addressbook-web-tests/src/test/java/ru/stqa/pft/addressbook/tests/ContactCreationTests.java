package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase{

    @Test
    public void testContactCreation() {
        app.getContactHelper().gotoContactCreationPage();
        app.getContactHelper().fillContactForm(new ContactData("Ilya", "Levkov", "Russia, Ryazan", "+79156255826", "ilya.levkov2@gmail.com"));
        app.getContactHelper().submitContactCreation();
    }

}
