package com.bridgelabz.employeepayrollapp;

import java.util.Scanner;

// Exception class for all validation errors
class ValidationExceptions extends Exception {

    // Constructor
    public ValidationExceptions(String message) {
        super(message);
    }
}

// Custom Exception for invalid email
class EmailValidationException extends ValidationExceptions {

    public EmailValidationException(String message) {
        super(message);
    }
}

// Custom Exception for invalid phone number
class phoneValidationException extends ValidationExceptions {

    public phoneValidationException(String message) {
        super(message);
    }
}

// Custom Exception for invalid password
class passwordValidationException extends ValidationExceptions {

    public passwordValidationException(String message) {
        super(message);
    }
}

// Custom Exception for invalid employee ID
class EmployeeIdValidationException extends ValidationExceptions {

    public EmployeeIdValidationException(String message) {
        super(message);
    }
}

// Validation Service class
class ValidationService {

    // Removes leading and trailing spaces
    private static String sanitize(String input) {
        if (input == null) {
            return "";
        }

        // To remove unnecessary spaces
        return input.trim();
    }

    // Validate Email Address
    public static void validateEmail(String email)
            throws EmailValidationException {

        // Remove extra spaces
        email = sanitize(email);

        // Regular expression for Email validation
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";

        if (!email.matches(regex)) {
            throw new EmailValidationException("Invalid Email Address.");
        }
    }

    // Validate Phone Number
    public static void validatePhone(String phone)
            throws phoneValidationException {

        // Remove extra spaces
        phone = sanitize(phone);

        // Regular expression for mobile number validation
        String regex = "^[6-9][0-9]{9}$";

        if (!phone.matches(regex)) {
            throw new phoneValidationException("Invalid Phone Number. Must be 10 digits starting with 6-9.");
        }
    }

    // Validate Password
    public static void validatePassword(String password)
            throws passwordValidationException {

        // Remove extra spaces
        password = sanitize(password);

        // Password must contain:
        // 1 uppercase letter
        // 1 lowercase letter
        // 1 digit
        // 1 special character
        // Minimum 8 characters
        String regex = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@#$%^&+=!]).{8,}$";

        if (!password.matches(regex)) {
            throw new passwordValidationException("Password must contain uppercase, lowercase, digit, special character and minimum 8 characters.");
        }
    }

    // Validate Employee ID
    public static void validateEmployeeId(String empId)
            throws EmployeeIdValidationException {

        // Remove extra spaces
        empId = sanitize(empId);

        // Regular expression forEmployee ID (Format: EMP-1234)
        String regex = "^EMP-[0-9]{4}$";

        if (!empId.matches(regex)) {
            throw new EmployeeIdValidationException("Employee ID must be in EMP-XXXX format.");
        }
    }
}

// Main class
public class UseCase6InputValidationApp {

    public static void main(String[] args) {

        // Create Scanner object
        Scanner sc = new Scanner(System.in);

        System.out.println("===== USE CASE 6 : INPUT VALIDATION APP =====");

        try {
            System.out.println("Enter Employee ID : ");
            String empID = sc.next();

            // Validate employee ID
            ValidationService.validateEmployeeId(empID);

            System.out.println("Enter Email ID : ");
            String email = sc.next();

            // Validate email
            ValidationService.validateEmail(email);

            System.out.println("Enter Phone Number : ");
            String phonenum = sc.next();

            // Validate phone number
            ValidationService.validatePhone(phonenum);

            System.out.println("Enter Password : ");
            String password = sc.next();

            // Validate password
            ValidationService.validatePassword(password);

            System.out.println("\nValidation Succeeded.");
            System.out.println("Login/Register can proceed.");
        }

        // Handle validation exceptions
        catch (ValidationExceptions e) {
            System.out.println("\nValidation Failed.");
            System.out.println(e.getMessage());
        }
    }
}