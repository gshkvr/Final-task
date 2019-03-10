package command.impl.admin;

import command.Command;
import command.exception.CommandException;
import controller.Page;
import controller.SessionRequestContent;
import resource.ConfigurationManager;
import service.UserService;
import service.exception.ServiceException;

/**
 * Administrator {@code command}. Gets all {@code users}.
 *
 * @author George Kvirikashvili
 */
public class ShowUsersCommand implements Command {
    private static final String USERS_PAGE = ConfigurationManager.getProperty("page.users");
    private static final String USERS_COMMAND = ConfigurationManager.getProperty("command.users");
    private static final String LOCALE_COMMAND = "localeCommand";
    private final UserService userService = UserService.getInstance();

    @Override
    public Page execute(SessionRequestContent content) throws CommandException {
        try {
            content.setRequestAttribute("allUsers", userService.getAllUsers());
            content.setRequestAttribute(LOCALE_COMMAND, USERS_COMMAND);
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
        return new Page(USERS_PAGE);
    }
}
