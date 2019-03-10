package entity;

/**
 * The enum Person sex.
 * Representation of table "person_sex".
 *
 * @author George Kvirikashvili
 */
public enum PersonSex {
    /**
     * Male person sex.
     */
    MALE(1, "male"),
    /**
     * Female person sex.
     */
    FEMALE(2, "female");

    private int id;
    private String value;

    PersonSex(int id, String value) {
        this.id = id;
        this.value = value;
    }

    /**
     * Gets by id.
     *
     * @param id the id
     * @return the by id
     */
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

    /**
     * Gets by value.
     *
     * @param value the value
     * @return the by value
     */
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
