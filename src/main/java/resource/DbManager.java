package resource;

import java.util.ResourceBundle;

public class DbManager {
    private final static ResourceBundle resourceBundle = ResourceBundle.getBundle("db");
    private DbManager() { }
    public static String getProperty(String key) {
        return resourceBundle.getString(key);
    }
}
