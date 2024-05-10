package testCase_BB;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import baseFile.BaseFileBB;
import pages_BestBuy.CartPage;
import pages_BestBuy.CheckOutPage;
import pages_BestBuy.CountryPageValidation;

public class BBTest_4_CartPageValidationTest extends BaseFileBB {

	@BeforeTest
	public void setup() {
		testName = "BBTest_4_CartPageValidationTest";
		testDescription = "Cart Page vaidation";
		testCategory = "Regression testing";
		testAuthor = "Harish";
	}
	
	@Test( priority = 4)
	   public void BBTest_4_CartPageValidationTest() throws Exception {
		  CartPage cart =new  CartPage(driver);
		   cart.reportStep(testAuthor, testCategory, testName);
		   
		   
	   }
	}

