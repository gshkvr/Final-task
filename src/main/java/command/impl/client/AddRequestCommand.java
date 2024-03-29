package command.impl.client;

import command.Command;
import command.exception.CommandException;
import controller.Page;
import controller.SessionRequestContent;
import entity.Request;
import resource.ConfigurationManager;
import service.RequestService;
import service.exception.*;

/**
 * Client {@code command}. Add new {@link Request}.
 *
 * @author George Kvirikashvili
 */
public class AddRequestCommand implements Command {
    private static final String MESSAGE_PAGE_COMMAND = ConfigurationManager.getProperty("command.message.page");
    private static final String SUCCESS_ADD_REQUEST = ConfigurationManager.getProperty("success.add.request");
    private static final String REQUEST_PAGE_COMMAND = ConfigurationManager.getProperty("command.add.request.page");
    private static final String NAME_ERROR = ConfigurationManager.getProperty("error.request.name");
    private static final String FILE_ERROR = ConfigurationManager.getProperty("error.request.file");
    private static final String SEX_ERROR = ConfigurationManager.getProperty("error.request.sex");
    private static final String TYPE_ERROR = ConfigurationManager.getProperty("error.request.type");
    private static final String NATIONALITY_ERROR = ConfigurationManager.getProperty("error.request.nationality");
    private static final String BIRTH_DATE_ERROR = ConfigurationManager.getProperty("error.request.birth.date");
    private RequestService requestService = RequestService.getInstance();

    /**
     * Default constructor with default RequestService.
     */
    public AddRequestCommand() {
    }

    /**
     * Constructor with RequestService for test.
     *
     * @param requestService test UserService
     */
    AddRequestCommand(RequestService requestService) {
        this.requestService = requestService;
    }

    @Override
    public Page execute(SessionRequestContent content) throws CommandException {
        try {
            requestService.createRequest(content);
        } catch (EmptyNameException e) {
            return new Page(REQUEST_PAGE_COMMAND + NAME_ERROR, true);
        } catch (EmptyFileException e) {
            return new Page(REQUEST_PAGE_COMMAND + FILE_ERROR, true);
        } catch (EmptySexException e) {
            return new Page(REQUEST_PAGE_COMMAND + SEX_ERROR, true);
        } catch (EmptyBirthDateException e) {
            return new Page(REQUEST_PAGE_COMMAND + BIRTH_DATE_ERROR, true);
        } catch (EmptyNationalityException e) {
            return new Page(REQUEST_PAGE_COMMAND + NATIONALITY_ERROR, true);
        } catch (EmptyTypeException e) {
            return new Page(REQUEST_PAGE_COMMAND + TYPE_ERROR, true);
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
        return new Page(MESSAGE_PAGE_COMMAND + SUCCESS_ADD_REQUEST, true);
    }

}
