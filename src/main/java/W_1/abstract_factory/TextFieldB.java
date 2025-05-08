package W_1.abstract_factory;

public class TextFieldB extends TextField {
    @Override
    public void display(String s) {
        System.out.println("> " + s.toUpperCase() + " ".repeat(12 - s.length()) + "[                    ]");
    }
}
