package W_5.proxy;

public class User {
    public final String username;

    public User(String username) {
        System.out.println("Created user with username @" + username);
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public String toString(){
        return "User @" + this.username;
    }
}
