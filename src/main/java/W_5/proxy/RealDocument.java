package W_5.proxy;

public class RealDocument implements Document {
    private static long totalDocuments;

    private final long id;
    private final long creationDate;
    private final String content;

    public RealDocument(String content){
        this.id = totalDocuments++;
        this.creationDate = System.currentTimeMillis();
        this.content = content;
    }

    @Override
    public long getId(){
        return this.id;
    }

    @Override
    public long getCreationDate(){
        return this.creationDate;
    }

    @Override
    public String getContent(User user){
        System.out.println("[RealDocument] " + user + " has opened the contents of " + this);
        return this.content;
    }

    public String toString(){
        return "Document #" + this.id;
    }
}