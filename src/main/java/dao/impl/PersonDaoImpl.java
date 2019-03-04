package dao.impl;

import builder.impl.PersonBuilderImpl;
import dao.AbstractDao;
import dao.PersonDao;
import entity.Person;
import entity.RequestSex;
import entity.RequestType;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class PersonDaoImpl extends AbstractDao<Integer, Person> implements PersonDao {
    private PersonDaoImpl() {
    }

    public static PersonDaoImpl getInstance() {
        return PersonDaoImpl.InstanceHolder.INSTANCE;
    }

    private static class InstanceHolder {
        private static final PersonDaoImpl INSTANCE = new PersonDaoImpl();
    }

    private static final String SELECT_PERSON_ALL = "SELECT interpol.person.id AS person_id,\n" +
            "       interpol.person.sex_id AS sex_id,\n" +
            "       interpol.person.type_id AS type_id,\n" +
            "       interpol.person.full_name AS full_name,\n" +
            "       interpol.person.nationality AS nationality,\n" +
            "       interpol.person.birth_date AS birth_date,\n" +
            "       interpol.person.file_link AS file_link\n" +
            "       FROM interpol.person person";

    private static final String SELECT_PERSON_BY_ID = "SELECT interpol.person.id AS person_id,\n" +
            "       interpol.person.sex_id AS sex_id,\n" +
            "       interpol.person.type_id AS type_id,\n" +
            "       interpol.person.full_name AS full_name,\n" +
            "       interpol.person.nationality AS nationality,\n" +
            "       interpol.person.birth_date AS birth_date,\n" +
            "       interpol.person.file_link AS file_link\n" +
            "       FROM interpol.person person\n" +
            "       WHERE person.id = ?";

    private static final String CREATE_PERSON = "insert into interpol.person (full_name, sex_id," +
            "       type_id, birth_date, nationality, file_link) " +
            "       values (?,?,?,?,?,?)";

    private static final String UPDATE_PERSON = "update interpol.person set full_name=?, sex_id=?," +
            "       type_id=?, birth_date=?, nationality=?, file_link=? " +
            "       where id=?";

    private static final String DELETE_PERSON = "delete from interpol.person where id=?";

    @Override
    protected String getTableName() {
        return PersonBuilderImpl.TABLE_NAME;
    }

    @Override
    protected String getFindEntityByIdQuery() {
        return SELECT_PERSON_BY_ID;
    }

    @Override
    protected String getFindAllQuery() {
        return SELECT_PERSON_ALL;
    }

    @Override
    public String getCreateQuery() {
        return CREATE_PERSON;
    }

    @Override
    public String getUpdateQuery() {
        return UPDATE_PERSON;
    }

    @Override
    public String getDeleteQuery() {
        return DELETE_PERSON;
    }

    @Override
    protected List<String> getParametersForCreate(Person entity) {
        List<String> parameters = new ArrayList<>();
        String fullName = entity.getFullName();
        parameters.add(fullName);
        RequestSex sex = entity.getSex();
        int sexId = sex.getId();
        parameters.add(String.valueOf(sexId));
        RequestType type = entity.getType();
        int typeId = type.getId();
        parameters.add(String.valueOf(typeId));
        Date birthDate = entity.getBirthDate();
        parameters.add(birthDate.toString());
        String nationality = entity.getNationality();
        parameters.add(nationality);
        String fileLink = entity.getFileLink();
        parameters.add(fileLink);
        return parameters;
    }
}
