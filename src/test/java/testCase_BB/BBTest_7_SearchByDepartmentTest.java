package testCase_BB;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import baseFile.BaseFileBB;
import pages_BestBuy.SelectProductByDepartment;


public class BBTest_7_SearchByDepartmentTest extends BaseFileBB{
	@BeforeTest
	public void setup() {
		testName = " BBTest_7_SearchByDepartmentTest";
		testDescription = " Search product by department";
		testCategory = "Regression testing";
		testAuthor = "Harish";
	}
	
	@Test( priority = 7)
	public void  BBTest_7_SearchByDepartmentTest() throws Exception {
		SelectProductByDepartment ByDept =new SelectProductByDepartment(driver);
		ByDept.byDept();
		ByDept.reportStep(testCategory, testAuthor, testName);
	}
}