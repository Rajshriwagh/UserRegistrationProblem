package com.userregistrationproblem;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserRegistration {
	private static final Logger logger = LogManager.getLogger(App.class);
	Scanner scannerObject = new Scanner(System.in);
	User userObject = new User();

	String namePatternMatcher(String value) {
		Pattern patternObject = Pattern.compile("^[A-Z]{1}[a-z]{3,}");
		Matcher matchObject = patternObject.matcher(value);
		if (matchObject.matches()) {
			return "valid";
		} else {
			return "invalid";
		}
	}

	void UserRegistrationMain() {

		logger.info("Please enter first name: ");
		String firstName = scannerObject.nextLine();
		String validInvalidFirstName = namePatternMatcher(firstName);
		if (validInvalidFirstName.equals("valid")) {
			userObject.setFirstName(firstName);
			logger.info(userObject.getFirstName());
		}

		scannerObject.close();
	}

}
