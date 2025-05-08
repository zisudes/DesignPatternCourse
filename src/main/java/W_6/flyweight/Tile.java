package W_6.flyweight;

public abstract class Tile {
    TileGraphic image;

    public abstract TileType getType();

    public TileGraphic getImage(){
        return image;
    }

    public void action(){
        System.out.println("This is a " + getType() + " tile");
    }
}
