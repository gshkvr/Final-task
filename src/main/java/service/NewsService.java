package service;

import builder.impl.NewsBuilderImpl;
import controller.SessionRequestContent;
import dao.NewsDao;
import dao.exception.DaoException;
import dao.impl.NewsDaoImpl;
import entity.News;
import service.exception.*;

import java.sql.Date;
import java.util.List;

public class NewsService {
    private NewsService() {
    }

    public static NewsService getInstance() {
        return InstanceHolder.INSTANCE;
    }

    private static class InstanceHolder {
        private static final NewsService INSTANCE = new NewsService();
    }

    private final NewsDao newsDao = NewsDaoImpl.getInstance();

    public boolean addNews(SessionRequestContent content) throws ServiceException, EmptyRuTitleException, EmptyRuTextException, EmptyEnTitleException, EmptyEnTextException, EmptyDateException {
        String ruTitle = content.getRequestParameter(NewsBuilderImpl.RU_TITLE);
        if (ruTitle == null || "".equals(ruTitle)) {
            throw new EmptyRuTitleException();
        }
        String ruText = content.getRequestParameter(NewsBuilderImpl.RU_TEXT);
        if (ruText == null || "".equals(ruText)) {
            throw new EmptyRuTextException();
        }
        String enTitle = content.getRequestParameter(NewsBuilderImpl.EN_TITLE);
        if (enTitle == null || "".equals(enTitle)) {
            throw new EmptyEnTitleException();
        }
        String enText = content.getRequestParameter(NewsBuilderImpl.EN_TEXT);
        if (enText == null || "".equals(enText)) {
            throw new EmptyEnTextException();
        }
        String sDate = content.getRequestParameter(NewsBuilderImpl.DATE);
        if (sDate == null || "".equals(sDate)) {
            throw new EmptyDateException();
        }
        Date date = Date.valueOf(sDate);

        String defaultTitle;
        String defaultText;
        String defaultLang = content.getRequestParameter(NewsBuilderImpl.DEFAULT_LANG);
        if(defaultLang.equals(NewsBuilderImpl.RU_TEXT)){
            defaultTitle = ruTitle;
            defaultText = ruText;
        } else {
            defaultTitle = enTitle;
            defaultText = enText;
        }

        News news = new News(date, ruTitle, enTitle, defaultTitle, ruText, enText, defaultText);
        try {
            return newsDao.create(news);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    public List<News> getAllNews() throws ServiceException {
        try {
            return newsDao.findAll();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
