package command;

import command.impl.admin.AdminUserCommand;
import command.impl.admin.DeleteUserCommand;
import command.impl.admin.ShowUsersCommand;
import command.impl.common.LoginCommand;
import command.impl.common.LogoutCommand;
import command.impl.common.RegisterCommand;
import command.impl.page.ErrorPageCommand;
import command.impl.page.LoginPageCommand;
import command.impl.page.NewsPageCommand;
import command.impl.page.RegisterPageCommand;
import controller.SessionRequestContent;

public class CommandFactory {

    private CommandFactory() {
    }

    public static CommandFactory getInstance() {
        return CommandFactory.InstanceHolder.INSTANCE;
    }

    private static class InstanceHolder {
        private static final CommandFactory INSTANCE = new CommandFactory();
    }

    //TODO - DaoManager ???
    //private final DaoManager daoManager = DaoManager.getInstance();
    private static final String COMMAND = "command";

    private static final String ERROR_COMMAND = "error";
    private static final String NEWS_PAGE_COMMAND = "news_page";
    private static final String USERS_COMMAND = "users";
    private static final String LOGIN_COMMAND = "login";
    private static final String LOGIN_PAGE_COMMAND = "login_page";
    private static final String REGISTER_COMMAND = "register";
    private static final String REGISTER_PAGE_COMMAND = "register_page";
    private static final String LOGOUT_COMMAND = "logout";
    private static final String DELETE_USER_COMMAND = "delete_user";
    private static final String ADMIN_USER_COMMAND = "admin_user";

    public Command defineCommand(SessionRequestContent content) {
        String action = content.getRequestParameter(COMMAND);
        action = action == null ? "" : action;

        switch (action) {

            case ERROR_COMMAND:
                return new ErrorPageCommand();
                case NEWS_PAGE_COMMAND:
                return new NewsPageCommand();
            case USERS_COMMAND:
                return new ShowUsersCommand();
            case LOGIN_COMMAND:
                return new LoginCommand();
            case LOGIN_PAGE_COMMAND:
                return new LoginPageCommand();
            case REGISTER_COMMAND:
                return new RegisterCommand();
            case REGISTER_PAGE_COMMAND:
                return new RegisterPageCommand();
            case LOGOUT_COMMAND:
                return new LogoutCommand();
            case DELETE_USER_COMMAND:
                return new DeleteUserCommand();
            case ADMIN_USER_COMMAND:
                return new AdminUserCommand();
            default:
                return new NewsPageCommand();
        }
    }
}