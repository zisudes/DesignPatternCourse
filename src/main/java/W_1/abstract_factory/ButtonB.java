package W_1.abstract_factory;

public class ButtonB extends Button {
    @Override
    public void display(String s) {
        System.out.println("< " + s.toUpperCase() + " >");
    }
}
