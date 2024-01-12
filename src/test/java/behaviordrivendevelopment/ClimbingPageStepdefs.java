package behaviordrivendevelopment;

import io.cucumber.java.en.Given;
import pages.ClimbingPage;

public class ClimbingPageStepdefs {

    private ClimbingPage climbingPage;

    @Given("Climbing page step definitions are available")
    public void climbingPageStepDefinitionsAreAvailable() {
        climbingPage = new ClimbingPage();
    }
}
