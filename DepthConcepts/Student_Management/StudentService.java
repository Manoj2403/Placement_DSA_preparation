import java.util.*;

public class StudentService {
    private StudentDAO dao = new StudentDAOImpl();

    // Creating the Student
    public Result<Student> addStudent(Student student) {
        if (student == null)
            return new Result<Student>(false,"Student Is Null.");
        // Existing student logic
        Student existingStudent = dao.getStudentByRollNo(student.getRollNo());
        if (existingStudent != null) {
            return new Result<Student>(false, "Student Already Exists..", existingStudent);
        }

        Student createdStudent = dao.createStudent(student);
        if (createdStudent != null)
            return new Result<Student>(true, "Student Added Successfully", createdStudent);
        else
            return new Result<Student>(false, "Student Not Added");
    }

    public Result<Student> getStudent(String rollNo) {
        if (rollNo == null || rollNo.trim().isEmpty()) {
            return new Result<Student>(false, "Roll Number is Empty");
        }

        Student student = dao.getStudentByRollNo(rollNo);
        if(student==null)
            return new Result<>(false,"Student Not Found in the DB");
        return new Result<Student>(true,"Student Found",student);
    }
}
