package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.AbstractExecutorService;

public class CheckoutPage {
    WebDriver driver;


    public CheckoutPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.CSS, using = "#billing_first_name")
    private WebElement txtbx_FirstName;

    @FindBy(how = How.CSS, using = "#billing_last_name")
    private WebElement txtbx_LastName;

    @FindBy(how = How.CSS, using = "#billing_email")
    private WebElement txtbx_Email;

    @FindBy(how = How.CSS, using = "#billing_phone")
    private WebElement txtbx_Phone;



    @FindBy(how = How.CSS, using = "")
    private WebElement btn_PlaceOrder;

    public void enter_FirstName(String name) {
        txtbx_FirstName.sendKeys(name);
    }

    public void enter_LastName(String name) {
        txtbx_LastName.sendKeys(name);
    }

    public void enter_Email(String name) {
        txtbx_Email.sendKeys(name);
    }

    public void enter_Phone(String name) {
        txtbx_Phone.sendKeys(name);
    }

    public void fill_PersonalDetails() {
        enter_FirstName("Aotomation");
        enter_LastName("Test");
        enter_Phone("0000000000");
        enter_Email("Automation@gmail.com");
        select_Country("India");
//        enter_City("Delhi");
//        enter_Address("Shalimar Bagh");
//        enter_PostCode("110088");
//        select_County("Delhi");
    }

    public void select_Country(String countryName) {

    }

    public void check_ShipToDifferentAddress(boolean b) {

    }

    public void clickOn_PlaceOrder() {
        //btn_PlaceOrder.submit();
    }
}
