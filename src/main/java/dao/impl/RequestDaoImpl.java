package dao.impl;

import builder.impl.RequestBuilderImpl;
import dao.AbstractDao;
import dao.RequestDao;
import entity.PersonSex;
import entity.PersonType;
import entity.Request;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Contains methods to work with
 * "request" table and its representation
 * {@link Request}
 * Singleton.
 *
 * @author George Kvirikashvili
 */
public class RequestDaoImpl extends AbstractDao<Integer, Request> implements RequestDao {
    private RequestDaoImpl() {
    }

    /**
     * Gets singleton instance.
     *
     * @return the instance
     */
    public static RequestDaoImpl getInstance() {
        return RequestDaoImpl.InstanceHolder.INSTANCE;
    }

    private static class InstanceHolder {
        private static final RequestDaoImpl INSTANCE = new RequestDaoImpl();
    }

    private static final String SELECT_REQUEST_ALL = "SELECT interpol.request.id AS request_id,\n" +
            "       interpol.request.sex_id AS sex_id,\n" +
            "       interpol.request.type_id AS type_id,\n" +
            "       interpol.request.full_name AS full_name,\n" +
            "       interpol.request.nationality AS nationality,\n" +
            "       interpol.request.birth_date AS birth_date,\n" +
            "       interpol.request.file_link AS file_link\n" +
            "       FROM interpol.request request\n" +
            "       ORDER BY request.id desc ";

    private static final String SELECT_REQUEST_BY_ID = "SELECT interpol.request.id AS request_id,\n" +
            "       interpol.request.sex_id AS sex_id,\n" +
            "       interpol.request.type_id AS type_id,\n" +
            "       interpol.request.full_name AS full_name,\n" +
            "       interpol.request.nationality AS nationality,\n" +
            "       interpol.request.birth_date AS birth_date,\n" +
            "       interpol.request.file_link AS file_link\n" +
            "       FROM interpol.request request\n" +
            "       WHERE request.id = ?";

    private static final String CREATE_REQUEST = "insert into interpol.request (full_name, nationality, " +
            "       sex_id, type_id, birth_date, file_link) " +
            "       values (?,?,?,?,?,?)";

    private static final String UPDATE_REQUEST = "update interpol.request set full_name=?, nationality=?, " +
            "       sex_id=?, type_id=?, birth_date=?, file_link=? " +
            "       where id=?";

    private static final String DELETE_REQUEST = "delete from interpol.request where id=?";

    @Override
    protected String getTableName() {
        return RequestBuilderImpl.TABLE_NAME;
    }

    @Override
    protected String getFindEntityByIdQuery() {
        return SELECT_REQUEST_BY_ID;
    }

    @Override
    protected String getFindAllQuery() {
        return SELECT_REQUEST_ALL;
    }

    @Override
    public String getCreateQuery() {
        return CREATE_REQUEST;
    }

    @Override
    public String getUpdateQuery() {
        return UPDATE_REQUEST;
    }

    @Override
    public String getDeleteQuery() {
        return DELETE_REQUEST;
    }

    @Override
    protected List<String> getParametersForCreate(Request entity) {
        List<String> parameters = new ArrayList<>();
        String fullName = entity.getFullName();
        parameters.add(fullName);
        String nationality = entity.getNationality();
        parameters.add(nationality);
        PersonSex sex = entity.getSex();
        int sexId = sex.getId();
        parameters.add(String.valueOf(sexId));
        PersonType type = entity.getType();
        int typeId = type.getId();
        parameters.add(String.valueOf(typeId));
        Date birthDate = entity.getBirthDate();
        parameters.add(birthDate.toString());
        String fileLink = entity.getFileLink();
        parameters.add(fileLink);
        return parameters;
    }
}
