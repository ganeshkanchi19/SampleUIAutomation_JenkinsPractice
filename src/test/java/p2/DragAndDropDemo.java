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
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragAndDropDemo {

	@Test
	public void frameSwitchTest() throws IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/droppable");
		driver.manage().window().maximize();
		WebElement drag = driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement drop = driver.findElement(By.xpath("//div[@id='droppable']"));
		WebElement dragDropAct = driver.findElement(By.xpath("//div[@id='droppable']"));
		Actions act = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		act.dragAndDrop(drag, drop).perform();
		String textTo = drop.getText();
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("./Screenshots/DragAndDropDemo.png"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		if (textTo.equals("Dropped!")) {
			System.out.println("Drag and drop test is passed successfully");

		} else {
			System.out.println("Failed to drop");
		}
       driver.close();
	}

	
}
