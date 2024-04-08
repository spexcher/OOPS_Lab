package Lab_3;

import java.util.*;

class Student {
    private String name;
    private int rollNumber;
    private String department;
    private double averageMarks;

    public Student(String name, int rollNumber, String department, double averageMarks) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.department = department;
        this.averageMarks = averageMarks;
    }

    public String getName() {
        return name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public String getDepartment() {
        return department;
    }

    public double getAverageMarks() {
        return averageMarks;
    }

    public void display() {
        System.out.println("Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Department: " + department);
        System.out.println("Average Marks: " + averageMarks);
    }

    private List<Student> studentList;

    public Student() {
        studentList = new LinkedList<>();
    }

    public void displayAllStudents() {
        for (Student student : studentList) {
            System.out.println(student);
        }
    }

    public void searchStudent(int rollNumber) {
        for (Student student : studentList) {
            if (student.getRollNumber() == rollNumber) {
                System.out.println(student);
                return;
            }
        }
        System.out.println("Student not found");
    }

    public void sortStudentsByRollNumber() {
        studentList.sort(Comparator.comparingInt(Student::getRollNumber));
    }

    public void addStudent(String name, int rollNumber, String department, double averageMarks) {
        Student s = new Student(name, rollNumber, department, averageMarks);
        studentList.add(s);
    }

    public void deleteStudent(int rollNumber) {
        Iterator<Student> iterator = studentList.iterator();
        while (iterator.hasNext()) {
            Student temp = iterator.next();
            if (temp.getRollNumber() == rollNumber) {
                iterator.remove();
                System.out.println("Student deleted successfully");
                return;
            }
        }
        System.out.println("Student not found");
    }

    public String toString() {
        return "Student Name: " + name + ", Roll Number: " + rollNumber +
                ", Department: " + department + ", Marks: " + averageMarks;
    }
}

class CSE extends Student {
    public CSE() {
        super();
    }
}

class IT extends Student {
    public IT() {
        super();
    }
}

class CE extends Student {
    public CE() {
        super();
    }
}

class EE extends Student {
    public EE() {
        super();
    }
}

class ME extends Student {
    public ME() {
        super();
    }
}

class ECE extends Student {
    public ECE() {
        super();
    }
}

class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Student s = null;
        CSE cse = new CSE();
        IT it = new IT();
        ECE ece = new ECE();
        ME me = new ME();
        CE ce = new CE();
        EE ee = new EE();
        int choicetocontinue;
        do {
            System.out.print("Enter Department of Student (CSE, IT, ECE ,CE ,EE ,ME): ");
            String dept = scanner.nextLine();

            if (dept.equals("CSE")) {
                s = cse;
            } else if (dept.equals("IT")) {
                s = it;
            } else if (dept.equals("ECE")) {
                s = ece;
            } else if (dept.equals("EE")) {
                s = ee;
            } else if (dept.equals("ME")) {
                s = me;
            } else if (dept.equals("CE")) {
                s = ce;
            }

            else {
                System.out.println("Invalid department");
                System.exit(0);
            }
            int choice;
            do {
                System.out.println("\nMenu:");
                System.out.println("1. Insert Student Record");
                System.out.println("2. Display All Students");
                System.out.println("3. Search Student by Roll Number");
                System.out.println("4. Sort Students by Roll Number");
                System.out.println("5. Delete Student Record");
                System.out.println("6. Exit");
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        System.out.print("Enter Name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter Roll Number: ");
                        int rollNumber = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter Average Marks: ");
                        double averageMarks = scanner.nextDouble();
                        s.addStudent(name, rollNumber, dept, averageMarks);
                        break;
                    case 2:
                        s.displayAllStudents();
                        break;
                    case 3:
                        System.out.print("Enter Roll Number to search: ");
                        int searchRollNumber = scanner.nextInt();
                        scanner.nextLine();
                        s.searchStudent(searchRollNumber);
                        break;
                    case 4:
                        s.sortStudentsByRollNumber();
                        System.out.println("Students sorted by Roll Number");
                        break;
                    case 5:
                        System.out.print("Enter Roll Number to delete: ");
                        int deleteRollNumber = scanner.nextInt();
                        scanner.nextLine();
                        s.deleteStudent(deleteRollNumber);
                        break;
                    case 6:
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice");
                }
            } while (choice != 6);
            System.out.println("Do you want to continue? Enter 1 to continue, 0 to exit...");
            choicetocontinue = scanner.nextInt();
            scanner.nextLine();
        } while (choicetocontinue != 0);
        scanner.close();
    }
}