package pages_BestBuy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseFile.BaseFileBB;

public class SelectProductByDepartment extends BaseFileBB{
	@FindBy(xpath="//div[@class='country-selection']//h4[contains(text(),'United States')]")
	WebElement country;
	@FindBy(xpath="//button[@data-t='hamburger-navigation-button']")
	WebElement clickMenu;
	@FindBy(xpath="//li[@class='liDropdownList '][5]")
	WebElement clicklistTv;
	@FindBy(xpath="//li[@class='liDropdownList '][3]")
	WebElement TvbyBrand;
	@FindBy(xpath="//a[text()='Samsung TVs']")
	WebElement SamsungTv;	
	@FindBy(xpath="((//h4[@class='sku-title'])//a)[1]")
	WebElement addproduct;
	@FindBy(xpath="(//div[@class='fulfillment-add-to-cart-button'])[1]")
	WebElement addtocartButton;
	
	public SelectProductByDepartment(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void byDept() throws InterruptedException{
		clickOn(country);
		clickOn(clickMenu);
		clickOn(clicklistTv);
		clickOn(TvbyBrand);
		clickOn(SamsungTv);     
		clickOn(addproduct);
		clickOn(addtocartButton);		
		Thread.sleep(3000);
		

	}

}
