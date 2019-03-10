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
    private static final String CURRENT_COMMAND = "currentCommand";
    private static final String ALL_NEWS = "allNews";
    private static final String PAGES_PARAMETER = "pages";
    private static final String PAGE_PARAMETER = "page";
    private static final String ACTIVE_PAGE_PARAMETER = "activePage";
    private final NewsService newsService = NewsService.getInstance();

    @Override
    public Page execute(SessionRequestContent content) throws CommandException {
        try {
            int page = 1;
            if (content.getRequestParameter(PAGE_PARAMETER) != null) {
                page = Integer.parseInt(content.getRequestParameter(PAGE_PARAMETER));
            }
            content.setRequestAttribute(ALL_NEWS, newsService.getAllNews(page));
            content.setRequestAttribute(PAGES_PARAMETER, newsService.pageAmount());
            content.setRequestAttribute(CURRENT_COMMAND, NEWS_COMMAND);
            content.setRequestAttribute(ACTIVE_PAGE_PARAMETER, page);
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
        return new Page(NEWS_PAGE);
    }
}
