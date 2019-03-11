package command.impl.common;

import command.exception.CommandException;
import controller.Page;
import controller.SessionRequestContent;
import org.testng.Assert;
import org.testng.annotations.Test;
import resource.ConfigurationManager;
import service.UserService;
import service.exception.NoSuchUserException;
import service.exception.ServiceException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LoginCommandTest {
    private static final SessionRequestContent CONTENT = new SessionRequestContent();
    private static final String NEWS_COMMAND = ConfigurationManager.getProperty("command.news.page");
    private static final Page NEWS_PAGE = new Page(NEWS_COMMAND, true);
    private final UserService userService = mock(UserService.class);

    @Test
    public void returnNewsPage() throws ServiceException, NoSuchUserException, CommandException {
        when(userService.loginUser(CONTENT)).thenReturn(true);
        LoginCommand loginCommand = new LoginCommand(userService);
        Page actual = loginCommand.execute(CONTENT);
        Assert.assertEquals(actual, NEWS_PAGE);
    }
}