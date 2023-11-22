package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.util.List;

import static utils.DriverFactory.getDriver;

public class ShopPage {

    @FindBy(css = "[class=\"product-categories\"] a")
    private List<WebElement> shoppingCategory;

    public ShopPage() {
        PageFactory.initElements(new AjaxElementLocatorFactory(getDriver(), 10), this);
    }

    public void setShoppingCategoryChoice(String category) {
        shoppingCategory.stream().filter(element -> element.getText().equals(category)).findFirst().get().click();
    }
}
