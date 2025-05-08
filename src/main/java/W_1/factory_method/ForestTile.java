package W_1.factory_method;

public class ForestTile extends Tile {
    @Override
    public String getCharacter() {
        return "\033[92m♠\033[0m";
    }

    @Override
    public String getType() {
        return "";
    }
}
