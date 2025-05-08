package W_5.proxy;

import java.util.ArrayList;
import java.util.HashMap;

public class AccessControlService {
    private static AccessControlService instance;
    private static HashMap<Long, ArrayList<String>> accessTable;
    private AccessControlService() {}

    public static AccessControlService getInstance() {
        if (instance == null){
            instance = new AccessControlService();
            accessTable = new HashMap<>();
        }
        return instance;
    }

    public void grantAccess(User user, Document document){
        System.out.println("[AccessControlService] Granting access for document " + document + " to user " + user);
        if (accessTable.containsKey(document.getId())) {
            accessTable.get(document.getId()).add(user.getUsername());
        } else {
            ArrayList<String> usersWithAccess = new ArrayList<>();
            usersWithAccess.add(user.getUsername());
            accessTable.put(document.getId(), usersWithAccess);
        }
    }

    public boolean isAllowed(User user, Document document) {
        return accessTable.containsKey(document.getId()) && accessTable.get(document.getId()).contains(user.getUsername());
    }
}
