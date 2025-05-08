package W_5.proxy;

public class Main {
    public static void main(String[] args) {
        System.out.println("\u001B[33m=== creating users ===\u001B[0m");

        User permissionUser = new User("permissionUser");
        User noPermissionUser = new User("noPermissionUser");

        // ###################################################################################
        System.out.println("\u001B[33m\n=== creating library, adding documents to it ===\u001B[0m");

        Library library = new Library();

        RealDocument unprotectedDocument = new RealDocument("this is all unprotected content");
        library.addDocument(unprotectedDocument);

        DocumentProxy protectedDocument = new DocumentProxy("content that is protected");
        library.addDocument(protectedDocument);

        DocumentProxy otherProtectedDocument = new DocumentProxy("more content that is also protected");
        library.addDocument(otherProtectedDocument);

        // ###################################################################################
        System.out.println("\u001B[33m\n=== granting access to @permissionUser to everything ===\u001B[0m");

        AccessControlService service = AccessControlService.getInstance();
        service.grantAccess(permissionUser, protectedDocument);
        service.grantAccess(permissionUser, otherProtectedDocument);

        // ###################################################################################
        System.out.println("\u001B[33m\n=== opening documents as @permissionUser ===\u001B[0m");

        library.openDocumentAsUser(unprotectedDocument.getId(), permissionUser);
        System.out.println();
        library.openDocumentAsUser(protectedDocument.getId(), permissionUser);
        System.out.println();
        library.openDocumentAsUser(otherProtectedDocument.getId(), permissionUser);

        // ###################################################################################
        System.out.println("\u001B[33m\n=== opening documents as @noPermissionUser ===\u001B[0m");

        library.openDocumentAsUser(unprotectedDocument.getId(), noPermissionUser);
        System.out.println();
        library.openDocumentAsUser(protectedDocument.getId(), noPermissionUser);
        System.out.println();
        library.openDocumentAsUser(otherProtectedDocument.getId(), noPermissionUser);
    }
}
