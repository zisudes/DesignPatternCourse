package W_6.flyweight;

public class Game {
    public static void main(String[] args) {
        WildernessMap wildernessMap = new WildernessMap();
        CityMap cityMap = new CityMap();

        createMap(wildernessMap);
    }

    public static void createMap(Map map){
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 10; j++) {
                Tile tile = map.createTile();
                System.out.printf(tile.toString());
            }
            System.out.println();
        }
        map.display();
    }
}