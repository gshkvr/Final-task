package builder.impl;

import builder.Builder;
import entity.impl.Request;
import exception.BuilderException;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RequestBuilder implements Builder<Request> {
    @Override
    public Request build(ResultSet resultSet) throws BuilderException {
        try {
            int id = resultSet.getInt(Request.REQUEST_ID);
            String name = resultSet.getString(Request.REQUEST_NAME);
            String fileLink = resultSet.getString(Request.REQUEST_FILE_LINK);

            return new Request(id, name, fileLink);
        } catch (SQLException e) {
            throw new BuilderException("Can't build Request", e);
        }
    }
}
