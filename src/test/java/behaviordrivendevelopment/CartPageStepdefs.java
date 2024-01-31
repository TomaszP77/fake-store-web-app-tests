package behaviordrivendevelopment;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import pages.CartPage;

public class CartPageStepdefs {

    private CartPage cartPage;

    @Given("Cart page step definitions are available")
    public void cartPageStepDefinitionsAreAvailable() {
        cartPage = new CartPage();
    }

    @And("The user moves the cursor to the quick view of the basket")
    public void theUserMovesTheCursorToTheQuickViewOfTheBasket() {
        cartPage.moveCursorTooCartQuickLook();
    }

    @And("The user presses the Zobacz koszyk button in the basket quick view window")
    public void theUserPressesTheViewBasketButtonInTheBasketQuickViewWindow() {
        cartPage.viewCart();
    }

    @Then("The user notices that the product has been successfully added to the cart")
    public void theUserNoticesThatTheProductHasBeenSuccessfullyAddedToTheCart() {
        Assertions.assertEquals("Egipt - El Gouna", cartPage.getTextForAssertionCart());
        Assertions.assertTrue(cartPage.imageForAssertionCart());
    }
}
