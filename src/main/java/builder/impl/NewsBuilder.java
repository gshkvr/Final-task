package builder.impl;

import builder.Builder;
import entity.impl.News;
import exception.BuilderException;

import java.sql.ResultSet;
import java.sql.SQLException;

public class NewsBuilder implements Builder<News> {
    @Override
    public News build(ResultSet resultSet) throws BuilderException {
        try {
            return new News(resultSet.getDate(News.DATE_COLUMN),
                    resultSet.getString(News.RU_TITLE_COLUMN),
                    resultSet.getString(News.EN_TITLE_COLUMN),
                    resultSet.getString(News.DEFAULT_TITLE_COLUMN),
                    resultSet.getString(News.RU_TEXT_COLUMN),
                    resultSet.getString(News.EN_TEXT_COLUMN),
                    resultSet.getString(News.DEFAULT_TEXT_COLUMN));
        } catch (SQLException e) {
            throw new BuilderException("Can't build news", e);
        }
    }
}
