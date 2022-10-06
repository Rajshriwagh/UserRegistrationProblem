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

	Boolean namePatternMatcher(String value) {
		Pattern patternObject = Pattern.compile("^[A-Z]{1}[a-z]{3,}");
		Matcher matchObject = patternObject.matcher(value);
		if (matchObject.matches()) {
			return true;
		} else {
			return false;
		}
	}

	Boolean emailPatternMatcher(String value) {
		Pattern patternObject = Pattern.compile("^[a-z]{1}[a-zA-Z0-9+-.]*@[a-z0-9]*.[a-z]*(.[a-z]*?)$");
		// ^[a-z]{1}[a-zA-Z.]*@[a-z]{2}.[a-z]{2}[a-z.]?
		Matcher matchObject = patternObject.matcher(value);
		if (matchObject.matches()) {
			return true;
		} else {
			return false;
		}
	}

	Boolean phoneNumberPatternMatcher(String value) {
		Pattern patternObject = Pattern.compile("^[91]{2}[ ]{1}[0-9]{10}$");
		Matcher matchObject = patternObject.matcher(value);
		if (matchObject.matches()) {
			return true;
		} else {
			return false;
		}
	}

	Boolean passwordPatternMatcher(String value) {
		Pattern patternObject = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])((?=.*[!@#&–?/*~$^]{1})).{8,}$");
		Matcher matchObject = patternObject.matcher(value);
		if (matchObject.matches()) {
			return true;
		} else {
			return false;
		}
	}

	void UserRegistrationMain() throws InvalidInputException {
		Boolean isValid;

		try {
			logger.info("Please enter first name: ");
			String firstName = scannerObject.nextLine();
			isValid = namePatternMatcher(firstName);
			if (isValid) {
				userObject.setFirstName(firstName);
				logger.info(userObject.getFirstName());
			} else {
				throw new InvalidInputException();
			}

			logger.info("Please enter last name: ");
			String lastName = scannerObject.nextLine();
			isValid = namePatternMatcher(lastName);
			if (isValid) {
				userObject.setLastName(lastName);
				logger.info(userObject.getLastName());
			} else {
				throw new InvalidInputException();
			}

			logger.info("Please enter Email Id: ");
			String emailId = scannerObject.nextLine();
			isValid = emailPatternMatcher(emailId);
			if (isValid) {
				userObject.setEmailId(emailId);
				logger.info(userObject.getEmailId());
			} else {
				throw new InvalidInputException();
			}

			logger.info("Please enter Phone number: ");
			String phoneNumber = scannerObject.nextLine();
			isValid = phoneNumberPatternMatcher(phoneNumber);
			if (isValid) {
				userObject.setPhoneNumber(phoneNumber);
				logger.info(userObject.getPhoneNumber());
			} else {
				throw new InvalidInputException();
			}

			logger.info("Please enter Password: ");
			String password = scannerObject.nextLine();
			isValid = passwordPatternMatcher(password);
			if (isValid) {
				userObject.setPassword(password);
				logger.info(userObject.getPassword());
			} else {
				throw new InvalidInputException();
			}
		} catch (InvalidInputException e) {
			logger.info("Invalid Input detected!");
		}
		scannerObject.close();
	}

}
