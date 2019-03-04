package builder.impl;

import builder.Builder;
import entity.User;
import entity.UserRole;
import builder.exception.BuilderException;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserBuilderImpl implements Builder<User> {

    public static final String TABLE_NAME = "user";
    public static final String USER_ID = "user_id";
    public static final String USER_ROLE_ID = "user_role_id";
    public static final String USER_ROLE = "role";
    public static final String LOGIN = "login";
    public static final String PASSWORD = "password";
    public static final String CONFIRM_PASSWORD = "confirm_password";
    public static final String EMAIL = "email";
    public static final String FIRST_NAME = "first_name";
    public static final String LAST_NAME = "last_name";

    private UserBuilderImpl() {
    }

    public static UserBuilderImpl getInstance() {
        return UserBuilderImpl.InstanceHolder.INSTANCE;
    }

    private static class InstanceHolder {
        private static final UserBuilderImpl INSTANCE = new UserBuilderImpl();
    }

    @Override
    public User build(ResultSet resultSet) throws BuilderException {
        try {
            int id = resultSet.getInt(USER_ID);
            int roleId = resultSet.getInt(USER_ROLE_ID);
            UserRole userRole = UserRole.getById(roleId);
            String login = resultSet.getString(LOGIN);
            String password = resultSet.getString(PASSWORD);
            String email = resultSet.getString(EMAIL);
            String firstName = resultSet.getString(FIRST_NAME);
            String lastName = resultSet.getString(LAST_NAME);

            return new User(id, userRole, login, password, email, firstName, lastName);
        } catch (SQLException e) {
            throw new BuilderException("Can't build User", e);
        }
    }
}
