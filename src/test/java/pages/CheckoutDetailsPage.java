package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutDetailsPage extends BasePage{
    public CheckoutDetailsPage(WebDriver d) {
        super(d);
        PageFactory.initElements(d, this);
    }

    // Locators //

    @FindBy (id = "finish")
    private WebElement finishButton;

    @FindBy (id = "cancel")
    private WebElement cancelButton;

    @FindBy(xpath = "//div[@class='inventory_item_price']")
    private WebElement checkoutFirstItemPrice;

    // Methods //


    public void clickOnFinishButton() {
        click(finishButton);
    }

    public double getCheckoutFirstItemPrice() {
        String priceText = checkoutFirstItemPrice.getText().trim();
        priceText = priceText.replaceAll("[^0-9.]", "");
        double firstItemPriceCheckout = Double.parseDouble(priceText);
        return firstItemPriceCheckout;
    }
}
