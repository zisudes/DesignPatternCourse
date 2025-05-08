package W_4;

import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class MementoButton extends Button {
    public MementoButton(Memento memento, Controller controller) {
        this.setGraphic(createGraphic(memento));
        this.setOnAction(evt -> controller.jumpToState(memento));
        this.setStyle("-fx-background-color: transparent;");
    }

    private HBox createGraphic(Memento memento){
        HBox hbox = new HBox();

        Color[] colors = {Color.RED, Color.BLUE, Color.YELLOW};

        for (int option : memento.getOptions()){
            Rectangle rectangle = new Rectangle(16, 16);
            rectangle.setFill(colors[option]);
            hbox.getChildren().add(rectangle);
        }

        CheckBox checkBox = new CheckBox();
        checkBox.setSelected(memento.isSelected());
        checkBox.setDisable(true);
        hbox.getChildren().add(checkBox);

        hbox.setSpacing(10);

        return hbox;
    }
}
