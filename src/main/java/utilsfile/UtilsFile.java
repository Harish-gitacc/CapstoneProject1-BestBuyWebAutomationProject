package utilsfile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UtilsFile {
	public static WebDriver driver;
	public static ExtentTest test;
	public String sheetName;
	public static ExtentReports extent;
	public String testName;
	public String testDescription;
	public String testCategory;
	public String testAuthor;
	
	public static String readProperty(String url) throws IOException {
		String projectPath = System.getProperty("user.dir");
		File file = new File(projectPath + "/configBBfile.properties");
		FileInputStream fileinput = new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(fileinput);
		return prop.get(url).toString();

	}

	public static void launchBrowser(String browser) {

		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless");
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--headless");
		} else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
			WebDriverManager.edgedriver().setup();
			EdgeOptions options = new EdgeOptions();
			options.addArguments("--headless");
		} else {
			
			ChromeOptions options = new ChromeOptions();
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
	}

	

	public static void waitExplicit(WebElement element) {
		try
		{
			WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(15));
			wait.until(ExpectedConditions.visibilityOf(element));
			
		}
		catch(Exception ex)
		{
			System.out.println("problem in explicit wait");
			ex.printStackTrace();
		}
	}

	public static void waitExplicitUntilTitle(String titltToWait) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(500));
		wait.until(ExpectedConditions.titleIs(titltToWait));
	}
	
	
	public void navigateBack()
	{
		try
		{
			driver.navigate().back();
		}
		catch(Exception ex)
		{
			System.out.println("problem in navigate back");
			ex.printStackTrace();
		}
	}
	
	public static void getapplication(String url) {
		try {
			driver.get(url);
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
			
		}
	

	public static String getPageTitle() {
		waitExplicitUntilTitle(driver.getTitle());
		return driver.getTitle();
	}

	public static void selectDropDown(WebElement element, String visibleText) {
		Select select = new Select(element);
		select.selectByVisibleText(visibleText);
	}

	public static void titleAssertion(String expTitle) {
		Assert.assertEquals(getPageTitle(), expTitle);
	}

	public static void jsScrollUntilElement(WebElement element) {
		waitExplicit(element);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public static void jsClickOn(WebElement element) {
		waitExplicit(element);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);

	}

	public static int getResponseCode(String url) throws Exception {
		URI link = new URI(url);
		URL urL = link.toURL();
		HttpURLConnection connect = (HttpURLConnection) urL.openConnection();
		int responseCode = connect.getResponseCode();
		return responseCode;
	}

	public static String extractText(WebElement element) {
		return element.getText();
	}

	public static void clickOn(WebElement element) {
		waitExplicit(element);
		element.click();
	}
	
	public void selectByIndex(WebElement ele, int value){
		
			Select sel = new Select(ele);
			sel.selectByIndex(value);
		}
    
	public static void enter(WebElement element, String text) {
		waitExplicit(element);
		element.clear();
		element.sendKeys(text);
	}
	public void action(WebElement element) {
		 driver.switchTo().alert().accept();
	}
	
	public void jsscrollDownBottom(){
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight);");
	}
	

	public static Object[][] dataReader(  ) throws IOException, InterruptedException {
		
		XSSFWorkbook workBook = new XSSFWorkbook("C:/Users/lenovo/eclipse-workspace/BestBuy/bestbuyLoginTest .xlsx");
		XSSFSheet sheet = workBook.getSheetAt(0);
		int rows = sheet.getLastRowNum();
		int columns = sheet.getRow(0).getLastCellNum();
		System.out.println(rows);
		System.out.println(columns);
		Object[][] data = new Object[rows][columns];
		Thread.sleep(3000);
		for (int row = 1; row <= rows; row++) 
		{
			for (int colm = 0; colm < columns; colm++) 
			{
				data[row-1][colm] = sheet.getRow(row).getCell(colm).toString();
				System.out.println(sheet.getRow(row).getCell(colm).toString());
			}
		}
		workBook.close();
		return data;
	}

	public static int screenShot(String testName) throws InterruptedException, Exception, Exception 
	{
		int randomnum= (int) (Math.random() * 999 + 1000);
		Thread.sleep(2000);
		String projectpatth = System.getProperty("user.dir");
		FileUtils.copyFile(((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE),
		new File(projectpatth + "/ScreenShot/" + testName + randomnum + ".png"));
		return randomnum;
	}

	public void reportStep(String stepDetails, String stepStatus, String testName) throws Exception, Exception
	{
		int randomnum = screenShot(testName);
		String projectPath = System.getProperty("user.dir");
		if (stepStatus.equalsIgnoreCase("pass")) 
		{
			Assert.assertTrue(true, stepDetails);
			test.pass(stepDetails, MediaEntityBuilder
			.createScreenCaptureFromPath(projectPath +"/Screenshot/"+testName+randomnum+".png").build());
		} 
		else if (stepStatus.equalsIgnoreCase("fail"))
		{
			Assert.fail("Step Failed: " + stepDetails);
			test.fail(stepDetails, MediaEntityBuilder
			.createScreenCaptureFromPath(projectPath+"/Screenshot/"+testName+randomnum+".png").build());
		}
	}
}