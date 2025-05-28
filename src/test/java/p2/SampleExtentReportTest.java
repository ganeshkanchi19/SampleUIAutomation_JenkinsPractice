package p2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SampleExtentReportTest {

	ExtentReports extent;
	ExtentTest test;
	ExtentSparkReporter sparkReporter;
	WebDriver driver;

	@BeforeClass
	public void startTest() {
		String reportPath = System.getProperty("user.dir") + "/test-output/ExtentReport.html";
		sparkReporter = new ExtentSparkReporter(reportPath);
		sparkReporter.config().setReportName("UI Automation Report");
		sparkReporter.config().setDocumentTitle("Test Execution Report");
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);

	}

	@BeforeTest
	public void setupDriver() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

	}

	@Test()
	public void sampleTestPass() throws IOException {

		test = extent.createTest("Flipcart Login navigation check",
				"This test will check if the login page is displaying or not after clicking on LOGIN button");
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String title = driver.getTitle();
		System.out.println("Title is : " + title);
		try {
			driver.findElement(By.xpath("//a[@title='Login'][1]")).click();
			WebElement reqotp = driver.findElement(By.xpath("//button[@class='QqFHMw twnTnD _7Pd1Fp']"));
			if (reqotp.isDisplayed()) {
				test.pass("Login page is displayed successfully");
				test.log(Status.PASS, "Successfully launched the flipcart login page");
			} else {
				test.fail("Failed to display login page");

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("./Screenshots/ExtentReportCheck_FlipCartLogin.png"));

	}

//	@Test
//	public void sampleTestFail() {
//		WebElement amzlogo = driver.findElement(By.xpath("//div[@id='nav-logo']"));
//		test = extent.createTest("Amazon url launch check",
//				"This test will check if the user succesffuly able to launch the amazon url or not");
//
//		try {
//			driver.get("https://www.aman.in/");
//			driver.manage().window().maximize();
//			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//			String title = driver.getTitle();
//			System.out.println("Title is : " + title);
//			if (amzlogo.isDisplayed()) {
//				test.pass("Aamzon page is displaying successfuly");
//			} else {
//				test.fail("Unable to launch Amazon page");
//				test.log(Status.FAIL, "Getting some error while launching the amazon url");
//			}
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//
//	}

	@AfterClass
	public void endTest() {
		extent.flush();
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
