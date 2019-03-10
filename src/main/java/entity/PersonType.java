package entity;

/**
 * The enum Person type.
 * Representation of table "person_type".
 *
 * @author George Kvirikashvili
 */
public enum PersonType {
    /**
     * Missing person type.
     */
    MISSING(1, "missing"),
    /**
     * Wanted person type.
     */
    WANTED(2, "wanted");

    private int id;
    private String value;

    PersonType(int id, String value) {
        this.id = id;
        this.value = value;
    }

    /**
     * Gets by id.
     *
     * @param id the id
     * @return the by id
     */
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

    /**
     * Gets by value.
     *
     * @param value the value
     * @return the by value
     */
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
