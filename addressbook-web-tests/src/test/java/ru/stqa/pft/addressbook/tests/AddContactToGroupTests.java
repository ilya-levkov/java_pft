package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.testng.Assert.assertEquals;

import java.security.acl.Group;

public class AddContactToGroupTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
        if (app.db().contacts().size() == 0) {
            app.goTo().ContactPage();
            app.contact().create(new ContactData()
                    .withContactFirstName("firstname_test")
                    .withContactLastName("lastname_test"));
        }
        if (app.db().groups().size() == 0) {
            app.goTo().GroupPage();
            app.group().create(new GroupData()
                    .withName("test2'"));
        }
    }

    @Test
    public void testAddContactToGroup() {
        app.goTo().gotoToHomePage();
        ContactData addedContact = app.db().contacts().iterator().next();
        GroupData group = app.db().groups().iterator().next();
        Contacts before = group.getContacts();
        app.contact().addToGroup(addedContact, group);
        GroupData group1 = app.db().groups().iterator().next();
        Contacts after = group1.getContacts();
        assertThat(after, equalTo(before.withAdded(addedContact)));
    }

}
