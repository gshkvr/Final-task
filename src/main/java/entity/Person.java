package entity;

import java.sql.Date;
import java.util.Objects;

/**
 * The type Person.
 * Representation of table "person".
 *
 * @author George Kvirikashvili
 */
public class Person extends AbstractEntity {
    private PersonSex sex;
    private PersonType type;
    private String fullName;
    private String nationality;
    private Date birthDate;
    private String fileLink;

    /**
     * Instantiates a new Person.
     *
     * @param id          the id
     * @param sex         the sex
     * @param type        the type
     * @param fullName    the full name
     * @param nationality the nationality
     * @param birthDate   the birth date
     * @param fileLink    the file link
     */
    public Person(int id, PersonSex sex, PersonType type, String fullName, String nationality, Date birthDate, String fileLink) {
        this.id = id;
        this.sex = sex;
        this.type = type;
        this.fullName = fullName;
        this.nationality = nationality;
        this.birthDate = birthDate;
        this.fileLink = fileLink;
    }

    /**
     * Gets sex.
     *
     * @return the sex
     */
    public PersonSex getSex() {
        return sex;
    }

    /**
     * Sets sex.
     *
     * @param sex the sex
     */
    public void setSex(PersonSex sex) {
        this.sex = sex;
    }

    /**
     * Gets type.
     *
     * @return the type
     */
    public PersonType getType() {
        return type;
    }

    /**
     * Sets type.
     *
     * @param type the type
     */
    public void setType(PersonType type) {
        this.type = type;
    }

    /**
     * Gets full name.
     *
     * @return the full name
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * Gets nationality.
     *
     * @return the nationality
     */
    public String getNationality() {
        return nationality;
    }

    /**
     * Sets nationality.
     *
     * @param nationality the nationality
     */
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    /**
     * Gets birth date.
     *
     * @return the birth date
     */
    public Date getBirthDate() {
        return birthDate;
    }

    /**
     * Gets file link.
     *
     * @return the file link
     */
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
