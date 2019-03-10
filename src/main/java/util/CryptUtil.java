package util;

import org.mindrot.jbcrypt.BCrypt;

/**
 * The type Crypt util.
 * Singleton.
 *
 * @author George Kvirikashvili
 */
public class CryptUtil {
    private CryptUtil() {
    }

    /**
     * Gets singleton instance.
     *
     * @return the instance
     */
    public static CryptUtil getInstance() {
        return CryptUtil.InstanceHolder.INSTANCE;
    }

    private static class InstanceHolder {
        private static final CryptUtil INSTANCE = new CryptUtil();
    }

    /**
     * Check password boolean.
     *
     * @param enteredPass the entered pass
     * @param storedPass  the stored pass
     * @return the boolean
     */
    public boolean checkPassword(String enteredPass, String storedPass) {
        return BCrypt.checkpw(enteredPass, storedPass);
    }

    /**
     * Crypt password string.
     *
     * @param password the password
     * @return the string
     */
    public String cryptPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }
}
