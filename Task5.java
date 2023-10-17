package Projects.CodeSoftInternship;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Course {
    private int courseId;
    private String courseName;
    private int capacity;
    private List<Student> enrolledStudents;

    public Course(int courseId, String courseName, int capacity) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.capacity = capacity;
        this.enrolledStudents = new ArrayList<>();
    }

    public int getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean addStudent(Student student) {
        if (enrolledStudents.size() < capacity) {
            enrolledStudents.add(student);
            return true;
        } else {
            return false;
        }
    }
}

class Student {
    private int studentId;
    private String studentName;

    public Student(int studentId, String studentName) {
        this.studentId = studentId;
        this.studentName = studentName;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }
}

public class Task5 {
    private List<Student> students;
    private List<Course> courses;

    public Task5() {
        students = new ArrayList<>();
        courses = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void registerStudentForCourse(int studentId, int courseId) {
        Student student = findStudent(studentId);
        Course course = findCourse(courseId);

        if (student != null && course != null) {
            boolean success = course.addStudent(student);
            if (success) {
                System.out.println(student.getStudentName() + " registered for " + course.getCourseName());
            } else {
                System.out.println("Course is full. " + student.getStudentName() + " could not register.");
            }
        } else {
            System.out.println("Student or course not found.");
        }
    }

    public Student findStudent(int studentId) {
        for (Student student : students) {
            if (student.getStudentId() == studentId) {
                return student;
            }
        }
        return null;
    }

    public Course findCourse(int courseId) {
        for (Course course : courses) {
            if (course.getCourseId() == courseId) {
                return course;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Task5 registrationSystem = new Task5();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add Student");
            System.out.println("2. Add Course");
            System.out.println("3. Register Student for Course");
            System.out.println("4. Exit");
            System.out.print("Select an option: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid option (1, 2, 3, or 4).");
                continue;
            }

            switch (choice) {
                case 1:
                    int studentId;
                    try {
                        System.out.print("Enter Student ID: ");
                        studentId = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Student ID must be an integer.");
                        continue;
                    }
                    System.out.print("Enter Student Name: ");
                    String studentName = scanner.nextLine();
                    Student student = new Student(studentId, studentName);
                    registrationSystem.addStudent(student);
                    break;
                case 2:
                    int courseId;
                    try {
                        System.out.print("Enter Course ID: ");
                        courseId = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Course ID must be an integer.");
                        continue;
                    }
                    System.out.print("Enter Course Name: ");
                    String courseName = scanner.nextLine();
                    System.out.print("Enter Course Capacity: ");
                    int capacity;
                    try {
                        capacity = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Course capacity must be an integer.");
                        continue;
                    }
                    Course course = new Course(courseId, courseName, capacity);
                    registrationSystem.addCourse(course);
                    break;
                case 3:
                    int studentIdForRegistration;
                    int courseIdForRegistration;
                    try {
                        System.out.print("Enter Student ID: ");
                        studentIdForRegistration = Integer.parseInt(scanner.nextLine());
                        System.out.print("Enter Course ID: ");
                        courseIdForRegistration = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Student and Course IDs must be integers.");
                        continue;
                    }
                    registrationSystem.registerStudentForCourse(studentIdForRegistration, courseIdForRegistration);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
