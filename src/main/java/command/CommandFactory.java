package command;

import command.impl.LoginCommand;
import dao.DaoManager;
import resource.ConfigurationManager;
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


    private final DaoManager daoManager = DaoManager.getInstance();
    private static final String COMMAND = "command";

    public Command defineCommand(HttpServletRequest request) {
//        String action = request.getParameter(COMMAND);
//        if (action == null || action.isEmpty()) {
//            return new NewsCommand();
//        }
//        CommandEnum currentEnum = CommandEnum.valueOf(action.toUpperCase());
//        if(currentEnum == null){
//            throw new IllegalArgumentException("No such command in CommandFactory.");
//        }
//        return currentEnum.getCommand();

        switch (command) {
            case LoginCo
                mand.COMMAND:
                UserService userService = new UserService(daoManager.getUserDao());
                return new LoginCommand(userService);
        }
    }
}