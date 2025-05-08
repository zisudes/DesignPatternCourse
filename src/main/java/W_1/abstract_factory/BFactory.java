package W_1.abstract_factory;

public class BFactory extends UIFactory {
    @Override
    public void createButton(String s) {
        new ButtonB().display(s);
    }

    @Override
    public void createTextField(String s) {
        new TextFieldB().display(s);
    }

    @Override
    public void createCheckbox(String s) {
        new CheckboxB().display(s);
    }
}
