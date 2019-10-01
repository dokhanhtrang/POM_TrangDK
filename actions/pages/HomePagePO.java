package pages;

import org.openqa.selenium.WebDriver;

import bankguru.HomePageUI;
import commons.AbstractPage;
//Descip action in page

public class HomePagePO extends AbstractPage {
	WebDriver driver;

	public HomePagePO(WebDriver driver_) {
		this.driver = driver_;
	}

	public boolean marquee() {
		waitForElementVisible(driver, HomePageUI.MARQUEE_TEXT);
		return isControlDisplayed(driver, HomePageUI.MARQUEE_TEXT);
	}

}
