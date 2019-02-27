package command;

import controller.Page;
import controller.SessionRequestContent;
import exception.ServiceException;

public interface Command {
    Page execute(SessionRequestContent content) throws ServiceException;
}
