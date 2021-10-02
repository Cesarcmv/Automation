package Test;

import org.testng.annotations.Test;
import POM.PuppyList;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeClass;
import static org.testng.Assert.assertTrue;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class Pagination {
	WebDriver driver;
	PuppyList puppyList;

	@BeforeClass
	public void beforeClass() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://puppies.herokuapp.com/");
	}

	@Test
	public void pagination() {
		// objects
		puppyList = new PuppyList(driver);

		// methods
		try {
			assertTrue(puppyList.elementsByPage() <= 4);
			System.out.println("Correct number of elements by page:" + puppyList.elementsByPage());
		} catch (AssertionError e) {
			System.out.println("Incorrect number of elements by page.");
			System.out.println(e.toString());
		}
		
		while (puppyList.paginate()) {
			try {
				assertTrue(puppyList.elementsByPage() <= 4);
				System.out.println("Correct number of elements by page:" + puppyList.elementsByPage());
			} catch (AssertionError e) {
				System.out.println("Incorrect number of elements by page.");
				System.out.println(e.toString());
			}
		}
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
