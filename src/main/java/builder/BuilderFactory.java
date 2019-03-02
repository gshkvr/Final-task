package builder;

import builder.impl.NewsBuilder;
import builder.impl.RequestBuilder;
import builder.impl.UserBuilder;
import entity.impl.News;
import entity.impl.Request;
import entity.impl.User;

public class BuilderFactory {
    private BuilderFactory() {
    }

    public static BuilderFactory getInstance() {
        return BuilderFactory.InstanceHolder.INSTANCE;
    }

    private static class InstanceHolder {
        private static final BuilderFactory INSTANCE = new BuilderFactory();
    }

    private final Builder newsBuilder = NewsBuilder.getInstance();
    private final Builder requestBuilder = RequestBuilder.getInstance();
    private final Builder userBuilder = UserBuilder.getInstance();

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
