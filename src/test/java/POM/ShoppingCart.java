package POM;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShoppingCart extends Base{
	
	By listOfPuppies = By.xpath("//td//h2[contains(text(),':')]");
	By adoptAnotherPuppy = By.xpath("//input[@value='Adopt Another Puppy']");
	By allAdditions = By.xpath("//input[@type='checkbox']");
	By verifyTotalAmount = By.xpath("//td[@class='total_cell']//h2");
	By purchaseDetails = By.xpath("//tbody//tr[1]");
	By clearCart = By.xpath("//input[@value='Change your mind']");
	By completeAdoption = By.xpath("//input[@value='Complete the Adoption']");

	public ShoppingCart(WebDriver driver) {
		super(driver);
	}

	public ArrayList<String> listOfPuppies() {
		wait(listOfPuppies);
		ArrayList<String> puppiesName = new ArrayList<String>();
		List<WebElement> puppies = findElements(listOfPuppies); 
		for(int i = 0 ; i < puppies.size() ; i ++) {
			puppiesName.add(puppies.get(i).getText().replaceAll(":", ""));
		}
		
		return puppiesName;
	}
	
	public void adoptAnotherPuppy() {
		wait(adoptAnotherPuppy);
		clic(adoptAnotherPuppy);
	}
	
	public void allAdditions() {
		wait(allAdditions);
		List<WebElement> additions = findElements(allAdditions); 
		for(int i = 0 ; i < additions.size() ; i ++) {
			additions.get(i).click();
		}
	}
	
	public String verifyTotalAmount() {
		wait(verifyTotalAmount);
		return getText(verifyTotalAmount);
	}
	
	public void clearCart() {
		wait(clearCart);
		clic(clearCart);
	}
	
	public void completeAdoption() {
		wait(completeAdoption);
		clic(completeAdoption);
	}
	
	public ArrayList<String> purchaseDetails() {
		wait(purchaseDetails);
		ArrayList<String> purchaseDetail = new ArrayList<String>();
		List<WebElement> detail = findElements(purchaseDetails); 
		for(int i = 0 ; i < detail.size() ; i ++) {
			purchaseDetail.add(detail.get(i).getText());
		}
		
		return purchaseDetail;
	}
}
