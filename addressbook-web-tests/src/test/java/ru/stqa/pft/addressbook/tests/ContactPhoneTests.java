package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactPhoneTests extends TestBase {

    @Test
    public void testContactPhones() {
        app.goTo().gotoToHomePage();
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

        assertThat(contact.getContactHomePhone(), equalTo(cleaned(contactInfoFromEditForm.getContactHomePhone())));
        assertThat(contact.getContactMobilePhone(), equalTo(cleaned(contactInfoFromEditForm.getContactMobilePhone())));
        assertThat(contact.getContactWorkPhone(), equalTo(cleaned(contactInfoFromEditForm.getContactWorkPhone())));
    }

    public String cleaned(String phone) {
        return phone.replaceAll("\\s", "").replaceAll("[-()]", "");
    }

}
