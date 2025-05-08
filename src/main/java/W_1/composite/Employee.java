package W_1.composite;

public class Employee extends Component {
    private final double salary;

    public Employee(String name, double salary) {
        super(name);
        this.salary = salary;
    }

    public double getSalary() {
        return this.salary;
    }
}