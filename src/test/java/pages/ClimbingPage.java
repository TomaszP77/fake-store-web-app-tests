package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import static utils.DriverFactory.getDriver;

public class ClimbingPage {

    @FindBy(css = "a[class=\"button product_type_simple add_to_cart_button ajax_add_to_cart\"]")
    private WebElement addProductClimbingToCart;
    @FindBy(css = "[title=\"Zobacz koszyk\"]")
    private WebElement checkCart;

    public ClimbingPage() {
        PageFactory.initElements(new AjaxElementLocatorFactory(getDriver(), 10), this);
    }

    public void addingTheGranKoscielcowProductToTheCart() {
        addProductClimbingToCart.click();
    }

    public void goToTheCart() {
        checkCart.click();
    }
}
