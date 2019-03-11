package service;

import builder.impl.RequestBuilderImpl;
import controller.SessionRequestContent;
import dao.RequestDao;
import dao.exception.DaoException;
import dao.impl.RequestDaoImpl;
import entity.PersonSex;
import entity.PersonType;
import entity.Request;
import org.apache.commons.fileupload.FileItem;
import resource.ConfigurationManager;
import service.exception.*;

import java.io.File;
import java.sql.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Provides methods to work with {@link Request}
 * and "request" table.
 * Singleton.
 *
 * @author George Kvirikashvili
 */
public class RequestService {
    private RequestService() {
    }

    /**
     * Gets singleton instance.
     *
     * @return the instance
     */
    public static RequestService getInstance() {
        return RequestService.InstanceHolder.INSTANCE;
    }

    private static class InstanceHolder {
        private static final RequestService INSTANCE = new RequestService();
    }

    private static final int NEWS_ON_PAGE = 6;
    private final static String IMAGES_DIRECTORY = ConfigurationManager.getProperty("images.directory");
    private final RequestDao requestDao = RequestDaoImpl.getInstance();

    /**
     * Create request.
     *
     * @param content the content
     * @throws EmptyNameException        the empty name exception
     * @throws ServiceException          the service exception
     * @throws EmptyFileException        the empty file exception
     * @throws EmptySexException         the empty sex exception
     * @throws EmptyTypeException        the empty type exception
     * @throws EmptyBirthDateException   the empty birth date exception
     * @throws EmptyNationalityException the empty nationality exception
     */
    public boolean createRequest(SessionRequestContent content) throws EmptyNameException, ServiceException, EmptyFileException, EmptySexException, EmptyTypeException, EmptyBirthDateException, EmptyNationalityException {
        String fullName = content.getRequestParameter(RequestBuilderImpl.FULL_NAME);
        if (fullName == null || "".equals(fullName)) {
            throw new EmptyNameException();
        }

        String sSex = content.getRequestParameter(RequestBuilderImpl.SEX_ID);
        if (sSex == null || "".equals(sSex)) {
            throw new EmptySexException();
        }
        PersonSex sex = PersonSex.getByValue(sSex);

        String sType = content.getRequestParameter(RequestBuilderImpl.TYPE_ID);
        if (sType == null || "".equals(sType)) {
            throw new EmptyTypeException();
        }
        PersonType type = PersonType.getByValue(sType);

        String date = content.getRequestParameter(RequestBuilderImpl.BIRTH_DATE);
        if (date == null || "".equals(date)) {
            throw new EmptyBirthDateException();
        }
        Date birthDate = Date.valueOf(date);

        String nationality = content.getRequestParameter(RequestBuilderImpl.NATIONALITY);
        if (nationality == null || "".equals(nationality)) {
            throw new EmptyNationalityException();
        }

        FileItem item = (FileItem) content.getRequestAttribute(RequestBuilderImpl.REQUEST_FILE);
        String filePath;
        if (item == null) {
            throw new EmptyFileException();
        } else {
            String fileName = UUID.randomUUID().toString();
            filePath = IMAGES_DIRECTORY + File.separator + fileName;
            String extractPath = content.getRealPath() + filePath;
            File storeFile = new File(extractPath);
            try {
                item.write(storeFile);
            } catch (Exception e) {
                throw new ServiceException(e);
            }
        }

        Request request = new Request(0, sex, type, fullName, nationality, birthDate, filePath);
        addRequest(request);
        return true;
    }

    /**
     * Gets all news on page.
     *
     * @param page number of page
     * @return the all requests
     * @throws ServiceException the service exception
     */
    public List<Request> getAllRequests(int page) throws ServiceException {
        try {
            return requestDao.findAll(page);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    /**
     * Gets all requests.
     *
     * @return the all requests
     * @throws ServiceException the service exception
     */
    private List<Request> getAllRequests() throws ServiceException {
        try {
            return requestDao.findAll();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    /**
     * Find request by id optional.
     *
     * @param id the id
     * @return the optional
     * @throws ServiceException the service exception
     */
    Optional<Request> findRequestById(int id) throws ServiceException {
        try {
            return requestDao.findEntityById(id);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    private void addRequest(Request request) throws ServiceException {
        try {
            requestDao.create(request);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    /**
     * Decline request.
     *
     * @param content the content
     * @throws ServiceException the service exception
     */
    public boolean declineRequest(SessionRequestContent content) throws ServiceException {
        try {
            String sRequestId = content.getRequestParameter(RequestBuilderImpl.REQUEST_ID);
            int requestId = Integer.parseInt(sRequestId);
            requestDao.delete(requestId, true);
            return true;
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    /**
     * Delete request.
     *
     * @param requestId the request id
     * @throws ServiceException the service exception
     */
    void deleteRequest(int requestId) throws ServiceException {
        try {
            requestDao.delete(requestId, false);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    /**
     * Returns number of pages requests.
     *
     * @return the int
     * @throws ServiceException the service exception
     */
    public final int pageAmount() throws ServiceException {
        List<Request> requestList = getAllRequests();
        return requestList.size() / NEWS_ON_PAGE + 1;
    }
}
