package builder.impl;

import builder.Builder;
import entity.impl.News;
import exception.BuilderException;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class NewsBuilder implements Builder<News> {
    @Override
    public News build(ResultSet resultSet) throws BuilderException {
        try {
            Date date = resultSet.getDate(News.DATE_COLUMN);
            String ruTitle = resultSet.getString(News.RU_TITLE_COLUMN);
            String enTitle = resultSet.getString(News.EN_TITLE_COLUMN);
            String defaultTitle = resultSet.getString(News.DEFAULT_TITLE_COLUMN);
            String ruText = resultSet.getString(News.RU_TEXT_COLUMN);
            String enText = resultSet.getString(News.EN_TEXT_COLUMN);
            String defaultText = resultSet.getString(News.DEFAULT_TEXT_COLUMN);

            return new News( date, ruTitle, enTitle, defaultTitle, ruText, enText, defaultText);
        } catch (SQLException e) {
            throw new BuilderException("Can't build news", e);
        }
    }
}
