package p2;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ReadingDataFrom_PropertyFile {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		Properties p = new Properties();
		driver.get("https://www.saucedemo.com/v1/index.html");
		try {
			FileInputStream fis = new FileInputStream(
					"C:/Users/DELL/eclipse-workspace/UI_Automation/config/Configuration.properties");
			p.load(fis);
			String Url = p.getProperty("loginUrl");
			String username = p.getProperty("uname");
			String password = p.getProperty("pwd");
			//driver.get("https://www.saucedemo.com/v1/index.html");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			WebElement user = driver.findElement(By.xpath("//input[@id='user-name']"));
			WebElement pass = driver.findElement(By.xpath("//input[@id='password']"));
			WebElement Login = driver.findElement(By.xpath("//input[@id='login-button']"));
			WebElement prodLabel = driver.findElement(By.xpath("//div[@class='product_label']"));
			user.sendKeys(username);
			user.sendKeys(password);
			Login.click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			if (prodLabel.isDisplayed()) {
				System.out.println("Login test is passed");
			} else {
				System.out.println("Login test is failed");
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		driver.quit();
	}

}
