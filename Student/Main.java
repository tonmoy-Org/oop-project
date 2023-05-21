package Student;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter student's name: ");
        String name = sc.nextLine();
        System.out.print("Enter student's roll number: ");
        int rollNumber = sc.nextInt();
        sc.nextLine(); // Consume the newline character
        System.out.print("Enter the number of subjects: ");
        int numSubjects = sc.nextInt();
        sc.nextLine(); // Consume the newline character
        String[] subjects = new String[numSubjects];
        for (int i = 0; i < numSubjects; i++) {
            System.out.print("Enter subject " + (i + 1) + ": ");
            subjects[i] = sc.nextLine();
        }
        Student student = new Student(name, rollNumber, subjects);
        System.out.println("\n---- Student Management System -----");
        int choice;
        do {
            System.out.println("\n1. Input Marks");
            System.out.println("2. Display Marks");
            System.out.println("3. Calculate Percentage");
            System.out.println("4. Calculate CGPA");
            System.out.println("5. All Information");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // Consume the newline character
            switch (choice) {
                case 1:
                    student.inputMarks();
                    break;
                case 2:
                    student.displayMarks();
                    break;
                case 3:
                    double percentage = student.calculatePercentage();
                    System.out.println("Percentage: " + percentage);
                    break;
                case 4:
                    double cgpa = student.calculateCGPA();
                    System.out.println("CGPA = " + String.format("%.2f", cgpa));
                    break;
                case 5:
                    student.displayMarks();
                    double percentage2 = student.calculatePercentage();
                    System.out.println("Percentage: " + percentage2);
                    double cgpa2 = student.calculateCGPA();
                    System.out.println("CGPA = " + String.format("%.2f", cgpa2));
                    break;
                case 6:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 6);
        sc.close();
    }
}