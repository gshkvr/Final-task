package command.impl.page;

import command.Command;
import controller.Page;
import controller.SessionRequestContent;
import resource.ConfigurationManager;

/**
 * Command that opens message page and shows necessary message.
 *
 * @author George Kvirikashvili
 */
public class MessagePageCommand implements Command {
    private static final String MESSAGE_PAGE = ConfigurationManager.getProperty("page.message");
    private static final String MESSAGE_PAGE_COMMAND = ConfigurationManager.getProperty("command.message.page");
    private static final String SUCCESS_ATTRIBUTE = "success";
    private static final String LOCALE_COMMAND = "localeCommand";

    @Override
    public Page execute(SessionRequestContent content) {
        content.setRequestAttribute(LOCALE_COMMAND, MESSAGE_PAGE_COMMAND);
        String success = content.getRequestParameter(SUCCESS_ATTRIBUTE);
        if(success != null){
            content.setRequestAttribute(LOCALE_COMMAND, MESSAGE_PAGE_COMMAND + ConfigurationManager.getProperty(success));
            content.setRequestAttribute(SUCCESS_ATTRIBUTE, success);
        }
        return new Page(MESSAGE_PAGE);
    }
}
