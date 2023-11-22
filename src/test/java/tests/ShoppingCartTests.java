package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.*;
import utils.BaseTest;

import static model.ReadyUsersWithData.userWithAccount;

public class ShoppingCartTests extends BaseTest {

    private HomePage homePage;
    private MyAccountPage myAccountPage;
    private LoggedUserPage loggedUserPage;
    private ShopPage shopPage;
    private WindsurfingCategoryPage windsurfingCategoryPage;
    private CartPage cartPage;

    @BeforeEach
    public void beforeEach() {
        setUp();
        homePage = new HomePage();
        myAccountPage = new MyAccountPage();
        loggedUserPage = new LoggedUserPage();
        shopPage = new ShopPage();
        windsurfingCategoryPage = new WindsurfingCategoryPage();
        cartPage = new CartPage();
    }

    @Test
    public void addToCartTest() {
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
    }
}
