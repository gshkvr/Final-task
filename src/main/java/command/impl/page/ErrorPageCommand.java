package command.impl.page;

import command.Command;
import controller.Page;
import controller.SessionRequestContent;
import exception.CommandException;
import exception.ServiceException;
import resource.ConfigurationManager;

public class ErrorPageCommand implements Command {
    private static final String ERROR_PAGE = ConfigurationManager.getProperty("page.error");
    private static final String ERROR_COMMAND = ConfigurationManager.getProperty("command.error");
    private static final String LOCALE_COMMAND= "localeCommand";

    @Override
    public Page execute(SessionRequestContent content) throws ServiceException, CommandException {
        content.setRequestAttribute(LOCALE_COMMAND, ERROR_COMMAND);
        return new Page(ERROR_PAGE);
    }
}