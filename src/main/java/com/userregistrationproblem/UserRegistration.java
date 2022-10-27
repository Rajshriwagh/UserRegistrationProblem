package com.userregistrationproblem;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@FunctionalInterface
interface patternMatcher {
    boolean pattern(String value, String pattern);
}

public class UserRegistration {
    private static final Logger logger = LogManager.getLogger(App.class);
    Scanner scannerObject = new Scanner(System.in);
    User userObject = new User();

    patternMatcher patternChecker = (value, pattern) -> {
        Pattern patternObject = Pattern.compile(pattern);
        Matcher matchObject = patternObject.matcher(value);
        if (matchObject.matches()) {
            return true;
        } else {
            return false;
        }
    };

    void UserRegistrationMain() throws InvalidInputException {
        Boolean isValid;

        try {
            logger.info("Please enter first name: ");
            String firstName = scannerObject.nextLine();
            isValid = patternChecker.pattern(firstName, "^[A-Z]{1}[a-z]{3,}");
            if (isValid) {
                userObject.setFirstName(firstName);
                logger.info(userObject.getFirstName());
            } else {
                throw new InvalidInputException();
            }

            logger.info("Please enter last name: ");
            String lastName = scannerObject.nextLine();
            isValid = patternChecker.pattern(lastName, "^[A-Z]{1}[a-z]{3,}");
            if (isValid) {
                userObject.setLastName(lastName);
                logger.info(userObject.getLastName());
            } else {
                throw new InvalidInputException();
            }

            logger.info("Please enter Email Id: ");
            String emailId = scannerObject.nextLine();

            isValid = patternChecker.pattern(emailId, "^[a-z]{1}[a-zA-Z0-9+-.]*@[a-z0-9]*.[a-z]*(.[a-z]*?)$");
            if (isValid) {
                userObject.setEmailId(emailId);
                logger.info(userObject.getEmailId());
            } else {
                throw new InvalidInputException();
            }

            logger.info("Please enter Phone number: ");
            String phoneNumber = scannerObject.nextLine();
            isValid = patternChecker.pattern(phoneNumber, "^[91]{2}[ ]{1}[0-9]{10}$");
            if (isValid) {
                userObject.setPhoneNumber(phoneNumber);
                logger.info(userObject.getPhoneNumber());
            } else {
                throw new InvalidInputException();
            }

            logger.info("Please enter Password: ");
            String password = scannerObject.nextLine();
            isValid = patternChecker.pattern(password, "^(?=.*[a-z])(?=.*[A-Z])((?=.*[!@#&?/*~$^]{1})).{8,}$");
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
