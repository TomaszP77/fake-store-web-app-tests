package behaviordrivendevelopment;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import pages.ClimbingPage;

public class ClimbingPageStepdefs {

    private ClimbingPage climbingPage;

    @Given("Climbing page step definitions are available")
    public void climbingPageStepDefinitionsAreAvailable() {
        climbingPage = new ClimbingPage();
    }

    @And("The user adds the Gran Koscielcow product to the cart")
    public void theUserAddsTheGranKoscielcowProductToTheCart() {
        climbingPage.addingTheGranKoscielcowProductToTheCart();
    }

    @And("The user goes to the cart")
    public void theUserGoesToTheCart() {
        climbingPage.goToTheCart();
    }
}
