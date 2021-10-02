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

public class AdoptTwoCorrectAmount {
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
	public void adoptTwoCorrectAmount() {
		// objects
		puppyList = new PuppyList(driver);
		puppyDetails = new PuppyDetails(driver);
		shoppingCart = new ShoppingCart(driver);

		// methods
		puppyList.viewDetailPuppy1();
		puppyDetails.adoptMe();
		shoppingCart.adoptAnotherPuppy();
		puppyList.viewDetailPuppy2();
		puppyDetails.adoptMe();

		try {
			assertEquals(shoppingCart.verifyTotalAmount(), "$57.94");
			System.out.println("Correct total amount:" + shoppingCart.verifyTotalAmount());
		} catch (AssertionError e) {
			System.out.println("Incorrect amount.");
			System.out.println(e.toString());
		}
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
