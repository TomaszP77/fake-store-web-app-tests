package pages;

import model.ReadyUsersWithData;
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
    @FindBy(css = ".is-error")
    private WebElement assertionForInvalidEmail;
    @FindBy(id = "username")
    private WebElement userDataInput;
    @FindBy(id = "password")
    private WebElement userPasswordInput;
    @FindBy(name = "login")
    private WebElement logInButton;
    @FindBy(css = "[role=\"alert\"]>li")
    private WebElement errorMessageForLogin;

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

    public String getAssertionForInvalidEmail() {
        return assertionForInvalidEmail.getText();
    }

    public void logInUser(ReadyUsersWithData readyUsersWithData) {
        userDataInput.sendKeys(readyUsersWithData.getEmail());
        userPasswordInput.sendKeys(readyUsersWithData.getPassword());
        logInButton.click();
    }

    public String errorMessageForLoginWithWrongData() {
        return errorMessageForLogin.getText();
    }
}
