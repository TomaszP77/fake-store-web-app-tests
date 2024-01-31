package behaviordrivendevelopment;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import pages.WindsurfingCategoryPage;

public class WindsurfingCategoryPageStepdefs {

    private WindsurfingCategoryPage windsurfingCategoryPage;

    @Given("Windsurfing category page step definitions are available")
    public void windsurfingCategoryPageStepDefinitionsAreAvailable() {
        windsurfingCategoryPage = new WindsurfingCategoryPage();
    }

    @And("The user adds an offer Egipt El Gouna to the cart")
    public void theUserAddsAnOfferEgiptElGounaToTheCart() {
        windsurfingCategoryPage.setAddProductWindsurfingEgiptElGounaToCart();
    }
}
