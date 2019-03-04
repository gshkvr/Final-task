package entity;

import java.sql.Date;

public class Person extends Request {
    public Person(int id, RequestSex sex, RequestType type, String fullName, String nationality, Date birthDate, String fileLink) {
        super(id, sex, type, fullName, nationality, birthDate, fileLink);
    }
}
