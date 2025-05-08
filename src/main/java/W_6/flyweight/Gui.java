package W_6.flyweight;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Gui extends Application {
    public HBox createNormalMap(Map map, int size){
        HBox hbox = new HBox();
        for (int i = 0; i < size; i++) {
            VBox row = new VBox();
            for (int j = 0; j < size; j++) {
                Tile tile = map.createTile();
                Image image = TileGraphicFactory.getTileImage(tile.getType()).getImage();
                row.getChildren().add(new ImageView(image));
            }
            hbox.getChildren().add(row);
        }
        return hbox;
    }

    @Override
    public void start(Stage stage) {
        int SIZE_OF_MAP = 15;

        final Map[] map = {new WildernessMap()};
        HBox mapView = createNormalMap(map[0], SIZE_OF_MAP);

        Text title = new Text("Wilderness Map");

        Button button = new Button("Generate New Map");

        button.setOnAction(e -> {
                    mapView.getChildren().clear();
                    mapView.getChildren().add(createNormalMap(map[0], SIZE_OF_MAP));
                });

        Button changeType = new Button("Create a City Map");

        changeType.setOnAction(e -> {
            if (map[0] instanceof WildernessMap) {
                map[0] = new CityMap();
                title.setText("City Map");
                changeType.setText("Create a Wilderness Map");
            } else {
                map[0] = new WildernessMap();
                title.setText("Wilderness Map");
                changeType.setText("Create a City Map");
            }
            mapView.getChildren().clear();
            mapView.getChildren().add(createNormalMap(map[0], SIZE_OF_MAP));
        });

        VBox scene = new VBox(title, mapView, button, changeType);
        scene.setAlignment(Pos.CENTER);
        scene.setSpacing(10);
        stage.setScene(new Scene(scene));
        stage.setTitle("Flyweight Example");

        stage.show();
    }
}
