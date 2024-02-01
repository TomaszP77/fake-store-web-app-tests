package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.LoggedUserPage;
import pages.MyAccountPage;
import utils.BaseTest;

import java.io.IOException;

import static model.ReadyUsersWithData.userWithAccount;
import static model.ReadyUsersWithData.userWithOutAccount;
import static utils.Screenshot.screenshotAssertion;

public class LogInTests extends BaseTest {

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
    public void logInTest() throws IOException {
        homePage.closingTheInformationWindow();
        homePage.topMenuChoice("Moje konto");
        myAccountPage.logInUser(userWithAccount());

        Assertions.assertEquals("Witaj abc-7252 (nie jesteœ abc-7252? Wyloguj siê)"
                , loggedUserPage.getAssertionForLogInUser());
        screenshotAssertion("logInTest");
    }

    @Test
    public void logInTheUserWithWrongDataTest() throws IOException {
        homePage.closingTheInformationWindow();
        homePage.topMenuChoice("Moje konto");
        myAccountPage.logInUser(userWithOutAccount());

        Assertions.assertEquals("B³¹d: brak 1234 wœród zarejestrowanych w witrynie u¿ytkowników." +
                        " Jeœli nie masz pewnoœci co do nazwy u¿ytkownika, u¿yj adresu e-mail."
                , myAccountPage.errorMessageForLoginWithWrongData());
        screenshotAssertion("logInTheUserWithWrongDataTest");
    }
}
