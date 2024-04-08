package Lab_3;

import java.util.*;
import java.util.function.Consumer;

class BankAccount {
    String accountHolderName;
    int accountNumber;
    String accountType;
    double balance;

    public BankAccount(String name, int number, String type, double initialBalance) {
        accountHolderName = name;
        accountNumber = number;
        accountType = type;
        balance = initialBalance;
    }

    public void displayAccountInfo() {
        System.out.println("Account Holder Name: " + accountHolderName);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Type: " + accountType);
        System.out.println("Balance: $" + balance);
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposit of $" + amount + " successful.");
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal of $" + amount + " successful.");
        } else {
            System.out.println("Insufficient balance.");
        }
    }
}

class AccountList {
    ArrayList<BankAccount> accounts = new ArrayList<>();

    public void addAccount(String name, int number, String type, double initialBalance) {
        BankAccount account = new BankAccount(name, number, type, initialBalance);
        accounts.add(account);
        System.out.println("Account added successfully.");
    }

    public void displayAllAccounts() {
        for (BankAccount account : accounts) {
            account.displayAccountInfo();
            System.out.println();
        }
    }

    public BankAccount searchByAccountNumber(int accountNumber) {
        for (BankAccount account : accounts) {
            if (account.accountNumber == accountNumber) {
                return account;
            }
        }
        return null;
    }

    public void deleteAccount(int accountNumber) {
        BankAccount account = searchByAccountNumber(accountNumber);
        if (account != null) {
            accounts.remove(account);
            System.out.println("Account deleted successfully.");
        } else {
            System.out.println("Account not found.");
        }
    }

    public void sortByAccountNumber() {
        Collections.sort(accounts, Comparator.comparingInt(a -> a.accountNumber));
        System.out.println("Accounts sorted by account number.");
    }
}

public class Assignment_3_problem_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AccountList accountList = new AccountList();

        while (true) {
            System.out.println("\nBank Management System Menu:");
            System.out.println("1. Add Account");
            System.out.println("2. Display All Accounts");
            System.out.println("3. Search by Account Number");
            System.out.println("4. Delete Account");
            System.out.println("5. Sort Accounts by Account Number");
            System.out.println("6. Quit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Account Holder Name: ");
                    String name = scanner.next();
                    System.out.print("Enter Account Number: ");
                    int number = scanner.nextInt();
                    System.out.print("Enter Account Type (rdf saving or current): ");
                    String type = scanner.next();
                    System.out.print("Enter Initial Balance: ");
                    double initialBalance = scanner.nextDouble();
                    accountList.addAccount(name, number, type, initialBalance);
                    break;
                case 2:
                    accountList.displayAllAccounts();
                    break;
                case 3:
                    System.out.print("Enter Account Number to search: ");
                    int searchNumber = scanner.nextInt();
                    BankAccount account = accountList.searchByAccountNumber(searchNumber);
                    if (account != null) {
                        account.displayAccountInfo();
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;
                case 4:
                    System.out.print("Enter Account Number to delete: ");
                    int deleteNumber = scanner.nextInt();
                    accountList.deleteAccount(deleteNumber);
                    break;
                case 5:
                    accountList.sortByAccountNumber();
                    break;
                case 6:
                    scanner.close();
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    scanner.close();
                    System.out.println("Invalid choice. Please enter a number between 1 and 6.");
            }

        }

    }
}
