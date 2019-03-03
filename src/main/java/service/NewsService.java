package service;

import service.exception.ServiceException;
import dao.NewsDao;
import dao.exception.DaoException;
import dao.impl.NewsDaoImpl;
import entity.News;

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

    public final List<News> getAllNews() throws ServiceException {
        try {
            return newsDao.findAll();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
