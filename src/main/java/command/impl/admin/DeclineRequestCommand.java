package command.impl.admin;

import command.Command;
import command.exception.CommandException;
import controller.Page;
import controller.SessionRequestContent;
import resource.ConfigurationManager;
import service.RequestService;
import service.exception.ServiceException;

public class DeclineRequestCommand implements Command {
    private final RequestService requestService = RequestService.getInstance();
    private static final String REQUESTS_PAGE = ConfigurationManager.getProperty("command.show.request.page");

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
