package builder;

import builder.impl.NewsBuilderImpl;
import builder.impl.RequestBuilderImpl;
import builder.impl.UserBuilderImpl;
import entity.News;
import entity.Request;
import entity.User;

public class BuilderFactory {
    private BuilderFactory() {
    }

    public static BuilderFactory getInstance() {
        return BuilderFactory.InstanceHolder.INSTANCE;
    }

    private static class InstanceHolder {
        private static final BuilderFactory INSTANCE = new BuilderFactory();
    }

    private final Builder newsBuilder = NewsBuilderImpl.getInstance();
    private final Builder requestBuilder = RequestBuilderImpl.getInstance();
    private final Builder userBuilder = UserBuilderImpl.getInstance();

    public Builder getBuilder(String tableName) {
        switch (tableName) {
            case User.TABLE_NAME:
                return userBuilder;
            case News.TABLE_NAME:
                return newsBuilder;
            case Request.TABLE_NAME:
                return requestBuilder;
            default:
                throw new IllegalArgumentException("No such builder type in BuilderFactory");
        }
    }
}
