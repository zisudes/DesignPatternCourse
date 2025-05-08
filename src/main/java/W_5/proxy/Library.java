package W_5.proxy;

import java.util.HashMap;

public class Library {
    private final HashMap<Long, Document> library;

    public Library(){
        library = new HashMap<>();
    }

    public Document getDocumentById(long id){
        return library.get(id);
    }

    public void addDocument(Document document){
        System.out.println("[Library] Adding document " + document + " to library");
        library.put(document.getId(), document);
    }

    public void openDocumentAsUser(long documentId, User user){
        Document document = getDocumentById(documentId);
        try {
            System.out.println("[Library] Contents of " + document + ": \"" + document.getContent(user) + "\"");
        } catch (AccessDeniedException e){
            System.out.println("\u001B[31mcaught AccessDeniedException: " + e.getMessage() + "\u001B[0m");
        }
    }
}