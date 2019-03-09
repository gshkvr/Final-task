package entity;

import java.sql.Date;

public class Request extends Person {
    public Request(int id, PersonSex sex, PersonType type, String fullName, String nationality, Date birthDate, String fileLink) {
        super(id, sex, type, fullName, nationality, birthDate, fileLink);
    }
}
