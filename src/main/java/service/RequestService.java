package service;

import dao.RequestDao;
import dao.impl.RequestDaoImpl;
import entity.impl.Request;
import exception.DaoException;
import exception.ServiceException;

import java.util.List;

public class RequestService {
    private RequestService() {
    }

    public static RequestService getInstance() {
        return RequestService.InstanceHolder.INSTANCE;
    }

    private static class InstanceHolder {
        private static final RequestService INSTANCE = new RequestService();
    }

    private final RequestDao requestDao = RequestDaoImpl.getInstance();

    public List<Request> getAllRequests() throws ServiceException {
        try {
            return requestDao.findAll();
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    public boolean addRequest(Request request) throws ServiceException {
        try {
            return requestDao.create(request);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    public boolean deleteRequest(int requestId) throws ServiceException {
        try {
            return requestDao.delete(requestId);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }
}
