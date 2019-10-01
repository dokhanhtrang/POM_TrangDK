package commons;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class AbstractTest {
	WebDriver driver;

	public WebDriver openMulptyBrowser(String browser) {
		if (browser.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", ".\\resources\\chromedriver.exe");
			driver = new ChromeDriver();
		} else {
			System.setProperty("webdriver.ie.driver", ".\\resources\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		driver.get(Constants.DEV_URL);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}

	public int randomNumber() {
		Random random = new Random();
		int number = random.nextInt(9999);
		return number;
	}
}
