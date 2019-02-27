package builder;

import builder.impl.NewsBuilder;
import builder.impl.UserBuilder;
import entity.AbstractEntity;
import entity.impl.News;
import entity.impl.User;

public enum BuilderFactory {
    INSTANCE;

    public Builder<? extends AbstractEntity> getBuilder(String tableName) {
        switch (tableName) {
            case User.TABLE_NAME:
                return new UserBuilder();
            case News.TABLE_NAME:
                return new NewsBuilder();
            default:
                throw new IllegalArgumentException("No such BuilderType in BuilderFactory");
        }
    }
}
