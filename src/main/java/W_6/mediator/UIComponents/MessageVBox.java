package W_6.mediator.UIComponents;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import static javafx.geometry.Pos.CENTER_LEFT;
import static javafx.geometry.Pos.CENTER_RIGHT;

public class MessageVBox extends VBox {
    public MessageVBox(String sender, String message, boolean isFromMe) {
        this.getChildren().clear();

        this.setMinWidth(200);
        this.setMaxWidth(200);

        VBox messageHolder = new VBox();

        if (isFromMe) {
            messageHolder.setAlignment(CENTER_RIGHT);
            messageHolder.setStyle("-fx-background-color: rgba(173, 177, 206, 0.5); -fx-background-radius: 10;");
        } else {
            Label senderLabel = new Label(sender);
            senderLabel.setFont(Font.font("System", FontWeight.BOLD, 12));
            messageHolder.getChildren().add(senderLabel);
            messageHolder.setAlignment(CENTER_LEFT);
            messageHolder.setStyle("-fx-background-color: rgba(211, 211, 211, 0.5); -fx-background-radius: 10;");
        }

        Label text = new Label(message);
        text.setWrapText(true);

        messageHolder.getChildren().add(text);
        messageHolder.setPadding(new Insets(8));

        this.getChildren().add(messageHolder);
        VBox.setMargin(this, new Insets(4));
    }
}
