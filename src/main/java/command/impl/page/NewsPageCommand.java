package command.impl.page;

import command.Command;
import controller.Page;
import controller.SessionRequestContent;
import command.exception.CommandException;
import service.exception.ServiceException;
import resource.ConfigurationManager;
import service.NewsService;

public class NewsPageCommand implements Command {
    private static final String NEWS_PAGE = ConfigurationManager.getProperty("page.news");
    private static final String NEWS_COMMAND = ConfigurationManager.getProperty("command.news_page");
    private static final String LOCALE_COMMAND = "localeCommand";
    private final NewsService newsService = NewsService.getInstance();

    @Override
    public Page execute(SessionRequestContent content) throws CommandException {
        try {
            content.setRequestAttribute("allNews", newsService.getAllNews());
            content.setRequestAttribute(LOCALE_COMMAND, NEWS_COMMAND);
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
        return new Page(NEWS_PAGE);
    }
}
