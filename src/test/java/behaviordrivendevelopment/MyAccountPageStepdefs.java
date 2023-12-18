package behaviordrivendevelopment;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import model.User;
import org.junit.jupiter.api.Assertions;
import pages.MyAccountPage;

import static model.ReadyUsersWithData.userWithAccount;

public class MyAccountPageStepdefs {

    private MyAccountPage myAccountPage;

    @Given("My account page step definitions are available")
    public void myAccountPageStepDefinitionsAreAvailable() {
        myAccountPage = new MyAccountPage();
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

    @And("The user provides a valid e-mail address and a weak password and clicks the Register button")
    public void theUserProvidesAValidEMailAddressAndAWeakPasswordAndClicksTheRegisterButton() {
        int randomEmail = (int) (Math.random() * 1000);

        User user = new User();
        user.setEmail("abc@de" + randomEmail + ".fg");
        user.setPassword("abcd");

        myAccountPage.registerUser(user);
    }

    @And("The user provides an incorrect e-mail address and password and clicks the Register button")
    public void theUserProvidesAnIncorrectEMailAddressAndPasswordAndClicksTheRegisterButton() {
        User user = new User();
        user.setEmail("abcd@ef");
        user.setPassword("Abcd123456789$");

        myAccountPage.registerUser(user);
    }

    @And("In the log in section, the user enters the correct email address and password, then clicks the log in button")
    public void inTheLogInSectionTheUserEntersTheCorrectEmailAddressAndPasswordThenClicksTheLogInButton() {
        myAccountPage.logInUser(userWithAccount());
    }

    @Then("Message appears: Blad: Podaj poprawny adres e-mail.")
    public void theUserIsNotRegisteredBecauseHisEmailAddressIsIncorrect() {
        Assertions.assertEquals("B³¹d: Podaj poprawny adres e-mail.",
                myAccountPage.getAssertionForInvalidEmail());
    }

    @Then("Message appears: Bardzo slabe - Prosze wpisac mocniejsze haslo.")
    public void messageAppearsBardzoSlabeProszeWpisacMocniejszeHaslo() {
        String assertionMessage = myAccountPage.getAssertionForTooWeakPassword();
        Assertions.assertEquals("Bardzo s³abe - Proszê wpisaæ mocniejsze has³o.", assertionMessage);
    }
}
