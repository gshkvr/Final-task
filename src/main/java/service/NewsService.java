package service;

import com.google.protobuf.ServiceException;
import dao.impl.NewsDao;
import entity.impl.News;
import exception.DaoException;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class NewsService {
    private NewsService() {
    }

    public static NewsService getInstance() {
        return InstanceHolder.INSTANCE;
    }

    private static class InstanceHolder {
        private static final NewsService INSTANCE = new NewsService();

        private static List<News> news = null;
        private static final ReentrantLock LOCK = new ReentrantLock();
    }

    public final List<News> loadNews() throws ServiceException {
        if(InstanceHolder.news == null){
            loadFromDB();
        }
        return InstanceHolder.news;
    }

    public void loadFromDB() throws ServiceException {
        InstanceHolder.LOCK.lock();
        NewsDao newsDao = new NewsDao();
        try{
            InstanceHolder.news = newsDao.findAll();
        } catch (DaoException e) {
            throw new ServiceException(e);
        } finally {
            InstanceHolder.LOCK.unlock();
        }
    }
}
