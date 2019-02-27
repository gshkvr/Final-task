package dao.impl;

import dao.AbstractDao;
import dao.QueryEnum;
import entity.impl.News;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class NewsDao extends AbstractDao<Integer, News> {
    @Override
    protected String getFindEntityByIdQuery() {
        return QueryEnum.SELECT_NEWS_BY_ID.getQuery();
    }

    @Override
    protected String getFindAllQuery() {
        return QueryEnum.SELECT_NEWS_ALL.getQuery();
    }

    @Override
    protected String getTableName() {
        return News.TABLE_NAME;
    }

    @Override
    public String getCreateQuery() {
        return QueryEnum.CREATE_NEWS.getQuery();
    }

    @Override
    public String getUpdateQuery() {
        return QueryEnum.UPDATE_NEWS.getQuery();
    }

    @Override
    public String getDeleteQuery() {
        return QueryEnum.DELETE_NEWS.getQuery();
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
