package builder;

import entity.AbstractEntity;
import exception.BuilderException;

import java.sql.ResultSet;

public interface Builder<T extends AbstractEntity> {
    T build(ResultSet parameters) throws BuilderException;
}
