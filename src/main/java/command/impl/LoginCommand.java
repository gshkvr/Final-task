package command.impl;

import command.Command;
import controller.Page;
import controller.SessionRequestContent;
import logic.LoginLogic;
import resource.ConfigurationManager;
import service.UserService;

import javax.servlet.http.Cookie;

public class LoginCommand implements Command {
    public static final String COMMAND = "login";
    private static final String USER_ATTRIBUTE = "user";
    private static final String PARAM_NAME_LOGIN = "login";
    private static final String PARAM_NAME_PASSWORD = "password";
    private static final String NEWS_COMMAND = ConfigurationManager.getProperty("command.news");
    private static final String LOGIN_PAGE_COMMAND = ConfigurationManager.getProperty("command.login.page");
    private static final String LOGIN_ERROR = ConfigurationManager.getProperty("error.login");

    private final UserService userService;

    public LoginCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public Page execute(SessionRequestContent content) {
        String login = content.getRequestParameter(PARAM_NAME_LOGIN);
        //String pass = BCrypt.hashpw(content.getRequestParameter(PARAM_NAME_PASSWORD), BCrypt.gensalt());
        String pass = content.getRequestParameter(PARAM_NAME_PASSWORD);

        if (LoginLogic.checkLogin(login, pass)) {
            content.setSessionAttribute(USER_ATTRIBUTE, login);
            Cookie cookie = new Cookie(USER_ATTRIBUTE, login);
            content.setCookie(cookie);
            return new Page(NEWS_COMMAND, true);
        } else {
            return new Page(LOGIN_PAGE_COMMAND + LOGIN_ERROR, true);
        }
    }
}
