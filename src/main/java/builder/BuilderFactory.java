package builder;

import builder.impl.NewsBuilderImpl;
import builder.impl.PersonBuilderImpl;
import builder.impl.RequestBuilderImpl;
import builder.impl.UserBuilderImpl;

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
    private final Builder personBuilder = PersonBuilderImpl.getInstance();

    public Builder getBuilder(String tableName) {
        switch (tableName) {
            case UserBuilderImpl.TABLE_NAME:
                return userBuilder;
            case NewsBuilderImpl.TABLE_NAME:
                return newsBuilder;
            case RequestBuilderImpl.TABLE_NAME:
                return requestBuilder;
            case PersonBuilderImpl.TABLE_NAME:
                return personBuilder;
            default:
                throw new IllegalArgumentException("No such builder type in BuilderFactory");
        }
    }
}
