package p2;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.util.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VerifyTitle {
	WebDriver driver;

	@BeforeTest
	public void launchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	@Test(groups = { "Smoke" })
	public void verifyTitleOfTextBox() {
		driver.get("https://demoqa.com/text-box");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String expected = "Text Box";
		WebElement textBox = driver.findElement(By.xpath("//h1[text()='Text Box']"));
		// assertTrue(textBox.isDisplayed());
		if (textBox.isDisplayed()) {
			System.out.println("Text Box title is present");
		} else {
			System.out.println("Text Box title is absent");
		}

	}

	@Test
	public void checkTitle() {
		String testTitle = "Free QA Automation Tools For Everyone";
		String originalTitle = driver.getTitle();
		assertEquals(originalTitle, testTitle);
	}

	@AfterTest
	public void browserClose() {
		driver.quit();
	}

}
