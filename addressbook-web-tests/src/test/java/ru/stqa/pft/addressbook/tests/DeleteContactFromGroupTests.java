package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;

import static org.testng.AssertJUnit.assertTrue;

public class DeleteContactFromGroupTests extends TestBase {

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
        if (app.db().contactsInGroup().size()==0){
            app.goTo().gotoToHomePage();
            app.contact().addToGroup(app.db().contacts().iterator().next(), app.db().groups().iterator().next());
        };
    }

    @Test
    public void testDeleteContactFromGroup() {
        app.goTo().gotoToHomePage();
        Contacts before = app.db().contactsInGroup();
        ContactData deletedContact = before.iterator().next();
        GroupData group = app.db().groups().iterator().next();
        app.contact().deleteFromGroup(deletedContact, group);
        Contacts after = app.db().contacts();
        assertTrue(after.iterator().next().getGroups().isEmpty());

    }
}
