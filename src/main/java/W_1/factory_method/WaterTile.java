package W_1.factory_method;

public class WaterTile extends Tile {
    @Override
    public String getCharacter() {
        return "\033[34m■\033[0m";
    }

    @Override
    public String getType() {
        return "Water";
    }
}
