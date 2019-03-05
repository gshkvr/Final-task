package command;

import command.impl.admin.*;
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
    private static final String ERROR_COMMAND = "error_page";
    private static final String MESSAGE_COMMAND = "message_page";
    private static final String NEWS_PAGE_COMMAND = "news_page";
    private static final String ADD_NEWS_COMMAND = "add_news";
    private static final String ADD_NEWS_PAGE_COMMAND = "add_news_page";
    private static final String USERS_COMMAND = "users";
    private static final String MISSING_COMMAND = "missing";
    private static final String WANTED_COMMAND = "wanted";
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
    private static final String DECLINE_REQUEST_COMMAND = "decline_request";
    private static final String ACCEPT_REQUEST_COMMAND = "accept_request";

    public Command defineCommand(SessionRequestContent content) {
        String action = content.getRequestParameter(COMMAND);
        action = action == null ? "" : action;

        switch (action) {

            case ERROR_COMMAND:
                return new ErrorPageCommand();
            case MESSAGE_COMMAND:
                return new MessagePageCommand();
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
            case ACCEPT_REQUEST_COMMAND:
                return new AcceptRequestCommand();
            case DECLINE_REQUEST_COMMAND:
                return new DeclineRequestCommand();
            case MISSING_COMMAND:
                return new MissingPersonsPageCommand();
            case WANTED_COMMAND:
                return new WantedPersonsPageCommand();
            case ADD_NEWS_COMMAND:
                return new AddNewsCommand();
            case ADD_NEWS_PAGE_COMMAND:
                return new AddNewsPageCommand();
            default:
                return new NewsPageCommand();
        }
    }
}