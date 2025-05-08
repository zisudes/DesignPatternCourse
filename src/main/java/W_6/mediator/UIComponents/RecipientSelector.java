package W_6.mediator.UIComponents;

import W_6.mediator.ChatClient;
import W_6.mediator.Mediator;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;

public class RecipientSelector extends MenuButton {
    public RecipientSelector(Mediator mediator, ChatClient parent){
        mediator.getUsernames().forEach(username -> {
            if (!username.equals(parent.getUsername())) {
                MenuItem item = new MenuItem(username);
                item.setOnAction(event -> {
                    this.setText(username);
                    parent.setCurrentRecipient(username);
                });
                this.getItems().add(item);
            }
        });

        this.setMinWidth(240);
        this.setMaxWidth(240);
    }
}
