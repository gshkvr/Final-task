package dao.impl;

import builder.impl.UserBuilderImpl;
import dao.AbstractDao;
import dao.UserDao;
import dao.exception.DaoException;
import entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Contains methods to work with
 * "user" table and its representation
 * {@link User}
 * Singleton.
 *
 * @author George Kvirikashvili
 */
public class UserDaoImpl extends AbstractDao<Integer, User> implements UserDao {
    private UserDaoImpl() {
    }

    /**
     * Gets singleton instance.
     *
     * @return the instance
     */
    public static UserDaoImpl getInstance() {
        return UserDaoImpl.InstanceHolder.INSTANCE;
    }

    private static class InstanceHolder {
        private static final UserDaoImpl INSTANCE = new UserDaoImpl();
    }

    private static final String SELECT_USER_ALL = "SELECT interpol.user.id AS user_id,\n" +
            "       interpol.user.user_role_id AS user_role_id,\n" +
            "       interpol.user.login AS login,\n" +
            "       interpol.user.password AS password,\n" +
            "       interpol.user.email AS email,\n" +
            "       interpol.user.first_name AS first_name,\n" +
            "       interpol.user.last_name AS last_name\n" +
            "       FROM interpol.user user";

    private static final String SELECT_USER_BY_ID = "SELECT interpol.user.id AS user_id,\n" +
            "       interpol.user.user_role_id AS user_role_id,\n" +
            "       interpol.user.login AS login,\n" +
            "       interpol.user.password AS password,\n" +
            "       interpol.user.email AS email,\n" +
            "       interpol.user.first_name AS first_name,\n" +
            "       interpol.user.last_name AS last_name\n" +
            "       FROM interpol.user user\n" +
            "       WHERE user.id = ?";

    private static final String SELECT_USER_BY_LOGIN = "SELECT interpol.user.id AS user_id,\n" +
            "       interpol.user.user_role_id AS user_role_id,\n" +
            "       interpol.user.login AS login,\n" +
            "       interpol.user.password AS password,\n" +
            "       interpol.user.email AS email,\n" +
            "       interpol.user.first_name AS first_name,\n" +
            "       interpol.user.last_name AS last_name\n" +
            "       FROM interpol.user user\n" +
            "       WHERE user.login = ?";

    private static final String SELECT_USER_BY_EMAIL = "SELECT interpol.user.id AS user_id,\n" +
            "       interpol.user.user_role_id AS user_role_id,\n" +
            "       interpol.user.login AS login,\n" +
            "       interpol.user.password AS password,\n" +
            "       interpol.user.email AS email,\n" +
            "       interpol.user.first_name AS first_name,\n" +
            "       interpol.user.last_name AS last_name\n" +
            "       FROM interpol.user user\n" +
            "       WHERE user.email = ?";

    private static final String CREATE_USER = "insert into interpol.user (user_role_id, login, " +
            "       password, email, first_name, last_name) " +
            "       values (?,?,?,?,?,?)";

    private static final String UPDATE_USER = "update interpol.user set user_role_id=?, login=?, " +
            "       password=?, email=?, first_name=?, last_name=? " +
            "       where id=?";

    private static final String DELETE_USER = "delete from interpol.user where id=?";

    @Override
    protected String getTableName() {
        return UserBuilderImpl.TABLE_NAME;
    }

    @Override
    protected String getFindEntityByIdQuery() {
        return SELECT_USER_BY_ID;
    }

    @Override
    protected String getFindAllQuery() {
        return SELECT_USER_ALL;
    }

    @Override
    public String getCreateQuery() {
        return CREATE_USER;
    }

    @Override
    public String getUpdateQuery() {
        return UPDATE_USER;
    }

    @Override
    public String getDeleteQuery() {
        return DELETE_USER;
    }

    @Override
    public Optional<User> findUserByLogin(String login) throws DaoException {
        String query = getFindUserByLoginQuery();
        return executeEntityQuery(query, login);
    }

    @Override
    public Optional<User> findUserByEmail(String email) throws DaoException {
        String query = getFindUserByEmailQuery();
        return executeEntityQuery(query, email);
    }

    @Override
    protected List<String> getParametersForCreate(User entity) {
        List<String> parameters = new ArrayList<>();
        int roleId = entity.getRole().getId();
        String sRoleId = String.valueOf(roleId);
        parameters.add(sRoleId);
        String login = entity.getLogin();
        parameters.add(login);
        String password = entity.getPassword();
        parameters.add(password);
        String email = entity.getEmail();
        parameters.add(email);
        String firstName = entity.getFirstName();
        parameters.add(firstName);
        String lastName = entity.getLastName();
        parameters.add(lastName);
        return parameters;
    }

    private String getFindUserByLoginQuery() {
        return SELECT_USER_BY_LOGIN;
    }

    private String getFindUserByEmailQuery() {
        return SELECT_USER_BY_EMAIL;
    }

}
