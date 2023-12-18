package behaviordrivendevelopment;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import pages.LoggedUserPage;

import java.util.List;

public class LoggedUserPageStepdefs {

    private LoggedUserPage loggedUserPage;

    @Given("Logged user page step definitions are available")
    public void loggedUserPageStepDefinitionsAreAvailable() {
        loggedUserPage = new LoggedUserPage();
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

    @Then("The user is successfully logged into the account")
    public void theUserIsSuccessfullyLoggedIntoTheAccount() {
        Assertions.assertEquals("Witaj abc-7252 (nie jesteœ abc-7252? Wyloguj siê)"
                , loggedUserPage.getAssertionForLogInUser());
    }
}
