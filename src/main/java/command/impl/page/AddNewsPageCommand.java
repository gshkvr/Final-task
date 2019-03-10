package command.impl.page;

import command.Command;
import controller.Page;
import controller.SessionRequestContent;
import entity.News;
import resource.ConfigurationManager;


/**
 * Command that opens page to add new {@link News}.
 *
 * @author George Kvirikashvili
 */
public class AddNewsPageCommand implements Command {
    private static final String ADD_NEWS_PAGE = ConfigurationManager.getProperty("page.add.news");
    private static final String ADD_NEWS_PAGE_COMMAND = ConfigurationManager.getProperty("command.add.news.page");
    private static final String ERROR_PARAMETER = "errorAddNews";
    private static final String LOCALE_COMMAND = "localeCommand";

    @Override
    public Page execute(SessionRequestContent content) {
        content.setRequestAttribute(LOCALE_COMMAND, ADD_NEWS_PAGE_COMMAND);
        String error = content.getRequestParameter(ERROR_PARAMETER);
        if (error != null) {
            content.setRequestAttribute(LOCALE_COMMAND, ADD_NEWS_PAGE_COMMAND + ConfigurationManager.getProperty(error));
            content.setRequestAttribute(ERROR_PARAMETER, error);
        }
        return new Page(ADD_NEWS_PAGE);
    }
}
