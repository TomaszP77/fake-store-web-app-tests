package pages;

import model.User;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import static utils.DriverFactory.getDriver;

public class MyAccountPage {

    @FindBy(id = "reg_email")
    private WebElement regEmailInput;
    @FindBy(id = "reg_password")
    private WebElement regPasswordInput;
    @FindBy(name = "register")
    private WebElement registerButton;
    @FindBy(css = "div.woocommerce-password-strength")
    private WebElement assertionForTooWeakPassword;

    public MyAccountPage() {
        PageFactory.initElements(new AjaxElementLocatorFactory(getDriver(), 10), this);
    }

    public void registerUser(User user) {
        regEmailInput.sendKeys(user.getEmail());
        regPasswordInput.sendKeys(user.getPassword());
        registerButton.click();
    }

    public String getAssertionForTooWeakPassword() {
        return assertionForTooWeakPassword.getText();
    }
}
