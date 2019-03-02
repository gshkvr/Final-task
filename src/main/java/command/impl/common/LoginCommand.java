package command.impl.common;

import command.Command;
import controller.Page;
import controller.SessionRequestContent;
import entity.impl.User;
import command.exception.CommandException;
import service.exception.NoSuchUserException;
import service.exception.ServiceException;
import resource.ConfigurationManager;
import service.UserService;

import javax.servlet.http.Cookie;
import java.util.Optional;

public class LoginCommand implements Command {
    private static final String NEWS_COMMAND = ConfigurationManager.getProperty("command.news_page");
    private static final String LOGIN_PAGE_COMMAND = ConfigurationManager.getProperty("command.login_page");
    private static final String LOGIN_ERROR = ConfigurationManager.getProperty("attribute.error.login");

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
