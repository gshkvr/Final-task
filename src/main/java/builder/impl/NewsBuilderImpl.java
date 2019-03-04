package builder.impl;

import builder.Builder;
import entity.News;
import builder.exception.BuilderException;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class NewsBuilderImpl implements Builder<News> {
    public static final String TABLE_NAME = "news";
    public static final String DATE_COLUMN = "date";
    public static final String RU_TITLE_COLUMN = "ru_title";
    public static final String RU_TEXT_COLUMN = "ru_text";
    public static final String EN_TITLE_COLUMN = "en_title";
    public static final String EN_TEXT_COLUMN = "en_text";
    public static final String DEFAULT_TITLE_COLUMN = "default_title";
    public static final String DEFAULT_TEXT_COLUMN = "default_text";

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
            Date date = resultSet.getDate(DATE_COLUMN);
            String ruTitle = resultSet.getString(RU_TITLE_COLUMN);
            String enTitle = resultSet.getString(EN_TITLE_COLUMN);
            String defaultTitle = resultSet.getString(DEFAULT_TITLE_COLUMN);
            String ruText = resultSet.getString(RU_TEXT_COLUMN);
            String enText = resultSet.getString(EN_TEXT_COLUMN);
            String defaultText = resultSet.getString(DEFAULT_TEXT_COLUMN);

            return new News( date, ruTitle, enTitle, defaultTitle, ruText, enText, defaultText);
        } catch (SQLException e) {
            throw new BuilderException("Can't build News", e);
        }
    }
}
