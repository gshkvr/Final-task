package entity;

/**
 * The enum User role.
 * Representation of table "user_role".
 *
 * @author George Kvirikashvili
 */
public enum UserRole {
    /**
     * Admin user role.
     */
    ADMIN(1, "admin"),
    /**
     * Client user role.
     */
    CLIENT(2, "client");

    private int id;
    private String value;

    UserRole(int id, String value) {
        this.id = id;
        this.value = value;
    }

    /**
     * Gets by id.
     *
     * @param id the id
     * @return the by id
     */
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

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Gets value.
     *
     * @return the value
     */
    public String getValue() {
        return value;
    }
}
