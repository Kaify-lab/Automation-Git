package rohitshettyacademy.AutomationFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AutomationFramework.AbstractComponent.AbstractComponent;

public class CheckoutPage extends AbstractComponent{
	WebDriver driver;

	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(css=".action__submit")
	WebElement submit;
	
	@FindBy(css="input[placeholder='Select Country']")
	WebElement country;
	
	@FindBy(xpath="(//button[@type='button'])[2]")
	WebElement selectCountry;
	
	
	public void selectCountry(String countryName) {
		Actions a = new Actions(driver);
		 a.sendKeys(country, countryName).build().perform();
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("window.scrollBy(0,250)", "");
		 selectCountry.click();
		 
	}
	
	public ConfirmationPage submitOrder() {
		submit.click();
		return new ConfirmationPage(driver);
		
	}
	
	
	

}
