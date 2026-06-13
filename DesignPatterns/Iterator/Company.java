import java.util.List;

public class Company implements Aggregate<Employee> {
    private List<Employee> employees;

    public Company(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public Iterator<Employee> createIteraor() {
        return new EmployeeIterator(employees);
    }
}
