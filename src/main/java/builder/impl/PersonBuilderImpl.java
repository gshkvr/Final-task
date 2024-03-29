package builder.impl;

import builder.Builder;
import builder.exception.BuilderException;
import entity.Person;
import entity.PersonSex;
import entity.PersonType;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Creates an object {@link Person}
 * Singleton.
 *
 * @author George Kvirikashvili
 */
public class PersonBuilderImpl implements Builder<Person> {
    /**
     * Constants to get values from sql request.
     */
    public static final String TABLE_NAME = "person";
    static final String PERSON_ID = "person_id";
    static final String FULL_NAME = "full_name";
    static final String SEX_ID = "sex_id";
    static final String TYPE_ID = "type_id";
    static final String BIRTH_DATE = "birth_date";
    static final String NATIONALITY = "nationality";
    static final String FILE_LINK = "file_link";

    private PersonBuilderImpl() {
    }

    /**
     * Gets singleton instance.
     *
     * @return the instance
     */
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
            PersonSex sex = PersonSex.getById(sexId);
            int typeId = resultSet.getInt(TYPE_ID);
            PersonType type = PersonType.getById(typeId);
            Date birthDate = resultSet.getDate(BIRTH_DATE);
            String nationality = resultSet.getString(NATIONALITY);
            String fileLink = resultSet.getString(FILE_LINK);

            return new Person(id, sex, type, fullName, nationality, birthDate, fileLink);
        } catch (SQLException e) {
            throw new BuilderException("Can't build Person", e);
        }
    }
}
