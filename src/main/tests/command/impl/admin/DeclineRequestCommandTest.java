package command.impl.admin;

import command.exception.CommandException;
import controller.Page;
import controller.SessionRequestContent;
import org.testng.Assert;
import org.testng.annotations.Test;
import resource.ConfigurationManager;
import service.RequestService;
import service.exception.ServiceException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DeclineRequestCommandTest {
    private static final SessionRequestContent CONTENT = new SessionRequestContent();
    private static final String REQUESTS_PAGE = ConfigurationManager.getProperty("command.show.request.page");
    private static final Page PAGE = new Page(REQUESTS_PAGE, true);
    private final RequestService requestService = mock(RequestService.class);

    @Test
    public void returnNewsPage() throws ServiceException, CommandException {
        when(requestService.declineRequest(CONTENT)).thenReturn(true);
        DeclineRequestCommand declineRequestCommand = new DeclineRequestCommand(requestService);
        Page actual = declineRequestCommand.execute(CONTENT);
        Assert.assertEquals(actual, PAGE);
    }
}