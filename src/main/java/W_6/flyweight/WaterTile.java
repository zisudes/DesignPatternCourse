package W_6.flyweight;

import static W_6.flyweight.TileType.WATER;

public class WaterTile extends Tile {
    @Override
    public TileType getType() {
        return WATER;
    }
}
