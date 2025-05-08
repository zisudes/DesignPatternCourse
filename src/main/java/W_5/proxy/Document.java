package W_5.proxy;

public interface Document {
    long getId();
    long getCreationDate();
    String getContent(User user);
}