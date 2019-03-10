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
 * Command that opens page with missing {@link Person}.
 *
 * @author George Kvirikashvili
 */
public class MissingPersonsPageCommand implements Command {
    private static final String MISSING_PERSONS_COMMAND = ConfigurationManager.getProperty("command.missing");
    private static final String MISSING_PERSONS_PAGE = ConfigurationManager.getProperty("page.missing");
    private static final String MISSING_PERSONS = "missingPersons";
    private static final String LOCALE_COMMAND = "localeCommand";
    private final PersonService personService = PersonService.getInstance();

    @Override
    public Page execute(SessionRequestContent content) throws CommandException {
        try {
            content.setRequestAttribute(MISSING_PERSONS, personService.getAllMissingPersons());
            content.setRequestAttribute(LOCALE_COMMAND, MISSING_PERSONS_COMMAND);
            return new Page(MISSING_PERSONS_PAGE);
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
    }
}
