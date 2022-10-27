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

    String emailPatternMatcher(String value) {
        Pattern patternObject = Pattern.compile("^[a-z]{1}[a-zA-Z0-9+-.]*@[a-z0-9]*.[a-z]*(.[a-z]*?)$");
        // ^[a-z]{1}[a-zA-Z.]*@[a-z]{2}.[a-z]{2}[a-z.]?
        Matcher matchObject = patternObject.matcher(value);
        if (matchObject.matches()) {
            return "valid";
        } else {
            return "invalid";
        }
    }

    void UserRegistrationMain() {
        String validInvalidFirstName = "invalid";
        String validInvalidLastName = "invalid";
        String validInvalidEmail = "invalid";

        while ((validInvalidFirstName.equals("invalid"))) {
            logger.info("Please enter first name: ");
            String firstName = scannerObject.nextLine();
            validInvalidFirstName = namePatternMatcher(firstName);
            if (validInvalidFirstName.equals("valid")) {
                userObject.setFirstName(firstName);
                logger.info(userObject.getFirstName());
            } else {
                logger.info("Invalid input!! Please try again");
            }
        }
        while ((validInvalidLastName.equals("invalid"))) {
            logger.info("Please enter last name: ");
            String lastName = scannerObject.nextLine();
            validInvalidLastName = namePatternMatcher(lastName);
            if (validInvalidLastName.equals("valid")) {
                userObject.setLastName(lastName);
                logger.info(userObject.getLastName());
            } else {
                logger.info("Invalid input!! Please try again");
            }
        }

        while ((validInvalidEmail.equals("invalid"))) {
            logger.info("Please enter Email Id: ");
            String emailId = scannerObject.nextLine();
            validInvalidEmail = emailPatternMatcher(emailId);
            if (validInvalidLastName.equals("valid")) {
                userObject.setEmailId(emailId);
                logger.info(userObject.getEmailId());
            } else {
                logger.info("Invalid input!! Please try again");
            }
        }

        scannerObject.close();
    }

}
