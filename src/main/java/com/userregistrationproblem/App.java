package com.userregistrationproblem;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class App {
	private static final Logger logger = LogManager.getLogger(App.class);

	public static void main(String[] args) throws InvalidInputException {
		logger.info("Regex Practise Problem");
		UserRegistration userRegistrationObject = new UserRegistration();
		userRegistrationObject.UserRegistrationMain();
	}
}