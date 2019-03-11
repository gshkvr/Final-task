package builder.impl;

import builder.Builder;
import builder.exception.BuilderException;
import entity.News;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class NewsBuilderImplTest {
    private static final int NEWS_ID = 1;
    private static final Date DATE = Date.valueOf("1990-01-01");
    private static final String RU_TITLE = "ru_title";
    private static final String RU_TEXT = "ru_text";
    private static final String EN_TITLE = "en_title";
    private static final String EN_TEXT = "en_text";
    private static final String DEFAULT_TITLE = "default_title";
    private static final String DEFAULT_TEXT = "default_text";
    private static final Builder NEWS_BUILDER = NewsBuilderImpl.getInstance();

    private static final News EXPECTED = new News(NEWS_ID, DATE, RU_TITLE, EN_TITLE, DEFAULT_TITLE,
            RU_TEXT, EN_TEXT, DEFAULT_TEXT);

    @Test
    public void testBuild() throws BuilderException, SQLException {
        ResultSet resultSet = mock(ResultSet.class);
        when(resultSet.getInt(NewsBuilderImpl.NEWS_ID)).thenReturn(NEWS_ID);
        when(resultSet.getDate(NewsBuilderImpl.DATE)).thenReturn(DATE);
        when(resultSet.getString(NewsBuilderImpl.RU_TITLE)).thenReturn(RU_TITLE);
        when(resultSet.getString(NewsBuilderImpl.RU_TEXT)).thenReturn(RU_TEXT);
        when(resultSet.getString(NewsBuilderImpl.EN_TITLE)).thenReturn(EN_TITLE);
        when(resultSet.getString(NewsBuilderImpl.EN_TEXT)).thenReturn(EN_TEXT);
        when(resultSet.getString(NewsBuilderImpl.DEFAULT_TITLE)).thenReturn(DEFAULT_TITLE);
        when(resultSet.getString(NewsBuilderImpl.DEFAULT_TEXT)).thenReturn(DEFAULT_TEXT);
        News actual = (News) NEWS_BUILDER.build(resultSet);
        Assert.assertEquals(actual, EXPECTED);
    }
}