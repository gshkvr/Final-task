package service;

import builder.impl.RequestBuilderImpl;
import controller.SessionRequestContent;
import dao.PersonDao;
import dao.exception.DaoException;
import dao.impl.PersonDaoImpl;
import entity.Person;
import entity.PersonType;
import entity.Request;
import service.exception.NoSuchRequestException;
import service.exception.ServiceException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class PersonService {
    private PersonService() {
    }

    public static PersonService getInstance() {
        return PersonService.InstanceHolder.INSTANCE;
    }

    private static class InstanceHolder {
        private static final PersonService INSTANCE = new PersonService();
    }

    private final RequestService requestService = RequestService.getInstance();
    private final PersonDao personDao = PersonDaoImpl.getInstance();

    public void createPerson(SessionRequestContent content) throws ServiceException, NoSuchRequestException {
        String sId = content.getRequestParameter(RequestBuilderImpl.REQUEST_ID);
        int id = Integer.parseInt(sId);
        Optional<Request> optionalRequest = requestService.findRequestById(id);
        if (optionalRequest.isPresent()) {
            Person person = optionalRequest.get();
            requestService.deleteRequest(id);
            addPerson(person);
        } else {
            throw new NoSuchRequestException();
        }
    }

    public List<Person> getAllWantedPersons() throws ServiceException {
        try {
            return personDao.findAll()
                    .stream()
                    .filter(person -> person.getType() == PersonType.WANTED)
                    .collect(Collectors.toList());
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    public List<Person> getAllMissingPersons() throws ServiceException {
        try {
            return personDao.findAll()
                    .stream()
                    .filter(person -> person.getType() == PersonType.MISSING)
                    .collect(Collectors.toList());
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    private void addPerson(Person person) throws ServiceException {
        try {
            personDao.create(person);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
