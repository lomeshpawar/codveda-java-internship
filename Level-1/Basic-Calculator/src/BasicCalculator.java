import java.util.Scanner;

public class BasicCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Basic Calculator ===");
        System.out.print("Enter first number: ");
        double a = scanner.nextDouble();

        System.out.print("Enter operator (+, -, *, /, %): ");
        char operator = scanner.next().charAt(0);

        System.out.print("Enter second number: ");
        double b = scanner.nextDouble();

        double result;

        switch (operator) {
            case '+':
                result = a + b;
                break;
            case '-':
                result = a - b;
                break;
            case '*':
                result = a * b;
                break;
            case '/':
                if (b == 0) {
                    System.out.println("Error: Cannot divide by zero.");
                    scanner.close();
                    return;
                }
                result = a / b;
                break;
            case '%':
                if (b == 0) {
                    System.out.println("Error: Cannot use modulo with zero.");
                    scanner.close();
                    return;
                }
                result = a % b;
                break;
            default:
                System.out.println("Invalid operator.");
                scanner.close();
                return;
        }

        System.out.println("Result = " + result);
        scanner.close();
    }
}
