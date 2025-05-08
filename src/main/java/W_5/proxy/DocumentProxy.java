package W_5.proxy;

public class DocumentProxy implements Document {
    private final long id;
    private final long creationDate;

    private final RealDocument realDocument;

    public DocumentProxy(String content){
        this.realDocument = new RealDocument(content);
        this.id = this.realDocument.getId();
        this.creationDate = this.realDocument.getCreationDate();
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
        AccessControlService accessControl = AccessControlService.getInstance();
        if (accessControl.isAllowed( user, this.realDocument)){
            System.out.println("[DocumentProxy] Checking... " + user + " has access to document " + this);
            return this.realDocument.getContent(user);
        } else {
            System.out.println("[DocumentProxy] Checking... " + user + " has no permission to access document " + this);
            throw new AccessDeniedException(user + " has no permission to open " + this);
        }
    }

    public String toString(){
        return "Document #" + this.id + " (PROTECTED)";
    }
}
