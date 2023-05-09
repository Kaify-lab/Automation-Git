package rohitshettyacademy.AutomationFramework;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AutomationFramework.AbstractComponent.AbstractComponent;

public class ProductCatalogue extends AbstractComponent {
	
	WebDriver driver;
	
	ProductCatalogue(WebDriver driver){
		
		//initialization
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	//List<WebElement> products =  driver.findElements(By.cssSelector(".mb-3"));
	//Use Page Factory
	
	@FindBy(css=".mb-3")
	List <WebElement> products;
	
	@FindBy(css=".ng-animating")
	WebElement spinner;
	
	By productBy = By.cssSelector(".mb-3");
	By addToCart = By.cssSelector(".card-body button:last-of-type");
	
	By toastMessage = By.cssSelector("#toast-container");
	
	public List<WebElement> getProductList() {
		
		waitForElementToAppear(productBy);
		return products;
	}
	public WebElement getProduct(String productName) {
		
		WebElement prod =  getProductList().stream().filter(product-> 
		 product.findElement(By.cssSelector("b")).getText().equals(productName) ).findFirst().orElse(null);
		return prod;
	}
	
	public void addProductToCart(String productName) {
		WebElement prod = getProduct(productName);		
		prod.findElement(addToCart).click();
		
		waitForElementToAppear(toastMessage);
		try {
			waitForElementToDisappear(spinner);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
}
