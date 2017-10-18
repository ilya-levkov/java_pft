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

    public ContactData contactWithoutGroup = new ContactData();

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
        // Если добавлены все имеющиеся контакты
        if (app.db().contactsInGroup().size() == app.db().contacts().size()) {
            app.goTo().ContactPage();
            app.contact().create(contactWithoutGroup = new ContactData()
                    .withContactFirstName("first_test")
                    .withContactLastName("last_test"));

        }
    }

    @Test
    public void testAddContactToGroup() {
        app.goTo().gotoToHomePage();
        GroupData group = app.db().groups().iterator().next();
        Contacts before = group.getContacts();
        System.out.println(app.db().ContactsWithoutGroups().size() + "345345345345");
        ContactData addedContact;
        if (app.db().ContactsWithoutGroups().size() == 0) {
            addedContact = contactWithoutGroup;
            app.contact().addToGroup(addedContact, group);
        }
        else {
            addedContact = app.db().contacts().iterator().next();
            app.contact().addToGroup(addedContact, group);
        }
        System.out.println("dgdfgdfgdfg" + addedContact);
        /*
        if (app.db().ContactsWithoutGroups().size() == 1) {
            ContactData addedContact = contactWithoutGroup;
            app.contact().addToGroup(contactWithoutGroup, group);
        } else {
            ContactData addedContact = app.db().contacts().iterator().next();
            app.contact().addToGroup(addedContact, group);
        }
        */
        /*
        else {
            ContactData addedContact = app.db().contacts().iterator().next(); }
            app.contact().addToGroup(addedContact, group);
        */
        //ContactData addedContact = app.db().contacts().iterator().next();
        //app.contact().addToGroup(addedContact, group);
        GroupData group1 = app.db().groups().iterator().next();
        Contacts after = group1.getContacts();
        assertThat(after, equalTo(before.withAdded(addedContact)));
        /*
        app.goTo().gotoToHomePage();
        ContactData addedContact = app.db().contacts().iterator().next();
        GroupData group = app.db().groups().iterator().next();
        Contacts before = group.getContacts();
        app.contact().addToGroup(addedContact, group);
        GroupData group1 = app.db().groups().iterator().next();
        Contacts after = group1.getContacts();
        assertThat(after, equalTo(before.withAdded(addedContact)));
        */
    }

}
