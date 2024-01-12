package behaviordrivendevelopment;

import io.cucumber.java.en.Given;
import pages.WindsurfingCategoryPage;

public class WindsurfingCategoryPageStepdefs {

    private WindsurfingCategoryPage windsurfingCategoryPage;

    @Given("Windsurfing category page step definitions are available")
    public void windsurfingCategoryPageStepDefinitionsAreAvailable() {
        windsurfingCategoryPage = new WindsurfingCategoryPage();
    }
}
