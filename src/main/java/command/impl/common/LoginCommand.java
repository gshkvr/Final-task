package command.impl.common;

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
    private static final String NEWS_COMMAND = ConfigurationManager.getProperty("command.news_page");
    private static final String LOGIN_PAGE_COMMAND = ConfigurationManager.getProperty("command.login_page");
    private static final String LOGIN_ERROR = ConfigurationManager.getProperty("attribute.error.login");

    private final UserService userService = UserService.getInstance();
    private final CryptUtil cryptUtil = CryptUtil.getInstance();

    @Override
    public Page execute(SessionRequestContent content) throws ServiceException {
        String login = content.getRequestParameter(User.LOGIN);
        String pass = content.getRequestParameter(User.PASSWORD);

        Optional<User> optionalUser = userService.findUserByLogin(login);

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            if (cryptUtil.checkPassword(pass, user.getPassword())) {
                content.setSessionAttribute(User.TABLE_NAME, login);
                content.setSessionAttribute(User.USER_ROLE, user.getRole().getValue());
                Cookie userCookie = new Cookie(User.TABLE_NAME, login);
                Cookie roleCookie = new Cookie(User.USER_ROLE, user.getRole().getValue());
                content.setCookie(userCookie);
                content.setCookie(roleCookie);
                return new Page(NEWS_COMMAND, true);
            }
        }
        return new Page(LOGIN_PAGE_COMMAND + LOGIN_ERROR, true);
    }

}
