package commons;

import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;


public class AbstractPage {
	
	public void openAnyUrl(WebDriver driver, String url) {
		driver.get(url);
	}

	public String getTitlePage(WebDriver driver) {
		return driver.getTitle();
	}

	public String getCurrentUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	public String getPageSource(WebDriver driver) {
		return driver.getPageSource();
	}

	public void back(WebDriver driver) {
		driver.navigate().back();
	}

	public void forward(WebDriver driver) {
		driver.navigate().forward();
	}

	public void refresh(WebDriver driver) {
		driver.navigate().refresh();
	}

	public void clickToElement(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		element.click();
	}

	public void sendKeyToElement(WebDriver driver, String locator, String value) {
		WebElement element = driver.findElement(By.xpath(locator));
		element.clear();
		element.sendKeys(value);
	}

	public void selectItemInDropdown(WebDriver driver, String locator, String value) {
		Select select = new Select(driver.findElement(By.xpath(locator)));
		select.selectByVisibleText(value);
	}

	public void selectItemInCustomDropdown(WebDriver driver, String locator, String textExpected, String tagName) {
		driver.findElement(By.xpath(locator)).click();
		List<WebElement> items = driver.findElements(By.tagName(tagName));
		for (WebElement item : items) {
			String text = item.getText();
			if (text == textExpected) {
				item.click();
				break;
			}
		}
	}

	public String getFirstItemSelected(WebDriver driver, String locator) {
		Select select = new Select(driver.findElement(By.xpath(locator)));
		return select.getFirstSelectedOption().getText();
	}

	public String getAttributeValue(WebDriver driver, String locator, String attribute) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.getAttribute(attribute);
	}

	public String getTextElement(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.getText();
	}

	public int countElementNumber(WebDriver driver, String locator, int value) {
		List<WebElement> elements = driver.findElements(By.xpath(locator));
		return value = elements.size();
	}

	public void checkTheCheckbox(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		element.click();
		assertTrue(element.isSelected());
	}

	public void unCheckTheCheckbox(WebDriver driver, String locator) {
		if (driver.findElement(By.xpath(locator)).isSelected()) {
			driver.findElement(By.xpath(locator)).click();
		}
	}

	public boolean isControlDisplayed(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.isDisplayed();
	}

	public boolean isControlSelected(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.isSelected();
	}

	public boolean isControlEnabled(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.isEnabled();
	}

	public void switchWindowByID(WebDriver driver, String parentID) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindow : allWindows) {
			if (!runWindow.equals(parentID)) {
				driver.switchTo().window(runWindow);
				break;
			}
		}
	}

	public void switchWindowByTitle(WebDriver driver, String title) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindow : allWindows) {
			driver.switchTo().window(runWindow);
			String currentWin = driver.getTitle();
			if (currentWin.equals(title)) {
				break;
			}

		}
	}

	public void closeAllWithoutParentWindows(WebDriver driver, String parentWindow) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindows : allWindows) {
			if (!runWindows.equals(parentWindow)) {
				driver.switchTo().window(runWindows);
				driver.close();
			}
		}
	}

	public void swithToIframe(WebDriver driver, String idIframe) {
		WebElement iframe = driver.findElement(By.id(idIframe));
		driver.switchTo().frame(iframe);
		driver.quit();
	}

	public void doubleClickToElement(WebDriver driver, String locator) {
		WebElement ele = driver.findElement(By.xpath(locator));
		Actions builder = new Actions(driver);
		builder.doubleClick(ele).perform();
	}

	public void righClick(WebDriver driver, String locator) {
		WebElement ele = driver.findElement(By.xpath(locator));
		Actions action = new Actions(driver).contextClick(ele);
		action.build().perform();
	}

	public void moveMouseToElement(WebDriver driver, String locator) {
		WebElement elem = driver.findElement(By.xpath(locator));
		Actions builder = new Actions(driver);
		builder.moveToElement(elem).perform();
	}

	public void clickAnHold(WebDriver driver, String locator, int index1, int index2) {
		List<WebElement> listItems = driver.findElements(By.xpath(locator));
		Actions builder = new Actions(driver);
		builder.clickAndHold(listItems.get(index1)).clickAndHold(listItems.get(index2)).click().perform();
	}

	public void dragAndDrop(WebDriver driver, String locatorFrom, String locatorTarget) {
		WebElement dragFrom = driver.findElement(By.xpath(locatorFrom));
		WebElement target = driver.findElement(By.xpath(locatorTarget));
		Actions builder = new Actions(driver);
		Action dragAndDrop = builder.clickAndHold(dragFrom).moveToElement(target).release(target).build();
		dragAndDrop.perform();
	}

	public void sendKeyBoardToElement(WebDriver driver, String locator, CharSequence key) {
		WebElement element = driver.findElement(By.xpath(locator));
		Actions action = new Actions(driver);
		action.sendKeys(element, key).perform();
	}

	public boolean checkAnyImgLoad(WebDriver driver, WebElement image) {
		JavascriptExecutor jsExcutor = (JavascriptExecutor) driver;
		return (boolean) jsExcutor.executeScript("return arguments[0].complete && "
				+ "typeof arguments[0].naturalWidth ! = 'undifined' && arguments[0].naturalWidth > 0", image);
	}

	public void uploadBySendkeys(WebDriver driver, String locate, String submitBtn, String filePath, String fileName) {
		WebElement upload = driver.findElement(By.xpath(locate));
		upload.sendKeys(filePath);
		driver.findElement(By.xpath(submitBtn)).click();
		driver.findElement(By.xpath("//img[contains(@src,'" + fileName + "')]"));
		checkAnyImgLoad(driver, driver.findElement(By.xpath("//img[contains(@src,'" + fileName + "')]")));
	}
	
	 public void uploadMultipleBySendkeys(WebDriver driver, String locate, String[] listFileName) {
	        WebElement upload = driver.findElement(By.xpath(locate));
	        var fileNames = "";
			for (var i = 0; i < listFileName.length; i++) {
	          fileNames += listFileName[i] + "\n";
	        }
	        upload.sendKeys(fileNames);
	    }

	public void uploadMultipleBySendkeys(WebDriver driver, String locate, String fileName1, String fileName) {
		WebElement upload = driver.findElement(By.xpath(locate));
		upload.sendKeys(fileName + "\n" + fileName1);
	}

	public void uploadByAutoIT(WebDriver driver, String filePath, String submitBtn, String fileName) throws Exception {
		driver.findElement(By.xpath("//span[contains(text(),'Add files...')]")).click();
		Runtime.getRuntime().exec(new String[] { ".\\upload\\firefox.exe", filePath });
		Thread.sleep(3000);
		driver.findElement(By.xpath("//img[contains(@src,'" + fileName + "')]"));
		checkAnyImgLoad(driver, driver.findElement(By.xpath("//img[contains(@src,'" + fileName + "')]")));
	}

	public void uploadByRobot(WebDriver driver, String filePath, String inputLocate) throws Exception {
		// Specify the file location with extension
		StringSelection select = new StringSelection(filePath);
		// Copy to clipboard
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(select, null);
		// Click
		driver.findElement(By.xpath(inputLocate)).click();
		Robot robot = new Robot();
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

	public Object excuteJsToBrowser(WebDriver driver, String javaSript) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
        return js.executeScript(javaSript);
	}

	public void jsClickToElement(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}

	public Object jsScrollToBottomPage(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
        return js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public Object jsScrollToElement(WebDriver driver) {
		WebElement element = driver.findElement(By.id("id_of_element"));
		return ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public void highlightElement(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border='6px groove red'", element);
	}

	public void removeAttributeOfElement(WebDriver driver, String locator, String attribute) {
		WebElement element = driver.findElement(By.xpath(locator));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].removeAttribute('" + attribute + "');", element);
	}

	public boolean verifyTextInInnerText(WebDriver driver, String text) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String sText = js.executeScript("return document.documentElement.innerText;").toString();
		return sText.contains(text);
	}

	public void waitForElementPresence(WebDriver driver, String locate) {
		By by = By.xpath(locate);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(by));
	}

	public void waitForElementVisible(WebDriver driver, String locate) {
		By by = By.xpath(locate);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}

	public void waitForElementClickable(WebDriver driver, String locate) {
		By by = By.xpath(locate);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(by));
		driver.findElement(By.xpath(locate)).click();
	}

	public void waitForElementInvisible(WebDriver driver, String locate) {
		By by = By.xpath(locate);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
	}

}