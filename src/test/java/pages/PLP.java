package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PLP extends BasePage{
    public PLP(WebDriver d) {
        super(d);
        PageFactory.initElements(d, this);

    }

    // Locators //

    //Any add to cart button
    @FindBy (xpath = "//button[@class='btn btn_primary btn_small btn_inventory ']")
    private List<WebElement> addToCartButtons;

    // first product add to basket
    @FindBy(xpath = "//div[@class='inventory_item'][1]//button[text()='Add to cart']")
    private WebElement firstProductATB;

    // third product add to basket
    @FindBy(xpath = "//div[@class='inventory_item'][3]//button[text()='Add to cart']")
    private WebElement thirdProductATB;

    //first product
    @FindBy(id = "item_4_title_link")
    private WebElement firstProductLink;

    //Cart badge count
    @FindBy(className = "shopping_cart_badge")
    private WebElement cartBadge;

    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    private WebElement cartButton;

    // Sort by dropdown
    @FindBy(xpath = "//select[@class='product_sort_container']//option[text()='Price (low to high)']")
    private WebElement sortByPriceLowToHigh;

    // List of all item price
    @FindBy(className = "inventory_item_price")
    private List<WebElement> itemPrices;

    // burger menu
    @FindBy(id = "react-burger-menu-btn")
    private WebElement burgerMenu;

    // logout link
    @FindBy(id = "logout_sidebar_link")
    private WebElement logoutLink;




    // Methods //

    // return cart badge product count
    public int getCartBadgeCount() {
        return Integer.parseInt(cartBadge.getText());
    }

    // click burger menu to display sidebar
    public void clickBurgerMenu() {
        click(burgerMenu);
    }

    // click logout link
    public void clickLogout() {
        click(logoutLink);
    }

    // click cart button
    public void clickCartButton() {
        click(cartButton);
    }

    // click first product of the list
    public void clickFirstProduct() {
        click(firstProductLink);
    }

    // add first product to basket method
    public void addFirstProductToBasket() {
        click(firstProductATB);
    }

    // add third product to basket method
    public void addThirdProductToBasket() {
        click(thirdProductATB);
    }

    // add cheapest product to basket method
    public void addCheapestProductToBasket() {
        double minPrice = Double.MAX_VALUE;
        int cheapestProductIndex = -1;

        // Loop through the item prices to find the cheapest one
        for (int i = 0; i < itemPrices.size(); i++) {
            // Get the price text and remove the '$' sign
            String priceText = itemPrices.get(i).getText().replace("$", "").trim();
            try {
                double price = Double.parseDouble(priceText);
                if (price < minPrice) {
                    minPrice = price;
                    cheapestProductIndex = i;
                }
            } catch (NumberFormatException e) {
                System.out.println("Error parsing price: " + priceText);
            }
        }
        // If a valid cheapest product index is found, click the 'Add to Cart' button
        if (cheapestProductIndex != -1) {
            click(addToCartButtons.get(cheapestProductIndex));
            System.out.println("Added the cheapest product (price: $" + minPrice + ") to the cart.");
        } else {
            System.out.println("No valid product found.");
        }

    }

    // add most expensive product to basket method
    public void addMostExpProductToBasket() {
        double maxPrice = Double.MIN_VALUE;  // Start with the lowest possible price
        int mostExpensiveProductIndex = -1;

        // Loop through the item prices to find the most expensive one
        for (int i = 0; i < itemPrices.size(); i++) {
            // Get the price text and remove the '$' sign
            String priceText = itemPrices.get(i).getText().replace("$", "").trim();
            try {
                double price = Double.parseDouble(priceText); // Parse the price
                if (price > maxPrice) {
                    maxPrice = price;
                    mostExpensiveProductIndex = i;
                }
            } catch (NumberFormatException e) {
                System.out.println("Error parsing price: " + priceText);
            }
        }

        // If a valid most expensive product index is found, click the 'Add to Cart' button
        if (mostExpensiveProductIndex != -1) {
            click(addToCartButtons.get(mostExpensiveProductIndex));
            System.out.println("Added the most expensive product (price: $" + maxPrice + ") to the cart.");
        } else {
            System.out.println("No valid product found.");
        }

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
