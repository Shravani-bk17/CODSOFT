import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

// 1. Create a Student class to represent individual students
class Student {
    private String name;
    private int rollNumber;
    private String grade;

    public Student(String name, int rollNumber, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
    }

    // Getters and Setters for management operations
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public int getRollNumber() { return rollNumber; }
    
    public String getGrade() { return grade; }
    public void setGrade(String grade) { this.grade = grade; }

    @Override
    public String toString() {
        return "Roll No: " + rollNumber + " | Name: " + name + " | Grade: " + grade;
    }

    // Formats student details neatly to store in a text file
    public String toFileString() {
        return rollNumber + "," + name + "," + grade;
    }
}

// The public class name is now matched to your file name: task5
public class task5 {
    private ArrayList<Student> students;
    private final String FILE_NAME = "students.txt";

    public task5() {
        students = new ArrayList<>();
        loadDataFromFile(); // 4. Read student data from a storage medium automatically at startup
    }

    // Method to add a student
    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Student added successfully!");
        saveDataToFile(); // 4. Write data to file to preserve it
    }

    // Method to remove a student
    public void removeStudent(int rollNumber) {
        Student target = searchStudent(rollNumber);
        if (target != null) {
            students.remove(target);
            System.out.println("Student with Roll Number " + rollNumber + " removed successfully.");
            saveDataToFile();
        } else {
            System.out.println("Error: Student not found.");
        }
    }

    // Method to search for a student
    public Student searchStudent(int rollNumber) {
        for (Student s : students) {
            if (s.getRollNumber() == rollNumber) {
                return s;
            }
        }
        return null;
    }

    // Method to display all students
    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No student records available.");
            return;
        }
        System.out.println("\n--- All Student Records ---");
        for (Student s : students) {
            System.out.println(s);
        }
    }

    // 4. File I/O: Writing to a text file
    private void saveDataToFile() {
        try (FileWriter writer = new FileWriter(FILE_NAME)) {
            for (Student s : students) {
                writer.write(s.toFileString() + "\n");
            }
        } catch (Exception e) {
            System.out.println("Error saving data to file: " + e.getMessage());
        }
    }

    // 4. File I/O: Reading from a text file
    private void loadDataFromFile() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return;

        try (Scanner fileScanner = new Scanner(file)) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                if (line.trim().isEmpty()) continue;
                String[] tokens = line.split(",");
                if (tokens.length == 3) {
                    int roll = Integer.parseInt(tokens[0]);
                    String name = tokens[1];
                    String grade = tokens[2];
                    students.add(new Student(name, roll, grade));
                }
            }
        } catch (Exception e) {
            System.out.println("Error loading data from file: " + e.getMessage());
        }
    }

    // 3 & 5. Design the console User Interface and interaction logic
    public static void main(String[] args) {
        task5 sms = new task5();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\n=========================================");
            System.out.println("        STUDENT MANAGEMENT SYSTEM        ");
            System.out.println("=========================================");
            System.out.println("1. Add a New Student");
            System.out.println("2. Remove a Student");
            System.out.println("3. Edit Existing Student Info");
            System.out.println("4. Search for a Student");
            System.out.println("5. Display All Students");
            System.out.println("6. Exit");
            System.out.print("Choose an option (1-6): ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear scanner buffer

            switch (choice) {
                case 1:
                    // 6. Input Validation for mandatory non-empty parameters
                    System.out.print("Enter Student Name: ");
                    String name = scanner.nextLine().trim();
                    if (name.isEmpty()) {
                        System.out.println("Error: Name field cannot be empty.");
                        break;
                    }

                    System.out.print("Enter Unique Roll Number: ");
                    int roll = scanner.nextInt();
                    scanner.nextLine(); // Clear buffer
                    if (sms.searchStudent(roll) != null) {
                        System.out.println("Error: A student with this roll number already exists.");
                        break;
                    }

                    System.out.print("Enter Grade (e.g., A, B, C): ");
                    String grade = scanner.nextLine().trim();
                    if (grade.isEmpty()) {
                        System.out.println("Error: Grade field cannot be empty.");
                        break;
                    }

                    sms.addStudent(new Student(name, roll, grade));
                    break;

                case 2:
                    System.out.print("Enter Roll Number to remove: ");
                    int removeRoll = scanner.nextInt();
                    sms.removeStudent(removeRoll);
                    break;

                case 3:
                    // 5. Editing an existing student's information
                    System.out.print("Enter Roll Number to edit: ");
                    int editRoll = scanner.nextInt();
                    scanner.nextLine(); // Clear buffer
                    Student existingStudent = sms.searchStudent(editRoll);

                    if (existingStudent != null) {
                        System.out.print("Enter new name (Press Enter to keep current: " + existingStudent.getName() + "): ");
                        String newName = scanner.nextLine().trim();
                        if (!newName.isEmpty()) {
                            existingStudent.setName(newName);
                        }

                        System.out.print("Enter new grade (Press Enter to keep current: " + existingStudent.getGrade() + "): ");
                        String newGrade = scanner.nextLine().trim();
                        if (!newGrade.isEmpty()) {
                            existingStudent.setGrade(newGrade);
                        }

                        sms.saveDataToFile(); // Save updated changes
                        System.out.println("Student record updated successfully!");
                    } else {
                        System.out.println("Error: Student not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter Roll Number to search: ");
                    int searchRoll = scanner.nextInt();
                    Student foundStudent = sms.searchStudent(searchRoll);
                    if (foundStudent != null) {
                        System.out.println("\nStudent Found:\n" + foundStudent);
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 5:
                    sms.displayAllStudents();
                    break;

                case 6:
                    System.out.println("Exiting Application. Data saved securely. Goodbye!");
                    exit = true;
                    break;

                default:
                    System.out.println("Invalid option chosen! Please pick between 1 and 6.");
                    break;
            }
        }
        scanner.close();
    }
}