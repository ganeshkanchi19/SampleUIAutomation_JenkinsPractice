package p2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NavigationMethodsDemo {

	@Test
	public void navigationTest() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://www.snapdeal.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String amzt = driver.getTitle();
		System.out.println("Title of snapdeal web page is : " + amzt);
		driver.navigate().back();
		WebElement googleLogo = driver.findElement(By.xpath("//div[@class='logo']"));
		googleLogo.click();
		String googleUrl = driver.getCurrentUrl();
		System.out.println("Current url og google page is : " + googleUrl);
		driver.quit();

	}

}
