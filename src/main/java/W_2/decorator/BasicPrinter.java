package W_2.decorator;

public class BasicPrinter implements Printer {
    Printer wrappee;

    public BasicPrinter(){}

    public BasicPrinter(Printer wrappee){
        this.wrappee = wrappee;
    }

    @Override
    public void print(String s) {
        System.out.println(s);
    }
}
