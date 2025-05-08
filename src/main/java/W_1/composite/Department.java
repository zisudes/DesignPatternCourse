package W_1.composite;

import java.util.ArrayList;
import java.util.List;

public class Department extends Component {
    public List<Employee> employees;
    public List<Department> departments;

    public Department(String name) {
        super(name);
        this.departments = new ArrayList<>();
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Employee e) {
        this.employees.add(e);
    }

    public void removeEmployee(Employee e) {
        this.employees.remove(e);
    }

    public void addChildDepartment(Department d) {
        this.departments.add(d);
    }

    @Override
    public double getSalary() {
        double sum = 0;
        for (Department d : this.departments) {
            for (Employee e : d.employees) {
               sum += e.getSalary();
            }
        }

        for (Employee e : this.employees) {
            sum += e.getSalary();
        }

        return sum;
    }

    public void printXML(int ident) {
        System.out.println("  ".repeat(ident) + String.format("<department name=\"%s\" totalSalary=\"%.2f\">", getName(), getSalary()));

        for (Department d : this.departments) {
            d.printXML(ident + 2);
        }

        for (Employee e : this.employees) {
            System.out.println("  ".repeat(ident + 2) + String.format("<employee name=\"%s\" salary=\"%.2f\">", e.getName(), e.getSalary()));
        }

        System.out.println("  ".repeat(ident) + "</department>");
    }
}