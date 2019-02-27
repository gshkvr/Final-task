package builder.impl;

import builder.Builder;
import entity.impl.User;
import entity.impl.UserRole;
import exception.BuilderException;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserBuilder implements Builder<User> {
    @Override
    public User build(ResultSet resultSet) throws BuilderException {
        try {
            return new User(resultSet.getInt(User.ID),
                    UserRole.getById(resultSet.getInt(User.USER_ROLE_ID)),
                    resultSet.getString(User.LOGIN),
                    resultSet.getString(User.PASS),
                    resultSet.getString(User.EMAIL),
                    resultSet.getString(User.FIRST_NAME),
                    resultSet.getString(User.LAST_NAME));
        } catch (SQLException e) {
            throw new BuilderException("Can't build User", e);
        }
    }
}
