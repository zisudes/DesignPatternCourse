package W_1.factory_method;

import java.util.Random;

public class WildernessMap extends Map {
    @Override
    public Tile createTile() {
        Random random = new Random();
        switch (random.nextInt(3)){
            case 0:
                return new WaterTile();
            case 1:
                return new ForestTile();
            default:
                return new SwampTile();
        }
    }
}
