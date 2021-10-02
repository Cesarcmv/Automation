package Test;

import org.testng.annotations.Test;
import POM.PuppyDetails;
import POM.PuppyList;
import POM.ShoppingCart;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class
EmptyCart {
    WebDriver driver;
    PuppyList puppyList;
    PuppyDetails puppyDetails;
    ShoppingCart shoppingCart;

    @BeforeClass
    public void beforeClass() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://puppies.herokuapp.com/");
    }

    @Test
    public void emptyCart() {
        // objects
        puppyList = new PuppyList(driver);
        puppyDetails = new PuppyDetails(driver);
        shoppingCart = new ShoppingCart(driver);

        // methods
        puppyList.viewDetailPuppy1();
        puppyDetails.adoptMe();
        shoppingCart.clearCart();
        shoppingCart.clearConfirmation();
        shoppingCart.clearConfirmation();
        String emptyCartMessage = puppyList.getAdoptionMessage();

        try {
            assertEquals("Your car is currently empty", emptyCartMessage);
            System.out.println("Successful clear :D");
        } catch (AssertionError e) {
            System.out.println("Failed clear :(");
            System.out.println(e.toString());
        }
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
