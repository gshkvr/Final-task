package command.impl.common;

import command.exception.CommandException;
import controller.Page;
import controller.SessionRequestContent;
import org.testng.Assert;
import org.testng.annotations.Test;
import resource.ConfigurationManager;
import service.UserService;
import service.exception.EmailExistsException;
import service.exception.LoginExistsException;
import service.exception.NotEqualPasswordsException;
import service.exception.ServiceException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RegisterCommandTest {
    private static final SessionRequestContent CONTENT = new SessionRequestContent();
    private static final String MESSAGE_PAGE_COMMAND = ConfigurationManager.getProperty("command.message.page");
    private static final String SUCCESS_REGISTRATION = ConfigurationManager.getProperty("success.register");
    private static final Page PAGE = new Page(MESSAGE_PAGE_COMMAND + SUCCESS_REGISTRATION, true);
    private final UserService userService = mock(UserService.class);

    @Test
    public void returnNewsPage() throws ServiceException, CommandException, LoginExistsException, NotEqualPasswordsException, EmailExistsException {
        when(userService.registerUser(CONTENT)).thenReturn(true);
        RegisterCommand registerCommand = new RegisterCommand(userService);
        Page actual = registerCommand.execute(CONTENT);
        Assert.assertEquals(actual, PAGE);
    }
}