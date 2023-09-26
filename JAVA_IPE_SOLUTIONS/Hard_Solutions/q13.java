
/* 
Problem Statement: Employee Management System
Implement an employee management system in Java using ArrayList and a class. The system should have the following functionalities:

Add an employee to the system
Remove an employee from the system
Update an employee's details
Display all employees in the system
To implement this system, you can create an Employee class with attributes such as name, age, salary, etc. Then, you can create an ArrayList to store all the employees. You can then implement functions to add, remove, update and display employees.
---------------------------------------------------------------*/
import java.util.ArrayList;
import java.util.Scanner;

class Employee {
    private String name;
    private int age;
    private double salary;

    public Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}

class EmployeeManagementSystem {
    private ArrayList<Employee> employees;
    private Scanner scanner;

    public EmployeeManagementSystem() {
        employees = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void addEmployee() {
        System.out.println("Enter employee name:");
        String name = scanner.nextLine();

        System.out.println("Enter employee age:");
        int age = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter employee salary:");
        double salary = Double.parseDouble(scanner.nextLine());

        Employee employee = new Employee(name, age, salary);
        employees.add(employee);

        System.out.println("Employee added successfully.");
    }

    public void removeEmployee() {
        System.out.println("Enter the index of the employee to remove:");
        int index = Integer.parseInt(scanner.nextLine());

        if (index >= 0 && index < employees.size()) {
            Employee employee = employees.get(index);
            employees.remove(index);
            System.out.println("Removed employee: " + employee.getName());
        } else {
            System.out.println("Invalid index!");
        }
    }

    public void updateEmployee() {
        System.out.println("Enter the index of the employee to update:");
        int index = Integer.parseInt(scanner.nextLine());

        if (index >= 0 && index < employees.size()) {
            Employee employee = employees.get(index);

            System.out.println("Enter new name (leave blank to keep the current name):");
            String newName = scanner.nextLine();
            if (!newName.isEmpty()) {
                employee.setName(newName);
            }

            System.out.println("Enter new age (leave blank to keep the current age):");
            String newAgeStr = scanner.nextLine();
            if (!newAgeStr.isEmpty()) {
                int newAge = Integer.parseInt(newAgeStr);
                employee.setAge(newAge);
            }

            System.out.println("Enter new salary (leave blank to keep the current salary):");
            String newSalaryStr = scanner.nextLine();
            if (!newSalaryStr.isEmpty()) {
                double newSalary = Double.parseDouble(newSalaryStr);
                employee.setSalary(newSalary);
            }

            System.out.println("Employee updated successfully.");
        } else {
            System.out.println("Invalid index!");
        }
    }

    public void displayEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees found.");
        } else {
            System.out.println("Employee List:");
            for (int i = 0; i < employees.size(); i++) {
                Employee employee = employees.get(i);
                System.out.println("Index: " + i + ", Name: " + employee.getName() + ", Age: " + employee.getAge()
                        + ", Salary: " + employee.getSalary());
            }
        }
    }

    public static void main(String[] args) {
        EmployeeManagementSystem system = new EmployeeManagementSystem();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Employee Management System Menu:");
            System.out.println("1. Add Employee");
            System.out.println("2. Remove Employee");
            System.out.println("3. Update Employee");
            System.out.println("4. Display Employees");
            System.out.println("0. Exit");
            System.out.println("Enter your choice:");

            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    system.addEmployee();
                    break;
                case 2:
                    system.removeEmployee();
                    break;
                case 3:
                    system.updateEmployee();
                    break;
                case 4:
                    system.displayEmployees();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
                    break;
            }

            System.out.println();
        } while (choice != 0);
    }
}