package command.impl.admin;

import command.Command;
import command.exception.CommandException;
import controller.Page;
import controller.SessionRequestContent;
import resource.ConfigurationManager;
import service.UserService;
import service.exception.ServiceException;

/**
 * Administrator {@code command}. Gives {@code user} a role of administrator.
 *
 * @author George Kvirikashvili
 */
public class AdminUserCommand implements Command {
    private static final String USERS_COMMAND = ConfigurationManager.getProperty("command.users");
    private UserService userService = UserService.getInstance();

    /**
     * Default constructor with default UserService.
     */
    public AdminUserCommand() {
    }

    /**
     * Constructor with UserService for test.
     *
     * @param userService test UserService
     */
    AdminUserCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public Page execute(SessionRequestContent content) throws CommandException {
        try {
            userService.makeUserAdmin(content);
            return new Page(USERS_COMMAND, true);
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
    }
}
