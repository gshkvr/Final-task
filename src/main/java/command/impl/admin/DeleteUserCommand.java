package command.impl.admin;

import command.Command;
import controller.Page;
import controller.SessionRequestContent;
import entity.impl.User;
import command.exception.CommandException;
import service.exception.ServiceException;
import resource.ConfigurationManager;
import service.UserService;

public class DeleteUserCommand implements Command {
    private static final String USERS_COMMAND = ConfigurationManager.getProperty("command.users");
    private final UserService userService = UserService.getInstance();

    @Override
    public Page execute(SessionRequestContent content) throws CommandException {
        String sUserId = content.getRequestParameter(User.USER_ID);
        int userId = Integer.parseInt(sUserId);
        try {
            userService.deleteUser(userId);
            return new Page(USERS_COMMAND, true);
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
    }
}
