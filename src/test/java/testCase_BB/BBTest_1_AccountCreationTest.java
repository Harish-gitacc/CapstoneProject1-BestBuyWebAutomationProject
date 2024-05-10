package testCase_BB;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import baseFile.BaseFileBB;
import pages_BestBuy.CountryPage;

public class BBTest_1_AccountCreationTest extends BaseFileBB{
	@BeforeTest
	public void setup() {
		testName = "BBTest_1_AccountCreationTest";
		testDescription = "Select Country and create account in BestBuy webpage";
		testCategory = "Regression Testing";
		testAuthor = "Harish ";
		
	}
	@Test(dataProvider = "getFromExcel", priority = 1)
	public void BBTest_1_AccountCreationTest(String fname,String lname,String emailid,String conpassword,String repassword,String pNum) throws Exception {
		CountryPage country = new CountryPage(driver);
		country .country();
		country .Signup(fname, lname, emailid, conpassword, repassword, pNum);
		country .reportStep(testAuthor, testCategory, testName);
	}
}