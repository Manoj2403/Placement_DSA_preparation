import java.util.List;
import java.util.NoSuchElementException;

public class EmployeeIterator implements Iterator<Employee> {
    private int index = 0;
    private List<Employee> employees;

    public EmployeeIterator(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public boolean hasNext() {
        return index < employees.size();
    }

    @Override
    public Employee next() {
        if(!hasNext())
            throw new NoSuchElementException();
        return employees.get(index++);
    }

}
