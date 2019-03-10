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
    private static final String CURRENT_COMMAND = "currentCommand";
    private static final String PAGES_PARAMETER = "pages";
    private static final String PAGE_PARAMETER = "page";
    private static final String ACTIVE_PAGE_PARAMETER = "activePage";
    private final PersonService personService = PersonService.getInstance();

    @Override
    public Page execute(SessionRequestContent content) throws CommandException {
        try {
            int page = 1;
            if (content.getRequestParameter(PAGE_PARAMETER) != null) {
                page = Integer.parseInt(content.getRequestParameter(PAGE_PARAMETER));
            }
            content.setRequestAttribute(WANTED_PERSONS, personService.getAllWantedPersons(page));
            content.setRequestAttribute(CURRENT_COMMAND, WANTED_PERSONS_COMMAND);
            content.setRequestAttribute(PAGES_PARAMETER, personService.pageWantedAmount());
            content.setRequestAttribute(ACTIVE_PAGE_PARAMETER, page);
            return new Page(WANTED_PERSONS_PAGE);
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
    }
}
