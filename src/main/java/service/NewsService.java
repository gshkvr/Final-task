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

/**
 * Provides methods to work with {@link News}
 * and "news" table.
 * Singleton.
 *
 * @author George Kvirikashvili
 */
public class NewsService {
    private NewsService() {
    }

    /**
     * Gets singleton instance.
     *
     * @return the instance
     */
    public static NewsService getInstance() {
        return InstanceHolder.INSTANCE;
    }

    private static class InstanceHolder {
        private static final NewsService INSTANCE = new NewsService();
    }

    private static final int NEWS_ON_PAGE = 6;
    private static final String NEW_ROW = "\r\n";
    private static final String OPEN_TAG = "<p>";
    private static final String CLOSE_TAG = "</p>";
    private final NewsDao newsDao = NewsDaoImpl.getInstance();

    /**
     * Add news.
     *
     * @param content the content
     * @throws ServiceException      the service exception
     * @throws EmptyRuTitleException the empty ru title exception
     * @throws EmptyRuTextException  the empty ru text exception
     * @throws EmptyEnTitleException the empty en title exception
     * @throws EmptyEnTextException  the empty en text exception
     * @throws EmptyDateException    the empty date exception
     */
    public void addNews(SessionRequestContent content) throws ServiceException, EmptyRuTitleException, EmptyRuTextException, EmptyEnTitleException, EmptyEnTextException, EmptyDateException {
        News news = getNewsFromRequestContent(content);
        try {
            newsDao.create(news);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    /**
     * Gets all news on page.
     *
     * @param page number of page
     * @return the all news
     * @throws ServiceException the service exception
     */
    public List<News> getAllNews(int page) throws ServiceException {
        try {
            List<News> newsList = newsDao.findAll(page);
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

    /**
     * Gets all news.
     *
     * @return the all news
     * @throws ServiceException the service exception
     */
    private List<News> getAllNews() throws ServiceException {
        try {
            return newsDao.findAll();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    /**
     * Gets news.
     *
     * @param content the content
     * @return the news
     * @throws ServiceException    the service exception
     * @throws NoSuchNewsException the no such news exception
     */
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

    /**
     * Update news.
     *
     * @param content the content
     * @throws EmptyDateException    the empty date exception
     * @throws EmptyRuTextException  the empty ru text exception
     * @throws EmptyEnTitleException the empty en title exception
     * @throws EmptyEnTextException  the empty en text exception
     * @throws EmptyRuTitleException the empty ru title exception
     * @throws ServiceException      the service exception
     */
    public void updateNews(SessionRequestContent content) throws EmptyDateException, EmptyRuTextException, EmptyEnTitleException, EmptyEnTextException, EmptyRuTitleException, ServiceException {
        News news = getNewsFromRequestContent(content);
        try {
            newsDao.update(news);
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

    /**
     * Returns number of pages news.
     *
     * @return the int
     * @throws ServiceException the service exception
     */
    public final int pageAmount() throws ServiceException {
        List<News> newsList = getAllNews();
        return newsList.size() / NEWS_ON_PAGE + 1;
    }
}
