package service;

import builder.impl.RequestBuilderImpl;
import controller.SessionRequestContent;
import dao.PersonDao;
import dao.exception.DaoException;
import dao.impl.MissingPersonDaoImpl;
import dao.impl.PersonDaoImpl;
import dao.impl.WantedPersonDaoImpl;
import entity.Person;
import entity.Request;
import service.exception.NoSuchRequestException;
import service.exception.ServiceException;

import java.util.List;
import java.util.Optional;

/**
 * Provides methods to work with {@link Person}
 * and "person" table.
 * Singleton.
 *
 * @author George Kvirikashvili
 */
public class PersonService {
    private PersonService() {
    }

    /**
     * Gets singleton instance.
     *
     * @return the instance
     */
    public static PersonService getInstance() {
        return PersonService.InstanceHolder.INSTANCE;
    }

    private static class InstanceHolder {
        private static final PersonService INSTANCE = new PersonService();
    }

    private static final int PERSONS_ON_PAGE = 6;
    private final RequestService requestService = RequestService.getInstance();
    private final PersonDao personDao = PersonDaoImpl.getInstance();
    private final PersonDao wantedPersonDao = WantedPersonDaoImpl.getInstance();
    private final PersonDao missingPersonDao = MissingPersonDaoImpl.getInstance();

    /**
     * Create person.
     *
     * @param content the content
     * @throws ServiceException       the service exception
     * @throws NoSuchRequestException the no such request exception
     */
    public boolean createPerson(SessionRequestContent content) throws ServiceException, NoSuchRequestException {
        String sId = content.getRequestParameter(RequestBuilderImpl.REQUEST_ID);
        int id = Integer.parseInt(sId);
        Optional<Request> optionalRequest = requestService.findRequestById(id);
        if (optionalRequest.isPresent()) {
            Person person = optionalRequest.get();
            requestService.deleteRequest(id);
            addPerson(person);
            return true;
        } else {
            throw new NoSuchRequestException();
        }
    }

    private void addPerson(Person person) throws ServiceException {
        try {
            personDao.create(person);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    /**
     * Returns number of pages missing persons.
     *
     * @return the int
     * @throws ServiceException the service exception
     */
    public final int pageMissingAmount() throws ServiceException {
        List<Person> missingPersons = getAllMissingPersons();
        return missingPersons.size() / PERSONS_ON_PAGE + 1;
    }

    /**
     * Returns number of pages wanted persons.
     *
     * @return the int
     * @throws ServiceException the service exception
     */
    public final int pageWantedAmount() throws ServiceException {
        List<Person>  wantedPersons = getAllWantedPersons();
        return wantedPersons.size() / PERSONS_ON_PAGE + 1;
    }

    /**
     * Gets all wanted persons.
     *
     * @return the all wanted persons
     * @throws ServiceException the service exception
     */
    private List<Person> getAllWantedPersons() throws ServiceException {
        try {
            return wantedPersonDao.findAll();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    /**
     * Gets all wanted persons on page.
     *
     * @param page number of page
     * @return the all wanted persons
     * @throws ServiceException the service exception
     */
    public List<Person> getAllWantedPersons(int page) throws ServiceException {
        try {
            return wantedPersonDao.findAll(page);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    /**
     * Gets all missing persons.
     *
     * @return the all missing persons
     * @throws ServiceException the service exception
     */
    private List<Person> getAllMissingPersons() throws ServiceException {
        try {
            return missingPersonDao.findAll();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    /**
     * Gets all missing persons on page.
     *
     * @param page number of page
     * @return the all wanted persons
     * @throws ServiceException the service exception
     */
    public List<Person> getAllMissingPersons(int page) throws ServiceException {
        try {
            return missingPersonDao.findAll(page);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

}
