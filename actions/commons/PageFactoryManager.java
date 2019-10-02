package commons;

import org.openqa.selenium.WebDriver;

import pages.DeleteCustomerPagePO;
import pages.EditCustomerPagePO;
import pages.HomePagePO;
import pages.LoginPagePO;
import pages.NewCustomerPO;
import pages.RegisterPagePO;
//Check creat page

public class PageFactoryManager {
	private static HomePagePO homePage;
	private static RegisterPagePO registerPage;
	private static LoginPagePO loginPage;
	private static NewCustomerPO newCusPage;
	private static EditCustomerPagePO editCusPage;
	private static DeleteCustomerPagePO delCusPage;

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

	public static NewCustomerPO getNewCusPage(WebDriver driver_) {
		if (newCusPage == null) {
			return new NewCustomerPO(driver_);
		}
		return newCusPage;
	}

	public static EditCustomerPagePO getEditCusPage(WebDriver driver_) {
		if (editCusPage == null) {
			return new EditCustomerPagePO(driver_);
		}
		return editCusPage;
	}

	public static DeleteCustomerPagePO getDelCusPage(WebDriver driver_) {
		if (delCusPage == null) {
			return new DeleteCustomerPagePO(driver_);
		}
		return delCusPage;
	}
}
