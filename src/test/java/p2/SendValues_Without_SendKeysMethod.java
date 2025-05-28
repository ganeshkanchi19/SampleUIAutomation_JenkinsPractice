package p2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SendValues_Without_SendKeysMethod {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/text-box");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebElement fname = driver.findElement(By.xpath("//input[@placeholder='Full Name']"));
		WebElement uemail = driver.findElement(By.xpath("//input[@placeholder='name@example.com']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String value = (String) js.executeScript("return arguments[0].value='Ganesh Kanchi';", fname);
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("./Screenshots/EnteringText_withoutSendKeys.png"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		System.out.println(value);
		driver.quit();
	}

}
