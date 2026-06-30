package com.bridgelabz.employeepayrollapp;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

// Employee class to store employee details
class Employee {

    private String empId;
    private String name;
    private String email;
    private String phoneNum;

    // User account
    private UserAccount account;

    // Parameterized constructor
    public Employee(String empId, String name, String email, String phoneNum, UserAccount account) {
        this.empId = empId;
        this.name = name;
        this.email = email;
        this.phoneNum = phoneNum;
        this.account = account;
    }

    // Display employee details
    @Override
    public String toString() {
        return "Employee Id = " + empId + '\n' +
                "Name = " + name + '\n' +
                "Email = " + email + '\n' +
                "Phone Number = " + phoneNum + '\n' +
                account;
    }

    // Save employee details into a text file
    public void persist() throws IOException {

        // Open file in append mode
        FileWriter fw = new FileWriter("employees.txt", true);

        // Write employee details into the file
        fw.write(toString());

        // Separator between employee records
        fw.write("\n-----------------\n");

        // Close file
        fw.close();
    }
}

// Class to store login details
class UserAccount {
    // Username and password
    private String username;
    private String password;

    // Constructor
    public UserAccount(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Display username
    @Override
    public String toString() {
        return "Username = " + username;
    }
}

// Validation class for input checking
class Validator {
    // Regular expression for Employee ID (Format: EMP-1234)
    private static final String EMP_ID_REGEX = "^EMP-[0-9]{4}$";

    // Regular expression for mobile number validation
    private static final String PHONE_NUM_REGEX = "^[6-9][0-9]{9}$";

    // Regular expression for Email validation
    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";

    // Method to validate email
    public static void validateEmail(String email) throws ValidationException {
        if (!email.matches(EMAIL_REGEX)) {
            throw new ValidationException("Invalid email");
        }
    }

    // Method to validate phone number
    public static void validatePhoneNum(String phoneNum) throws ValidationException {
        if (!phoneNum.matches(PHONE_NUM_REGEX)) {
            throw new ValidationException("Invalid Phone num");
        }
    }

    // Method to validate employee ID
    public static void validateEmpId(String empId) throws ValidationException {
        if (!empId.matches(EMP_ID_REGEX)) {
            throw new ValidationException("Invalid Emp Id");
        }
    }
}

// Custom validation exception class
class ValidationException extends Exception {
    // Constructor
    public ValidationException(String message) {
        super(message);
    }
}

// Main class
public class UseCase1EmployeeRegistrationApp {

    public static void main(String[] args) {

        System.out.println("===== USE CASE 1 : EMPLOYEE REGISTRATION =====");

        // Creating Scanner object
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("Enter EmpId : ");
            String empId = sc.nextLine();

            // Validate employee ID
            Validator.validateEmpId(empId);

            System.out.println("Enter Name : ");
            String name = sc.nextLine();

            System.out.println("Enter Email : ");
            String email = sc.nextLine();

            // Validate email
            Validator.validateEmail(email);

            System.out.println("Enter Phone Number : ");
            String phoneNum = sc.nextLine();

            // Validate phone number
            Validator.validatePhoneNum(phoneNum);

            System.out.println("Enter Username : ");
            String username = sc.nextLine();

            System.out.println("Enter Password : ");
            String password = sc.nextLine();

            // Create user account object
            UserAccount account = new UserAccount(username, password);

            // Create employee object
            Employee employee = new Employee(empId, name, email, phoneNum, account);

            // Store employee details in a file
            employee.persist();

            System.out.println("Employee Registered Successfully.");

            // Display employee information
            System.out.println(employee);

        }

        // Handle validation error
        catch (ValidationException e) {
            System.out.println(
                    "Validation Error : " + e.getMessage());
        }

        // Handle file error
        catch (IOException e) {
            System.out.println("File Error : " + e.getMessage());
        }
    }
}