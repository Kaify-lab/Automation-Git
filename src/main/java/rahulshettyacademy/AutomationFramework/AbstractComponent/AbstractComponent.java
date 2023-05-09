package rahulshettyacademy.AutomationFramework.AbstractComponent;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import rohitshettyacademy.AutomationFramework.CartPage;

public class AbstractComponent {
	
	WebDriver driver;
	
	public AbstractComponent(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	 //driver.findElement(By.cssSelector(".btn.btn-custom[routerlink='/dashboard/cart']")).click();
	
	@FindBy(css=".btn.btn-custom[routerlink='/dashboard/cart']")
	WebElement CartHeader;
	
	public CartPage goToCart() {
		CartHeader.click();
		CartPage cartPage = new CartPage(driver);
		return cartPage;
	}

	public void waitForElementToAppear(By findBy) {
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		 
		 wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	
	public void waitForElementToDisappear(WebElement ele) throws InterruptedException {
		Thread.sleep(1000);
		
		
	}
}
