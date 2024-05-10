package testCase_BB;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import utilsfile.UtilsFile;

public class BBTest_2_UrlValidationTest extends UtilsFile {
	@BeforeTest
	public void setup() {
		testName = "BBTest_2_UrlValidationTest";
		testDescription = " BestBuy website url validation to check the url is broken or not";
		testCategory = "Regression Testing";
		testAuthor = "Harish ";

	}

	@Test(priority = 2)

	public void brokenLinkBestbuy() throws Exception {
		String urlToCheck = "https://www.bestbuy.com/";

		@SuppressWarnings("deprecation")
		URL url = new URL(urlToCheck);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("HEAD");
		int responseCode = conn.getResponseCode();

		if (responseCode != HttpURLConnection.HTTP_OK) {
			System.out.println("The URL is broken.");
		} else {
			System.out.println("The URL is not broken.");
		}

	}
}