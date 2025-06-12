import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // How many subjects you have
        System.out.print("Enter the number of subjects: ");
        int subjectCount = scanner.nextInt();

        int[] marks = new int[subjectCount];
        int total = 0;

        // Get marks for each subject
        for (int i = 0; i < subjectCount; i++) {
            System.out.print("Enter marks for Subject " + (i + 1) + " (out of 100): ");
            marks[i] = scanner.nextInt();

            // Check if marks are between 0 and 100
            if (marks[i] < 0 || marks[i] > 100) {
                System.out.println("❌ Please enter valid marks between 0 and 100.");
                i--; // ask again for same subject
                continue;
            }

            total += marks[i]; // Add to total
        }

        // Calculate average
        double average = (double) total / subjectCount;

        // Find Grade
        char grade;
        if (average >= 90) {
            grade = 'A';
        } else if (average >= 80) {
            grade = 'B';
        } else if (average >= 70) {
            grade = 'C';
        } else if (average >= 60) {
            grade = 'D';
        } else {
            grade = 'F';
        }

        // Show result
        System.out.println("\n📊 Your Result:");
        System.out.println("Total Marks: " + total + " / " + (subjectCount * 100));
        System.out.printf("Average Percentage: %.2f%%\n", average);
        System.out.println("Grade: " + grade);

        scanner.close();
    }
}
