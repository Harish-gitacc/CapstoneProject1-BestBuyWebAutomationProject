package testCase_BB;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import baseFile.BaseFileBB;
import pages_BestBuy.SignInPage;
import pages_BestBuy.CountryPage;

public class BBTest_3_LoginTest extends BaseFileBB{
	@BeforeTest
	public void setup() {
		testName = "BBTest_3_LoginTest";
		testDescription = "BestBuy website login test";
		testCategory = "Regression testing";
		testAuthor = "Harish";
	}
	@Test(priority = 3)
	
	public void BBTest_3_LoginTest() throws Exception {
		CountryPage country = new CountryPage(driver);
		country.country();
		SignInPage sign=new SignInPage();
		sign.loginBestbuy("admin@yourstore.com", "Admin@1234");
		sign.reportStep(testAuthor, testCategory, testDescription);
	}

}