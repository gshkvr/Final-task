package builder;

import builder.exception.BuilderException;
import entity.AbstractEntity;

import java.sql.ResultSet;

public interface Builder<T extends AbstractEntity> {
    T build(ResultSet parameters) throws BuilderException;
}
