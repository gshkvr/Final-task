package entity;

public enum RequestSex {
    MALE(1, "male"),
    FEMALE(2, "female");

    private int id;
    private String value;

    RequestSex(int id, String value) {
        this.id = id;
        this.value = value;
    }

    public static RequestSex getById(int id) {
        switch (id) {
            case 1:
                return RequestSex.MALE;
            case 2:
                return RequestSex.FEMALE;
            default:
                throw new IllegalArgumentException("No such RequestSex");
        }
    }

    public static RequestSex getByValue(String value) {
        switch (value) {
            case "male":
                return RequestSex.MALE;
            case "female":
                return RequestSex.FEMALE;
            default:
                throw new IllegalArgumentException("No such RequestSex");
        }
    }

    public int getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

}
