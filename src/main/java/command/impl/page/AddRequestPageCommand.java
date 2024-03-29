package command.impl.page;

import command.Command;
import controller.Page;
import controller.SessionRequestContent;
import entity.Request;
import resource.ConfigurationManager;

/**
 * Command that opens page to add new {@link Request}.
 *
 * @author George Kvirikashvili
 */
public class AddRequestPageCommand implements Command {
    private static final String ERROR_REQUEST = "errorRequest";
    private static final String REQUEST_PAGE = ConfigurationManager.getProperty("page.request");
    private static final String REQUEST_PAGE_COMMAND = ConfigurationManager.getProperty("command.add.request.page");
    private static final String CURRENT_COMMAND = "currentCommand";

    @Override
    public Page execute(SessionRequestContent content) {
        content.setRequestAttribute(CURRENT_COMMAND, REQUEST_PAGE_COMMAND);
        String registrationError = content.getRequestParameter(ERROR_REQUEST);
        if (registrationError != null) {
            content.setRequestAttribute(CURRENT_COMMAND, REQUEST_PAGE_COMMAND + ConfigurationManager.getProperty(registrationError));
            content.setRequestAttribute(ERROR_REQUEST, registrationError);
        }
        return new Page(REQUEST_PAGE);
    }
}
