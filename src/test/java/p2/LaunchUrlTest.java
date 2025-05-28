package p2;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchUrlTest {

	@Test
	public void launchUrl() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		String title = driver.getTitle();
		System.out.println("Title is : " + title);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		try {
			driver.findElement(By.xpath("//a[@title='Login'][1]")).click();
			WebElement reqotp = driver.findElement(By.xpath("//button[@class='QqFHMw twnTnD _7Pd1Fp']"));
			if (reqotp.isDisplayed()) {
				System.out.println("Login page is displayed successfully");
			} else {
				System.out.println("Error occured while displaying login page");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		driver.quit();

	}

}
