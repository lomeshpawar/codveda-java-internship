import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeManagementSystem {
    private static final ArrayList<Employee> employees = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=== Employee Management System ===");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Search Employee");
            System.out.println("4. Update Employee");
            System.out.println("5. Delete Employee");
            System.out.println("6. Exit");
            System.out.print("Choose: ");

            int choice = readInt();

            switch (choice) {
                case 1 -> addEmployee();
                case 2 -> viewEmployees();
                case 3 -> searchEmployee();
                case 4 -> updateEmployee();
                case 5 -> deleteEmployee();
                case 6 -> {
                    System.out.println("Goodbye!");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private static void addEmployee() {
        System.out.print("ID: ");
        int id = readInt();

        if (id <= 0) {
            System.out.println("Employee ID must be positive.");
            return;
        }

        if (findById(id) != null) {
            System.out.println("Employee ID already exists.");
            return;
        }

        System.out.print("Name: ");
        String name = scanner.nextLine().trim();
        if (name.isBlank()) {
            System.out.println("Name is required.");
            return;
        }

        System.out.print("Department: ");
        String department = scanner.nextLine().trim();
        if (department.isBlank()) {
            System.out.println("Department is required.");
            return;
        }

        System.out.print("Salary: ");
        double salary = readDouble();

        employees.add(new Employee(id, name, department, salary));
        System.out.println("Employee added.");
    }

    private static void viewEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees found.");
            return;
        }
        employees.forEach(System.out::println);
    }

    private static void searchEmployee() {
        System.out.print("Enter employee ID: ");
        Employee employee = findById(readInt());
        System.out.println(employee == null ? "Employee not found." : employee);
    }

    private static void updateEmployee() {
        System.out.print("Enter employee ID: ");
        Employee employee = findById(readInt());

        if (employee == null) {
            System.out.println("Employee not found.");
            return;
        }

        System.out.print("New name: ");
        String name = scanner.nextLine().trim();
        if (name.isBlank()) {
            System.out.println("Name is required.");
            return;
        }

        System.out.print("New department: ");
        String department = scanner.nextLine().trim();
        if (department.isBlank()) {
            System.out.println("Department is required.");
            return;
        }

        System.out.print("New salary: ");
        double salary = readDouble();

        employee.setName(name);
        employee.setDepartment(department);
        employee.setSalary(salary);
        System.out.println("Employee updated.");
    }

    private static void deleteEmployee() {
        System.out.print("Enter employee ID: ");
        Employee employee = findById(readInt());

        if (employee == null) {
            System.out.println("Employee not found.");
            return;
        }

        employees.remove(employee);
        System.out.println("Employee deleted.");
    }

    private static Employee findById(int id) {
        for (Employee employee : employees) {
            if (employee.getId() == id) return employee;
        }
        return null;
    }

    private static int readInt() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Enter a valid integer: ");
            }
        }
    }

    private static double readDouble() {
        while (true) {
            try {
                double value = Double.parseDouble(scanner.nextLine().trim());
                if (!Double.isFinite(value) || value < 0) throw new NumberFormatException();
                return value;
            } catch (NumberFormatException e) {
                System.out.print("Enter a valid non-negative number: ");
            }
        }
    }
}
