package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactCreationTests extends TestBase{

    @Test
    public void testContactCreation() {
        app.goTo().ContactPage();
        Contacts before = app.contact().all();
        // Contacts before = app.contact().all();
        ContactData contact1 = new ContactData()
                .withContactFirstName("ilya_test").withContactLastName("ilya_test");
        app.contact().create(contact1);
        Contacts after = app.contact().all();
        assertThat(after.size(), equalTo(before.size() + 1));

        assertThat(after, equalTo(
                before.withAdded(contact1.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
    }

}
