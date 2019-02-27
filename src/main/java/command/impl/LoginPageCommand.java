package command.impl;

import command.Command;
import controller.Page;
import controller.SessionRequestContent;
import resource.ConfigurationManager;

public class LoginPageCommand implements Command {
    private static final String LOGIN_PAGE = ConfigurationManager.getProperty("page.login");
    private static final String LOGIN_PAGE_COMMAND = ConfigurationManager.getProperty("command.login.page");
    private static final String LOGIN_ERROR_PARAM = "errorLogin";
    private static final String LOCALE_COMMAND= "localeCommand";

    @Override
    public Page execute(SessionRequestContent content) {
        String errorLogin = content.getRequestParameter(LOGIN_ERROR_PARAM);
        content.setRequestAttribute(LOGIN_ERROR_PARAM, errorLogin);
        content.setRequestAttribute(LOCALE_COMMAND, LOGIN_PAGE_COMMAND);
        return new Page(LOGIN_PAGE);
    }
}
