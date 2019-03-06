package builder.impl;

import builder.Builder;
import builder.exception.BuilderException;
import entity.Person;
import entity.Request;
import entity.RequestSex;
import entity.RequestType;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonBuilderImpl implements Builder<Request> {
    public static final String TABLE_NAME = "person";
    private static final String PERSON_ID = "person_id";
    private static final String FULL_NAME = "full_name";
    private static final String SEX_ID = "sex_id";
    private static final String TYPE_ID = "type_id";
    private static final String BIRTH_DATE = "birth_date";
    private static final String NATIONALITY = "nationality";
    private static final String FILE_LINK = "file_link";

    private PersonBuilderImpl() {
    }

    public static PersonBuilderImpl getInstance() {
        return PersonBuilderImpl.InstanceHolder.INSTANCE;
    }

    private static class InstanceHolder {
        private static final PersonBuilderImpl INSTANCE = new PersonBuilderImpl();
    }

    @Override
    public Person build(ResultSet resultSet) throws BuilderException {
        try {
            int id = resultSet.getInt(PERSON_ID);
            String fullName = resultSet.getString(FULL_NAME);
            int sexId = resultSet.getInt(SEX_ID);
            RequestSex sex = RequestSex.getById(sexId);
            int typeId = resultSet.getInt(TYPE_ID);
            RequestType type = RequestType.getById(typeId);
            Date birthDate = resultSet.getDate(BIRTH_DATE);
            String nationality = resultSet.getString(NATIONALITY);
            String fileLink = resultSet.getString(FILE_LINK);

            return new Person(id, sex, type, fullName, nationality, birthDate, fileLink);
        } catch (SQLException e) {
            throw new BuilderException("Can't build Person", e);
        }
    }
}
