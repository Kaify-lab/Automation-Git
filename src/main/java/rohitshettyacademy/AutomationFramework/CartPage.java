package rohitshettyacademy.AutomationFramework;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AutomationFramework.AbstractComponent.AbstractComponent;

public class CartPage extends AbstractComponent{
	
	WebDriver driver;
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver,this);
		// TODO Auto-generated constructor stub
	}
	
	//driver.findElement(By.cssSelector(".totalRow button")).click();
	
	@FindBy(css=".totalRow button")
	WebElement checkoutButton;
	
	@FindBy(css=".cartSection h3")
	private List<WebElement> productTitle;

	
	
	public Boolean verifyProductDisplay(String productName) {
		Boolean match = productTitle.stream().anyMatch(cartProduct-> 
		cartProduct.getText().equalsIgnoreCase(productName));
		
		return match;
		
	}
	
	public CheckoutPage gotoCheckout() {
		checkoutButton.click();
		return new CheckoutPage(driver);
	}

}
