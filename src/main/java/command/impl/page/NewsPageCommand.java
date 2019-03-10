package command.impl.page;

import command.Command;
import command.exception.CommandException;
import controller.Page;
import controller.SessionRequestContent;
import entity.News;
import resource.ConfigurationManager;
import service.NewsService;
import service.exception.ServiceException;

/**
 * Command that opens page with {@link News}.
 *
 * @author George Kvirikashvili
 */
public class NewsPageCommand implements Command {
    private static final String NEWS_PAGE = ConfigurationManager.getProperty("page.news");
    private static final String NEWS_COMMAND = ConfigurationManager.getProperty("command.news.page");
    private static final String LOCALE_COMMAND = "localeCommand";
    private static final String ALL_NEWS = "allNews";
    private final NewsService newsService = NewsService.getInstance();

    @Override
    public Page execute(SessionRequestContent content) throws CommandException {
        try {
            content.setRequestAttribute(ALL_NEWS, newsService.getAllNews());
            content.setRequestAttribute(LOCALE_COMMAND, NEWS_COMMAND);
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
        return new Page(NEWS_PAGE);
    }
}
