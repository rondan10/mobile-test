package mobile.test.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductsPage {
    private AndroidDriver<AndroidElement> driver;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Products']")
    private AndroidElement productsTitle;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id, 'productName')]")
    private List<AndroidElement> productNames;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id, 'productAddBtn')]")
    private List<AndroidElement> addToCartButtons;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id, 'cartBadge')]")
    private AndroidElement cartBadge;

    public ProductsPage(AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public boolean isProductsPageLoaded() {
        return productsTitle.isDisplayed();
    }

    public void addProductToCart(String productName, int quantity) {
        for (int i = 0; i < productNames.size(); i++) {
            if (productNames.get(i).getText().equals(productName)) {
                for (int j = 0; j < quantity; j++) {
                    addToCartButtons.get(i).click();
                }
                break;
            }
        }
    }

    public int getCartItemCount() {
        return Integer.parseInt(cartBadge.getText());
    }
}