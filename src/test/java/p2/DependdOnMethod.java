package p2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DependdOnMethod {

	@Test(dependsOnMethods = { "openBrowser" })
	public void login() {
		System.out.println("This will execute second (SignIn)");
	}

	@Test
	public void openBrowser() {
		System.out.println("This will execute first (Open Browser)");
	}

}
