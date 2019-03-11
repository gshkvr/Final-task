package command.impl.admin;

import command.exception.CommandException;
import controller.Page;
import controller.SessionRequestContent;
import org.testng.Assert;
import org.testng.annotations.Test;
import resource.ConfigurationManager;
import service.NewsService;
import service.exception.*;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AddNewsCommandTest {
    private static final SessionRequestContent CONTENT = new SessionRequestContent();
    private static final String NEWS_PAGE_COMMAND = ConfigurationManager.getProperty("command.news.page");
    private static final Page PAGE = new Page(NEWS_PAGE_COMMAND, true);
    private final NewsService newsService = mock(NewsService.class);

    @Test
    public void returnNewsPage() throws ServiceException, CommandException, EmptyDateException, EmptyRuTextException, EmptyEnTitleException, EmptyEnTextException, EmptyRuTitleException {
        when(newsService.addNews(CONTENT)).thenReturn(true);
        AddNewsCommand addNewsCommand = new AddNewsCommand(newsService);
        Page actual = addNewsCommand.execute(CONTENT);
        Assert.assertEquals(actual, PAGE);
    }
}