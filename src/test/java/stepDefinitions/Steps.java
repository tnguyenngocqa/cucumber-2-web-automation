package stepDefinitions;

import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import dataProviders.ConfigFileReader;
import managers.FileReaderManager;
import managers.PageObjectManager;
import managers.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.CartPage;
import pageObjects.CheckoutPage;
import pageObjects.HomePage;
import pageObjects.ProductListingPage;

import java.util.concurrent.TimeUnit;

public class Steps {
    private WebDriver driver;
    private WebDriverWait wait;

    HomePage homePage;
    ProductListingPage productListingPage;
    CartPage cartPage;
    CheckoutPage checkoutPage;
    PageObjectManager pageObjectManager;
    WebDriverManager webDriverManager;


    @Given("^user is on Home Page$")
    public void user_is_on_Home_Page() {
        webDriverManager = new WebDriverManager();
        driver = webDriverManager.getDriver();
        driver.get(FileReaderManager.getInstance().getConfigFileReader().getApplicationUrl());
    }

    @When("^he search for \"([^\"]*)\"$")
    public void he_search_for(String product) {
        homePage = pageObjectManager.getHomePage();
        homePage.perform_search(product);
    }

    @And("^choose to buy the first item$")
    public void choose_to_buy_the_first_item() {
        productListingPage = pageObjectManager.getProductListingPage();
        productListingPage.select_Product(0);
        productListingPage.clickOn_AddToCart();
    }

    @And("^moves to checkout from mini cart$")
    public void moves_to_checkout_from_mini_cart() {
        cartPage = pageObjectManager.getCartPage();
//        cartPage.clinkOn_Cart();
//        cartPage.clickOn_ContinueToCheckout();
    }

    @And("^enter personal details on checkout page$")
    public void enter_personal_details_on_checkout_page() {
//        checkoutPage = new CheckoutPage(driver);
//        checkoutPage.fill_PersonalDetails();
    }

    @And("^select same delivery address$")
    public void select_same_delivery_address() {
//        checkoutPage = new CheckoutPage(driver);
//        checkoutPage.check_ShipToDifferentAddress(false);
    }

    @And("^select payment method as \"([^\"]*)\" payment$")
    public void select_payment_method_as_payment(String arg1) {
//        checkoutPage = new CheckoutPage(driver);

    }

    @And("^place the order$")
    public void place_the_order() {
//        checkoutPage = new CheckoutPage(driver);
//        checkoutPage.clickOn_PlaceOrder();
    }

    @After
    public void teardown() {
        webDriverManager.closeDriver();
    }
}
