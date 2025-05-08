package W_1.abstract_factory;

public class ButtonA extends Button {
    @Override
    public void display(String s) {
        System.out.println("[ " + s + " → ]");
    }
}
