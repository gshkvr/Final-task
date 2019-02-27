package util;

import org.mindrot.jbcrypt.BCrypt;

public class CryptUtil {
    private CryptUtil() {
    }

    public static CryptUtil getInstance() {
        return CryptUtil.InstanceHolder.INSTANCE;
    }

    private static class InstanceHolder {
        private static final CryptUtil INSTANCE = new CryptUtil();
    }

    public boolean checkPassword(String enteredPass, String storedPass){
        return BCrypt.checkpw(enteredPass, storedPass);
    }

    public String cryptPassword(String password){
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }
}
