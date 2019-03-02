package command;

import controller.Page;
import controller.SessionRequestContent;
import command.exception.CommandException;

public interface Command {
    Page execute(SessionRequestContent content) throws CommandException;
}
