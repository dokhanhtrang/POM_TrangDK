package com.bankguru.login;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import static org.junit.Assert.assertTrue;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;

public class Login_01_CreateUserAndLogin_PageObject {
	WebDriver driver;
	String email = "khanhtrang" + randomNumber() + "@gmail.com";
	String username, password, loginUrl;
	@Parameters({"browser"})
	@BeforeClass
	public void beforeClass(String browser) {
	
	}

	@Test
	public void TC_Login01_CreateUser() {
		loginUrl = driver.getCurrentUrl();
		driver.findElement(By.xpath("//a[text()='here']")).click();
		driver.findElement(By.xpath("//input[@name='emailid']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
		assertTrue(driver.findElement(By.xpath("//h2[text()='Access details to demo site.']")).isDisplayed());
		username = driver.findElement(By.xpath("//td[text()='User ID :']/following-sibling::td")).getText();
		password = driver.findElement(By.xpath("//td[text()='Password :']/following-sibling::td")).getText();
		System.out.println("User name:" + username + " Password: " + password);
		driver.navigate().back();
		
		//test

	}

	@Test
	public void TC_Login02_LoginToApplication() {
		driver.get(loginUrl); // mngr217421 //nYzumEn
		driver.findElement(By.xpath("//input[@name ='uid']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@name ='password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@name ='btnLogin']")).click();
		assertTrue(driver.findElement(By.xpath("//td[contains(text(),'" + username + "')]")).isDisplayed());
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

	public int randomNumber() {
		Random random = new Random();
		int number = random.nextInt(9999);
		return number;
	}
}
