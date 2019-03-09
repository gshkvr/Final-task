package entity;

public enum PersonSex {
    MALE(1, "male"),
    FEMALE(2, "female");

    private int id;
    private String value;

    PersonSex(int id, String value) {
        this.id = id;
        this.value = value;
    }

    public static PersonSex getById(int id) {
        switch (id) {
            case 1:
                return PersonSex.MALE;
            case 2:
                return PersonSex.FEMALE;
            default:
                throw new IllegalArgumentException("No such PersonSex");
        }
    }

    public static PersonSex getByValue(String value) {
        switch (value) {
            case "male":
                return PersonSex.MALE;
            case "female":
                return PersonSex.FEMALE;
            default:
                throw new IllegalArgumentException("No such PersonSex");
        }
    }

    public int getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

}
