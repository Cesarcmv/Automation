package POM;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PuppyList extends Base{
	
	By menuList = By.xpath("//ul[@id='navlist']//a");
	By paginate = By.xpath("//div[@class='pagination']//a[@class='next_page']");
	By countElements = By.xpath("//div[@class='puppy_list']");	
	By viewDetailPuppy1 = By.xpath("//form[@action='/puppies/3']//input[@value='View Details']");
	By viewDetailPuppy2 = By.xpath("//form[@action='/puppies/4']//input[@value='View Details']");
	By viewDetailPuppy3 = By.xpath("//form[@action='/puppies/1']//input[@value='View Details']");
	By adoptionMessage = By.id("notice");

	public PuppyList(WebDriver driver) {
		super(driver);
	}
	
	public List<String> menuList() {
		wait(menuList);
		ArrayList<String> menu = new ArrayList<String>();
		List<WebElement> menuElements = findElements(menuList); 
		for(int i = 0 ; i < menuElements.size() ; i ++) {
			menu.add(menuElements.get(i).getText());
		}		
		return menu;
	}

	public Boolean paginate() {
		wait(paginate);
		try {
			if(findElement(paginate).isDisplayed()) {
				findElement(paginate).click();
				return true;
			}			
		} catch (NoSuchElementException e) {
			return false;
		}
		return false;		
	}
	
	public Integer elementsByPage() {
		wait(countElements);
		List<WebElement> elements = findElements(countElements); 
		return elements.size();
	}
	
	public void viewDetailPuppy1() {
		wait(viewDetailPuppy1);
		clic(viewDetailPuppy1);
	}
	
	public void viewDetailPuppy2() {
		wait(viewDetailPuppy2);
		clic(viewDetailPuppy2);
	}
	
	public void viewDetailPuppy3() {
		wait(viewDetailPuppy3);
		clic(viewDetailPuppy3);
	}
	
	public String getAdoptionMessage() {
		wait(adoptionMessage);
		return getText(adoptionMessage);
	}
}
