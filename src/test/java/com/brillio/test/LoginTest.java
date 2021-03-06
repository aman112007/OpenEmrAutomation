package com.brillio.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.brillio.base.WebDriverWrapper;
import com.brillio.pages.LoginPage;
import com.brillio.pages.MainPage;
import com.brillio.utilities.DataUtils;

public class LoginTest extends WebDriverWrapper {

	@Test(dataProviderClass = DataUtils.class, dataProvider = "commonDataProvider")
	public void validCredentialTest(String username, String password, String language, String expectedTitle) {

		LoginPage.enterUsername(driver, username);
		test.log(Status.INFO, "Enter Username as " + username);

		LoginPage.enterPassword(driver, password);
		test.log(Status.INFO, "Enter Password as " + password);

		LoginPage.selectLanguageByText(driver, language);
		test.log(Status.INFO, "Selected Lanaguage as " + language);

		LoginPage.clickOnLogin(driver);
		test.log(Status.INFO, "Clicked on login ");

		MainPage.waitForPresenceOfPatientMenu(driver);

		String actualTitle = MainPage.getMainPageTitle(driver);
		test.log(Status.INFO, "Title is " + actualTitle);

		Assert.assertEquals(actualTitle, expectedTitle);

	}

	@Test(dataProviderClass = DataUtils.class, dataProvider = "commonDataProvider")
	public void invalidCredentialTest(String username, String password, String language, String expectedError) {

		LoginPage.enterUsername(driver, username);
		LoginPage.enterPassword(driver, password);
		LoginPage.selectLanguageByText(driver, language);
		LoginPage.clickOnLogin(driver);

		String actualError = LoginPage.getInvalidErrorMessage(driver);
		Assert.assertEquals(actualError, expectedError);

	}
}
