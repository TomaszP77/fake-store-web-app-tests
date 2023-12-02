package pages;

import model.BillingAddressData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static utils.DriverFactory.getDriver;

public class OrderPage {

    @FindBy(id = "billing_first_name")
    private WebElement firstNameInput;
    @FindBy(id = "billing_last_name")
    private WebElement lastNameInput;
    @FindBy(css = "[class=\"select2-selection__arrow\"]")
    private WebElement countryListButton;
    @FindBy(css = "[aria-owns=\"select2-billing_country-results\"]")
    private WebElement countryFieldInput;
    @FindBy(css = "[id=\"select2-billing_country-result-0apd-PL\"]")
    private WebElement countrySelectChoice;
    @FindBy(id = "billing_address_1")
    private WebElement billingAddressInput;
    @FindBy(id = "billing_postcode")
    private WebElement billingPostcodeInput;
    @FindBy(id = "billing_city")
    private WebElement billingCityInput;
    @FindBy(id = "billing_phone")
    private WebElement billingPhoneInput;
    @FindBy(id = "billing_email")
    private WebElement billingEmailInput;
    @FindBy(css = "[class=\"InputElement is-empty Input Input--empty\"]")
    private WebElement inputCardNumber;
    @FindBy(css = "[name=\"exp-date\"]")
    private WebElement inputExpDate;
    @FindBy(css = "[name=\"cvc\"]")
    private WebElement inputCvc;
    @FindBy(id = "terms")
    private WebElement confirmField;
    @FindBy(id = "place_order")
    private WebElement confirmPaymentButton;

    private WebDriver driver = getDriver();

    public OrderPage() {
        PageFactory.initElements(new AjaxElementLocatorFactory(getDriver(), 10), this);
    }

    public void billingAddressForm(BillingAddressData billingAddressData) {
        firstNameInput.sendKeys(billingAddressData.getFirstName());
        lastNameInput.sendKeys(billingAddressData.getLastName());
        billingAddressInput.sendKeys(billingAddressData.getStreetAddress());
        billingPostcodeInput.sendKeys(billingAddressData.getPostcode());
        billingCityInput.sendKeys(billingAddressData.getTown());
        billingPhoneInput.sendKeys(billingAddressData.getPhone());
        billingEmailInput.sendKeys(billingAddressData.getEmail());
    }

    public void paymentConfirm(String cardNumber, String expDate, String cvc) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(15));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector("#stripe-card-element iframe")));
        inputCardNumber.sendKeys(cardNumber);
        driver.switchTo().defaultContent();
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector("#stripe-exp-element iframe")));
        inputExpDate.sendKeys(expDate);
        driver.switchTo().defaultContent();
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector("#stripe-cvc-element iframe")));
        inputCvc.sendKeys(cvc);
        driver.switchTo().defaultContent();
        confirmField.click();
        confirmPaymentButton.click();
    }
}

