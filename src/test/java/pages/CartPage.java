package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import utils.SeleniumHelper;

import static utils.DriverFactory.getDriver;

public class CartPage {

    @FindBy(css = "[class = cart-contents]")
    private WebElement cartQuickLook;
    @FindBy(css = "[class=\"button wc-forward\"]")
    private WebElement viewCartButton;
    @FindBy(css = "td.product-name>a")
    private WebElement textForAssertionCart;
    @FindBy(css = "img[class=\"attachment-woocommerce_thumbnail size-woocommerce_thumbnail\"]")
    private WebElement imageForAssertionCart;
    @FindBy(css = "div.quantity input")
    private WebElement quantityField;
    @FindBy(name = "update_cart")
    private WebElement updateCartButton;
    @FindBy(css = ".wc-block-components-notice-banner__content")
    private WebElement cartUpdateMessage;
    @FindBy(css = "td.product-quantity")
    private WebElement productQuantity;
    @FindBy(css = "[class=\"remove\"]")
    private WebElement removeItemButton;
    @FindBy(css = "a[class=\"checkout-button button alt wc-forward\"]")
    private WebElement checkoutButton;

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

    public void setQuantity(String quantity) {
        quantityField.click();
        quantityField.clear();
        quantityField.sendKeys(quantity);
    }

    public void updateCart() {
        updateCartButton.click();
    }

    public String getCartUpdateMessage() {
        SeleniumHelper.waitForElementToBeVisible(cartUpdateMessage);
        return cartUpdateMessage.getText();
    }

    public WebElement productQuantityDisplayedCheck() {
        return productQuantity;
    }

    public void removeItemFromCart() {
        removeItemButton.click();
    }

    public String assertionMessageForRemoveProductFromCart() {
        return cartUpdateMessage.getText();
    }

    public void checkout() {
        checkoutButton.click();
    }
}
