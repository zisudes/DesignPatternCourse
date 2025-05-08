package W_8;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Gui extends Application {
    @Override
    public void start(Stage primaryStage) {
        PixelGrid grid = PixelGrid.getInstance();

        MoveCursorUpCommand up = new MoveCursorUpCommand();
        MoveCursorDownCommand down = new MoveCursorDownCommand();
        MoveCursorRightCommand right = new MoveCursorRightCommand();
        MoveCursorLeftCommand left = new MoveCursorLeftCommand();
        TogglePixelCommand togglePixel = new TogglePixelCommand();
        GenerateCodeCommand generateCode = new GenerateCodeCommand();

        HBox buttonRow = new HBox();
        String basicButtonStyle = "-fx-background-color: rgba(210,227,234,0.47);" +
                "-fx-text-fill: rgba(14,64,83,0.47);" +
                "-fx-font-weight: bold;" +
                "-fx-border-color: rgba(14,64,83,0.47); -fx-border-width: 2px; -fx-border-radius: 5px";


        Button leftButton = new Button("Left");
        leftButton.setOnAction(e -> left.execute());
        leftButton.setStyle(basicButtonStyle);
        leftButton.setMinWidth(80);

        Button rightButton = new Button("Right");
        rightButton.setOnAction(e -> right.execute());
        rightButton.setStyle(basicButtonStyle);
        rightButton.setMinWidth(80);

        Button upButton = new Button("Up");
        upButton.setOnAction(e -> up.execute());
        upButton.setStyle(basicButtonStyle);
        upButton.setMinWidth(80);

        Button downButton = new Button("Down");
        downButton.setOnAction(e -> down.execute());
        downButton.setStyle(basicButtonStyle);
        downButton.setMinWidth(80);

        VBox upDownButtons = new VBox(upButton, downButton);
        buttonRow.getChildren().addAll(leftButton, upDownButtons, rightButton);
        buttonRow.setAlignment(Pos.BOTTOM_CENTER);

        Button paintButton = new Button("Paint");
        paintButton.setOnAction(e -> togglePixel.execute());
        paintButton.setStyle(basicButtonStyle);
        paintButton.setMinWidth(240);

        Button generateButton = new Button("Copy to Clipboard as 2D Java Array");
        generateButton.setOnAction(e -> generateCode.execute());
        generateButton.setStyle(basicButtonStyle);
        generateButton.setMinWidth(240);

        Text instructionText = new Text("[WASD] Move cursor\n[Z] Paint\n[C] Copy to Clipboard as 2D Java Array");

        VBox vbox = new VBox(
                grid.getGridPane(),
                buttonRow,
                paintButton,
                generateButton,
                instructionText);

        vbox.setSpacing(10);
        VBox.setMargin(instructionText, new Insets(10, 10, 10, 10));

        Scene scene = new Scene(vbox);

        scene.setOnKeyPressed(e -> {
            switch (e.getCode()) {
                case Z -> togglePixel.execute();
                case W -> up.execute();
                case S -> down.execute();
                case D -> right.execute();
                case A -> left.execute();
                case C -> generateCode.execute();
            }
        });

        primaryStage.setScene(scene);
        primaryStage.setTitle("Pixel Art Maker");
        primaryStage.show();
    }
}
