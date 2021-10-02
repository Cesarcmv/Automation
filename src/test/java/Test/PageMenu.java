package Test;

import org.testng.annotations.Test;

import POM.PuppyList;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeClass;
import static org.junit.Assert.assertArrayEquals;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class PageMenu {
	WebDriver driver;
	PuppyList puppyList;
	private String[] menuList = {"Adopt a Puppy","Learn","Animal Shelters","Classifieds","Message Boards","Pet News"};

	@BeforeClass
	public void beforeClass() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://puppies.herokuapp.com/");
	}

	@Test
	public void menu() {
		// objects
		puppyList = new PuppyList(driver);

		// methods
		List<String> menu = puppyList.menuList();				
		try {
			assertArrayEquals(menuList, menu.toArray());
			System.out.println("Menu displayed correctly:" + menu);
		} catch (AssertionError e) {
			System.out.println("Menu displayed incorrectly.");
			System.out.println(e.toString());
		}
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
