package p2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SauceLabAssessment {
	
	
	@Test
	public void  sauceDemo()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		// Opening the url
		driver.get("https://www.saucedemo.com/v1/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
		driver.findElement(By.xpath("//input[@id='login-button']")).click();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		WebElement prodlable = driver.findElement(By.xpath("//div[@class='product_label']"));
		if (prodlable.isDisplayed()) {
			System.out.println("User is redirected to product page successfully");
		} else {
			System.out.println("User is failed to redirected to product page");
		}

		List<WebElement> prodList = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
		int prodcount = prodList.size();
		System.out.println("Number of total prodcust are : " + prodcount);
		
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		WebElement fisrtProd = driver.findElement(By.xpath("//a[@id='item_4_title_link']/following::button[@class='btn_primary btn_inventory'][1]"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		fisrtProd.click();
		
		List<WebElement> cartItems = driver.findElements(By.xpath("//span[@class='fa-layers-counter shopping_cart_badge']"));
		int cartItemxCount = cartItems.size();
		
		if (cartItemxCount==1) {
			System.out.println("Cart items contains only one product");
		} else {
			System.out.println("Cart items is empty");
		}
		
		List<WebElement> cart = driver.findElements(By.xpath("//div[@id='shopping_cart_container']"));
		driver.close();
	}

}
