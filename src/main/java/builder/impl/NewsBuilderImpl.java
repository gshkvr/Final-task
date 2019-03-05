package builder.impl;

import builder.Builder;
import entity.News;
import builder.exception.BuilderException;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class NewsBuilderImpl implements Builder<News> {
    public static final String TABLE_NAME = "news";
    public static final String DATE = "date";
    public static final String RU_TITLE = "ru_title";
    public static final String RU_TEXT = "ru_text";
    public static final String EN_TITLE = "en_title";
    public static final String EN_TEXT = "en_text";
    public static final String DEFAULT_LANG = "default_lang";
    private static final String DEFAULT_TITLE = "default_title";
    private static final String DEFAULT_TEXT = "default_text";
    private static final String NEW_ROW = "\r\n";
    private static final String OPEN_TAG = "<p>";
    private static final String CLOSE_TAG = "</p>";

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
            Date date = resultSet.getDate(DATE);
            String ruTitle = resultSet.getString(RU_TITLE);
            String enTitle = resultSet.getString(EN_TITLE);
            String defaultTitle = resultSet.getString(DEFAULT_TITLE);
            String ruText = resultSet.getString(RU_TEXT);
            ruText = formatText(ruText);
            String enText = resultSet.getString(EN_TEXT);
            enText = formatText(enText);
            String defaultText = resultSet.getString(DEFAULT_TEXT);
            defaultText = formatText(defaultText);

            return new News( date, ruTitle, enTitle, defaultTitle, ruText, enText, defaultText);
        } catch (SQLException e) {
            throw new BuilderException("Can't build News", e);
        }
    }

    private String formatText(String text){
        List<String> list = Arrays.asList(text.split(NEW_ROW));
        String result = "";
        for (String t : list){
            result += OPEN_TAG + t + CLOSE_TAG;
        }
        return result;
    }
}
