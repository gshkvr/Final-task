package command.impl.admin;

import command.Command;
import command.exception.CommandException;
import controller.Page;
import controller.SessionRequestContent;
import resource.ConfigurationManager;
import service.PersonService;
import service.exception.NoSuchRequestException;
import service.exception.ServiceException;

public class AcceptRequestCommand implements Command {
    private static final String REQUESTS_PAGE = ConfigurationManager.getProperty("command.show.request.page");
    private final PersonService personService = PersonService.getInstance();

    @Override
    public Page execute(SessionRequestContent content) throws CommandException {
        try {
            personService.createPerson(content);
            return new Page(REQUESTS_PAGE, true);
        } catch (ServiceException | NoSuchRequestException e) {
            throw new CommandException(e);
        }
    }
}
