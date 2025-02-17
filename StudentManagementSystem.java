package studentmanagementsystem;

import java.util.*;

class Student {
    private String name;
    private int age;
    private String rollNumber;

    public Student(String name, int age, String rollNumber) {
        this.name = name;
        this.age = age;
        this.rollNumber = rollNumber;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Age: " + age + ", Roll Number: " + rollNumber;
    }
}

public class StudentManagementSystem {

    private static List<Student> studentList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Display menu
            System.out.println("----- Student Management System -----");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student by Name");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            // Get user input
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline character

            switch (choice) {
                case 1:
                    // Add Student
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter student age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();  // Consume newline character
                    System.out.print("Enter roll number: ");
                    String rollNumber = scanner.nextLine();
                    addStudent(name, age, rollNumber);
                    break;

                case 2:
                    // View All Students
                    viewStudents();
                    break;

                case 3:
                    // Search Student by Name
                    System.out.print("Enter student name to search: ");
                    String searchName = scanner.nextLine();
                    searchStudentByName(searchName);
                    break;

                case 4:
                    // Exit
                    System.out.println("Exiting the application...");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Method to add a student
    private static void addStudent(String name, int age, String rollNumber) {
        Student student = new Student(name, age, rollNumber);
        studentList.add(student);
        System.out.println("Student added: " + student);
    }

    // Method to view all students
    private static void viewStudents() {
        if (studentList.isEmpty()) {
            System.out.println("No students to display.");
        } else {
            System.out.println("----- Student List -----");
            for (Student student : studentList) {
                System.out.println(student);
            }
        }
    }

    // Method to search student by name
    private static void searchStudentByName(String name) {
        boolean found = false;
        for (Student student : studentList) {
            if (student.getName().equalsIgnoreCase(name)) {
                System.out.println("Student found: " + student);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Student with name " + name + " not found.");
        }
    }
}
