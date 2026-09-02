import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BankingApplication {
    private static final Map<String, BankAccount> accounts = new HashMap<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=== Banking Application ===");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. View Account");
            System.out.println("6. Exit");
            System.out.print("Choose: ");

            switch (readInt()) {
                case 1 -> createAccount();
                case 2 -> deposit();
                case 3 -> withdraw();
                case 4 -> checkBalance();
                case 5 -> viewAccount();
                case 6 -> {
                    System.out.println("Thank you!");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private static void createAccount() {
        System.out.print("Account number: ");
        String number = scanner.nextLine().trim();

        if (accounts.containsKey(number)) {
            System.out.println("Account already exists.");
            return;
        }

        System.out.print("Holder name: ");
        String name = scanner.nextLine().trim();
        System.out.print("Initial deposit: ");
        double amount = readDouble();

        accounts.put(number, new BankAccount(number, name, amount));
        System.out.println("Account created successfully.");
    }

    private static BankAccount getAccount() {
        System.out.print("Account number: ");
        BankAccount account = accounts.get(scanner.nextLine().trim());
        if (account == null) System.out.println("Account not found.");
        return account;
    }

    private static void deposit() {
        BankAccount account = getAccount();
        if (account == null) return;

        System.out.print("Amount: ");
        double amount = readDouble();

        System.out.println(account.deposit(amount)
                ? "Deposit successful."
                : "Invalid amount.");
    }

    private static void withdraw() {
        BankAccount account = getAccount();
        if (account == null) return;

        System.out.print("Amount: ");
        double amount = readDouble();

        System.out.println(account.withdraw(amount)
                ? "Withdrawal successful."
                : "Invalid amount or insufficient balance.");
    }

    private static void checkBalance() {
        BankAccount account = getAccount();
        if (account != null) {
            System.out.printf("Current balance: %.2f%n", account.getBalance());
        }
    }

    private static void viewAccount() {
        BankAccount account = getAccount();
        if (account != null) System.out.println(account);
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
                if (value < 0) throw new NumberFormatException();
                return value;
            } catch (NumberFormatException e) {
                System.out.print("Enter a valid non-negative number: ");
            }
        }
    }
}
