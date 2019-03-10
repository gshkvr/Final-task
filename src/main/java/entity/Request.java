package entity;

import java.sql.Date;

/**
 * The type Request.
 * Representation of table "request".
 * Extends type {@link Person}
 *
 * @author George Kvirikashvili
 */
public class Request extends Person {
    /**
     * Instantiates a new Request.
     *
     * @param id          the id
     * @param sex         the sex
     * @param type        the type
     * @param fullName    the full name
     * @param nationality the nationality
     * @param birthDate   the birth date
     * @param fileLink    the file link
     */
    public Request(int id, PersonSex sex, PersonType type, String fullName, String nationality, Date birthDate, String fileLink) {
        super(id, sex, type, fullName, nationality, birthDate, fileLink);
    }
}
