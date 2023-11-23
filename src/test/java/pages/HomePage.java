package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.util.List;

import static utils.DriverFactory.getDriver;

public class HomePage {

    @FindBy(css = "a.woocommerce-store-notice__dismiss-link")
    private WebElement informationClosingButton;
    @FindBy(css = "div.primary-navigation li")
    private List<WebElement> topMenu;
    @FindBy(css = "[class=\"added_to_cart wc-forward\"]")
    private WebElement cartViewButton;

    public HomePage() {
        PageFactory.initElements(new AjaxElementLocatorFactory(getDriver(), 10), this);
    }

    public void closingTheInformationWindow() {
        informationClosingButton.click();
    }

    public void topMenuChoice(String menuButton) {
        topMenu.stream().filter(element -> element.getText().equals(menuButton)).findFirst().get().click();
    }

    public void goToTheCartView() {
        cartViewButton.click();
    }

    public void selectionOfOffer(String selectionOfOffer) {
        String css = String.format("[aria-label='Dodaj „%s” do koszyka']", selectionOfOffer);
        getDriver().findElement(By.cssSelector(css)).click();
    }
}
