package p2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchingBrowser_InCognito {

	@Test
	public void launch_Incognito() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions incog = new ChromeOptions();
		incog.addArguments("--incognito");
		WebDriver driver = new ChromeDriver(incog);
		driver.get("https://www.nseindia.com/report-detail/eq_security");
		driver.quit();
		
	}
}
