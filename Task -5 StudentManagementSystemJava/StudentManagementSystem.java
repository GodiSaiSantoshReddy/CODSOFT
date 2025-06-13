import java.io.*;
import java.util.*;

public class StudentManagementSystem {
    private static final String FILE_NAME = "students.txt";
    private static List<Student> students = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        loadStudents();

        while (true) {
            System.out.println("\n📚 Student Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Search Student");
            System.out.println("3. Display All Students");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1": addStudent(); break;
                case "2": searchStudent(); break;
                case "3": displayAll(); break;
                case "4": deleteStudent(); break;
                case "5": saveStudents(); System.out.println("Goodbye!"); return;
                default: System.out.println("❌ Invalid choice.");
            }
        }
    }

    private static void addStudent() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        if (name.isEmpty()) {
            System.out.println("❌ Name cannot be empty.");
            return;
        }

        System.out.print("Enter roll number: ");
        String roll = scanner.nextLine();
        if (roll.isEmpty()) {
            System.out.println("❌ Roll number cannot be empty.");
            return;
        }

        System.out.print("Enter grade: ");
        String grade = scanner.nextLine();
        if (grade.isEmpty()) {
            System.out.println("❌ Grade cannot be empty.");
            return;
        }

        students.add(new Student(name, roll, grade));
        System.out.println("✅ Student added successfully!");
    }

    private static void searchStudent() {
        System.out.print("Enter roll number to search: ");
        String roll = scanner.nextLine();

        for (Student s : students) {
            if (s.getRollNumber().equalsIgnoreCase(roll)) {
                System.out.println("🔍 Found: " + s);
                return;
            }
        }
        System.out.println("⚠️ Student not found.");
    }

    private static void displayAll() {
        if (students.isEmpty()) {
            System.out.println("⚠️ No student data available.");
            return;
        }

        System.out.println("\n📋 All Students:");
        for (Student s : students) {
            System.out.println(s);
        }
    }

    private static void deleteStudent() {
        System.out.print("Enter roll number to delete: ");
        String roll = scanner.nextLine();

        Iterator<Student> it = students.iterator();
        while (it.hasNext()) {
            Student s = it.next();
            if (s.getRollNumber().equalsIgnoreCase(roll)) {
                it.remove();
                System.out.println("🗑️ Student deleted.");
                return;
            }
        }
        System.out.println("⚠️ Student not found.");
    }

    private static void loadStudents() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                students.add(Student.fromFileString(line));
            }
        } catch (IOException e) {
            // No file found on first run
        }
    }

    private static void saveStudents() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (Student s : students) {
                pw.println(s.toFileString());
            }
        } catch (IOException e) {
            System.out.println("❌ Error saving students.");
        }
    }
}
