package W_1.factory_method;

public abstract class Tile {
    public abstract String getCharacter();
    public abstract String getType();

    public void action(){
        System.out.println("This is a " + getType() + " tile");
    }
}
