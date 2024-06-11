import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Student Grade Calculator!");

        // Input: Marks obtained in each subject (out of 100)
        double[] subjectMarks = new double[6];
        for (int i = 0; i < 6; i++) {
            System.out.print("Enter marks obtained in Subject " + (i + 1) + ": ");
            subjectMarks[i] = scanner.nextDouble();
        }

        // Calculate total marks obtained
        double totalMarks = 0;
        for (double marks : subjectMarks) {
            totalMarks += marks;
        }

        // Calculate average percentage
        double averagePercentage = totalMarks / 6.0;

        // Assign grade based on average percentage
        String grade;
        if (averagePercentage >= 90) {
            grade = "A";
        } else if (averagePercentage >= 80) {
            grade = "B";
        } else if (averagePercentage >= 70) {
            grade = "C";
        } else if (averagePercentage >= 60) {
            grade = "D";
        } else {
            grade = "F";
        }

        // Display the result
        System.out.println("\nResult:");
        System.out.println("Total Marks Obtained: " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage + "%");
        System.out.println("Grade: " + grade);

        scanner.close();
    }
}

