package com.bridgelabz.employeepayrollapp;

import java.util.Scanner;

// Employee class to store employee details
class Employ {
    private String empId;
    private String empName;

    // Parameterized constructor
    public Employ(String empId, String empName) {
        this.empId = empId;
        this.empName = empName;
    }

    // Getters
    public String getEmpId() {
        return empId;
    }

    public String getEmpName() {
        return empName;
    }
}

// Class to store salary variables
class SalaryComponents {
    double basic;
    double hra;
    double da;
    double allowances;
    double pf;
    double tax;
    double netPay;

    // Constructor to initialize salary details
    public SalaryComponents(double basic, double hra, double da, double allowances) {
        this.basic = basic;
        this.hra = hra;
        this.da = da;
        this.allowances = allowances;
    }
}

// Class to generate and display payslip
class Payslip {
    private Employ employee;
    private SalaryComponents components;
    private String month;

    // Constructor to initialize payslip details
    public Payslip(Employ employee, SalaryComponents components, String month) {
        this.employee = employee;
        this.components = components;
        this.month = month;
    }

    // Method to display payslip details
    @Override
    public String toString() {
        return "\n=========== PAYSLIP ===========\n"
                + "Month        : " + month + "\n"
                + "Employee ID  : " + employee.getEmpId() + "\n"
                + "Employee Name: " + employee.getEmpName() + "\n\n"

                + "Basic Salary : " + components.basic + "\n"
                + "HRA          : " + components.hra + "\n"
                + "DA           : " + components.da + "\n"
                + "Allowances   : " + components.allowances + "\n\n"

                + "PF           : " + components.pf + "\n"
                + "Tax          : " + components.tax + "\n\n"

                + "Net Pay      : " + components.netPay + "\n"

                + "===============================\n";
    }
}

// Service class to calculate payroll
class PayrollService {

    // Method to generate payslip
    public Payslip generatePayslip(Employ employee, String month, double basic, double hra, double da, double allowances) {

        // Create salary component object
        SalaryComponents sc = new SalaryComponents(basic, hra, da, allowances);

        // Calculate gross salary
        double gross = basic + hra + da + allowances;

        // Calculate Provident Fund (12% of basic salary)
        sc.pf = basic * 0.12;

        // Calculate tax (10% of gross salary)
        sc.tax = gross * 0.10;

        // Calculate net salary
        sc.netPay = gross - (sc.pf + sc.tax);

        // Return generated payslip
        return new Payslip(employee, sc, month);
    }
}

// Main class
public class UseCase3PayslipApp {

    public static void main(String[] args) {

        // Creating Scanner object for user input
        Scanner sc = new Scanner(System.in);

        System.out.println("===== USE CASE 3 : PAYSLIP GENERATION =====");

        // Input employee details
        System.out.print("Enter Employee ID : ");
        String empId = sc.nextLine();

        System.out.print("Enter Employee Name : ");
        String empName = sc.nextLine();

        System.out.print("Enter Month : ");
        String month = sc.nextLine();

        // Input salary details
        System.out.print("Enter Basic Salary : ");
        double basic = sc.nextDouble();

        System.out.print("Enter HRA : ");
        double hra = sc.nextDouble();

        System.out.print("Enter DA : ");
        double da = sc.nextDouble();

        System.out.print("Enter Allowances : ");
        double allowances = sc.nextDouble();

        // Create employee object
        Employ employee = new Employ(empId, empName);

        // Create payroll service object
        PayrollService service = new PayrollService();

        // Generate payslip
        Payslip payslip = service.generatePayslip(employee, month, basic, hra, da, allowances);

        // Display payslip
        System.out.println(payslip);
    }
}