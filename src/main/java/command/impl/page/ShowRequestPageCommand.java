package command.impl.page;

import command.Command;
import controller.Page;
import controller.SessionRequestContent;
import exception.CommandException;
import exception.ServiceException;
import resource.ConfigurationManager;
import service.RequestService;

public class ShowRequestPageCommand implements Command {
    private static final String REQUESTS_SHOW_PAGE = ConfigurationManager.getProperty("page.requests");
    private static final String REQUESTS_SHOW_COMMAND = ConfigurationManager.getProperty("command.show_request_page");
    private static final String LOCALE_COMMAND = "localeCommand";
    private final RequestService requestService = RequestService.getInstance();

    @Override
    public Page execute(SessionRequestContent content) throws CommandException {
        try {
            content.setRequestAttribute("allRequests", requestService.getAllRequests());
            content.setRequestAttribute(LOCALE_COMMAND, REQUESTS_SHOW_COMMAND);
        } catch (ServiceException e) {
            throw new CommandException(e.getMessage(), e);
        }
        return new Page(REQUESTS_SHOW_PAGE);
    }
}
