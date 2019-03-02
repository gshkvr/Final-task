package command.impl.client;

import command.Command;
import command.exception.CommandException;
import controller.Page;
import controller.SessionRequestContent;
import resource.ConfigurationManager;
import service.RequestService;
import service.exception.EmptyFileException;
import service.exception.EmptyNameException;
import service.exception.ServiceException;


public class AddRequestCommand implements Command {
    private static final String REQUEST_PAGE_COMMAND = ConfigurationManager.getProperty("command.add_request_page");
    private static final String REQUEST_SHOW_COMMAND = ConfigurationManager.getProperty("command.show_request_page");
    private static final String FILE_SIZE_ERROR = ConfigurationManager.getProperty("attribute.error.request.file_size");
    private static final String NAME_ERROR = ConfigurationManager.getProperty("attribute.error.request.name");
    private static final String FILE_ERROR = ConfigurationManager.getProperty("attribute.error.request.file");
    private final RequestService requestService = RequestService.getInstance();

    @Override
    public Page execute(SessionRequestContent content) throws CommandException {
        try {
            requestService.createRequest(content);
        } catch (EmptyNameException e) {
            return new Page(REQUEST_PAGE_COMMAND + NAME_ERROR, true);
        } catch (EmptyFileException e) {
            return new Page(REQUEST_PAGE_COMMAND + FILE_ERROR, true);
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
        return new Page(REQUEST_SHOW_COMMAND, true);
    }

}
