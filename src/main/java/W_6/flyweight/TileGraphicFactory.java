package W_6.flyweight;

import java.util.EnumMap;

public class TileGraphicFactory {
    private static final EnumMap<TileType, TileGraphic> images = new EnumMap<>(TileType.class);

    public static TileGraphic getTileImage(TileType type) {
        TileGraphic image = images.get(type);
        if (image == null) {
            image = switch (type) {
                case FOREST -> new TileGraphic("/image/forest.png");
                case WATER -> new TileGraphic("/image/water.png");
                case SWAMP -> new TileGraphic("/image/swamp.png");
                case BUILDING -> new TileGraphic("/image/building.png");
                case ROAD -> new TileGraphic("/image/road.png");
            };
            images.put(type, image);
        }
        return image;
    }
}
