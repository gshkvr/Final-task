package command.impl.page;

import command.Command;
import controller.Page;
import controller.SessionRequestContent;
import resource.ConfigurationManager;

public class MessagePageCommand implements Command {
    private static final String MESSAGE_PAGE = ConfigurationManager.getProperty("page.message");
    private static final String MESSAGE_PAGE_COMMAND = ConfigurationManager.getProperty("command.message_page");
    private static final String SUCCESS_ATTRIBUTE = "success";
    private static final String LOCALE_COMMAND = "localeCommand";

    @Override
    public Page execute(SessionRequestContent content) {
        String success = content.getRequestParameter(SUCCESS_ATTRIBUTE);
        content.setRequestAttribute(SUCCESS_ATTRIBUTE, success);
        content.setRequestAttribute(LOCALE_COMMAND, MESSAGE_PAGE_COMMAND);
        return new Page(MESSAGE_PAGE);
    }
}
