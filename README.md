# Employee Payroll App

A Java console-based application that demonstrates the implementation of an Employee Payroll Management System using Object-Oriented Programming (OOP) concepts. The project is developed incrementally through multiple use cases, covering employee registration, authentication, payroll generation, payslip management, dashboard display, and input validation. Each feature is implemented in a separate Git feature branch and merged into the development branch following a structured Git workflow.

---

## About the Project

The Employee Payroll App is designed to simulate a real-world payroll management system while reinforcing core Object-Oriented Programming concepts. The application demonstrates how enterprise applications are built by separating responsibilities into different modules and implementing concepts such as encapsulation, inheritance, polymorphism, abstraction, composition, aggregation, interfaces, exception handling, and file handling.

The implemented use cases are based on the BridgeLabz Employee Payroll App OOP scenarios and progressively enhance the application by introducing new functionalities and Java concepts. :contentReference[oaicite:1]{index=1}

---

## Project Highlights

- Employee Registration System
- Employee Authentication and Login
- Payslip Generation
- Payslip Download
- Employee Dashboard
- Input Validation using Custom Exceptions
- File Handling
- Object-Oriented Programming Concepts
- Feature Branch Git Workflow

---

## Use Cases Implemented

| Use Case | Description |
|----------|-------------|
| UC1 | Employee Registration with input validation and file persistence |
| UC2 | Employee Authentication and Login System |
| UC3 | Payslip Generation with payroll calculations |
| UC4 | Payslip Download with cloning and file generation |
| UC5 | Dashboard Display with payslip sorting and earnings summary |
| UC6 | Input Validation using Custom Exceptions |

---

## Technologies Used

- Java
- Object-Oriented Programming (OOP)
- Java Collections
- Stream API
- File Handling
- Exception Handling
- Regular Expressions (Regex)
- Git
- GitHub

---

## Project Structure

```text
Employee_Payroll_App/
│
├── src/
│   └── com/
│       └── bridgelabz/
│           └── employeepayrollapp/
│               ├── UseCase1EmployeeRegistrationApp.java
│               ├── UseCase2LoginApp.java
│               ├── UseCase3PayslipApp.java
│               ├── UseCase4PayslipDownloadApp.java
│               ├── UseCase5DashboardApp.java
│               └── UseCase6InputValidationApp.java
│
└── README.md
```

---

## Objectives

- Understand real-world Object-Oriented Programming concepts.
- Build an Employee Payroll Management System.
- Learn enterprise-level Java application development.
- Implement secure employee authentication.
- Generate and manage employee payslips.
- Handle exceptions using custom exception classes.
- Practice modular application development.
- Follow Git feature branch workflow.

---

## Learning Outcomes

After completing this project, you will be able to:

- Apply Object-Oriented Programming concepts in real-world applications.
- Implement employee registration and authentication.
- Generate payroll and payslips.
- Work with Java Collections and Stream API.
- Perform file handling operations.
- Design reusable and modular Java applications.
- Implement custom exception handling.
- Follow professional Git branching strategies.

---

## How to Run

### Clone the Repository

```bash
git clone https://github.com/Pavi512/Employee_Payroll_App.git
```

### Navigate to the Project

```bash
cd Employee_Payroll_App
```

### Compile

```bash
javac src/Main.java src/com/bridgelabz/employeepayrollapp/*.java
```

### Run

```bash
java -cp src Main
```

---

## Git Workflow

The project follows a feature branch workflow.

- `dev` – Development branch
- `feature/UC1` – Employee Registration
- `feature/UC2` – Employee Authentication & Login
- `feature/UC3` – Payslip Generation
- `feature/UC4` – Payslip Download
- `feature/UC5` – Dashboard Display
- `feature/UC6` – Input Validation

Each feature branch introduces a new use case and is merged into the `dev` branch after successful implementation and testing, ensuring incremental development and a clean Git history.

---

## OOP Concepts Demonstrated

- Encapsulation through employee data management
- Inheritance for user hierarchy
- Polymorphism using overridden methods
- Abstraction using abstract classes
- Composition between Employee and UserAccount
- Aggregation in Payslip management
- Interface implementation for dashboards
- Custom exception hierarchy for validation
- Stream API for data processing
- File handling for persistence and payslip generation

---

## Repository

This repository demonstrates the implementation of a complete Employee Payroll Management System using Java. Each use case introduces advanced Object-Oriented Programming concepts while solving real-world payroll management problems. It serves as a practical learning resource for Java, OOP, Collections, File Handling, Exception Handling, and enterprise application development.

---

## License

This project is intended for educational and learning purposes.

---

## Author

**Gondi Pavithra**

GitHub: https://github.com/Pavi512
