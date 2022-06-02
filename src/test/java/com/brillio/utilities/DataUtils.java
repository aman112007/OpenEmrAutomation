package com.brillio.utilities;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

public class DataUtils {

	@DataProvider
	public Object[][] commonDataProvider(Method method) throws IOException {
		
		//current test method name is the sheetname
		String testMethodName=method.getName();
		
		Object[][] main = ExcelUtils.getSheetIntoTwoDimArray("test-data/orange_data.xlsx", testMethodName);
		return main;
	}

//	@DataProvider
//	public Object[][] invalidCredentialData() throws IOException {
//
//		Object[][] main = ExcelUtils.getSheetIntoTwoDimArray("test-data/orange_data.xlsx", "invalidCredentialTest");
//
//		return main;
//
//	}
//
//	@DataProvider
//	public Object[][] validCredentialData() throws IOException {
//
//		Object[][] main = ExcelUtils.getSheetIntoTwoDimArray("test-data/orange_data.xlsx", "validCredentialTest");
//
//		return main;
//
//	}

	// @DataProvider
	// public String[][] validCredentialData() {
	// String[][] main = new String[2][4];

	// main[0][0] = "admin";
	// main[0][1] = "pass";
	// main[0][2] = "English (Indian)";
	// main[0][3] = "OpenEMR";
	// main[1][0] = "physician";
	// main[1][1] = "physician";
	// main[1][2] = "Dutch";
	// main[1][3] = "OpenEMR";

	// return main;

	// }
}
