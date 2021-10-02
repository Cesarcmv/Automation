package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOut extends Base{
	
	By orderName = By.id("order_name");
	By orderAddress = By.id("order_address");
	By orderEmail = By.id("order_email");
	By orderPayType = By.id("order_pay_type");
	By placeOrder = By.xpath("//input[@value='Place Order']");

	public CheckOut(WebDriver driver) {
		super(driver);
	}

	public void placeOrder() {
		wait(placeOrder);
		clic(placeOrder);
	}
	
	public void inputDetails(String name, String address, String email) {
		wait(orderName);
		sendKeys(name, orderName);
		sendKeys(address, orderAddress);
		sendKeys(email, orderEmail);
		selectElement("Check",orderPayType);
	}
}
