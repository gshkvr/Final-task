package builder.impl;

import builder.Builder;
import builder.exception.BuilderException;
import entity.User;
import entity.UserRole;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserBuilderImplTest {
    private static final int USER_ID = 1;
    private static final UserRole USER_ROLE = entity.UserRole.ADMIN;
    private static final String USER_LOGIN = "login";
    private static final String USER_PASSWORD = "password";
    private static final String USER_EMAIL = "email";
    private static final String USER_FIRST_NAME = "firstName";
    private static final String USER_LAST_NAME = "lastName";
    private static final Builder USER_BUILDER = UserBuilderImpl.getInstance();
    private static final User EXPECTED = new User(USER_ID, USER_ROLE, USER_LOGIN, USER_PASSWORD,
            USER_EMAIL, USER_FIRST_NAME, USER_LAST_NAME);

    @Test
    public void testBuild() throws SQLException, BuilderException {
        ResultSet resultSet = mock(ResultSet.class);
        when(resultSet.getInt(UserBuilderImpl.USER_ID)).thenReturn(USER_ID);
        when(resultSet.getInt(UserBuilderImpl.USER_ROLE_ID)).thenReturn(USER_ROLE.getId());
        when(resultSet.getString(UserBuilderImpl.LOGIN)).thenReturn(USER_LOGIN);
        when(resultSet.getString(UserBuilderImpl.PASSWORD)).thenReturn(USER_PASSWORD);
        when(resultSet.getString(UserBuilderImpl.EMAIL)).thenReturn(USER_EMAIL);
        when(resultSet.getString(UserBuilderImpl.FIRST_NAME)).thenReturn(USER_FIRST_NAME);
        when(resultSet.getString(UserBuilderImpl.LAST_NAME)).thenReturn(USER_LAST_NAME);
        User actual = (User) USER_BUILDER.build(resultSet);
        Assert.assertEquals(actual, EXPECTED);
    }
}