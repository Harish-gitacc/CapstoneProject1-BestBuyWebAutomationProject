package testCase_BB;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import baseFile.BaseFileBB;
import pages_BestBuy.CheckOutPage;

public class BBTest_9_CheckOutPageFillingTest extends BaseFileBB{
	@BeforeTest
	public void setup() {
		testName = "BBTest_9_CheckOutPageFillingTest";
		testDescription = " Validate Checkout";
		testCategory = "Regression Testing";
		testAuthor = "Harish";
		
	}
	@Test(priority = 9)
	public void BBTest_9_CheckOutPageFillingTest() throws Exception {
		CheckOutPage CheckOut = new CheckOutPage(driver);
		 CheckOut.selectbyBrand("admin@yourstore.com", "8608239250");
	//	co.carddetails("Hari", "vijay", "PuducherryCity", "Puducherry", "Puducherry", "605004");
		 CheckOut.reportStep(testAuthor, testCategory, testName);
	}

}