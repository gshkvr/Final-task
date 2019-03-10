package builder;

import builder.exception.BuilderException;
import entity.AbstractEntity;

import java.sql.ResultSet;

/**
 * The interface Builder.
 * Creates an object of necessary type.
 *
 * @param <T> the type of object which will be created
 *
 * @author George Kvirikashvili
 */
public interface Builder<T extends AbstractEntity> {
    /**
     * Build an object of the class {@code <T extends AbstractEntity>}
     * Takes argument {@link ResultSet} from which build object.
     *
     * @param parameters the ResultSet from which build object
     * @return a new object of the type {@code <T extends AbstractEntity>}
     * @throws BuilderException if some exception occurred
     */
    T build(ResultSet parameters) throws BuilderException;
}
