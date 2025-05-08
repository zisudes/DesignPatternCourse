package W_6.flyweight;

import static W_6.flyweight.TileType.FOREST;

public class ForestTile extends Tile {
    @Override
    public TileType getType() {
        return FOREST;
    }
}
