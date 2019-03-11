package command.impl.common;

import command.Command;
import command.exception.CommandException;
import controller.Page;
import controller.SessionRequestContent;
import resource.ConfigurationManager;
import service.UserService;
import service.exception.NoSuchUserException;
import service.exception.ServiceException;

/**
 * Common {@code command}. Login user or redirect to error page.
 *
 * @author George Kvirikashvili
 */
public class LoginCommand implements Command {
    private static final String NEWS_COMMAND = ConfigurationManager.getProperty("command.news.page");
    private static final String LOGIN_PAGE_COMMAND = ConfigurationManager.getProperty("command.login.page");
    private static final String LOGIN_ERROR = ConfigurationManager.getProperty("error.login");

    private UserService userService = UserService.getInstance();

    /**
     * Default constructor with default UserService.
     */
    public LoginCommand() {
    }

    /**
     * Constructor with UserService for test.
     *
     * @param userService test UserService
     */
    LoginCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public Page execute(SessionRequestContent content) throws CommandException {
        try {
            userService.loginUser(content);
        } catch (ServiceException e) {
            throw new CommandException(e);
        } catch (NoSuchUserException e) {
            return new Page(LOGIN_PAGE_COMMAND + LOGIN_ERROR, true);
        }
        return new Page(NEWS_COMMAND, true);
    }
}
