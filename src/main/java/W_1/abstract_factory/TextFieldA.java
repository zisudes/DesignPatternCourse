package W_1.abstract_factory;

public class TextFieldA extends TextField {
    @Override
    public void display(String s) {
        System.out.println(s + ": " + "_".repeat(20 - s.length()));
    }
}
