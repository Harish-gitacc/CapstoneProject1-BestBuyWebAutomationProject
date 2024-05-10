package testCase_BB;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import baseFile.BaseFileBB;
import pages_BestBuy.SelectProductBySearch;

public class BBTest_8_SearchBySearchBarTest extends BaseFileBB{
	@BeforeTest
	public void setup() {
		testName = "BBTest_8_SearchBySearchBarTest";
		testDescription = "Add Product by Searh bar";
		testCategory = "Regression Testing";
		testAuthor = "Harish";
		
	}

	@Test( priority = 8)
	public void BBTest_8_SearchBySearchBarTest() throws Exception {
		SelectProductBySearch BySrch = new SelectProductBySearch(driver);
		BySrch.addToCart("Dell core i5 7th generation");
		BySrch.reportStep(testAuthor, testCategory, testName);
	}
}
