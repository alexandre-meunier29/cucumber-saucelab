package pages;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage extends BasePage{
    public CartPage(WebDriver d) {
        super(d);
    }

    // Locators //

    @FindBy(id = "checkout")
    private WebElement checkoutButton;

    @FindBy(id = "continue-shopping")
    private WebElement continueShoppingButton;

    @FindBy(xpath = "//div[@class='cart_item'][1] //button[@class='btn btn_secondary btn_small cart_button']")
    private WebElement removeFirstItemFromCart;

    @FindBy(xpath = "//div[@class='cart_item']")
    private WebElement cartItemBlock;

    @FindBy(xpath = "//div[@class='inventory_item_price']")
    private WebElement cartFirstItemPrice;


    // Methods //

    public void clickCheckoutButton() {
        click(checkoutButton);
    }

    public void clickRemoveFirstProduct() {
        click(removeFirstItemFromCart);
    }

    public void isItemDisplayed(){
        try {
            if (cartItemBlock.isDisplayed()) {
                Assert.fail("Product is still in the cart after removal");
            }
        } catch (Exception e) {
            System.out.println("Product successfully removed from cart.");
        }

    }

    public double getCartFirstItemPrice() {
        String priceText = cartFirstItemPrice.getText().trim();
        priceText = priceText.replaceAll("[^0-9.]", "");
        double firstItemPriceCart = Double.parseDouble(priceText);
        return firstItemPriceCart;
    }
}
