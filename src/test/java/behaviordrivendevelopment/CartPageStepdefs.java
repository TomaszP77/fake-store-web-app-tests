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

    @And("The user sets the number of products in the basket {string}")
    public void theUserSetsTheNumberOfProductsInTheBasket(String quantity) {
        cartPage.setQuantity(quantity);
    }

    @And("The user updates the cart")
    public void theUserUpdatesTheCart() {
        cartPage.updateCart();
    }

    @Then("The User then notices that the cart has been successfully updated")
    public void theUserThenNoticesThatTheCartHasBeenSuccessfullyUpdated() {
        Assertions.assertEquals("Koszyk zaktualizowany.", cartPage.getCartUpdateMessage());
        Assertions.assertTrue(cartPage.productQuantityDisplayedCheck().isDisplayed());
    }

    @And("The user removes the item from the cart")
    public void theUserRemovesTheItemFromTheCart() {
        cartPage.removeItemFromCart();
    }

    @Then("The user then notices that the product has been successfully removed from the cart")
    public void theUserThenNoticesThatTheProductHasBeenSuccessfullyRemovedFromTheCart() {
        Assertions.assertEquals("Usunięto: „Windsurfing w Lanzarote (Costa Teguise)“. Cofnij?"
                , cartPage.assertionMessageForRemoveProductFromCart());
    }
}
