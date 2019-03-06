package command.impl.admin;

import command.Command;
import command.exception.CommandException;
import controller.Page;
import controller.SessionRequestContent;
import resource.ConfigurationManager;
import service.UserService;
import service.exception.ServiceException;

public class AdminUserCommand implements Command {
    private static final String USERS_COMMAND = ConfigurationManager.getProperty("command.users");
    private final UserService userService = UserService.getInstance();

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
