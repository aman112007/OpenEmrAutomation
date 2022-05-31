package com.brillio.test;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.brillio.base.WebDriverWrapper;

public class LoginTest extends WebDriverWrapper {

	@DataProvider
	public String[][] validCredentialData() {
		String[][] main = new String[2][4];

		main[0][0] = "admin";
		main[0][1] = "pass";
		main[0][2] = "English (Indian)";
		main[0][3] = "OpenEMR";
		main[1][0] = "physician";
		main[1][1] = "physician";
		main[1][2] = "Dutch";
		main[1][3] = "OpenEMR";

		return main;

	}

	@Test(dataProvider = "validCredentialData")
	public void validCredentialTest(String username, String password, String language, String expectedTitle) {

		driver.findElement(By.id("authUser")).sendKeys(username);
		driver.findElement(By.id("clearPass")).sendKeys(password);

		Select selectLan = new Select(driver.findElement(By.xpath("//select[@name='languageChoice']")));
		selectLan.selectByVisibleText(language);

		driver.findElement(By.id("login-button")).click();

		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);

	}

	@Test
	public void invalidCredentialTest() {

		driver.findElement(By.id("authUser")).sendKeys("john");
		driver.findElement(By.id("clearPass")).sendKeys("jon123");
		driver.findElement(By.id("login-button")).click();

		String actualError = driver.findElement(By.xpath("//div[contains(text(),'Invalid')]")).getText();

		Assert.assertEquals(actualError, "Invalid username or password");

	}
}
