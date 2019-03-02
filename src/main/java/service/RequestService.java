package service;

import controller.SessionRequestContent;
import dao.RequestDao;
import dao.exception.DaoException;
import dao.impl.RequestDaoImpl;
import entity.impl.Request;
import org.apache.commons.fileupload.FileItem;
import resource.ConfigurationManager;
import service.exception.EmptyFileException;
import service.exception.EmptyNameException;
import service.exception.ServiceException;

import java.io.File;
import java.util.List;
import java.util.Optional;

public class RequestService {
    private RequestService() {
    }

    public static RequestService getInstance() {
        return RequestService.InstanceHolder.INSTANCE;
    }

    private static class InstanceHolder {
        private static final RequestService INSTANCE = new RequestService();
    }

    private final static String IMAGES_DIRECTORY = ConfigurationManager.getProperty("images.directory");
    private final RequestDao requestDao = RequestDaoImpl.getInstance();

    public void createRequest(SessionRequestContent content) throws EmptyNameException, ServiceException, EmptyFileException {
        String name = content.getRequestParameter(Request.REQUEST_NAME);
        if (name == null || "".equals(name)) {
            throw new EmptyNameException();
        }

        Optional<FileItem> optionalItem = content.getFileParts()
                .stream()
                .filter(i -> i.getFieldName().equals(Request.REQUEST_FILE))
                .findFirst();
        String filePath;
        if (optionalItem.isPresent()) {
            FileItem item = optionalItem.get();
            String fileName = item.getName();
            filePath = IMAGES_DIRECTORY + File.separator + fileName;
            String extractPath = content.getRealPath() + filePath;
            File storeFile = new File(extractPath);
            try {
                item.write(storeFile);
            } catch (Exception e) {
                throw new ServiceException(e);
            }
        } else {
            throw new EmptyFileException();
        }
        Request request = new Request(0, name, filePath);
        addRequest(request);
    }

    public List<Request> getAllRequests() throws ServiceException {
        try {
            return requestDao.findAll();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    private boolean addRequest(Request request) throws ServiceException {
        try {
            return requestDao.create(request);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    public boolean deleteRequest(int requestId) throws ServiceException {
        try {
            return requestDao.delete(requestId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
