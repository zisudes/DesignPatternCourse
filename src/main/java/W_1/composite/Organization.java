package W_1.composite;

import java.util.ArrayList;
import java.util.List;

public class Organization {
    List<Department> departments;
    private String name;

    public Organization(String name){
        this.departments = new ArrayList<>();
        this.name = name;
    }

    public void addDepartment(Department department){
        this.departments.add(department);
    }

    public void removeDepartment(Department department){
        this.departments.remove(department);
    }

    public double getSalary(){
        double total = 0;
        for (Department department : departments){
            total += department.getSalary();
        }

        return total;
    }

    public void printXML(){
        System.out.printf("<organization name=\"%s\" totalSalary=\"%.2f\">%n", this.name, this.getSalary());
        for (Department department : departments){
            department.printXML(2);
        }
        System.out.println("</organization>");
    }
}