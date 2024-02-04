package behaviordrivendevelopment;

import io.cucumber.java.en.Given;
import pages.OrderPage;

public class OrderPageStepdefs {

    private OrderPage orderPage;

    @Given("Order page step definitions are available")
    public void orderPageStepDefinitionsAreAvailable() {
        orderPage = new OrderPage();
    }
}
