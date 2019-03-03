package builder.impl;

import builder.Builder;
import builder.exception.BuilderException;
import entity.Request;
import entity.RequestSex;
import entity.RequestType;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RequestBuilderImpl implements Builder<Request> {
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
            int id = resultSet.getInt(Request.REQUEST_ID);
            String fullName = resultSet.getString(Request.FULL_NAME);
            int sexId = resultSet.getInt(Request.SEX_ID);
            RequestSex sex = RequestSex.getById(sexId);
            int typeId = resultSet.getInt(Request.TYPE_ID);
            RequestType type = RequestType.getById(typeId);
            Date birthDate = resultSet.getDate(Request.BIRTH_DATE);
            String nationality = resultSet.getString(Request.NATIONALITY);
            String fileLink = resultSet.getString(Request.FILE_LINK);

            return new Request(id, sex, type, fullName, nationality, birthDate, fileLink);
        } catch (SQLException e) {
            throw new BuilderException("Can't build Request", e);
        }
    }
}
