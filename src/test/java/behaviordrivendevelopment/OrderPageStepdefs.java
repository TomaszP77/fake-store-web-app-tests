package behaviordrivendevelopment;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import model.BillingAddressData;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import pages.OrderPage;

import static utils.DriverFactory.getDriver;

public class OrderPageStepdefs {

    private OrderPage orderPage;

    private WebDriver driver = getDriver();


    @Given("Order page step definitions are available")
    public void orderPageStepDefinitionsAreAvailable() {
        orderPage = new OrderPage();
    }

    @And("The user will provide data in the payment form")
    public void theUserWillProvideDataInThePaymentForm() {
        BillingAddressData billingAddressData = new BillingAddressData();
        billingAddressData.setFirstName("Angelika");
        billingAddressData.setLastName("Tomato");
        billingAddressData.setStreetAddress("Tomato street");
        billingAddressData.setPostcode("12 - 123");
        billingAddressData.setTown("Warsaw");
        billingAddressData.setPhone("123456789");
        billingAddressData.setEmail("abcd@ab.cd");

        orderPage.billingAddressForm(billingAddressData);
    }

    @And("The user will enter the correct payment card details: card {string} date {string} cvc {string}")
    public void theUserWillEnterTheCorrectPaymentCardDetailsAndUseTheBuyAndPlaceButton(String cardNumber, String expDate, String cvc) {
        orderPage.paymentConfirm(cardNumber, expDate, cvc);
    }

    @And("The user will use the buy and pay button")
    public void theUserWillUseTheBuyAndPayButton() {
        orderPage.confirmPayment();
    }

    @Then("The user notices that the order has been placed correctly")
    public void theUserNoticesThatTheOrderHasBeenPlacedCorrectly() {
        Assertions.assertEquals("Zamówienie otrzymane", orderPage.orderCompleteAssertion());
    }
}
