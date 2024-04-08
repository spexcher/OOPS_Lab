package Lab_5;
import java.util.Scanner;
import Lab_5.dsa.Array;

public class Assignment_5_problem_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        Array array = new Array(10); // Assuming initial capacity of the array as 10

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Input all elements in the array");
            System.out.println("2. Display all elements in array");
            System.out.println("3. Search an item in array");
            System.out.println("4. Sort all elements in array");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the number of elements: ");
                    int n = scanner.nextInt();
                    System.out.println("Enter the elements:");
                    for (int i = 0; i < n; i++) {
                        int element = scanner.nextInt();
                        array.insert(element);
                    }
                    break;
                case 2:
         array.display();
                    break;
                case 3:
                    System.out.print("Enter the element to search: ");
                    int searchElement = scanner.nextInt();
                    if (array.search(searchElement)) {
                        System.out.println("Element found in the array.");
                    } else {
                        System.out.println("Element not found in the array.");
                    }
                    break;
                case 4:
                    array.sort();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);

        scanner.close();
    }
}
