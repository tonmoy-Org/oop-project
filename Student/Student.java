package Student;

import java.util.Scanner;

public class Student {
    private String name;
    private int rollNumber;
    private String[] subjects;
    private int[] marks;

    public Student(String name, int rollNumber, String[] subjects) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.subjects = subjects;
        this.marks = new int[subjects.length];
    }

    public void inputMarks() {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < subjects.length; i++) {
            System.out.print("Enter marks for " + subjects[i] + ": ");
            marks[i] = sc.nextInt();
        }
    }

    public void displayMarks() {
        System.out.println("Marks for Name: " + name + "\n Roll Number: " + rollNumber);
        for (int i = 0; i < subjects.length; i++) {
            System.out.println(subjects[i] + ": " + marks[i]);
        }
    }

    public double calculatePercentage() {
        int totalMarks = 0;
        for (int mark : marks) {
            totalMarks += mark;
        }
        return (double) totalMarks / subjects.length;
    }

    public double calculateCGPA() {
        double totalGradePoints = 0;
        int totalCredits = 0;
        // Define the credit hours for each subject
        int[] creditHours = { 3, 3, 3, 3, 3 }; // Example: assuming there are 5 subjects with credit hours
        for (int i = 0; i < subjects.length; i++) {
            int credit = creditHours[i];
            int mark = marks[i];
            totalGradePoints += calculateGradePoint(mark) * credit;
            totalCredits += credit;
        }
        return totalGradePoints / totalCredits;
    }

    private double calculateGradePoint(int mark) {
        if (mark >= 80 && mark <= 100) {
            return 4.0;
        } else if (mark >= 75 && mark < 79) {
            return 3.75;
        } else if (mark >= 70 && mark < 74) {
            return 3.50;
        } else if (mark >= 65 && mark < 69) {
            return 3.25;
        } else if (mark >= 60 && mark < 64) {
            return 3.00;
        } else if (mark >= 55 && mark < 59) {
            return 2.75;
        } else if (mark >= 50 && mark < 54) {
            return 2.0;
        } else {
            return 0.0;
        }
    }
}
