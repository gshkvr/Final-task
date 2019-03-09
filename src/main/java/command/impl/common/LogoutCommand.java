package command.impl.common;

import command.Command;
import controller.Page;
import controller.SessionRequestContent;
import resource.ConfigurationManager;

public class LogoutCommand implements Command {
    private static final String NEWS_COMMAND = ConfigurationManager.getProperty("command.news.page");

    @Override
    public Page execute(SessionRequestContent content) {
        content.setSessionInvalidated(true);
        return new Page(NEWS_COMMAND, true);
    }
}
