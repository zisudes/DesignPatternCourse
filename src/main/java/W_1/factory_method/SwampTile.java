package W_1.factory_method;

public class SwampTile extends Tile {
    @Override
    public String getCharacter() {
        return "\033[32m#\033[0m";
    }

    @Override
    public String getType() {
        return "Swamp";
    }
}
