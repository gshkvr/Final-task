package command.impl.page;

import command.Command;
import controller.Page;
import controller.SessionRequestContent;
import resource.ConfigurationManager;

/**
 * Command that opens register page.
 *
 * @author George Kvirikashvili
 */
public class RegisterPageCommand implements Command {
    private static final String ERROR_REGISTRATION = "errorRegistration";
    private static final String REGISTER_PAGE = ConfigurationManager.getProperty("page.register");
    private static final String REGISTER_PAGE_COMMAND = ConfigurationManager.getProperty("command.register.page");
    private static final String LOCALE_COMMAND = "localeCommand";

    @Override
    public Page execute(SessionRequestContent content) {
        String registrationError = content.getRequestParameter(ERROR_REGISTRATION);
        content.setRequestAttribute(LOCALE_COMMAND, REGISTER_PAGE_COMMAND);
        if(registrationError!=null){
            content.setRequestAttribute(ERROR_REGISTRATION, registrationError);
            content.setRequestAttribute(LOCALE_COMMAND, REGISTER_PAGE_COMMAND + ConfigurationManager.getProperty(registrationError));
        }
        return new Page(REGISTER_PAGE);
    }
}
