package pages_BestBuy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseFile.BaseFileBB;

public class SelectProductBySearch extends BaseFileBB {
	@FindBy(xpath = "//div[@class='country-selection']//h4[contains(text(),'United States')]")
	WebElement country;
	@FindBy(xpath = "//input[@id='gh-search-input']")
	WebElement searchProduct;
	@FindBy(xpath = "//span[@class='header-search-icon']")
	WebElement clickSearch;
	@FindBy(xpath = "(//div[@class='fulfillment-add-to-cart-button'])[1]")
	WebElement addProduct;
	@FindBy(xpath = "//li[@data-sku-id='6573731']")
	WebElement productverify;
	
	public SelectProductBySearch(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void addToCart(String item1) throws InterruptedException {
		clickOn(country);

		enter(searchProduct, item1);
		clickOn(clickSearch);
		clickOn(addProduct);
		String actualProduct = productverify.getText();
		String expectedproduct = "Dell Inspiron 15 Touch Screen Laptop – Intel Core i5 – 8GB – 512GB SSD - Carbon Black";
		if (actualProduct.startsWith(expectedproduct)) {
			System.out.println("Product is validated");
		} else {
			System.out.println("Product is not validated");
		}
		

	}
}
