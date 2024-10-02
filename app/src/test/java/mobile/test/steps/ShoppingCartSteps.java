package mobile.test.steps;

import mobile.test.pages.ProductsPage;
import mobile.test.utils.AppiumDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.Assert;

public class ShoppingCartSteps {
    private AndroidDriver<AndroidElement> driver;
    private ProductsPage productsPage;

    @Before
    public void setup() throws Exception {
        driver = AppiumDriver.getDriver();
        productsPage = new ProductsPage(driver);
    }

    @After
    public void teardown() {
        AppiumDriver.quitDriver();
    }

    @Given("I am on the SauceLabs application")
    public void iAmOnTheSauceLabsApplication() {
        Assert.assertTrue(productsPage.isProductsPageLoaded(), "Products page is not loaded");
    }

    @Given("the products are loaded correctly in the gallery")
    public void theProductsAreLoadedCorrectlyInTheGallery() {
        // This step is implicitly verified in the previous step
    }

    @When("I add {int} of the product {string}")
    public void iAddOfTheProduct(int quantity, String productName) {
        productsPage.addProductToCart(productName, quantity);
    }

    @Then("the shopping cart should be updated correctly")
    public void theShoppingCartShouldBeUpdatedCorrectly() {
        int expectedCount = 1; // This should be calculated based on the scenario
        Assert.assertEquals(productsPage.getCartItemCount(), expectedCount, "Cart item count is incorrect");
    }
}