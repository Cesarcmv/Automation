package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PuppyDetails extends Base{

	By returnList = By.xpath("//a[contains(text(),'Return to List')]");
	By adoptMe = By.xpath("//input[@value='Adopt Me!']");
	
	public PuppyDetails(WebDriver driver) {
		super(driver);
	}
	
	public void returnList() {
		wait(returnList);
		clic(returnList);
	}
	
	public void adoptMe() {
		wait(adoptMe);
		clic(adoptMe);
	}

}
