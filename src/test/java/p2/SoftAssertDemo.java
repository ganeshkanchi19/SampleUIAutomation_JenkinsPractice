package p2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SoftAssertDemo {

	public static void main(String[] args) {
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		SoftAssert sa = new SoftAssert();
		driver.get("https://demoqa.com/text-box");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebElement userbox = driver.findElement(By.xpath("//input[@id='userName']"));
		WebElement TextBoxTitle = driver.findElement(By.xpath("//h1[text() = 'Text Box']"));
		driver.findElement(By.xpath("//input[@id='userName']")).sendKeys("Ganesh");
		String expTitle = "DEMOQA";
		String actTitle = driver.getTitle();
		sa.assertEquals(actTitle, expTitle);
		sa.assertEquals(false, userbox.isDisplayed());
		sa.assertTrue(TextBoxTitle.isDisplayed());
		System.out.println("Title of the webpage is : " + actTitle);
		sa.assertAll();
		driver.quit();

	}

}
