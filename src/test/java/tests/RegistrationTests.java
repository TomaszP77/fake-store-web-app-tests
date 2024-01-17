package tests;

import model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.LoggedUserPage;
import pages.MyAccountPage;
import utils.BaseTest;
import utils.Screenshot;

import java.io.IOException;
import java.util.List;

public class RegistrationTests extends BaseTest {

    private HomePage homePage;
    private MyAccountPage myAccountPage;
    private LoggedUserPage loggedUserPage;

    @BeforeEach
    public void beforeEach() {
        setUp();
        homePage = new HomePage();
        myAccountPage = new MyAccountPage();
        loggedUserPage = new LoggedUserPage();
    }

    @Test
    public void registrationUserTest() throws IOException {
        int randomEmail = (int) (Math.random() * 1000);
        String email = "abc@de" + randomEmail + ".fg";

        User user = new User();
        user.setEmail(email);
        user.setPassword("Abcd123456789$");

        homePage.closingTheInformationWindow();
        homePage.topMenuChoice("Moje konto");
        myAccountPage.registerUser(user);

        List<String> assertionElements = loggedUserPage.assertionForRegisterUser();

        Assertions.assertEquals("Kokpit", assertionElements.get(0));
        Assertions.assertEquals("Moje zamówienia", assertionElements.get(1));
        Assertions.assertEquals("Edycja konta", assertionElements.get(2));
        Assertions.assertEquals("Adres", assertionElements.get(3));
        Assertions.assertEquals("Wyloguj", assertionElements.get(4));
        Screenshot.screenshotAssertion("registrationUserTest");
    }

    @Test
    public void userRegistrationWithWeakPassword() {
        int randomEmail = (int) (Math.random() * 1000);

        User user = new User();
        user.setEmail("abc@de" + randomEmail + ".fg");
        user.setPassword("abcd");

        homePage.closingTheInformationWindow();
        homePage.topMenuChoice("Moje konto");
        myAccountPage.registerUser(user);

        String assertionMessage = myAccountPage.getAssertionForTooWeakPassword();
        Assertions.assertEquals("Bardzo s³abe - Proszê wpisaæ mocniejsze has³o.", assertionMessage);
    }

    @Test
    public void userRegistrationWithIncorrectEmailAddress() {
        User user = new User();
        user.setEmail("abcd@ef");
        user.setPassword("Abcd123456789$");

        homePage.closingTheInformationWindow();
        homePage.topMenuChoice("Moje konto");
        myAccountPage.registerUser(user);

        Assertions.assertEquals("B³¹d: Podaj poprawny adres e-mail.",
                myAccountPage.getAssertionForInvalidEmail());
    }
}
