package command.impl;

import command.Command;
import controller.Page;
import controller.SessionRequestContent;
import entity.impl.User;
import exception.ServiceException;
import resource.ConfigurationManager;
import service.UserService;
import util.CryptUtil;

import javax.servlet.http.Cookie;
import java.util.Optional;

public class LoginCommand implements Command {
    private static final String USER_ATTRIBUTE = "user";
    private static final String PARAM_NAME_LOGIN = "login";
    private static final String PARAM_NAME_PASSWORD = "password";
    private static final String NEWS_COMMAND = ConfigurationManager.getProperty("command.news");
    private static final String LOGIN_PAGE_COMMAND = ConfigurationManager.getProperty("command.login.page");
    private static final String LOGIN_ERROR = ConfigurationManager.getProperty("error.login");

    private final UserService userService = UserService.getInstance();
    private final CryptUtil cryptUtil = CryptUtil.getInstance();

    @Override
    public Page execute(SessionRequestContent content) throws ServiceException {
        String login = content.getRequestParameter(PARAM_NAME_LOGIN);
        String pass = content.getRequestParameter(PARAM_NAME_PASSWORD);

        Optional<User> optionalUser = userService.findUserByLogin(login);

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            if (cryptUtil.checkPassword(pass, user.getPassword())) {
                content.setSessionAttribute(USER_ATTRIBUTE, login);
                Cookie cookie = new Cookie(USER_ATTRIBUTE, login);
                content.setCookie(cookie);
                return new Page(NEWS_COMMAND, true);
            }
        }
        return new Page(LOGIN_PAGE_COMMAND + LOGIN_ERROR, true);
    }

}
