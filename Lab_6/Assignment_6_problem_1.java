package Lab_6;
import java.util.Scanner;
import Lab_6.dsa.LinkedList;

public class Assignment_6_problem_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList list = new LinkedList();

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Create a linked list");
            System.out.println("2. Display all elements in linked list");
            System.out.println("3. Search an item in linked list");
            System.out.println("4. Sort all elements in linked list");
            System.out.println("5. Insert a new item in linked list");
            System.out.println("6. Delete a particular item from linked list");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    
                    System.out.print("Enter the number of elements: ");
                    int n = scanner.nextInt();
                    System.out.println("Enter the elements:");
                    for (int i = 0; i < n; i++) {
                        int item = scanner.nextInt();
                        list.insert(item);
                    }
                    break;
                case 2:
                    
                    list.display();
                    break;
                case 3:
                
                    System.out.print("Enter the item to search: ");
                    int searchItem = scanner.nextInt();
                    if (list.search(searchItem)) {
                        System.out.println(searchItem + " found in the linked list.");
                    } else {
                        System.out.println(searchItem + " not found in the linked list.");
                    }
                    break;
                case 4:
                
                    list.sort();
                    System.out.println("Linked list sorted.");
                    break;
                case 5:
                  
                    System.out.print("Enter the item to insert: ");
                    int insertItem = scanner.nextInt();
                    list.insert(insertItem);
                    System.out.println(insertItem + " inserted into the linked list.");
                    break;
                case 6:
                    
                    System.out.print("Enter the item to delete: ");
                    int deleteItem = scanner.nextInt();
                    list.delete(deleteItem);
                    System.out.println(deleteItem + " deleted from the linked list.");
                    break;
                case 7:
                   
                    System.out.println("Exiting program.");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
            scanner.close();
        }
        
    }
}
