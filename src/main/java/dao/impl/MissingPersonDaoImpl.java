package dao.impl;

import entity.Person;

/**
 * Contains methods to work with missing persons
 * from "person" table and its representation
 * {@link Person}
 * Singleton.
 *
 * @author George Kvirikashvili
 */
public class MissingPersonDaoImpl extends PersonDaoImpl {
    private MissingPersonDaoImpl() {
    }

    /**
     * Gets singleton instance.
     *
     * @return the instance
     */
    public static MissingPersonDaoImpl getInstance() {
        return MissingPersonDaoImpl.InstanceHolder.INSTANCE;
    }

    private static class InstanceHolder {
        private static final MissingPersonDaoImpl INSTANCE = new MissingPersonDaoImpl();
    }

    private static final String SELECT_PERSON_ALL = "SELECT interpol.person.id AS person_id,\n" +
            "       interpol.person.sex_id AS sex_id,\n" +
            "       interpol.person.type_id AS type_id,\n" +
            "       interpol.person.full_name AS full_name,\n" +
            "       interpol.person.nationality AS nationality,\n" +
            "       interpol.person.birth_date AS birth_date,\n" +
            "       interpol.person.file_link AS file_link\n" +
            "       FROM interpol.person person\n" +
            "       WHERE person.type_id = 1\n" +
            "       ORDER BY person.id desc ";

    private static final String SELECT_PERSON_ALL_PAGE = "SELECT interpol.person.id AS person_id,\n" +
            "       interpol.person.sex_id AS sex_id,\n" +
            "       interpol.person.type_id AS type_id,\n" +
            "       interpol.person.full_name AS full_name,\n" +
            "       interpol.person.nationality AS nationality,\n" +
            "       interpol.person.birth_date AS birth_date,\n" +
            "       interpol.person.file_link AS file_link\n" +
            "       FROM interpol.person person\n" +
            "       WHERE person.type_id = 1\n" +
            "       ORDER BY person.id desc \n" +
            "       LIMIT 6 OFFSET ? ";

    @Override
    public String getFindAllQuery() {
        return SELECT_PERSON_ALL;
    }

    @Override
    public String getFindAllPageQuery() {
        return SELECT_PERSON_ALL_PAGE;
    }
}
