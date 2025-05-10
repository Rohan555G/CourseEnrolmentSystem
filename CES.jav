import java.util.*;

class Student {
    String name;
    Set<String> courses;

    public Student(String name) {
        this.name = name;
        this.courses = new HashSet<>();
    }
}

public class CES {

    private static Map<String, Student> studentMap = new HashMap<>();

    public static void addCourse(String studentId, String name, String courseName) {
        studentMap.putIfAbsent(studentId, new Student(name));
        Student student = studentMap.get(studentId);
        if (student.courses.add(courseName)) {
            System.out.println("Course added successfully.");
        } else {
            System.out.println("Student already enrolled in this course.");
        }
    }

    public static void dropCourse(String studentId, String courseName) {
        Student student = studentMap.get(studentId);
        if (student != null && student.courses.remove(courseName)) {
            System.out.println("Course dropped successfully.");
        } else {
            System.out.println("Course not found or student not enrolled.");
        }
    }

    public static void searchCourses(String studentId) {
        Student student = studentMap.get(studentId);
        if (student == null || student.courses.isEmpty()) {
            System.out.println("No courses found for student ID: " + studentId);
        } else {
            System.out.println("Courses for " + student.name + " (ID: " + studentId + "): " + student.courses);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String studentId, name, courseName;
        int choice;

        while (true) {
            System.out.println("\n--- Course Enrollment System ---");
            System.out.println("1. Add Course");
            System.out.println("2. Drop Course");
            System.out.println("3. Search Courses");
            System.out.println("4. Exit");
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.println("Enter student ID: ");
                    studentId = scanner.nextLine();
                    System.out.println("Enter student name: ");
                    name = scanner.nextLine();
                    System.out.println("Enter course name: ");
                    courseName = scanner.nextLine();
                    addCourse(studentId, name, courseName);
                    break;
                case 2:
                    System.out.println("Enter student ID: ");
                    studentId = scanner.nextLine();
                    System.out.println("Enter course name: ");
                    courseName = scanner.nextLine();
                    dropCourse(studentId, courseName);
                    break;
                case 3:
                    System.out.println("Enter student ID: ");
                    studentId = scanner.nextLine();
                    searchCourses(studentId);
                    break;
                case 4:
                    System.out.println("Exiting system.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
