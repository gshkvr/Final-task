package command.impl.page;

import command.Command;
import controller.Page;
import controller.SessionRequestContent;
import resource.ConfigurationManager;

/**
 * Command that opens error page.
 *
 * @author George Kvirikashvili
 */
public class ErrorPageCommand implements Command {
    private static final String ERROR_PAGE = ConfigurationManager.getProperty("page.error");
    private static final String ERROR_COMMAND = ConfigurationManager.getProperty("command.error.page");
    private static final String CURRENT_COMMAND = "currentCommand";

    @Override
    public Page execute(SessionRequestContent content) {
        content.setRequestAttribute(CURRENT_COMMAND, ERROR_COMMAND);
        return new Page(ERROR_PAGE);
    }
}
