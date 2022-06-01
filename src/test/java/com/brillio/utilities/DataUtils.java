package com.brillio.utilities;

import org.testng.annotations.DataProvider;

public class DataUtils {
	
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

	@DataProvider
	public String[][] invalidCredentialData() {
		String[][] main = new String[3][4];

		main[0][0] = "john";
		main[0][1] = "john123";
		main[0][2] = "English (Indian)";
		main[0][3] = "Invalid username or password";
		main[1][0] = "peter";
		main[1][1] = "peter123";
		main[1][2] = "Dutch";
		main[1][3] = "Invalid username or password";
		main[2][0] = "mark";
		main[2][1] = "mark123";
		main[2][2] = "Dutch";
		main[2][3] = "Invalid username or password";

		return main;

	}

}
