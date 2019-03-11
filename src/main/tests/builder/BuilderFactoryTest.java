package builder;

import builder.impl.NewsBuilderImpl;
import builder.impl.PersonBuilderImpl;
import builder.impl.RequestBuilderImpl;
import builder.impl.UserBuilderImpl;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class BuilderFactoryTest {
    private final BuilderFactory builderFactory = BuilderFactory.getInstance();

    @DataProvider(name = "params")
    private Object[][] testParameters() {
        return new Object[][]{
                {UserBuilderImpl.TABLE_NAME, UserBuilderImpl.class},
                {RequestBuilderImpl.TABLE_NAME, RequestBuilderImpl.class},
                {PersonBuilderImpl.TABLE_NAME, PersonBuilderImpl.class},
                {NewsBuilderImpl.TABLE_NAME, NewsBuilderImpl.class}
        };
    }

    @Test(dataProvider = "params")
    public void testGetBuilder(String tableName, Class expected) {
        Builder builder = builderFactory.getBuilder(tableName);
        Class actual = builder.getClass();
        Assert.assertEquals(actual, expected);
    }
}