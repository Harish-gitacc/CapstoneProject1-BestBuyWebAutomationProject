package testCase_BB;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import baseFile.BaseFileBB;
import pages_BestBuy.CountryPageValidation;

public class BBTest_5_CheckTitleofmenuTest extends BaseFileBB{
	@BeforeTest
	public void setup() {
		testName = "BBTest_5_CheckTitleofmenuTest";
		testDescription = "Navigating to the BestBuy website and MainMenu";
		testCategory = "Regression";
		testAuthor = "Kavin Vikram ";
		
	}
   @Test( priority = 5)
   public void BBTest_5_CheckTitleofmenuTest() throws Exception {
	   CountryPageValidation countryPV =new CountryPageValidation(driver);
	   countryPV.MainMenu();
	   countryPV.reportStep(testAuthor, testCategory, testName);
	   
	   
   }
}