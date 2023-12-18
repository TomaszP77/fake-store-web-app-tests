package behaviordrivendevelopment;

import io.cucumber.java.en.Given;
import utils.BaseTest;

public class BaseTestMyStepdefs extends BaseTest {

    @Given("Page is loaded")
    public void pageIsLoaded() {
        setUp();
    }
}
