package command.impl;

import command.Command;
import controller.Page;
import controller.SessionRequestContent;
import resource.ConfigurationManager;

import javax.servlet.http.Cookie;

public class LogoutCommand implements Command {
    private static final String USER_ATTRIBUTE = "user";
    private static final String NEWS_COMMAND = ConfigurationManager.getProperty("command.news");

    @Override
    public Page execute(SessionRequestContent content) {
        Cookie cookie = new Cookie(USER_ATTRIBUTE, "");
        cookie.setMaxAge(0);
        cookie.setPath("/");
        content.setCookie(cookie);
        content.setSessionInvalidated(true);
        return new Page(NEWS_COMMAND, true);
    }
}
