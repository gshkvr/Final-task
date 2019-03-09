package entity;

public enum PersonType {
    MISSING(1, "missing"),
    WANTED(2, "wanted");

    private int id;
    private String value;

    PersonType(int id, String value) {
        this.id = id;
        this.value = value;
    }

    public static PersonType getById(int id) {
        switch (id) {
            case 1:
                return PersonType.MISSING;
            case 2:
                return PersonType.WANTED;
            default:
                throw new IllegalArgumentException("No such PersonType");
        }
    }

    public static PersonType getByValue(String value) {
        switch (value) {
            case "missing":
                return PersonType.MISSING;
            case "wanted":
                return PersonType.WANTED;
            default:
                throw new IllegalArgumentException("No such PersonType");
        }
    }

    public int getId() {
        return id;
    }

    public String getValue() {
        return value;
    }
}
