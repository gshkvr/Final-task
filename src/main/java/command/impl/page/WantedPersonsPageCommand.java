package command.impl.page;

import command.Command;
import command.exception.CommandException;
import controller.Page;
import controller.SessionRequestContent;
import entity.Person;
import resource.ConfigurationManager;
import service.PersonService;
import service.exception.ServiceException;

/**
 * Command that opens page with wanted {@link Person}.
 *
 * @author George Kvirikashvili
 */
public class WantedPersonsPageCommand implements Command {
    private static final String WANTED_PERSONS_COMMAND = ConfigurationManager.getProperty("command.wanted");
    private static final String WANTED_PERSONS_PAGE = ConfigurationManager.getProperty("page.wanted");
    private static final String WANTED_PERSONS = "wantedPersons";
    private static final String LOCALE_COMMAND = "localeCommand";
    private final PersonService personService = PersonService.getInstance();

    @Override
    public Page execute(SessionRequestContent content) throws CommandException {
        try {
            content.setRequestAttribute(WANTED_PERSONS, personService.getAllWantedPersons());
            content.setRequestAttribute(LOCALE_COMMAND, WANTED_PERSONS_COMMAND);
            return new Page(WANTED_PERSONS_PAGE);
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
    }
}
