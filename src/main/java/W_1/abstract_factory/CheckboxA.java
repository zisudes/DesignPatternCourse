package W_1.abstract_factory;

public class CheckboxA extends Checkbox {
    @Override
    public void display(String s) {
        System.out.println("[ ] " + s);
    }
}
