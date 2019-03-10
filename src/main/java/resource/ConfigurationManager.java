package resource;

import java.util.ResourceBundle;

/**
 * The type Configuration manager.
 * Gets properties from "config.properties"
 *
 * @author George Kvirikashvili
 */
public class ConfigurationManager {
    private final static ResourceBundle resourceBundle = ResourceBundle.getBundle("config");

    private ConfigurationManager() {
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