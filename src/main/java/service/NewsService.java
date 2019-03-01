package service;

import com.google.protobuf.ServiceException;
import dao.NewsDao;
import dao.impl.NewsDaoImpl;
import entity.impl.News;
import exception.DaoException;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class NewsService {
    private NewsService() {}

    public static NewsService getInstance() {
        return InstanceHolder.INSTANCE;
    }

    private static class InstanceHolder {
        private static final NewsService INSTANCE = new NewsService();

        private static List<News> news = null;
        private static final ReentrantLock LOCK = new ReentrantLock();
    }

    private final NewsDao newsDao = NewsDaoImpl.getInstance();

    public final List<News> loadNews() throws ServiceException {
        if(InstanceHolder.news == null){
            loadFromDB();
        }
        return InstanceHolder.news;
    }

    public void loadFromDB() throws ServiceException {
        InstanceHolder.LOCK.lock();

        try{
            InstanceHolder.news = newsDao.findAll();
        } catch (DaoException e) {
            throw new ServiceException(e);
        } finally {
            InstanceHolder.LOCK.unlock();
        }
    }
}
