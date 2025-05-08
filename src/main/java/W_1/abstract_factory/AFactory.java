package W_1.abstract_factory;

public class AFactory extends UIFactory {
    @Override
    public void createButton(String s) {
        new ButtonA().display(s);
    }

    @Override
    public void createTextField(String s) {
        new TextFieldA().display(s);
    }

    @Override
    public void createCheckbox(String s) {
        new CheckboxA().display(s);
    }
}
