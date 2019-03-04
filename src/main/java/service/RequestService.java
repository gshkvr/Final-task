package service;

import controller.SessionRequestContent;
import dao.RequestDao;
import dao.exception.DaoException;
import dao.impl.RequestDaoImpl;
import entity.Request;
import entity.RequestSex;
import entity.RequestType;
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
        String fullName = content.getRequestParameter(Request.FULL_NAME);
        if (fullName == null || "".equals(fullName)) {
            throw new EmptyNameException();
        }

        String sSex = content.getRequestParameter(Request.SEX_ID);
        if (sSex == null || "".equals(sSex)) {
            throw new EmptySexException();
        }
        RequestSex sex = RequestSex.getByValue(sSex);

        String sType = content.getRequestParameter(Request.TYPE_ID);
        if (sType == null || "".equals(sType)) {
            throw new EmptyTypeException();
        }
        RequestType type = RequestType.getByValue(sType);

        String date = content.getRequestParameter(Request.BIRTH_DATE);
        if (date == null || "".equals(date)) {
            throw new EmptyBirthDateException();
        }
        Date birthDate = Date.valueOf(date);

        String nationality = content.getRequestParameter(Request.NATIONALITY);
        if (nationality == null || "".equals(nationality)) {
            throw new EmptyNationalityException();
        }

        Optional<FileItem> optionalItem = content.getFileParts()
                .stream()
                .filter(i -> i.getFieldName().equals(Request.REQUEST_FILE))
                .findFirst();
        String filePath;
        if (optionalItem.isPresent()) {
            FileItem item = optionalItem.get();
            String fileName = UUID.randomUUID().toString();
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
