package dao.impl;

import builder.impl.NewsBuilderImpl;
import dao.AbstractDao;
import dao.NewsDao;
import entity.News;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class NewsDaoImpl extends AbstractDao<Integer, News> implements NewsDao {
    private NewsDaoImpl() {
    }

    public static NewsDaoImpl getInstance() {
        return NewsDaoImpl.InstanceHolder.INSTANCE;
    }

    private static class InstanceHolder {
        private static final NewsDaoImpl INSTANCE = new NewsDaoImpl();
    }

    private static final String SELECT_NEWS_ALL = "SELECT interpol.news.date AS date,\n" +
            "       interpol.news.ru_title AS ru_title,\n" +
            "       interpol.news.en_title AS en_title,\n" +
            "       interpol.news.default_title AS default_title,\n" +
            "       interpol.news.ru_text AS ru_text,\n" +
            "       interpol.news.en_text AS en_text,\n" +
            "       interpol.news.default_text AS default_text\n" +
            "       FROM interpol.news news\n" +
            "       ORDER BY news.date desc ";
    private static final String SELECT_NEWS_BY_ID = "SELECT interpol.news.date AS date,\n" +
            "       interpol.news.ru_title AS ru_title,\n" +
            "       interpol.news.en_title AS en_title,\n" +
            "       interpol.news.default_title AS default_title,\n" +
            "       interpol.news.ru_text AS ru_text,\n" +
            "       interpol.news.en_text AS en_text,\n" +
            "       interpol.news.default_text AS default_text\n" +
            "       FROM interpol.news news\n" +
            "       WHERE news.id = ?";
    private static final String CREATE_NEWS = "insert into interpol.news (date, ru_title, ru_text, " +
            "       en_title, en_text, default_title, default_text) " +
            "       values (?,?,?,?,?,?,?)";
    private static final String UPDATE_NEWS = "update interpol.news set date=?, ru_title=?, ru_text=?, " +
            "       en_title=?, en_text=?, default_title=?, default_text=? " +
            "       where id=?";
    private static final String DELETE_NEWS = "delete from interpol.news where id=?";

    @Override
    protected String getTableName() {
        return NewsBuilderImpl.TABLE_NAME;
    }

    @Override
    protected String getFindEntityByIdQuery() {
        return SELECT_NEWS_BY_ID;
    }

    @Override
    protected String getFindAllQuery() {
        return SELECT_NEWS_ALL;
    }

    @Override
    public String getCreateQuery() {
        return CREATE_NEWS;
    }

    @Override
    public String getUpdateQuery() {
        return UPDATE_NEWS;
    }

    @Override
    public String getDeleteQuery() {
        return DELETE_NEWS;
    }

    @Override
    protected List<String> getParametersForCreate(News entity) {
        List<String> parameters = new ArrayList<>();
        Date date = entity.getDate();
        String sDate = String.valueOf(date);
        parameters.add(sDate);
        String ruTitle = entity.getRuTitle();
        parameters.add(ruTitle);
        String ruText = entity.getRuText();
        parameters.add(ruText);
        String enTitle = entity.getEnTitle();
        parameters.add(enTitle);
        String enText = entity.getEnText();
        parameters.add(enText);
        String defaultTitle = entity.getDefaultTitle();
        parameters.add(defaultTitle);
        String defaultText = entity.getDefaultText();
        parameters.add(defaultText);
        return parameters;
    }

}
