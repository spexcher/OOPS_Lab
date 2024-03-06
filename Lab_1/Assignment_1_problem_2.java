package Lab_1;

import java.util.*;

class Student {
    String name;
    int rollNumber;
    String department;
    double averageMarks;

    public Student(String name, int rollNumber, String department, double averageMarks) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.department = department;
        this.averageMarks = averageMarks;
    }

    public void display() {
        System.out.println("Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Department: " + department);
        System.out.println("Average Marks: " + averageMarks);
    }

    public boolean searchByRollNumber(int rollNumber) {
        return this.rollNumber == rollNumber;
    }

    // public static Comparator<Student> comparator2 = (A, B) ->
    // Integer.compare(A.rollNumber, B.rollNumber);
    public static Comparator<Student> comparator = new Comparator<Student>() {
        @Override
        public int compare(Student A, Student B) {
            return A.rollNumber - B.rollNumber;
        }
    };

}

public class Assignment_1_problem_2 {
    static Scanner scanner = new Scanner(System.in);
    static Student[] students = new Student[500000];
    static int size = 0;

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            System.out.println("\nMenu:");
            System.out.println("1. Add a new student record");
            System.out.println("2. Display all student records");
            System.out.println("3. Search student by roll number");
            System.out.println("4. Delete a student record");
            System.out.println("5. Arrange student records by roll number");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addStudentRecord();
                    break;
                case 2:
                    displayAllStudents();
                    break;
                case 3:
                    searchStudentByRollNumber();
                    break;
                case 4:
                    deleteStudentRecord();
                    break;
                case 5:
                    arrangeStudentByRollNumber();
                    break;
                case 6:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
        scanner.close();
    }

    public static void arrangeStudentByRollNumber() {
        Arrays.sort(students, 0, size, Student.comparator);
        System.out.println("Students arranged by roll number.");
    }

    public static void addStudentRecord() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter roll number: ");
        int rollNumber = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter department: ");
        String department = scanner.nextLine();
        System.out.print("Enter average marks: ");
        double averageMarks = scanner.nextDouble();
        scanner.nextLine();

        Student student = new Student(name, rollNumber, department, averageMarks);
        students[size++] = student;
        System.out.println("Student record added successfully.");
    }

    public static void displayAllStudents() {
        if (size == 0) {
            System.out.println("No student records found.");
            return;
        }
        System.out.println("Student Records:");
        for (int i = 0; i < size; i++) {
            System.out.println("---------------------");
            students[i].display();
        }
    }

    public static void searchStudentByRollNumber() {
        System.out.print("Enter roll number to search: ");
        int rollNumber = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < size; i++) {
            if (students[i].searchByRollNumber(rollNumber)) {
                System.out.println("Student found:");
                students[i].display();
                return;
            }
        }
        System.out.println("Student with roll number " + rollNumber + " not found.");
    }

    public static void deleteStudentRecord() {
        System.out.print("Enter roll number to delete: ");
        int rollNumber = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < size; i++) {
            if (students[i].searchByRollNumber(rollNumber)) {
                for (int j = i; j < size - 1; j++) {
                    students[j] = students[j + 1];
                }
                size--;
                System.out.println("Student record deleted successfully.");
                return;
            }
        }
        System.out.println("Student with roll number " + rollNumber + " not found.");
    }
}
