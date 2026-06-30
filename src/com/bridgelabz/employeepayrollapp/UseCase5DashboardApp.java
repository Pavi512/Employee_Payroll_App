package com.bridgelabz.employeepayrollapp;

import java.util.*;

// Class to store payslip details
class PaySlip {
    private String month;
    private double netPay;

    // Constructor
    public PaySlip(String month, double netPay) {
        this.month = month;
        this.netPay = netPay;
    }

    // Getters
    public String getMonth() {
        return month;
    }

    public double getNetPay() {
        return netPay;
    }

    // Display payslip details
    @Override
    public String toString() {
        return month + " : " + netPay;
    }
}

// Class to store employee details
class Employees {
    private String empId;
    private String name;

    // Constructor
    public Employees(String empId, String name) {
        this.empId = empId;
        this.name = name;
    }

    // Getters
    public String getEmpId() {
        return empId;
    }

    public String getName() {
        return name;
    }
}

// Dashboard interface
interface Dashboard {
    // Method to display dashboard
    void display(ArrayList<PaySlip> payslips, Employees employee);
}

// Employee dashboard implementation
class EmployeeDashboard implements Dashboard {

    @Override
    public void display(ArrayList payslips, Employees employee) {

        System.out.println("\n===== EMPLOYEE DASHBOARD =====");

        System.out.println("Welcome, " + employee.getName());

        // Runtime class information
        System.out.println("Dashboard Type: " + this.getClass().getName());

        // Sort payslips based on highest salary
        Collections.sort(payslips, new Comparator<PaySlip>() {

            @Override
            public int compare(PaySlip p1, PaySlip p2) {
                return Double.compare(p2.getNetPay(), p1.getNetPay());
            }
        });

        System.out.println("\nRecent Payslips (Top 3):");

        int count = 0;
        Iterator it = payslips.iterator();

        // Display top 3 payslips
        while (it.hasNext() && count < 3) {
            PaySlip p = (PaySlip) it.next();
            System.out.println(p);
            count++;
        }

        // Calculate total earnings
        double total = 0;
        Iterator it2 = payslips.iterator();

        while (it2.hasNext()) {
            PaySlip p = (PaySlip) it2.next();
            total += p.getNetPay();
        }

        System.out.println("\nYear-To-Date Earnings: " + total);
    }
}

// Manager dashboard implementation
class ManagerDashboard implements Dashboard {

    @Override
    public void display(ArrayList payslips, Employees employee) {

        System.out.println("\n===== MANAGER DASHBOARD =====");

        System.out.println("Welcome, " + employee.getName());

        // Runtime class information
        System.out.println("Dashboard Type: " + this.getClass().getName());

        double total = 0;

        Iterator it = payslips.iterator();

        // Calculate total payroll
        while (it.hasNext()) {
            PaySlip p = (PaySlip) it.next();
            total += p.getNetPay();
        }

        System.out.println("\nTotal Payroll: " + total);
        System.out.println("Number of Payslips: " + payslips.size());
        System.out.println("Average Salary: " + (total / payslips.size()));
    }
}

// Class to create dashboard objects
class DashboardFactory {
    public static Dashboard getDashboard(String role) {
        // Create employee dashboard
        if ("EMPLOYEE".equalsIgnoreCase(role)) {
            return new EmployeeDashboard();
        }

        // Create manager dashboard
        else if ("MANAGER".equalsIgnoreCase(role)) {
            return new ManagerDashboard();
        }

        return null;
    }
}

// Main class
public class UseCase5DashboardApp {

    public static void main(String[] args) {

        // Scanner object for input
        Scanner sc = new Scanner(System.in);

        System.out.println("===== USE CASE 5: DASHBOARD DISPLAY =====");

        System.out.print("Enter Employee ID: ");
        String empId = sc.nextLine();

        System.out.print("Enter Employee Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Role (EMPLOYEE/MANAGER): ");
        String role = sc.nextLine();

        // Create employee object
        Employees employee = new Employees(empId, name);

        // Create payslip list
        ArrayList<PaySlip> payslips = new ArrayList<>();

        // Dummy payslips
        payslips.add(new PaySlip("Jan", 50000));
        payslips.add(new PaySlip("Feb", 52000));
        payslips.add(new PaySlip("Mar", 51000));
        payslips.add(new PaySlip("Apr", 53000));
        payslips.add(new PaySlip("May", 54000));

        // Get dashboard object
        Dashboard dashboard = DashboardFactory.getDashboard(role);

        // Display dashboard
        if (dashboard != null) {
            dashboard.display(payslips, employee);
        }
        else {
            System.out.println("Invalid Role.");
        }
    }
}