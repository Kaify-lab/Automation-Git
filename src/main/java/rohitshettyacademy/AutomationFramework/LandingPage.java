package rohitshettyacademy.AutomationFramework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
	
	WebDriver driver;
	
	LandingPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	//WebElement element = driver.findElement(By.id("userEmail"));
	//Use Page Factory
	
	@FindBy(id="userEmail")
	WebElement usermail;
	
	@FindBy(id="userPassword")
	WebElement passwordEle;
	
	@FindBy(id="login")
	WebElement submit;
	
	public ProductCatalogue loginApplication(String mail, String password) {
		usermail.sendKeys(mail);
		passwordEle.sendKeys(password);
		submit.click();
		
		ProductCatalogue prodCatalogue = new ProductCatalogue(driver);
		return prodCatalogue;
	}
	
	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");
	}
	
}
