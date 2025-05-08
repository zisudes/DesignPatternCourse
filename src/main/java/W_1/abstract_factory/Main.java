package W_1.abstract_factory;

public class Main {
    public static void main(String[] args) {
        AFactory factory = new AFactory();
        //BFactory factory = new BFactory();

        factory.createTextField("Username");
        factory.createTextField("E-Mail");
        factory.createTextField("Password");

        factory.createCheckbox("I want to receive newsletters");

        factory.createButton("Login");
    }
}
