package command.impl.page;

import command.Command;
import controller.Page;
import controller.SessionRequestContent;
import resource.ConfigurationManager;

public class LoginPageCommand implements Command {
    private static final String LOGIN_PAGE = ConfigurationManager.getProperty("page.login");
    private static final String LOGIN_PAGE_COMMAND = ConfigurationManager.getProperty("command.login_page");
    private static final String LOGIN_ERROR_PARAM = "errorLogin";
    private static final String SUCCESS_REGISTRATION_PARAM = "successRegister";
    private static final String LOCALE_COMMAND = "localeCommand";

    @Override
    public Page execute(SessionRequestContent content) {
        String errorLogin = content.getRequestParameter(LOGIN_ERROR_PARAM);
        content.setRequestAttribute(LOCALE_COMMAND, LOGIN_PAGE_COMMAND);
        if(errorLogin != null){
            content.setRequestAttribute(LOGIN_ERROR_PARAM, errorLogin);
            content.setRequestAttribute(LOCALE_COMMAND, LOGIN_PAGE_COMMAND + ConfigurationManager.getProperty(errorLogin));
        }
        String successRegister = content.getRequestParameter(SUCCESS_REGISTRATION_PARAM);
        if(successRegister != null){
            content.setRequestAttribute(SUCCESS_REGISTRATION_PARAM, successRegister);
            content.setRequestAttribute(LOCALE_COMMAND, LOGIN_PAGE_COMMAND + ConfigurationManager.getProperty(successRegister));
        }
        return new Page(LOGIN_PAGE);
    }
}
