package command.impl.admin;

import command.Command;
import command.exception.CommandException;
import controller.Page;
import controller.SessionRequestContent;
import entity.News;
import resource.ConfigurationManager;
import service.NewsService;
import service.exception.*;

/**
 * Administrator {@code command}. Add new {@link News}.
 *
 * @author George Kvirikashvili
 */
public class AddNewsCommand implements Command {
    private static final String NEWS_PAGE_COMMAND = ConfigurationManager.getProperty("command.news.page");
    private static final String ADD_NEWS_PAGE_COMMAND = ConfigurationManager.getProperty("command.add.news.page");
    private static final String ERROR_RU_TITLE = ConfigurationManager.getProperty("error.add.news.ru.title");
    private static final String ERROR_RU_TEXT = ConfigurationManager.getProperty("error.add.news.ru.text");
    private static final String ERROR_EN_TITLE = ConfigurationManager.getProperty("error.add.news.en.title");
    private static final String ERROR_EN_TEXT = ConfigurationManager.getProperty("error.add.news.en.text");
    private static final String ERROR_DATE = ConfigurationManager.getProperty("error.add.news.date");
    private NewsService newsService = NewsService.getInstance();

    /**
     * Default constructor with default NewsService.
     */
    public AddNewsCommand() {
    }

    /**
     * Constructor with NewsService for test.
     *
     * @param newsService test NewsService
     */
    AddNewsCommand(NewsService newsService) {
        this.newsService = newsService;
    }

    @Override
    public Page execute(SessionRequestContent content) throws CommandException {
        try {
            newsService.addNews(content);
        } catch (EmptyRuTitleException e) {
            return new Page(ADD_NEWS_PAGE_COMMAND + ERROR_RU_TITLE, true);
        } catch (EmptyRuTextException e) {
            return new Page(ADD_NEWS_PAGE_COMMAND + ERROR_RU_TEXT, true);
        } catch (EmptyEnTitleException e) {
            return new Page(ADD_NEWS_PAGE_COMMAND + ERROR_EN_TITLE, true);
        } catch (EmptyEnTextException e) {
            return new Page(ADD_NEWS_PAGE_COMMAND + ERROR_EN_TEXT, true);
        } catch (EmptyDateException e) {
            return new Page(ADD_NEWS_PAGE_COMMAND + ERROR_DATE, true);
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
        return new Page(NEWS_PAGE_COMMAND, true);
    }
}
