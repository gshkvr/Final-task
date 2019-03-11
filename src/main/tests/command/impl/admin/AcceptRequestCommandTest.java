package command.impl.admin;

import command.exception.CommandException;
import controller.Page;
import controller.SessionRequestContent;
import org.testng.Assert;
import org.testng.annotations.Test;
import resource.ConfigurationManager;
import service.PersonService;
import service.exception.NoSuchRequestException;
import service.exception.ServiceException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AcceptRequestCommandTest {
    private static final SessionRequestContent CONTENT = new SessionRequestContent();
    private static final String REQUESTS_PAGE = ConfigurationManager.getProperty("command.show.request.page");
    private static final Page PAGE = new Page(REQUESTS_PAGE, true);
    private final PersonService personService = mock(PersonService.class);

    @Test
    public void returnNewsPage() throws ServiceException, CommandException, NoSuchRequestException {
        when(personService.createPerson(CONTENT)).thenReturn(true);
        AcceptRequestCommand acceptRequestCommand = new AcceptRequestCommand(personService);
        Page actual = acceptRequestCommand.execute(CONTENT);
        Assert.assertEquals(actual, PAGE);
    }
}