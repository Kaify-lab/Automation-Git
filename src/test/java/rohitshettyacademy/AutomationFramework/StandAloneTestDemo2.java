package rohitshettyacademy.AutomationFramework;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class StandAloneTestDemo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String productName ="ZARA COAT 3";
		String email = "sfahmad511@gmail.com";
		String pwd = "Adnahm@464";		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		 //driver.get("https://rahulshettyacademy.com/client");
		 
		 //Creating landing PAge object and accessing methods inside it.
		 LandingPage landingPage = new LandingPage(driver);
		 landingPage.goTo();
		 ProductCatalogue prodCatalogue = landingPage.loginApplication(email, pwd);
		 
		 	 
		  new ProductCatalogue(driver);
		 
		 List <WebElement> products = prodCatalogue.getProductList();
		 prodCatalogue.addProductToCart(productName);
		 CartPage cartPage =prodCatalogue.goToCart();
		
		 Boolean match = cartPage.verifyProductDisplay(productName);
		 Assert.assertTrue(match); 				 
		 
		 CheckoutPage checkoutpage = cartPage.gotoCheckout();
		 checkoutpage.selectCountry("India");
		 ConfirmationPage confirmMsg =  checkoutpage.submitOrder();
		 String confirmMessage=confirmMsg.getVerfiyMessage();
		 
		 
		 Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		 
		 driver.close();
		 
		 
		 
		 
		 
		 
		 
		 
	}

}
