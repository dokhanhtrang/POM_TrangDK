package commons;

import org.openqa.selenium.WebDriver;

import pages.HomePagePO;
import pages.LoginPagePO;
import pages.RegisterPagePO;
//Check creat page

public class PageFactoryManager {
	private static HomePagePO homePage;
	private static RegisterPagePO registerPage;
	private static LoginPagePO loginPage;

	public static HomePagePO getHomePage(WebDriver driver_) {
		if (homePage == null) {
			return new HomePagePO(driver_);
		}
		return homePage;
	}

	public static RegisterPagePO getRegisterPage(WebDriver driver_) {
		if (registerPage == null) {
			return new RegisterPagePO(driver_);
		}
		return registerPage;
	}

	public static LoginPagePO getLoginPage(WebDriver driver_) {
		if (loginPage == null) {
			return new LoginPagePO(driver_);
		}
		return loginPage;
	}
}
