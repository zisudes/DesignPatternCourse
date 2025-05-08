package W_6.flyweight;

import static W_6.flyweight.TileType.SWAMP;

public class SwampTile extends Tile {
    @Override
    public TileType getType() {
        return SWAMP;
    }
}
