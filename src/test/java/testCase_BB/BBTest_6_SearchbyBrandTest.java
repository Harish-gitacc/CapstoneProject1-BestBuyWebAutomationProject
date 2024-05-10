package testCase_BB;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import baseFile.BaseFileBB;
import pages_BestBuy.SelectProductByBrand;

public class BBTest_6_SearchbyBrandTest extends BaseFileBB{
	@BeforeTest
	public void setup() {
		testName = "BBTest_6_SearchbyBrandTest";
		testDescription = "Search product by brand";
		testCategory = "Regression testing";
		testAuthor = "Harish";
		
	}
	
	@Test( priority = 6)
	public void BBTest_6_SearchbyBrandTest() throws Exception {
		SelectProductByBrand ByBrand =new SelectProductByBrand(driver);
		ByBrand.selectbyBrand();
		ByBrand.reportStep(testAuthor, testCategory, testName);
		
	}

}
