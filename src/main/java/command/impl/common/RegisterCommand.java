package command.impl.common;

import command.Command;
import command.exception.CommandException;
import controller.Page;
import controller.SessionRequestContent;
import service.exception.EmailExistsException;
import service.exception.LoginExistsException;
import service.exception.NotEqualPasswordsException;
import service.exception.ServiceException;
import resource.ConfigurationManager;
import service.UserService;

public class RegisterCommand implements Command {
    private static final String REGISTER_PAGE = ConfigurationManager.getProperty("command.register_page");
    private static final String MESSAGE_PAGE_COMMAND = ConfigurationManager.getProperty("command.message_page");
    private static final String SUCCESS_REGISTRATION = ConfigurationManager.getProperty("success.register");
    private static final String LOGIN_EXISTS_ERROR = ConfigurationManager.getProperty("attribute.error.register.login");
    private static final String EMAIL_EXISTS_ERROR = ConfigurationManager.getProperty("attribute.error.register.email");
    private static final String INCORRECT_PASSWORD_ERROR = ConfigurationManager.getProperty("attribute.error.register.password");
    private final UserService userService = UserService.getInstance();

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

