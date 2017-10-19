package ru.stqa.pft.mantis.tests;

import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.lanwen.verbalregex.VerbalExpression;
import ru.stqa.pft.mantis.appmanager.*;
import ru.stqa.pft.mantis.model.MailMessage;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;
import java.util.Random;

import static org.testng.Assert.assertTrue;


public class PasswordChangeTests extends TestBase {
    private PasswordChangeHelper passHelper;
    private MailHelper mailHelper;


    @BeforeMethod
    public void startMailServer() {
        passHelper = new PasswordChangeHelper(app);
        mailHelper = new MailHelper(app);
        //mailHelper.start();
        app.mail().start();
    }

    @Test
    public void testPasswordChange() throws IOException, MessagingException {
        passHelper.login(app.getProperty("web.adminLogin"), app.getProperty("web.adminPassword"));
        passHelper.goToManagePage();
        passHelper.goToManageUsers();
        passHelper.chooseUser();
        String username = passHelper.getUserName();
        String usermail = passHelper.getUserMail();
        passHelper.resetUserPassword();
        List<MailMessage> mailMessage = app.mail().waitForMail(1, 60000);
        String resetLink = findResetLink(mailMessage, usermail);
        System.out.println(resetLink);
        passHelper.goToResetPage(resetLink);
        String newPassword = "password";
        passHelper.setNewPassword(newPassword);
        HttpSession session1 = app.newSession();

//        assertTrue(session1.login(username, newPassword));
//        assertTrue(session1.isLoggedInAs(username));
        //passHelper.logout();
        //assertTrue(app.newSession().login(username, newPassword));
        //assertTrue(session.login(username, newPassword));
        //assertTrue(session.isLoggedInAs(username));
        //HttpSession session = app.newSession();
        //AssertJUnit.assertTrue(session1.login("user1508374177977", "123"));
        session1.login(username, newPassword);
        //assertTrue(passHelper.login("user1508374177977", newPassword));

    }

    private String findResetLink(List<MailMessage> mailMessages, String email) {
        MailMessage mailMessage = mailMessages.stream().filter((m) -> m.to.equals(email)).findFirst().get();
        VerbalExpression regex = VerbalExpression.regex().find("http://").nonSpace().oneOrMore().build();
        return regex.getText(mailMessage.text);
    }

    @AfterMethod
    public void stopMailServer() {
        app.mail().stop();
    }
}
