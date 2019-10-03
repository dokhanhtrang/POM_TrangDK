package commons;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.Reporter;

public class AbstractTest {
	WebDriver driver;

	protected WebDriver openMulptyBrowser(String browser, String url) {
		if (browser.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", ".\\resources\\chromedriver.exe");
			driver = new ChromeDriver();
		} else {
			System.setProperty("webdriver.ie.driver", ".\\resources\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}

	protected void closeBrowser(WebDriver driver) {
		// kill process
		try {
			String osName = System.getProperty("os.name").toLowerCase();
			String cmd = "";
			driver.quit();
			if (driver.toString().toLowerCase().contains("chrome")) {
				if (osName.toLowerCase().contains("mac")) {
					cmd = "pkill chromedriver";
				} else {
					cmd = "taskkill /IM chromedriver.exe /F";
				}
				Process process = Runtime.getRuntime().exec(cmd);
				process.waitFor();
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	protected static int randomNumber() {
		Random random = new Random();
		int number = random.nextInt(9999);
		return number;
	}

	private boolean verifyPass(boolean condition) {
		boolean pass = false;
		try {
			Assert.assertTrue(condition);
		} catch (Throwable e) {
			pass = true;
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyTrue(boolean condition) {
		return verifyPass(condition);
	}

	private boolean verifyFailed(boolean condition) {
		boolean pass = true;
		try {
			Assert.assertFalse(condition);
		} catch (Throwable e) {
			pass = true;
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyFalse(boolean condition) {
		return verifyFailed(condition);
	}

	private boolean verifyEqual(Object actual, Object expected) {
		boolean pass = true;
		try {
			Assert.assertEquals(actual, expected);
		} catch (Throwable e) {
			pass = true;
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyEquals(Object actual, Object expected) {
		return verifyEqual(actual, expected);
	}
}
