import java.util.List;

public class Application {
    public static void main(String[] args) {
        Employee emp1 = new Employee("Manoj", 400000);
        Employee emp2 = new Employee("Kumar", 700000);
        Employee emp3 = new Employee("Vishaal", 1000000);

        Company company = new Company(List.of(emp1, emp2, emp3));
        Iterator<Employee> itr = company.createIteraor();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }
}
