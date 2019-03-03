package entity;

public enum  RequestType {
    MISSING(1, "missing"),
    WANTED(2, "wanted");

    private int id;
    private String value;

    RequestType(int id, String value) {
        this.id = id;
        this.value = value;
    }

    public static RequestType getById(int id) {
        switch (id) {
            case 1:
                return RequestType.MISSING;
            case 2:
                return RequestType.WANTED;
            default:
                throw new IllegalArgumentException("No such RequestType");
        }
    }

    public int getId() {
        return id;
    }

    public String getValue() {
        return value;
    }
}
