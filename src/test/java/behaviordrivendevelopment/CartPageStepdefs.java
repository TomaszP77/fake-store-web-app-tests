package behaviordrivendevelopment;

import io.cucumber.java.en.Given;
import pages.CartPage;

public class CartPageStepdefs {

    private CartPage cartPage;

    @Given("Cart page step definitions are available")
    public void cartPageStepDefinitionsAreAvailable() {
        cartPage = new CartPage();
    }
}
