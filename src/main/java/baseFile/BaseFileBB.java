package baseFile;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import utilsfile.UtilsFile;

public class BaseFileBB extends UtilsFile{
	@BeforeSuite
	public void StartReport() {
		int randomnum = (int) (Math.random() * 100 + 99999);
		String path = System.getProperty("user.dir") + "/Reports/"+randomnum+"Chart.html";

		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation BestBuy Result");
		reporter.config().setDocumentTitle("Test Result");

		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Test", "Harish");

	}

	@BeforeClass
	public void testDetails() {
		test = extent.createTest(testName, testDescription);
		test.assignCategory(testCategory);
		test.assignAuthor(testAuthor);
	}

	@BeforeMethod
	public void start() throws Exception {
		launchBrowser(readProperty("browser"));
		getapplication(readProperty("url"));

	}

	@AfterMethod
	public void close(){
		try
		{
			driver.quit();
			
		}
		catch(Exception ex)
		{
			System.out.println("Problem in closing all the browsers");
			ex.printStackTrace();
		}
	}
	
	@DataProvider
	public Object[][] getFromExcel() throws Exception {
		Object[][] data = dataReader();
		return data;
	}

	@AfterSuite
	public void endReport() {
		extent.flush();
	}


}