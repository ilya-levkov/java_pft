package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase{

    @Test
    public void testContactModification() {
        app.getNavigationHelper().gotoContactPage();
        if (!app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData("Ilya", "Levkov", "Russia, Ryazan", "+79156255826", "ilya.levkov2@gmail.com"));
        }
        app.getContactHelper().selectContact();
        app.getContactHelper().initContactModification();
        app.getContactHelper().fillContactForm(new ContactData("Vasya", "Pupkin", "Russia, Ryazan", "+79156255826", "ilya.levkov2@gmail.com"));
        app.getContactHelper().submitContactModification();
    }
}
