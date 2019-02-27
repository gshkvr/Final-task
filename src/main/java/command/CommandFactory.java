package command;

import command.impl.*;
import dao.DaoManager;
import service.UserService;

import javax.servlet.http.HttpServletRequest;

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

    private static final String NEWS_COMMAND = "news";
    private static final String LOGIN_COMMAND = "login";
    private static final String LOGIN_PAGE_COMMAND = "login_page";
    private static final String REGISTER_COMMAND = "register";
    private static final String REGISTER_PAGE_COMMAND = "register_page";
    private static final String LOGOUT_COMMAND = "logout";

    public Command defineCommand(HttpServletRequest request) {
        String action = request.getParameter(COMMAND);
        action = action == null ? "" : action;

        switch (action) {
            case NEWS_COMMAND:
                return new NewsCommand();
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
            default:
                return new NewsCommand();
        }
    }
}