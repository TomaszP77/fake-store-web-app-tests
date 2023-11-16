package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.util.List;
import java.util.stream.Collectors;

import static utils.DriverFactory.getDriver;

public class LoggedUserPage {

    @FindBy(css = "ul.phoen_nav_tab > li > a")
    private List<WebElement> assertionForRegisterUser;

    public LoggedUserPage() {
        PageFactory.initElements(new AjaxElementLocatorFactory(getDriver(), 10), this);
    }

    public List<String> assertionForRegisterUser() {
        return assertionForRegisterUser.stream()
                .map(element -> element.getAttribute("textContent")).collect(Collectors.toList());
    }
}
