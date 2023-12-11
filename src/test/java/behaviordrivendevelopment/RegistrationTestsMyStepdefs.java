package behaviordrivendevelopment;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.User;
import org.junit.jupiter.api.Assertions;
import pages.HomePage;
import pages.LoggedUserPage;
import pages.MyAccountPage;
import utils.BaseTest;

import java.util.List;

public class RegistrationTestsMyStepdefs extends BaseTest {
    private HomePage homePage;
    private MyAccountPage myAccountPage;
    private LoggedUserPage loggedUserPage;

    @Given("Page is loaded")
    public void pageIsLoaded() {
        setUp();
        homePage = new HomePage();
        myAccountPage = new MyAccountPage();
        loggedUserPage = new LoggedUserPage();
    }

    @And("The user clicks the {string} button from the top menu")
    public void theUserClicksTheButtonFromTheTopMenu(String menuButton) {
        homePage.topMenuChoice(menuButton);
    }

    @And("The user enters the correct email address and password and clicks the Register button")
    public void theUserEntersTheCorrectEmailAddressAndPasswordAndClicksTheRegisterButton() {
        int randomEmail = (int) (Math.random() * 1000);
        String email = "abc@de" + randomEmail + ".fg";

        User user = new User();
        user.setEmail(email);
        user.setPassword("Abcd123456789$");

        myAccountPage.registerUser(user);
    }

    @When("The user closes the notification window at the bottom of the page")
    public void theUserClosesTheNotificationWindowAtTheBottomOfThePage() {
        homePage.closingTheInformationWindow();
    }

    @Then("The user is successfully registered and redirected to the 'Moje konto' page")
    public void theUserIsSuccessfullyRegisteredAndRedirectedToTheMyAccountPage() {
        List<String> assertionElements = loggedUserPage.assertionForRegisterUser();

        Assertions.assertEquals("Kokpit", assertionElements.get(0));
        Assertions.assertEquals("Moje zamówienia", assertionElements.get(1));
        Assertions.assertEquals("Edycja konta", assertionElements.get(2));
        Assertions.assertEquals("Adres", assertionElements.get(3));
        Assertions.assertEquals("Wyloguj", assertionElements.get(4));
    }

    @And("The user provides a valid e-mail address and a weak password and clicks the Register button")
    public void theUserProvidesAValidEMailAddressAndAWeakPasswordAndClicksTheRegisterButton() {
        int randomEmail = (int) (Math.random() * 1000);

        User user = new User();
        user.setEmail("abc@de" + randomEmail + ".fg");
        user.setPassword("abcd");

        myAccountPage.registerUser(user);
    }

    @Then("Message appears: Bardzo slabe - Prosze wpisac mocniejsze haslo.")
    public void messageAppearsBardzoSlabeProszeWpisacMocniejszeHaslo() {
        String assertionMessage = myAccountPage.getAssertionForTooWeakPassword();
        Assertions.assertEquals("Bardzo s³abe - Proszê wpisaæ mocniejsze has³o.", assertionMessage);
    }

    @And("The user provides an incorrect e-mail address and password and clicks the Register button")
    public void theUserProvidesAnIncorrectEMailAddressAndPasswordAndClicksTheRegisterButton() {
        User user = new User();
        user.setEmail("abcd@ef");
        user.setPassword("Abcd123456789$");

        myAccountPage.registerUser(user);
    }

    @Then("Message appears: Blad: Podaj poprawny adres e-mail.")
    public void theUserIsNotRegisteredBecauseHisEmailAddressIsIncorrect() {
        Assertions.assertEquals("B³¹d: Podaj poprawny adres e-mail.",
                myAccountPage.getAssertionForInvalidEmail());
    }
}
