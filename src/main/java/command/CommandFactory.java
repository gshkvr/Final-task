package command;

import command.impl.admin.AdminUserCommand;
import command.impl.admin.DeleteUserCommand;
import command.impl.admin.ShowUsersCommand;
import command.impl.client.AddRequestCommand;
import command.impl.common.LoginCommand;
import command.impl.common.LogoutCommand;
import command.impl.common.RegisterCommand;
import command.impl.page.*;
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

    private static final String COMMAND = "command";
    private static final String ERROR_COMMAND = "error";
    private static final String NEWS_PAGE_COMMAND = "news_page";
    private static final String USERS_COMMAND = "users";
    private static final String REQUEST_COMMAND = "add_request";
    private static final String REQUEST_ADD_PAGE_COMMAND = "add_request_page";
    private static final String REQUEST_SHOW_PAGE_COMMAND = "show_request_page";
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
            case REQUEST_COMMAND:
                return new AddRequestCommand();
            case REQUEST_ADD_PAGE_COMMAND:
                return new AddRequestPageCommand();
            case REQUEST_SHOW_PAGE_COMMAND:
                return new ShowRequestPageCommand();
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