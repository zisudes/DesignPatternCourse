package W_6.mediator;

import javafx.application.Application;
import javafx.stage.Stage;

import java.util.List;

public class ChatApp extends Application {
    @Override
    public void start(Stage primaryStage) {
        Mediator mediator = new Mediator();

        List<ChatClient> clients = List.of(
                new ChatClient("username", mediator),
                new ChatClient("another guy", mediator),
                new ChatClient("someone else", mediator)
        );

        clients.forEach(client -> {
            Stage stage = new Stage();
            stage.setTitle("ChatApp");
            stage.setScene(client.getScene());
            stage.setMinWidth(240);
            stage.setMaxWidth(240);

            stage.setMinHeight(340);
            stage.setMaxHeight(340);
            stage.show();
        });
    }
}
