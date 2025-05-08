package W_6.mediator;

import W_6.mediator.UIComponents.*;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ChatClient {
    private final String username;
    private final Mediator mediator;

    private final VBox messageView;
    private String currentRecipient;
    private ScrollPane messagePane;

    private final Map<String, ArrayList<Message>> allMessages = new HashMap<>();

    public ChatClient(String user, Mediator mediator) {
        this.username = user;
        this.mediator = mediator;

        this.messageView = new VBox();

        mediator.registerClient(user, this);
    }

    public void setCurrentRecipient(String username){
        this.currentRecipient = username;
        setUpMessageView(username);
    }

    public void setUpMessageView(String recipient) {
        messageView.setSpacing(10);
        messageView.getChildren().clear();

        if (allMessages.containsKey(recipient)) {
            allMessages.get(recipient).forEach(message -> {
                System.out.println(message);
                messageView.getChildren().add(new MessageVBox(message.getSender(),
                        message.getMessage(),
                        message.getSender().equals(username)));
            });
        }
    }

    public Scene getScene(){
        VBox vbox = new VBox();
        messagePane = new ScrollPane(messageView);
        messagePane.setMinHeight(200);
        messagePane.setMaxHeight(300);

        messageView.heightProperty().addListener((observable, oldValue, newValue) -> {
            messagePane.setVvalue(1.0);
        });

        vbox.getChildren().addAll(
                new Label(username),
                new RecipientSelector(mediator, this),
                messagePane,
                new MessageSendingArea(mediator, this));

        vbox.setMinWidth(200);
        vbox.setMinHeight(300);

        return new Scene(vbox);
    }

    public void sendMessage(String recipient, String message) {
        System.out.println("[" + username + "] sending message to " + recipient + ": " + message);

        if (mediator.userExists(recipient)) {
            if (!allMessages.containsKey(recipient)) {
                allMessages.put(recipient, new ArrayList<>());
            }

            allMessages.get(recipient).add(new Message(recipient, username, message));

            if (recipient.equals(currentRecipient)) {
                System.out.println(username + ": Adding to message view as my message");
                messageView.getChildren().add(new MessageVBox(username, message, true));
            }

            mediator.sendMessage(username, recipient, message);
        }
    }

    public void receiveMessage(String sender, String message) {
        System.out.println("[" + username + "] received message from " + sender + ": " + message);
        if (!allMessages.containsKey(sender)) {
            allMessages.put(sender, new ArrayList<>());
        }

        allMessages.get(sender).add(new Message(username, sender, message));
        if (sender.equals(currentRecipient)) {
            System.out.println(username + ": Adding to message view as someone elses message");
            messageView.getChildren().add(new MessageVBox(sender, message, false));
        }
    }

    public String getUsername() {
        return username;
    }

    public String getCurrentRecipient() {
        return currentRecipient;
    }
}