package command.impl.client;

import command.exception.CommandException;
import controller.Page;
import controller.SessionRequestContent;
import org.testng.Assert;
import org.testng.annotations.Test;
import resource.ConfigurationManager;
import service.RequestService;
import service.exception.*;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AddRequestCommandTest {
    private static final SessionRequestContent CONTENT = new SessionRequestContent();
    private static final String MESSAGE_PAGE_COMMAND = ConfigurationManager.getProperty("command.message.page");
    private static final String SUCCESS_ADD_REQUEST = ConfigurationManager.getProperty("success.add.request");
    private static final Page NEWS_PAGE = new Page(MESSAGE_PAGE_COMMAND + SUCCESS_ADD_REQUEST, true);
    private final RequestService requestService = mock(RequestService.class);

    @Test
    public void returnNewsPage() throws ServiceException, CommandException, EmptyFileException, EmptyNameException, EmptyBirthDateException, EmptyNationalityException, EmptySexException, EmptyTypeException {
        when(requestService.createRequest(CONTENT)).thenReturn(true);
        AddRequestCommand addRequestCommand = new AddRequestCommand(requestService);
        Page actual = addRequestCommand.execute(CONTENT);
        Assert.assertEquals(actual, NEWS_PAGE);
    }
}