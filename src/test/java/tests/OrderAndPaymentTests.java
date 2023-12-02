package tests;

import model.BillingAddressData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.*;
import utils.BaseTest;

public class OrderAndPaymentTests extends BaseTest {

    private HomePage homePage;
    private CartPage cartPage;
    private OrderPage orderPage;

    @BeforeEach
    public void beforeEach() {
        setUp();
        homePage = new HomePage();
        cartPage = new CartPage();
        orderPage = new OrderPage();
    }

    @Test
    public void checkoutTest() {

        BillingAddressData billingAddressData = new BillingAddressData();
        billingAddressData.setFirstName("Angelika");
        billingAddressData.setLastName("Tomato");
        billingAddressData.setStreetAddress("Tomato street");
        billingAddressData.setPostcode("12 - 123");
        billingAddressData.setTown("Warsaw");
        billingAddressData.setPhone("123456789");
        billingAddressData.setEmail("abcd@ab.cd");

        homePage.closingTheInformationWindow();
        homePage.selectionOfOffer("Fuerteventura - Sotavento");
        homePage.selectionOfOffer("Kurs ¿eglarski na Mazurach");
        homePage.goToTheCartView();
        cartPage.checkout();
        orderPage.billingAddressForm(billingAddressData);
        orderPage.paymentConfirm("4242 4242 4242 4242 4240", "06/24", "123");
    }
}
