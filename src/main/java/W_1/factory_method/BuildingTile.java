package W_1.factory_method;

public class BuildingTile extends Tile {
    @Override
    public String getCharacter() {
        return "\033[91m▲\033[0m";
    }

    @Override
    public String getType() {
        return "Building";
    }

    @Override
    public void action(){
        System.out.println("Welcome to the building!");
    }
}
