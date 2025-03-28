package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PLP extends BasePage{
    public PLP(WebDriver d) {
        super(d);
    }

    // Locators //
// first product add to basket
    @FindBy(xpath = "//div[@class='inventory_item'][1]//button[text()='Add to cart']")
    private WebElement firstProduct;

    //Cart badge count
    @FindBy(className = "shopping_cart_badge")
    private WebElement cartBadge;

    // Sort by dropdown
    @FindBy(xpath = "//select[@class='product_sort_container']//option[text()='Price (low to high)']")
    private WebElement sortByPriceLowToHigh;

    // List of all item price
    @FindBy(className = "inventory_item_price")
    private List<WebElement> itemPrices;





    // Methods //

    // return cart badge product count
    public int getCartBadgeCount() {
        return Integer.parseInt(cartBadge.getText());
    }


    // add first product to basket method
    public void addFirstProductToBasket() {
        click(firstProduct);
    }

    // Click "Price (low to high)" in the sort dropdown
    public void sortByPriceLowToHigh() {
        click(sortByPriceLowToHigh);
    }

    // check if "Price (low to high)" has successfully sorted listing
    public boolean verifyPriceLowToHighSorting() {
        List<Double> prices = itemPrices.stream()
                .map(priceElement -> Double.parseDouble(priceElement.getText().replace("$", "")))
                .toList();

        for (int i = 0; i < prices.size() - 1; i++) {
            if (prices.get(i) > prices.get(i + 1)) {
                return false;
            }
        }
        return true;
    }
}
