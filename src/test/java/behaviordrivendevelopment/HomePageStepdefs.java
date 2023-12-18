package behaviordrivendevelopment;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.HomePage;

public class HomePageStepdefs {

    private HomePage homePage;

    @Given("Home page step definitions are available")
    public void homePageStepDefinitionsAreAvailable() {
        homePage = new HomePage();
    }

    @And("The user clicks the {string} button from the top menu")
    public void theUserClicksTheButtonFromTheTopMenu(String menuButton) {
        homePage.topMenuChoice(menuButton);
    }

    @When("The user closes the notification window at the bottom of the page")
    public void theUserClosesTheNotificationWindowAtTheBottomOfThePage() {
        homePage.closingTheInformationWindow();
    }
}
