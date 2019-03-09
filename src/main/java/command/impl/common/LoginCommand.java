package command.impl.common;

import command.Command;
import controller.Page;
import controller.SessionRequestContent;
import command.exception.CommandException;
import service.exception.NoSuchUserException;
import service.exception.ServiceException;
import resource.ConfigurationManager;
import service.UserService;

public class LoginCommand implements Command {
    private static final String NEWS_COMMAND = ConfigurationManager.getProperty("command.news.page");
    private static final String LOGIN_PAGE_COMMAND = ConfigurationManager.getProperty("command.login.page");
    private static final String LOGIN_ERROR = ConfigurationManager.getProperty("error.login");

    private final UserService userService = UserService.getInstance();

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
