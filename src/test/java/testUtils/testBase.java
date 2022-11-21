package testUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class testBase {

	public WebDriver driver;
	public WebDriverWait wait;
	String browser;
	public String filePath;

	public WebDriver initialization() throws IOException

	{
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\config.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String url = prop.getProperty("Url");
		String browser_properties = prop.getProperty("browser");

		// In command line when you run mvn clean declare browser then browser_maven
		// initialize the browser//
		String browser_maven = System.getProperty("browser");
		filePath = prop.getProperty("filepath");
		// result = testCondition ? value1 : value2 ---> Ternary Operators in Java

		browser = browser_maven != null ? browser_maven : browser_properties;

		if (driver == null) {
			if (browser.equalsIgnoreCase("chrome")) {

				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			}

			if (browser.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();

			}
			if (browser.equalsIgnoreCase("edge")) {
				WebDriverManager.edgedriver().setup();
				driver = new FirefoxDriver();

			}
						
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.get(url);

		return driver;
	}

}
