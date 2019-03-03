package entity;

public enum UserRole {
    ADMIN(1, "admin"),
    CLIENT(2, "client");

    private int id;
    private String value;

    UserRole(int id, String value) {
        this.id = id;
        this.value = value;
    }

    public static UserRole getById(int id) {
        switch (id) {
            case 1:
                return UserRole.ADMIN;
            case 2:
                return UserRole.CLIENT;
            default:
                throw new IllegalArgumentException("No such UserRole");
        }
    }

    public int getId() {
        return id;
    }

    public String getValue() {
        return value;
    }
}
