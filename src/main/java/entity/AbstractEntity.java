package entity;

/**
 * The type Abstract entity.
 * Main object with id to work with tables.
 *
 * @author George Kvirikashvili
 */
public abstract class AbstractEntity {
    /**
     * The Id.
     */
    protected int id;

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }
}
