package studentmanagement;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagementSystem {

    static ArrayList<Student> students = new ArrayList<Student>();

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n===== STUDENT RECORD MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

            case 1:
                addStudent();
                break;

            case 2:
                viewStudents();
                break;

            case 3:
                updateStudent();
                break;

            case 4:
                deleteStudent();
                break;

            case 5:
                System.out.println("Thank you for using Student Record Management System.");
                break;

            default:
                System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 5);
    }

    // Add Student
    public static void addStudent() {

        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();

        sc.nextLine();

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Student Marks: ");
        double marks = sc.nextDouble();

        Student s = new Student(id, name, marks);

        students.add(s);

        System.out.println("Student added successfully!");
    }

    // View Students
    public static void viewStudents() {

        if (students.isEmpty()) {
            System.out.println("No student records available.");
        } 
        else {

            System.out.println("\n===== STUDENT RECORDS =====");

            for (Student s : students) {
                s.displayStudent();
            }
        }
    }

    // Update Student
    public static void updateStudent() {

        System.out.print("Enter Student ID to update: ");
        int id = sc.nextInt();

        boolean found = false;

        for (Student s : students) {

            if (s.getId() == id) {

                sc.nextLine();

                System.out.print("Enter new name: ");
                String name = sc.nextLine();

                System.out.print("Enter new marks: ");
                double marks = sc.nextDouble();

                s.setName(name);
                s.setMarks(marks);

                System.out.println("Student updated successfully!");

                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Student with ID " + id + " not found.");
        }
    }

    // Delete Student
    public static void deleteStudent() {

        System.out.print("Enter Student ID to delete: ");
        int id = sc.nextInt();

        boolean found = false;

        for (Student s : students) {

            if (s.getId() == id) {

                students.remove(s);

                System.out.println("Student deleted successfully!");

                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Student with ID " + id + " not found.");
        }
    }
}
