package com.bridgelabz.employeepayrollapp;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// Abstract User class
abstract class User {

    // Username of the user
    protected String username;

    // Hashed password for security
    protected String passwordHash;

    // Role of the user
    protected String role;

    // Constructor to initialize user details
    public User(String username, String password, String role) {
        this.username = username;
        this.passwordHash = PasswordUtil.hash(password);
        this.role = role;
    }

    // Abstract method for authentication
    public abstract boolean authenticate(String username, String password);

    // Getters
    public String getRole() {
        return role;
    }

    public String getUsername() {
        return username;
    }
}

// Utility class for password hashing
class PasswordUtil {
    // Converts password into hashed format
    public static String hash(String password) {
        return Integer.toHexString(password.hashCode());
    }
}

// Employee user class
class RegularEmployee extends User {

    // Constructor
    public RegularEmployee(String username, String password) {
        super(username, password, "EMPLOYEE");
    }

    // Authenticate employee credentials
    @Override
    public boolean authenticate(String username, String password) {
        return this.username.equals(username) && this.passwordHash.equals(PasswordUtil.hash(password));
    }
}

// Manager user class
class Manager extends User {

    // Constructor
    public Manager(String username, String password) {
        super(username, password, "MANAGER");
    }

    // Authenticate manager credentials
    @Override
    public boolean authenticate(String username, String password) {
        return this.username.equals(username) && this.passwordHash.equals(PasswordUtil.hash(password));
    }
}

// Session class to maintain login time
class Session {

    // Username of logged-in user
    private String username;

    // Login time in milliseconds
    private long loginTime;

    // Session timeout duration
    private long timeoutMillis;

    // Constructor
    public Session(String username) {
        this.username = username;

        // Store current login time
        this.loginTime = System.currentTimeMillis();

        // Session timeout set to 5 minutes
        this.timeoutMillis = 5 * 60 * 1000;
    }

    // Check whether session is expired
    public boolean isExpired() {
        long currentTime = System.currentTimeMillis();

        return (currentTime - loginTime) > timeoutMillis;
    }

    // Display session information
    @Override
    public String toString() {
        return "Session active for user: " + username;
    }
}

// Authentication Service class
class AuthenticationService {

    // Map to store users data
    private Map<String, User> users = new HashMap<String, User>();

    // Maximum login attempts
    private int maxAttempts = 3;

    // Constructor
    public AuthenticationService() {
        //Dummy users
        users.put("Pavi", new RegularEmployee("Pavi", "Pavi@123"));
        users.put("Bridgelabz", new Manager("Bridgelabz", "Bridgelabz@4321"));
    }

    // Method for user login
    public Session login() {

        Scanner sc = new Scanner(System.in);

        int attempts = 0;

        // Loop runs until maximum attempts reached
        while (attempts < maxAttempts) {
            System.out.print("\nEnter Username: ");
            String username = sc.nextLine();

            System.out.print("Enter Password: ");
            String password = sc.nextLine();

            // Get user from map
            User user = users.get(username);

            // Verify credentials
            if (user != null && user.authenticate(username, password)) {
                System.out.println("\nLogin Successful!");
                System.out.println("Role: " + user.getRole());

                // Display dashboard based on role
                showDashboard(user.getRole());

                // Create session
                return new Session(username);
            }

            // Failed attempts incrementation
            attempts++;

            System.out.println("Invalid Credentials!");
            System.out.println("Remaining Attempts: " + (maxAttempts - attempts));
        }

        // Print if Maximum attempts exceeded
        System.out.println("Maximum login attempts exceeded.");
        return null;
    }

    // Display dashboard according to role
    private void showDashboard(String role) {
        System.out.println("\n======== DASHBOARD ========");

        // Employee dashboard
        if (role.equals("EMPLOYEE")) {
            System.out.println("Employee Dashboard");
            System.out.println("View Payslip | Update Profile");
        }
        // Manager dashboard
        else if (role.equals("MANAGER")) {
            System.out.println("Manager Dashboard");
            System.out.println("Approve Leave | Manage Employees");
        }
    }
}

// Main class
public class UseCase2LoginApp {

    public static void main(String[] args) {

        System.out.println("===== USE CASE 2 : EMPLOYEE AUTHENTICATION & LOGIN =====");

        // Create authentication service object
        AuthenticationService auth = new AuthenticationService();

        // User Login
        Session session = auth.login();

        // Check if session is valid
        if (session != null) {
            System.out.println(session);
            if (!session.isExpired()) {
                System.out.println("\nSession active and valid.");
            }
            else {
                System.out.println("\nSession expired.");
            }
        }
    }
}