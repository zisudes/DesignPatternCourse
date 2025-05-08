package W_6.mediator;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Mediator {
    private final Map<String, ChatClient> clients = new HashMap<>();

    public void registerClient(String user, ChatClient client) {
        clients.put(user, client);
    }

    public Set<String> getUsernames() {
        return clients.keySet();
    }

    public boolean userExists(String user) {
        return clients.containsKey(user);
    }

    public void sendMessage(String sender, String recipient, String message) {
        ChatClient recipientClient = clients.get(recipient);
        if (recipientClient != null) {
            recipientClient.receiveMessage(sender, message);
        } else {
            System.out.println("Recipient not found: " + recipient);
        }
    }
}
