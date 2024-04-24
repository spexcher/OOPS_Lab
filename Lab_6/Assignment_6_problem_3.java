
package Lab_6;

import java.util.Scanner;

public class Assignment_6_problem_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue queue = new Queue();

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Insert a new item");
            System.out.println("2. Delete item");
            System.out.println("3. Display all elements");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter the item to insert: ");
                    int insertItem = scanner.nextInt();
                    try {
                        queue.insert(insertItem);
                        System.out.println("Item inserted successfully.");
                    } catch (MyException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 2:
                    try {
                        int deletedItem = queue.delete();
                        System.out.println("Deleted item: " + deletedItem);
                    } catch (MyException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        queue.display();
                    } catch (MyException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 4:
                    System.out.println("Exiting program.");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
            scanner.close();
        }
        
    }
}
