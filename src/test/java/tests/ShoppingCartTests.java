package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.*;
import utils.BaseTest;
import utils.Screenshot;

import java.io.IOException;

import static model.ReadyUsersWithData.userWithAccount;

public class ShoppingCartTests extends BaseTest {

    private HomePage homePage;
    private MyAccountPage myAccountPage;
    private LoggedUserPage loggedUserPage;
    private ShopPage shopPage;
    private WindsurfingCategoryPage windsurfingCategoryPage;
    private CartPage cartPage;
    private ClimbingPage climbingPage;

    @BeforeEach
    public void beforeEach() {
        setUp();
        homePage = new HomePage();
        myAccountPage = new MyAccountPage();
        loggedUserPage = new LoggedUserPage();
        shopPage = new ShopPage();
        windsurfingCategoryPage = new WindsurfingCategoryPage();
        cartPage = new CartPage();
        climbingPage = new ClimbingPage();
    }

    @Test
    public void addToCartTest() throws IOException {
        homePage.closingTheInformationWindow();
        homePage.topMenuChoice("Moje konto");
        myAccountPage.logInUser(userWithAccount());
        homePage.topMenuChoice("Sklep");
        shopPage.setShoppingCategoryChoice("Windsurfing");
        windsurfingCategoryPage.setAddProductWindsurfingToCart();
        cartPage.moveCursorTooCartQuickLook();
        cartPage.viewCart();

        Assertions.assertEquals("Egipt - El Gouna", cartPage.getTextForAssertionCart());
        Assertions.assertTrue(cartPage.imageForAssertionCart());
        Screenshot.screenshotAssertion("addToCartTest");
    }

    @Test
    public void storeCartUpdateTest() throws IOException {
        homePage.closingTheInformationWindow();
        homePage.topMenuChoice("Sklep");
        shopPage.setShoppingCategoryChoice("Wspinaczka");
        climbingPage.setAddProductClimbingToCart();
        climbingPage.goToTheCart();
        cartPage.setQuantity("2");
        cartPage.updateCart();

        Assertions.assertEquals("Koszyk zaktualizowany.", cartPage.getCartUpdateMessage());
        Assertions.assertTrue(cartPage.productQuantityDisplayedCheck().isDisplayed());
        Screenshot.screenshotAssertion("storeCartUpdateTest");
    }

    @Test
    public void deleteProductFromCartTest() {
        homePage.closingTheInformationWindow();
        homePage.selectionOfOffer("Windsurfing w Lanzarote (Costa Teguise)");
        homePage.goToTheCartView();
        cartPage.removeItemFromCart();

        Assertions.assertEquals("Usuniêto: „Windsurfing w Lanzarote (Costa Teguise)“. Cofnij?"
                , cartPage.assertionMessageForRemoveProductFromCart());
    }
}
