package behaviordrivendevelopment;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import pages.ShopPage;

public class ShopPageStepdefs {

    private ShopPage shopPage;

    @Given("Shop page step definitions are available")
    public void shopPageStepDefinitionsAreAvailable() {
        shopPage = new ShopPage();
    }

    @And("The user will select categories {string}")
    public void theUserWillSelectCategories(String category) {
        shopPage.setShoppingCategoryChoice(category);
    }
}
