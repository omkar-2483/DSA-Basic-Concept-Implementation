package ass5;
import java.util.Scanner;

class Employee {
    int empId;
    String empName;
    double empSalary;
    Employee next;

    public Employee(int id, String name, double salary) {
        empId = id;
        empName = name;
        empSalary = salary;
        next = null;
    }
}

class EmployeeLinkedList {
    private Employee head;

    public EmployeeLinkedList() {
        head = null;
    }

    // Insert an employee at the end of the list
    public void insert(Employee employee) {
        if (head == null) {
            head = employee;
        } else {
            Employee current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = employee;
        }
    }

    // Delete an employee by ID
    public void delete(int empId) {
        if (head == null) {
            System.out.println("List is empty. Deletion failed.");
            return;
        }

        if (head.empId == empId) {
            head = head.next;
            System.out.println("Employee with ID " + empId + " deleted.");
            return;
        }

        Employee current = head;
        while (current.next != null) {
            if (current.next.empId == empId) {
                current.next = current.next.next;
                System.out.println("Employee with ID " + empId + " deleted.");
                return;
            }
            current = current.next;
        }

        System.out.println("Employee with ID " + empId + " not found.");
    }

    // Search for an employee by ID
    public Employee search(int empId) {
        Employee current = head;
        while (current != null) {
            if (current.empId == empId) {
                return current;
            }
            current = current.next;
        }
        return null; // Employee not found
    }

    // Modify employee details by ID
    public void modify(int empId, String newName, double newSalary) {
        Employee employee = search(empId);
        if (employee != null) {
            employee.empName = newName;
            employee.empSalary = newSalary;
            System.out.println("Employee with ID " + empId + " modified.");
        } else {
            System.out.println("Employee with ID " + empId + " not found. Modification failed.");
        }
    }

    // Display the list of employees
    public void display() {
        Employee current = head;
        System.out.println("Employee List:");
        while (current != null) {
            System.out.println("ID: " + current.empId + ", Name: " + current.empName + ", Salary: " + current.empSalary);
            current = current.next;
        }
    }
}

public class LinkedList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        EmployeeLinkedList employeeList = new EmployeeLinkedList();
        System.out.println("!!!!  Welcome To the Program of Employee Data Management System !!!!");
        while (true) {
            System.out.println("\nEmployee Management System");
            System.out.println("1. Insert Employee data ");
            System.out.println("2. Delete Employee data");
            System.out.println("3. Search Employee data");
            System.out.println("4. Modify Employee data");
            System.out.println("5. Display Employee List");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Employee ID: ");
                    int id = sc.nextInt();
                    System.out.print("Enter Employee Name: ");
                    String name =sc.next();
                    System.out.print("Enter Employee Salary: ");
                    double salary = sc.nextDouble();
                    Employee newEmployee = new Employee(id, name, salary);
                    employeeList.insert(newEmployee);
                    System.out.println("Employee added successfully.");
                    break;

                case 2:
                    System.out.print("Enter Employee ID to delete: ");
                    int deleteId = sc.nextInt();
                    employeeList.delete(deleteId);
                    break;

                case 3:
                    System.out.print("Enter Employee ID to search: ");
                    int searchId = sc.nextInt();
                    Employee foundEmployee = employeeList.search(searchId);
                    if (foundEmployee != null) {
                        System.out.println("Employee found: ID: " + foundEmployee.empId +
                                ", Name: " + foundEmployee.empName + ", Salary: " + foundEmployee.empSalary);
                    } else {
                        System.out.println("Employee not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter Employee ID to modify: ");
                    int modifyId = sc.nextInt();
                    System.out.print("Enter New Employee Name: ");
                    sc.nextLine(); 
                    String newName = sc.nextLine();
                    System.out.print("Enter New Employee Salary: ");
                    double newSalary = sc.nextDouble();
                    employeeList.modify(modifyId, newName, newSalary);
                    break;

                case 5:
                    employeeList.display();
                    break;

                case 6:
                    System.out.println("Exiting program.");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

