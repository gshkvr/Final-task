package command.impl.common;

import command.Command;
import command.exception.CommandException;
import controller.Page;
import controller.SessionRequestContent;
import resource.ConfigurationManager;
import service.UserService;
import service.exception.EmailExistsException;
import service.exception.LoginExistsException;
import service.exception.NotEqualPasswordsException;
import service.exception.ServiceException;

/**
 * Common {@code command}. Makes registration or redirects on error page.
 *
 * @author George Kvirikashvili
 */
public class RegisterCommand implements Command {
    private static final String REGISTER_PAGE = ConfigurationManager.getProperty("command.register.page");
    private static final String MESSAGE_PAGE_COMMAND = ConfigurationManager.getProperty("command.message.page");
    private static final String SUCCESS_REGISTRATION = ConfigurationManager.getProperty("success.register");
    private static final String LOGIN_EXISTS_ERROR = ConfigurationManager.getProperty("error.register.login");
    private static final String EMAIL_EXISTS_ERROR = ConfigurationManager.getProperty("error.register.email");
    private static final String INCORRECT_PASSWORD_ERROR = ConfigurationManager.getProperty("error.register.password");
    private UserService userService = UserService.getInstance();

    /**
     * Default constructor with default UserService.
     */
    public RegisterCommand() {
    }

    /**
     * Constructor with UserService for test.
     *
     * @param userService test UserService
     */
    RegisterCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public Page execute(SessionRequestContent content) throws CommandException {
        try {
            userService.registerUser(content);
        } catch (LoginExistsException e) {
            return new Page(REGISTER_PAGE + LOGIN_EXISTS_ERROR, true);
        } catch (NotEqualPasswordsException e) {
            return new Page(REGISTER_PAGE + INCORRECT_PASSWORD_ERROR, true);
        } catch (EmailExistsException e) {
            return new Page(REGISTER_PAGE + EMAIL_EXISTS_ERROR, true);
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
        return new Page(MESSAGE_PAGE_COMMAND + SUCCESS_REGISTRATION, true);
    }
}

