package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutUserInfoPage extends BasePage{
    public CheckoutUserInfoPage(WebDriver d) {
        super(d);
    }

    // Locators //

    @FindBy(id = "first-name")
    private WebElement firstNameField;

    @FindBy(id = "last-name")
    private WebElement lastNameField;

    @FindBy(id = "postal-code")
    private WebElement postCodeField;

    @FindBy(id = "continue")
    private WebElement continueButton;

    @FindBy(id = "cancel")
    private WebElement cancelButton;




    // Methods //

    public void enterFirstName(String value) {
        enterValue(firstNameField, value);
    }

    public void enterLastName(String value) {
        enterValue(lastNameField, value);
    }

    public void enterPostCode(String value) {
        enterValue(postCodeField, value);
    }

    public void clickOnContinue() {
        click(continueButton);
    }


}
