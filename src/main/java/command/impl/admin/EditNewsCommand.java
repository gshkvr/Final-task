package command.impl.admin;

import builder.impl.NewsBuilderImpl;
import command.Command;
import command.exception.CommandException;
import controller.Page;
import controller.SessionRequestContent;
import entity.News;
import resource.ConfigurationManager;
import service.NewsService;
import service.exception.*;

/**
 * Administrator {@code command}. Edit {@link News}.
 *
 * @author George Kvirikashvili
 */
public class EditNewsCommand implements Command {
    private static final String NEWS_PAGE_COMMAND = ConfigurationManager.getProperty("command.news.page");
    private static final String EDIT_NEWS_PAGE_COMMAND = ConfigurationManager.getProperty("command.edit.news.page");
    private static final String ERROR_RU_TITLE = ConfigurationManager.getProperty("error.add.news.ru.title");
    private static final String ERROR_RU_TEXT = ConfigurationManager.getProperty("error.add.news.ru.text");
    private static final String ERROR_EN_TITLE = ConfigurationManager.getProperty("error.add.news.en.title");
    private static final String ERROR_EN_TEXT = ConfigurationManager.getProperty("error.add.news.en.text");
    private static final String ERROR_DATE = ConfigurationManager.getProperty("error.add.news.date");
    private static final String ATTRIBUTE_NEWS_ID = ConfigurationManager.getProperty("attribute.news.id");
    private NewsService newsService = NewsService.getInstance();

    /**
     * Default constructor with default NewsService.
     */
    public EditNewsCommand() {
    }

    /**
     * Constructor with NewsService for test.
     *
     * @param newsService test NewsService
     */
    EditNewsCommand(NewsService newsService) {
        this.newsService = newsService;
    }

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
