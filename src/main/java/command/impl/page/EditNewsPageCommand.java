package command.impl.page;

import command.Command;
import command.exception.CommandException;
import controller.Page;
import controller.SessionRequestContent;
import entity.News;
import resource.ConfigurationManager;
import service.NewsService;
import service.exception.NoSuchNewsException;
import service.exception.ServiceException;

public class EditNewsPageCommand implements Command {
    private static final String EDIT_NEWS_PAGE = ConfigurationManager.getProperty("page.edit_news");
    private static final String EDIT_NEWS_PAGE_COMMAND = ConfigurationManager.getProperty("command.edit_news_page");
    private static final String ATTRIBUTE_NEWS_ID = ConfigurationManager.getProperty("attribute.news_id");
    private static final String LOCALE_COMMAND = "localeCommand";
    private static final String ERROR_PARAMETER = "errorAddNews";
    private static final String NEWS_PARAM = "editNews";
    private final NewsService newsService = NewsService.getInstance();

    @Override
    public Page execute(SessionRequestContent content) throws CommandException {

        try {
            News news = newsService.getNews(content);
            content.setRequestAttribute(NEWS_PARAM, news);
            content.setRequestAttribute(LOCALE_COMMAND, EDIT_NEWS_PAGE_COMMAND + ATTRIBUTE_NEWS_ID + news.getId());
            String error = content.getRequestParameter(ERROR_PARAMETER);
            if (error != null) {
                content.setRequestAttribute(LOCALE_COMMAND, EDIT_NEWS_PAGE_COMMAND + ATTRIBUTE_NEWS_ID + news.getId() + ConfigurationManager.getProperty(error));
                content.setRequestAttribute(ERROR_PARAMETER, error);
            }
            content.setRequestAttribute(LOCALE_COMMAND, EDIT_NEWS_PAGE_COMMAND + ATTRIBUTE_NEWS_ID + news.getId());
        } catch (NoSuchNewsException | ServiceException e) {
            throw new CommandException(e);
        }
        return new Page(EDIT_NEWS_PAGE);
    }
}
