package resource;

import java.util.ResourceBundle;

/**
 * The type Db manager.
 * Gets properties from "db.properties"
 *
 * @author George Kvirikashvili
 */
public class DbManager {
    private final static ResourceBundle resourceBundle = ResourceBundle.getBundle("db");

    private DbManager() {
    }

    /**
     * Gets property.
     *
     * @param key the key
     * @return the property
     */
    public static String getProperty(String key) {
        return resourceBundle.getString(key);
    }
}
