package com.bridgelabz.employeepayrollapp;

import java.io.FileWriter;
import java.io.IOException;

// ================= Immutable Payslip Class =================
final class Payslips implements Cloneable {
    // Final variables make the object immutable
    private final String empId;
    private final String empName;
    private final String month;
    private final double netPay;

    // Parameterized constructor
    public Payslips(String empId, String empName, String month, double netPay) {
        this.empId = empId;
        this.empName = empName;
        this.month = month;
        this.netPay = netPay;
    }

    // Getters
    public String getEmpId() {
        return empId;
    }

    public String getEmpName() {
        return empName;
    }

    public String getMonth() {
        return month;
    }

    public double getNetPay() {
        return netPay;
    }

    // Clone method to create a duplicate object
    @Override
    public Object clone() {
        return new Payslips(empId, empName, month, netPay);
    }

    // Compare two payslip objects
    @Override
    public boolean equals(Object obj) {
        // Same object reference return true
        if (this == obj) {
            return true;
        }

        // Check object type
        if (!(obj instanceof Payslips)) {
            return false;
        }

        // Type casting
        Payslips p = (Payslips) obj;

        // Compare employee ID and month
        return empId.equals(p.empId) && month.equals(p.month);
    }

    // Generate hash code
    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + empId.hashCode();
        result = 31 * result + month.hashCode();

        return result;
    }

    // Display payslip details
    @Override
    public String toString() {
        return "PAYSLIP\n"
                + "Employee ID   : " + empId + "\n"
                + "Employee Name : " + empName + "\n"
                + "Month         : " + month + "\n"
                + "Net Pay       : " + netPay + "\n";
    }
}

// Download Token Class
class DownloadToken {

    // Time when token is created
    private long createdTime;

    // Token validity period
    private long expiryMillis;

    // Constructor
    public DownloadToken() {

        // Store current system time
        createdTime = System.currentTimeMillis();

        // Token expires after 60 seconds
        expiryMillis = 60 * 1000;
    }

    // Check whether token is expired
    public boolean isExpired() {
        return System.currentTimeMillis() - createdTime > expiryMillis;
    }
}

// File Service Class
class FileService {

    // Save payslip as text file
    public String savePayslipAsText(Payslips payslip) throws IOException {

        String fileName = "Payslip_" + payslip.getEmpId() + "_" + System.currentTimeMillis() + ".txt";

        FileWriter fw = new FileWriter(fileName);
        fw.write(payslip.toString());
        fw.close();

        return fileName;
    }

    // Save payslip as PDF file
    public String savePayslipAsPdf(Payslips payslip) throws IOException {
        String fileName = "Payslip_" + payslip.getEmpId() + "_" + System.currentTimeMillis() + ".pdf";

        FileWriter fw = new FileWriter(fileName);
        fw.write(payslip.toString());
        fw.close();

        return fileName;
    }
}

// ================= Main Class =================
public class UseCase4PayslipDownloadApp {

    public static void main(String[] args) {

        System.out.println("===== USE CASE 4 : PAYSLIP DOWNLOAD =====");

        // Create original immutable payslip
        Payslips original = new Payslips("EMP-1010", "Pavi", "January 2026", 50000);

        // Display original object
        System.out.println("\nOriginal Payslip");
        System.out.println(original);

        // Clone the payslip object
        Payslips copy = (Payslips) original.clone();

        System.out.println("Clone Created Successfully.");

        // Compare original and clone
        System.out.println("Equals : " + original.equals(copy));

        // Display hash codes
        System.out.println("Hash Original : " + original.hashCode());
        System.out.println("Hash Clone : " + copy.hashCode());

        // Create download token
        DownloadToken token = new DownloadToken();

        // Check token validity
        if (token.isExpired()) {
            System.out.println("Download Token Expired.");
            return;
        }

        // Create file service object
        FileService service = new FileService();

        try {
            // Save payslip as text file
            String txt = service.savePayslipAsText(copy);

            // Save payslip as PDF file
            String pdf = service.savePayslipAsPdf(copy);

            System.out.println("\nPayslip Saved Successfully.");

            System.out.println("Text File : " + txt);

            System.out.println("PDF File  : " + pdf);

        }
        //To handle file errors
        catch (IOException e) {
            System.out.println("File Error : " + e.getMessage());
        }
        System.out.println("\n--- Printed Payslip---");
        System.out.println(copy);

    }
}