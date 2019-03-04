package entity;

import java.sql.Date;
import java.util.Objects;

public class Request extends AbstractEntity {

    private RequestSex sex;
    private RequestType type;
    private String fullName;
    private String nationality;
    private Date birthDate;
    private String fileLink;

    public Request(int id, RequestSex sex, RequestType type, String fullName, String nationality, Date birthDate, String fileLink) {
        this.id = id;
        this.sex = sex;
        this.type = type;
        this.fullName = fullName;
        this.nationality = nationality;
        this.birthDate = birthDate;
        this.fileLink = fileLink;
    }

    public RequestSex getSex() {
        return sex;
    }

    public void setSex(RequestSex sex) {
        this.sex = sex;
    }

    public RequestType getType() {
        return type;
    }

    public void setType(RequestType type) {
        this.type = type;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String full_name) {
        this.fullName = full_name;
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

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getFileLink() {
        return fileLink;
    }

    public void setFileLink(String fileLink) {
        this.fileLink = fileLink;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {return true;}
        if (o == null || getClass() != o.getClass()) {return false;}
        Request request = (Request) o;
        return sex == request.sex &&
                type == request.type &&
                Objects.equals(fullName, request.fullName) &&
                Objects.equals(nationality, request.nationality) &&
                Objects.equals(birthDate, request.birthDate) &&
                Objects.equals(fileLink, request.fileLink);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sex, type, fullName, nationality, birthDate, fileLink);
    }

    @Override
    public String toString() {
        return "Request{" +
                "sex=" + sex +
                ", type=" + type +
                ", full_name='" + fullName + '\'' +
                ", nationality='" + nationality + '\'' +
                ", birthDate=" + birthDate +
                ", fileLink='" + fileLink + '\'' +
                '}';
    }
}
