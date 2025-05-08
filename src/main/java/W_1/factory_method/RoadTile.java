package W_1.factory_method;

public class RoadTile extends Tile {
    @Override
    public String getCharacter() {
        return "\033[90m#\033[0m";
    }

    @Override
    public String getType() {
        return "Road";
    }

    @Override
    public void action(){
        System.out.println("You are on the road");
    }
}
