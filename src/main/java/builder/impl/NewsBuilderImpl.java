package builder.impl;

import builder.Builder;
import builder.exception.BuilderException;
import entity.News;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class NewsBuilderImpl implements Builder<News> {
    public static final String TABLE_NAME = "news";
    public static final String NEWS_ID = "news_id";
    public static final String DATE = "date";
    public static final String RU_TITLE = "ru_title";
    public static final String RU_TEXT = "ru_text";
    public static final String EN_TITLE = "en_title";
    public static final String EN_TEXT = "en_text";
    public static final String DEFAULT_LANG = "default_lang";
    private static final String DEFAULT_TITLE = "default_title";
    private static final String DEFAULT_TEXT = "default_text";

    private NewsBuilderImpl() {
    }

    public static NewsBuilderImpl getInstance() {
        return NewsBuilderImpl.InstanceHolder.INSTANCE;
    }

    private static class InstanceHolder {
        private static final NewsBuilderImpl INSTANCE = new NewsBuilderImpl();
    }

    @Override
    public News build(ResultSet resultSet) throws BuilderException {
        try {
            int id = resultSet.getInt(NEWS_ID);
            Date date = resultSet.getDate(DATE);
            String ruTitle = resultSet.getString(RU_TITLE);
            String enTitle = resultSet.getString(EN_TITLE);
            String defaultTitle = resultSet.getString(DEFAULT_TITLE);
            String ruText = resultSet.getString(RU_TEXT);
            String enText = resultSet.getString(EN_TEXT);
            String defaultText = resultSet.getString(DEFAULT_TEXT);

            return new News(id, date, ruTitle, enTitle, defaultTitle, ruText, enText, defaultText);
        } catch (SQLException e) {
            throw new BuilderException("Can't build News", e);
        }
    }
}
