package command;

import command.exception.CommandException;
import controller.Controller;
import controller.Page;
import controller.SessionRequestContent;

/**
 * The interface Command.
 * Invokes in {@link Controller} and define what action will be execute.
 * {@link CommandFactory} looks at {@link SessionRequestContent} parameter
 * {@code command} and then returns concrete command.
 *
 * @author George Kvirikashvili
 */
public interface Command {
    /**
     * Makes logic of the command.
     *
     * @param content the content with parameters and attributes from http request
     * @return the page with redirect url
     * @throws CommandException if some exception occurred
     */
    Page execute(SessionRequestContent content) throws CommandException;
}
