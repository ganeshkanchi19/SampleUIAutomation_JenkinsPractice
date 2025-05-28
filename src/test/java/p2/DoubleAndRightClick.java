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
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DoubleAndRightClick {

	@Test
	public void rightAndDoubleClick() throws IOException {
		// WebDriverManager.chromedriver().setup();
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.get("https://demoqa.com/buttons");
		System.out.println("Firxfox is launced");
		String urlText = driver.getTitle();
		System.out.println("Title of the web page is:" + urlText);
		driver.manage().window().maximize();
		WebElement dobClick = driver.findElement(By.xpath("//button[@id='doubleClickBtn']"));
		WebElement righClick = driver.findElement(By.xpath("//button[@id='rightClickBtn']"));
		WebElement dobmsg = driver.findElement(By.xpath("//p[@id='doubleClickMessage']"));
		WebElement rightmsg = driver.findElement(By.xpath("//p[@id='rightClickMessage']"));
		Actions act = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		act.doubleClick(dobClick).perform();
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("./Screenshots/DoubleClick.png"));
		if (dobmsg.isDisplayed()) {
			System.out.println("Double click is performed successfully");
		} else {
			System.out.println("Double click action is failed");
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		act.contextClick(righClick).perform();
		File src1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src1, new File("./Screenshots/RightClickAction.png"));
		if (rightmsg.isDisplayed()) {
			System.out.println("Right click action is performed successfully");
		} else {
			System.out.println("Right click action is failed");
		}
		driver.quit();

	}

}
