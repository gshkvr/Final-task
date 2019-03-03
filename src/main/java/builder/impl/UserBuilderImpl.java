package builder.impl;

import builder.Builder;
import entity.User;
import entity.UserRole;
import builder.exception.BuilderException;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserBuilderImpl implements Builder<User> {
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
            int id = resultSet.getInt(User.USER_ID);
            int roleId = resultSet.getInt(User.USER_ROLE_ID);
            UserRole userRole = UserRole.getById(roleId);
            String login = resultSet.getString(User.LOGIN);
            String password = resultSet.getString(User.PASSWORD);
            String email = resultSet.getString(User.EMAIL);
            String firstName = resultSet.getString(User.FIRST_NAME);
            String lastName = resultSet.getString(User.LAST_NAME);

            return new User(id, userRole, login, password, email, firstName, lastName);
        } catch (SQLException e) {
            throw new BuilderException("Can't build User", e);
        }
    }
}
