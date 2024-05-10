package pages_BestBuy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseFile.BaseFileBB;

public class CartPage extends BaseFileBB {

	@FindBy(xpath="//a[contains(text(),'TCL - 40\" Class S3 S-Class LED Full HD Smart TV wi')]")
	WebElement TCL40TV;
	
	@FindBy(xpath="//a[contains(text(),'LG - 65” Class UQ75 Series LED 4K UHD Smart webOS ')]")
	WebElement LG65TV;
	
	@FindBy(xpath="//button[normalize-space()='Checkout']")
	WebElement ClickCheckOut;
	
	@FindBy(xpath="//button[@class='c-button c-button-primary c-button-lg c-button-block c-button-icon c-button-icon-leading add-to-cart-button']")
	WebElement addToCartSonyPS5;
	
	public CartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public String validateTCL40TVInCart() {
		return extractText(TCL40TV);
	}
	
	public String validateLG65TVInCart() {
		return extractText(LG65TV);
	}
	
	public String validateSonyPS5InCart() {
		return extractText(addToCartSonyPS5) ;
	}
	
	public void CheckOutPage() {
		clickOn(ClickCheckOut);
	}
}
