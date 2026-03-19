import java.sql.*;

public class StudentDAOImpl implements StudentDAO {

    @Override
    public Student getStudentByRollNo(String rollNo) {
        String query = "SELECT * FROM student WHERE roll_no=?;";
        try (Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(query);
                ResultSet rs = ps.executeQuery()) {

            ps.setString(1, rollNo);

            if (rs.next()) {
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String bloodGroup = rs.getString("blood_group");
                String email = rs.getString("email");

                return new Student(rollNo, name, bloodGroup, age, email);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Student createStudent(Student student) {
        String query = "INSERT INTO student(roll_no,name_,age,blood_group,email) VALUES( ?,?,?,?,? )";
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement(query);

            ps.setString(1, student.getRollNo());
            ps.setString(2, student.getName());
            ps.setInt(3, student.getAge());
            ps.setString(4, student.getBloodGroup());
            ps.setString(5, student.getEmail());

            int rows = ps.executeUpdate();
            if (rows > 0) {
                return student;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null)
                    ps.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                if (con != null)
                    con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
