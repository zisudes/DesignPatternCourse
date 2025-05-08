package W_6.mediator.UIComponents;

import W_6.mediator.ChatClient;
import W_6.mediator.Mediator;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class MessageSendingArea extends VBox {
    public MessageSendingArea(Mediator mediator, ChatClient client) {
        this.getChildren().clear();

        TextField textField = new TextField();
        Button button = new Button("Send");
        button.setOnAction(e -> {
           if (!textField.getText().isEmpty()) {
               client.sendMessage(client.getCurrentRecipient(), textField.getText());
           }
            textField.setText("");
        });

        this.getChildren().addAll(textField, button);
    }
}
