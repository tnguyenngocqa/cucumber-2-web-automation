package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void navigateTo_HomePage(){
        driver.get("http://shop.demoqa.com");
    }

    public void perform_search(String keyword) {
        driver.navigate().to("http://shop.demoqa.com/?s=" + keyword + "&post_type=product");
    }
}
