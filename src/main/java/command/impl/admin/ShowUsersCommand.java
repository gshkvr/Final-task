package command.impl.admin;

import command.Command;
import controller.Page;
import controller.SessionRequestContent;
import exception.ServiceException;
import resource.ConfigurationManager;
import service.UserService;

public class ShowUsersCommand implements Command {
    private static final String USERS_PAGE = ConfigurationManager.getProperty("page.users");
    private static final String USERS_COMMAND = ConfigurationManager.getProperty("command.users");
    private static final String LOCALE_COMMAND = "localeCommand";
    private final UserService userService = UserService.getInstance();

    @Override
    public Page execute(SessionRequestContent content) throws ServiceException {
        content.setRequestAttribute("allUsers", userService.getAllUsers());
        content.setRequestAttribute(LOCALE_COMMAND, USERS_COMMAND);
        return new Page(USERS_PAGE);
    }
}
