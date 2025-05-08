package W_1.composite;

public class Main {
    public static Organization createOrganizationA() {
        Organization organization = new Organization("My Organization");
        Department d = new Department("Main Department");
        Department sub = new Department("Sub Department");
        d.addChildDepartment(sub);

        d.addEmployee(new Employee("First Employee", 12));
        d.addEmployee(new Employee("Second Employee", 15));
        sub.addEmployee(new Employee("Third Employee", 20));
        organization.addDepartment(d);
        return organization;
    }

    public static Organization createOrganizationB() {
        Organization organization = new Organization("New Organization");
        Department logis = new Department("Logistics");

        Department lead = new Department("Team Lead");
        logis.addChildDepartment(lead);
        lead.addEmployee(new Employee("First First", 5000));
        lead.addEmployee(new Employee("Second Second", 5200));

        Department picking = new Department("Picking");
        picking.addEmployee(new Employee("Third Third", 1500));
        picking.addEmployee(new Employee("Fourth Fourth", 2600));
        logis.addChildDepartment(picking);

        Department customerService = new Department("Customer Service");
        customerService.addEmployee(new Employee("Five Five", 3200));
        customerService.addEmployee(new Employee("Six Six", 3400));
        customerService.addEmployee(new Employee("Seven Seven", 2000));

        organization.addDepartment(logis);
        organization.addDepartment(customerService);

        return organization;
    }

    public static void main(String[] args) {
        Organization organizationA = createOrganizationA();
        organizationA.printXML();

        System.out.println();

        Organization organizationB = createOrganizationB();
        organizationB.printXML();
    }
}
