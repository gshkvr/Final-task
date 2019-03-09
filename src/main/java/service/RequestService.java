package service;

import builder.impl.RequestBuilderImpl;
import controller.SessionRequestContent;
import dao.RequestDao;
import dao.exception.DaoException;
import dao.impl.RequestDaoImpl;
import entity.PersonSex;
import entity.Request;
import entity.PersonType;
import org.apache.commons.fileupload.FileItem;
import resource.ConfigurationManager;
import service.exception.*;

import java.io.File;
import java.sql.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

    public void createRequest(SessionRequestContent content) throws EmptyNameException, ServiceException, EmptyFileException, EmptySexException, EmptyTypeException, EmptyBirthDateException, EmptyNationalityException {
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
        if(item == null){
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
    }

    public List<Request> getAllRequests() throws ServiceException {
        try {
            return requestDao.findAll();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

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

    public void declineRequest(SessionRequestContent content) throws ServiceException {
        try {
            String sRequestId = content.getRequestParameter(RequestBuilderImpl.REQUEST_ID);
            int requestId = Integer.parseInt(sRequestId);
            requestDao.delete(requestId, true);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    void deleteRequest(int requestId) throws ServiceException {
        try {
            requestDao.delete(requestId, false);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
