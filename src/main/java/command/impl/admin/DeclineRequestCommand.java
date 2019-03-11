package command.impl.admin;

import command.Command;
import command.exception.CommandException;
import controller.Page;
import controller.SessionRequestContent;
import entity.Request;
import resource.ConfigurationManager;
import service.RequestService;
import service.exception.ServiceException;

/**
 * Administrator {@code command}. Deletes {@link Request} from requests.
 *
 * @author George Kvirikashvili
 */
public class DeclineRequestCommand implements Command {
    private static final String REQUESTS_PAGE = ConfigurationManager.getProperty("command.show.request.page");
    private RequestService requestService = RequestService.getInstance();

    /**
     * Default constructor with default RequestService.
     */
    public DeclineRequestCommand() {
    }

    /**
     * Constructor with RequestService for test.
     *
     * @param requestService test RequestService
     */
    DeclineRequestCommand(RequestService requestService) {
        this.requestService = requestService;
    }

    @Override
    public Page execute(SessionRequestContent content) throws CommandException {
        try {
            requestService.declineRequest(content);
            return new Page(REQUESTS_PAGE, true);
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
    }
}
