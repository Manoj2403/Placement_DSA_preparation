public interface StudentDAO {
    
    public Student getStudentByRollNo(String rollNo);

    public Student createStudent(Student student);
}
