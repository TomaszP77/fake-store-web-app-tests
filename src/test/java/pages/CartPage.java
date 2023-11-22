package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import static utils.DriverFactory.getDriver;

public class CartPage {

    @FindBy(css = "[class = cart-contents]")
    private WebElement cartQuickLook;
    @FindBy(css = "a[class=\"button wc-forward\"]")
    private WebElement viewCartButton;
    @FindBy(css = "td.product-name>a")
    private WebElement textForAssertionCart;
    @FindBy(css = "img[class=\"attachment-woocommerce_thumbnail size-woocommerce_thumbnail\"]")
    private WebElement imageForAssertionCart;

    private WebDriver driver = getDriver();

    public CartPage() {
        PageFactory.initElements(new AjaxElementLocatorFactory(getDriver(), 10), this);
    }

    public void moveCursorTooCartQuickLook() {
        Actions actions = new Actions(driver);
        actions.moveToElement(cartQuickLook).perform();
    }

    public void viewCart() {
        viewCartButton.click();
    }

    public String getTextForAssertionCart() {
        return textForAssertionCart.getText();
    }

    public boolean imageForAssertionCart() {
        return imageForAssertionCart.isDisplayed();
    }
}
