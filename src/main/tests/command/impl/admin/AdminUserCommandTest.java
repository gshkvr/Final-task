package command.impl.admin;

import command.exception.CommandException;
import controller.Page;
import controller.SessionRequestContent;
import org.testng.Assert;
import org.testng.annotations.Test;
import resource.ConfigurationManager;
import service.UserService;
import service.exception.ServiceException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AdminUserCommandTest {
    private static final SessionRequestContent CONTENT = new SessionRequestContent();
    private static final String USERS_COMMAND = ConfigurationManager.getProperty("command.users");
    private static final Page PAGE = new Page(USERS_COMMAND, true);
    private final UserService userService = mock(UserService.class);

    @Test
    public void returnNewsPage() throws ServiceException, CommandException {
        when(userService.makeUserAdmin(CONTENT)).thenReturn(true);
        AdminUserCommand adminUserCommand = new AdminUserCommand(userService);
        Page actual = adminUserCommand.execute(CONTENT);
        Assert.assertEquals(actual, PAGE);
    }
}