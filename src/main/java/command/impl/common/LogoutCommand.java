package command.impl.common;

import command.Command;
import controller.Page;
import controller.SessionRequestContent;
import entity.impl.User;
import resource.ConfigurationManager;

import javax.servlet.http.Cookie;

public class LogoutCommand implements Command {
    private static final String NEWS_COMMAND = ConfigurationManager.getProperty("command.news_page");

    @Override
    public Page execute(SessionRequestContent content) {
        Cookie userCookie = new Cookie(User.TABLE_NAME, "");
        Cookie roleCookie = new Cookie(User.USER_ROLE, "");
        userCookie.setMaxAge(0);
        roleCookie.setMaxAge(0);
        userCookie.setPath("/");
        roleCookie.setPath("/");
        content.setCookie(userCookie);
        content.setCookie(roleCookie);
        content.setSessionInvalidated(true);
        return new Page(NEWS_COMMAND, true);
    }
}