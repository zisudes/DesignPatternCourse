package W_6.flyweight;

import javafx.scene.image.Image;

public class TileGraphic implements Flyweight {
    private final Image image;

    public TileGraphic(String imagePath){
        System.out.println("Creating TileGraphic instance");
        this.image = new Image(imagePath);
    }

    public Image getImage() {
        return image;
    }
}
