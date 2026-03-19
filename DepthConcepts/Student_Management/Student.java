public class Student {

    private String rollNo;
    private String name;
    private String bloodGroup;
    private int age;
    private String email;

    public Student(String rollNo, String name, String bloodGroup, int age, String email) {
        this.rollNo = rollNo;
        this.name = name;
        this.bloodGroup = bloodGroup;
        this.age = age;
        this.email = email;
    }

    public String getRollNo() {
        return rollNo;
    }

    public void getRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Student{" +
                "Roll Number ='" + rollNo + '\'' +
                ", name='" + name + '\'' +
                ", bloodGroup='" + bloodGroup + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }
}