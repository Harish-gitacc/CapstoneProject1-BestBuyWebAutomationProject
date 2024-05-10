package pages_BestBuy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseFile.BaseFileBB;

public class SelectProductByBrand extends BaseFileBB {
	@FindBy(xpath = "//div[@class='country-selection']//h4[contains(text(),'United States')]")
	WebElement country;
	@FindBy(xpath = "//button[@data-t='hamburger-navigation-button']")
	WebElement menuClick;
	@FindBy(xpath = "//button[normalize-space()='Brands']")
	WebElement clickbrand;
	@FindBy(xpath = "//a[normalize-space()='PlayStation']")
	WebElement PSMenu;
	@FindBy(xpath = "//a[normalize-space()='PS5 consoles']")
	WebElement PS5Games;
	@FindBy(xpath="//div[@id='shop-sku-list-item-51318124']//a[contains(text(),'Sony Interactive Entertainment - PlayStation 5 Sli')]")
	WebElement SonyPS5ConsolesMenu3;
	@FindBy(xpath = "//button[normalize-space()='Add to Cart']")
	WebElement addToCart;
	@FindBy(xpath="//a[normalize-space()='Go to Cart']")
	WebElement GoToCart;
	
	public SelectProductByBrand(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void selectbyBrand() throws InterruptedException {
		clickOn(country);
		clickOn(menuClick);
		clickOn(clickbrand);
		clickOn(PSMenu);
		String expectedTitle = "Sony PlayStation 5: PS5 - Best Buy";
		if (driver.getTitle().startsWith(expectedTitle)) {
			System.out.println("title is validated");
		} else {
			System.out.println("title is not validated");
		}
		
		clickOn(PS5Games);
		Actions act = new Actions(driver);
		act.click(addToCart).build().perform();
		Thread.sleep(5000);
		clickOn(GoToCart);
		if (addToCart.isDisplayed()) {
			addToCart.click();
			} else {
			System.out.println("Product is out of stock.");
			}		
	}

}
