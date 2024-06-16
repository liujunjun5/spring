package bean;

import java.util.HashMap;
import java.util.Map;

public class UserDao {
    private static Map<String, String> hashMap = new HashMap<String, String>();

    static {
        hashMap.put("user", "user");
        hashMap.put("admin", "admin");
        hashMap.put("user2", "user2");
        hashMap.put("admin2", "admin2");
    }

    public String queryUserName(String uid) {
        return hashMap.get(uid);
    }
}
