package POM;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {
	
	private WebDriver driver;
	
	public Base(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement findElement(By locator) {
		return driver.findElement(locator);
	}
	
	public List<WebElement> findElements(By locator){
		return driver.findElements(locator);
	}
	
	public String getText(WebElement element) {
		return element.getText();
	}
	
	public String getText(By locator) {
		return driver.findElement(locator).getText();
	}

	public void sendKeys(String inputText, By locator) {
		driver.findElement(locator).clear();
		driver.findElement(locator).sendKeys(inputText);
	}
	
	public void clic(By locator) {
		driver.findElement(locator).click();
	}
	
	public void selectElement(String value, By locator) {
		Select select = new Select(driver.findElement(locator));
		select.selectByValue(value);
	}
	
	public void clearConfirmation() {
		driver.switchTo().alert().accept();
	}
	
	public void wait(By locator) {
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(locator));
	}
}
