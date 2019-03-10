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
    private static final String CURRENT_COMMAND = "currentCommand";
    private static final String ALL_REQUESTS = "allRequests";
    private static final String PAGES_PARAMETER = "pages";
    private static final String PAGE_PARAMETER = "page";
    private static final String ACTIVE_PAGE_PARAMETER = "activePage";
    private final RequestService requestService = RequestService.getInstance();

    @Override
    public Page execute(SessionRequestContent content) throws CommandException {
        try {
            int page = 1;
            if(content.getRequestParameter(PAGE_PARAMETER) != null){
                page = Integer.parseInt(content.getRequestParameter(PAGE_PARAMETER));
            }
            content.setRequestAttribute(PAGES_PARAMETER, requestService.pageAmount());
            content.setRequestAttribute(ALL_REQUESTS, requestService.getAllRequests(page));
            content.setRequestAttribute(ACTIVE_PAGE_PARAMETER, page);
            content.setRequestAttribute(CURRENT_COMMAND, REQUESTS_SHOW_COMMAND);
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
        return new Page(REQUESTS_SHOW_PAGE);
    }
}
