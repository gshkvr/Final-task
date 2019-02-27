package dao.impl;

import dao.AbstractDao;
import dao.QueryEnum;
import entity.impl.User;
import exception.DaoException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDao extends AbstractDao<Integer, User> {
    protected String getFindUserByLoginQuery() {
        return QueryEnum.SELECT_USER_BY_LOGIN.getQuery();
    }

    protected String getFindUserByEmailQuery() {
        return QueryEnum.SELECT_USER_BY_EMAIL.getQuery();
    }

    @Override
    protected String getFindEntityByIdQuery() {
        return QueryEnum.SELECT_USER_BY_ID.getQuery();
    }

    @Override
    protected String getFindAllQuery() {
        return QueryEnum.SELECT_USER_ALL.getQuery();
    }

    @Override
    public String getCreateQuery() {
        return QueryEnum.CREATE_USER.getQuery();
    }

    @Override
    public String getUpdateQuery() {
        return QueryEnum.UPDATE_USER.getQuery();
    }

    @Override
    public String getDeleteQuery() {
        return QueryEnum.DELETE_USER.getQuery();
    }

    @Override
    protected String getTableName() {
        return User.TABLE_NAME;
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
        String firstName = entity.getFirst_name();
        parameters.add(firstName);
        String lastName = entity.getLast_name();
        parameters.add(lastName);
        return parameters;
    }

    public Optional<User> findUserByLogin(String login) throws DaoException {
        String query = getFindUserByLoginQuery();
        return executeEntityQuery(query, login);
    }

    public Optional<User> findUserByEmail(String email) throws DaoException {
        String query = getFindUserByEmailQuery();
        return executeEntityQuery(query, email);
    }
}
