import java.util.*;

public class StudentApp {
    private static final Scanner sc = new Scanner(System.in);
    private static StudentService service = new StudentService();
    // private static String regex = ""

    private static boolean isValidString(String str) {
        if (str == null || str.trim().isEmpty())
            return false;
        return true;
    }

    public static void handleAddStudent() {
        sc.nextLine();
        System.out.println("Enter Student Roll Number : ");
        String rollNo = sc.nextLine();
        while (!isValidString(rollNo)) {
            System.out.println("**Enter Correct Roll Number**");
            System.out.println("Enter Student Roll Number : ");
            rollNo = sc.nextLine();
        }

        System.out.println("Enter Student Name : ");
        String name = sc.nextLine();
        while (!isValidString(name)) {
            System.out.println("**Enter Correct Student Name**");
            System.out.println("Enter Student Name : ");
            name = sc.nextLine();
        }

        System.out.println("Enter Student Blood Group(like - O-Positive) : ");
        String bloodgroup = sc.nextLine();
        while (!isValidString(bloodgroup)) {
            System.out.println("**Enter Correct Student Blood Group**");
            System.out.println("Enter Student Blood Group(like - O-Positive) : ");
            name = sc.nextLine();
        }

        System.out.println("Enter Student Email : ");
        String email = sc.nextLine();
        while (!isValidString(email)) {
            System.out.println("**Enter Correct Student Email**");
            System.out.println("Enter Student Email : ");
            name = sc.nextLine();
        }

        System.out.println("Enter Student Age : ");
        int age = sc.nextInt();
        sc.nextLine();
        while ((age <= 0 || age >= 90)) {
            System.out.println("**Enter Student Age Correctly**");
            System.out.println("Enter Student Age : ");
            age = sc.nextInt();
        }
        Student student = new Student(rollNo, name, bloodgroup, age, email);
        Result<Student> result = service.addStudent(student);
        if (result == null) {
            System.out.println("Student Response Not Found.");
            return;
        }
        if (!result.isStatus()) {
            System.out.println(result.getMessage());
        } else {
            System.out.println(result.getMessage());
            System.out.println(result.getData());
        }

    }

    public static void handleGetStudent() {
        System.out.println("Enter Student Roll Number : ");
        String rollNo = sc.nextLine();
        while (!isValidString(rollNo)) {
            System.out.println("**Enter Correct Roll Number**");
            System.out.println("Enter Student Roll Number : ");
            rollNo = sc.nextLine();
        }

        Result<Student>result = service.getStudent(rollNo);
        if(!result.isStatus()){
            System.out.println(result.getMessage());
        }
        else{
            System.out.println(result.getMessage());
            System.out.println(result.getData());
        }
    }

    public static void handleUpdateStudent() {

    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n===== STUDENT MANAGEMENT =====");
            System.out.println("1. Add Student");
            System.out.println("2. Get Student");
            System.out.println("3. Update Student");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            if (choice == 1) {
                handleAddStudent();
            } else if (choice == 2) {
                handleGetStudent();
            } else if (choice == 3) {
                handleUpdateStudent();
            } else {
                System.exit(0);
            }
        }
    }
}
