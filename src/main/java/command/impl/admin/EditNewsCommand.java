package command.impl.admin;

import builder.impl.NewsBuilderImpl;
import command.Command;
import command.exception.CommandException;
import controller.Page;
import controller.SessionRequestContent;
import resource.ConfigurationManager;
import service.NewsService;
import service.exception.*;

public class EditNewsCommand implements Command {
    private static final String NEWS_PAGE_COMMAND = ConfigurationManager.getProperty("command.news_page");
    private static final String EDIT_NEWS_PAGE_COMMAND = ConfigurationManager.getProperty("command.edit_news_page");
    private static final String ERROR_RU_TITLE = ConfigurationManager.getProperty("error.add_news.ru_title");
    private static final String ERROR_RU_TEXT = ConfigurationManager.getProperty("error.add_news.ru_text");
    private static final String ERROR_EN_TITLE = ConfigurationManager.getProperty("error.add_news.en_title");
    private static final String ERROR_EN_TEXT = ConfigurationManager.getProperty("error.add_news.en_text");
    private static final String ERROR_DATE = ConfigurationManager.getProperty("error.add_news.date");
    private static final String ATTRIBUTE_NEWS_ID = ConfigurationManager.getProperty("attribute.news_id");
    private final NewsService newsService = NewsService.getInstance();

    @Override
    public Page execute(SessionRequestContent content) throws CommandException {
        try {
            newsService.updateNews(content);
        } catch (EmptyRuTitleException e) {
            return new Page(EDIT_NEWS_PAGE_COMMAND + ATTRIBUTE_NEWS_ID + content.getRequestParameter(NewsBuilderImpl.NEWS_ID) + ERROR_RU_TITLE, true);
        } catch (EmptyRuTextException e) {
            return new Page(EDIT_NEWS_PAGE_COMMAND + ATTRIBUTE_NEWS_ID + content.getRequestParameter(NewsBuilderImpl.NEWS_ID) + ERROR_RU_TEXT, true);
        } catch (EmptyEnTitleException e) {
            return new Page(EDIT_NEWS_PAGE_COMMAND + ATTRIBUTE_NEWS_ID + content.getRequestParameter(NewsBuilderImpl.NEWS_ID) + ERROR_EN_TITLE, true);
        } catch (EmptyEnTextException e) {
            return new Page(EDIT_NEWS_PAGE_COMMAND + ATTRIBUTE_NEWS_ID + content.getRequestParameter(NewsBuilderImpl.NEWS_ID) + ERROR_EN_TEXT, true);
        } catch (EmptyDateException e) {
            return new Page(EDIT_NEWS_PAGE_COMMAND + ATTRIBUTE_NEWS_ID + content.getRequestParameter(NewsBuilderImpl.NEWS_ID) + ERROR_DATE, true);
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
        return new Page(NEWS_PAGE_COMMAND, true);
    }
}
