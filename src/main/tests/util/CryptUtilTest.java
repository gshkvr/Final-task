package util;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CryptUtilTest {
    private static final String PASSWORD = "admin";
    private static final String HASH_PASSWORD = "$2a$10$5cXbc/vvmRXhp1fAyoK4C.rh9GeGD36qHtChfxzMlkMSarTqMHxvq";
    private static final CryptUtil cryptUtil = CryptUtil.getInstance();

    @Test
    public void testCheckPassword() {
        boolean expected = cryptUtil.checkPassword(PASSWORD, HASH_PASSWORD);
        Assert.assertTrue(expected);
    }
}