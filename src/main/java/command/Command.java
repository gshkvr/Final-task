package command;

import controller.Page;
import controller.SessionRequestContent;

public interface Command {
    Page execute(SessionRequestContent content);
}
