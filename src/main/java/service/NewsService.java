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
import java.util.Optional;

public class NewsService {
    private NewsService() {
    }

    public static NewsService getInstance() {
        return InstanceHolder.INSTANCE;
    }

    private static class InstanceHolder {
        private static final NewsService INSTANCE = new NewsService();
    }

    private static final String NEW_ROW = "\r\n";
    private static final String OPEN_TAG = "<p>";
    private static final String CLOSE_TAG = "</p>";
    private final NewsDao newsDao = NewsDaoImpl.getInstance();

    public boolean addNews(SessionRequestContent content) throws ServiceException, EmptyRuTitleException, EmptyRuTextException, EmptyEnTitleException, EmptyEnTextException, EmptyDateException {
        News news = getNewsFromRequestContent(content);
        try {
            return newsDao.create(news);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    public List<News> getAllNews() throws ServiceException {
        try {
            List<News> newsList = newsDao.findAll();
            newsList.forEach(news -> {
                news.setRuText(formatText(news.getRuText()));
                news.setEnText(formatText(news.getEnText()));
                news.setDefaultText(formatText(news.getDefaultText()));
            });
            return newsList;
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    public News getNews(SessionRequestContent content) throws ServiceException, NoSuchNewsException {
        try {
            String id = content.getRequestParameter(NewsBuilderImpl.NEWS_ID);
            int newsId = Integer.parseInt(id);
            Optional<News> optionalNews = newsDao.findEntityById(newsId);
            if (optionalNews.isPresent()) {
                return optionalNews.get();
            } else {
                throw new NoSuchNewsException();
            }
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    public boolean updateNews(SessionRequestContent content) throws EmptyDateException, EmptyRuTextException, EmptyEnTitleException, EmptyEnTextException, EmptyRuTitleException, ServiceException {
        News news = getNewsFromRequestContent(content);
        try {
            return newsDao.update(news);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    private News getNewsFromRequestContent(SessionRequestContent content) throws EmptyRuTitleException, EmptyRuTextException, EmptyEnTitleException, EmptyEnTextException, EmptyDateException {
        String id = content.getRequestParameter(NewsBuilderImpl.NEWS_ID);
        int newsId = 0;
        if (id != null && !"".equals(id)) {
            newsId = Integer.parseInt(id);
        }
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
        if (defaultLang.equals(NewsBuilderImpl.RU_TEXT)) {
            defaultTitle = ruTitle;
            defaultText = ruText;
        } else {
            defaultTitle = enTitle;
            defaultText = enText;
        }
        return new News(newsId, date, ruTitle, enTitle, defaultTitle, ruText, enText, defaultText);
    }

    private String formatText(String text) {
        String[] list = text.split(NEW_ROW);
        StringBuilder result = new StringBuilder();
        for (String t : list) {
            result.append(OPEN_TAG).append(t).append(CLOSE_TAG);
        }
        return result.toString();
    }
}
