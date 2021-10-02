package Test;

import POM.CheckOut;
import POM.PuppyDetails;
import POM.PuppyList;
import POM.ShoppingCart;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class AdoptThree {
	WebDriver driver;
	PuppyList puppyList;
	PuppyDetails puppyDetails;
	ShoppingCart shoppingCart;
	CheckOut checkOut;

	@BeforeClass
	public void beforeClass() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://puppies.herokuapp.com/");
	}

	@Test
	public void adoptTwo() {	
		// objects
		puppyList = new PuppyList(driver);
		puppyDetails = new PuppyDetails(driver);
		shoppingCart = new ShoppingCart(driver);
		checkOut = new CheckOut(driver);
		
		// methods
		puppyList.viewDetailPuppy1();
		puppyDetails.adoptMe();
		shoppingCart.adoptAnotherPuppy();
		puppyList.viewDetailPuppy2();
		puppyDetails.adoptMe();		
		shoppingCart.completeAdoption();
		checkOut.inputDetails("Laura", "Guadalajara, Jalisco", "laura@mail.com");
		checkOut.placeOrder();
		String adoptionMessage = puppyList.getAdoptionMessage();	
		
		try {
			assertEquals("Thank you for adopting a puppy!", adoptionMessage);
			System.out.println("Successful adoption :D");
		} catch (AssertionError e) {
			System.out.println("Failed adoption :(");
			System.out.println(e.toString());			
		}
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
