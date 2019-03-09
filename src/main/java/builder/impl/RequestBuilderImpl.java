package builder.impl;

import builder.Builder;
import builder.exception.BuilderException;
import entity.PersonSex;
import entity.PersonType;
import entity.Request;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RequestBuilderImpl implements Builder<Request> {
    public static final String TABLE_NAME = "request";
    public static final String REQUEST_ID = "request_id";
    public static final String FULL_NAME = "full_name";
    public static final String SEX_ID = "sex_id";
    public static final String TYPE_ID = "type_id";
    public static final String BIRTH_DATE = "birth_date";
    public static final String NATIONALITY = "nationality";
    private static final String FILE_LINK = "file_link";
    public static final String REQUEST_FILE = "request_file";

    private RequestBuilderImpl() {
    }

    public static RequestBuilderImpl getInstance() {
        return RequestBuilderImpl.InstanceHolder.INSTANCE;
    }

    private static class InstanceHolder {
        private static final RequestBuilderImpl INSTANCE = new RequestBuilderImpl();
    }

    @Override
    public Request build(ResultSet resultSet) throws BuilderException {
        try {
            int id = resultSet.getInt(REQUEST_ID);
            String fullName = resultSet.getString(FULL_NAME);
            int sexId = resultSet.getInt(SEX_ID);
            PersonSex sex = PersonSex.getById(sexId);
            int typeId = resultSet.getInt(TYPE_ID);
            PersonType type = PersonType.getById(typeId);
            Date birthDate = resultSet.getDate(BIRTH_DATE);
            String nationality = resultSet.getString(NATIONALITY);
            String fileLink = resultSet.getString(FILE_LINK);

            return new Request(id, sex, type, fullName, nationality, birthDate, fileLink);
        } catch (SQLException e) {
            throw new BuilderException("Can't build Request", e);
        }
    }
}
