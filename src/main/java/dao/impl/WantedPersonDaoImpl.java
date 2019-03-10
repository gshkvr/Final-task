package dao.impl;

import entity.Person;

/**
 * Contains methods to work with wanted persons
 * from "person" table and its representation
 * {@link Person}
 * Singleton.
 *
 * @author George Kvirikashvili
 */
public class WantedPersonDaoImpl extends PersonDaoImpl {
    private WantedPersonDaoImpl() {
    }

    /**
     * Gets singleton instance.
     *
     * @return the instance
     */
    public static WantedPersonDaoImpl getInstance() {
        return WantedPersonDaoImpl.InstanceHolder.INSTANCE;
    }

    private static class InstanceHolder {
        private static final WantedPersonDaoImpl INSTANCE = new WantedPersonDaoImpl();
    }

    private static final String SELECT_PERSON_ALL = "SELECT interpol.person.id AS person_id,\n" +
            "       interpol.person.sex_id AS sex_id,\n" +
            "       interpol.person.type_id AS type_id,\n" +
            "       interpol.person.full_name AS full_name,\n" +
            "       interpol.person.nationality AS nationality,\n" +
            "       interpol.person.birth_date AS birth_date,\n" +
            "       interpol.person.file_link AS file_link\n" +
            "       FROM interpol.person person\n" +
            "       WHERE person.type_id = 2\n" +
            "       ORDER BY person.id desc ";

    private static final String SELECT_PERSON_ALL_PAGE = "SELECT interpol.person.id AS person_id,\n" +
            "       interpol.person.sex_id AS sex_id,\n" +
            "       interpol.person.type_id AS type_id,\n" +
            "       interpol.person.full_name AS full_name,\n" +
            "       interpol.person.nationality AS nationality,\n" +
            "       interpol.person.birth_date AS birth_date,\n" +
            "       interpol.person.file_link AS file_link\n" +
            "       FROM interpol.person person\n" +
            "       WHERE person.type_id = 2\n" +
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
