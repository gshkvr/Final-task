package command.impl.page;

import command.Command;
import command.exception.CommandException;
import controller.Page;
import controller.SessionRequestContent;
import entity.Request;
import resource.ConfigurationManager;
import service.RequestService;
import service.exception.ServiceException;

/**
 * Command that opens page with {@link Request}.
 *
 * @author George Kvirikashvili
 */
public class ShowRequestPageCommand implements Command {
    private static final String REQUESTS_SHOW_PAGE = ConfigurationManager.getProperty("page.requests");
    private static final String REQUESTS_SHOW_COMMAND = ConfigurationManager.getProperty("command.show.request.page");
    private static final String LOCALE_COMMAND = "localeCommand";
    private final RequestService requestService = RequestService.getInstance();

    @Override
    public Page execute(SessionRequestContent content) throws CommandException {
        try {
            content.setRequestAttribute("allRequests", requestService.getAllRequests());
            content.setRequestAttribute(LOCALE_COMMAND, REQUESTS_SHOW_COMMAND);
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
        return new Page(REQUESTS_SHOW_PAGE);
    }
}
