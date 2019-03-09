package entity;

import java.sql.Date;
import java.util.Objects;

public class Person extends AbstractEntity {
    private PersonSex sex;
    private PersonType type;
    private String fullName;
    private String nationality;
    private Date birthDate;
    private String fileLink;

    public Person(int id, PersonSex sex, PersonType type, String fullName, String nationality, Date birthDate, String fileLink) {
        this.id = id;
        this.sex = sex;
        this.type = type;
        this.fullName = fullName;
        this.nationality = nationality;
        this.birthDate = birthDate;
        this.fileLink = fileLink;
    }

    public PersonSex getSex() {
        return sex;
    }

    public void setSex(PersonSex sex) {
        this.sex = sex;
    }

    public PersonType getType() {
        return type;
    }

    public void setType(PersonType type) {
        this.type = type;
    }

    public String getFullName() {
        return fullName;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public String getFileLink() {
        return fileLink;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Person person = (Person) o;
        return sex == person.sex &&
                type == person.type &&
                Objects.equals(fullName, person.fullName) &&
                Objects.equals(nationality, person.nationality) &&
                Objects.equals(birthDate, person.birthDate) &&
                Objects.equals(fileLink, person.fileLink);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sex, type, fullName, nationality, birthDate, fileLink);
    }

    @Override
    public String toString() {
        return "Person{" +
                "sex=" + sex +
                ", type=" + type +
                ", fullName='" + fullName + '\'' +
                ", nationality='" + nationality + '\'' +
                ", birthDate=" + birthDate +
                ", fileLink='" + fileLink + '\'' +
                '}';
    }
}
