package command.impl.common;

import command.Command;
import controller.Page;
import controller.SessionRequestContent;
import entity.impl.User;
import entity.impl.UserRole;
import exception.ServiceException;
import resource.ConfigurationManager;
import service.UserService;
import util.CryptUtil;

public class RegisterCommand implements Command {
    private static final String REGISTER_PAGE = ConfigurationManager.getProperty("command.register_page");
    private static final String LOGIN_PAGE_COMMAND = ConfigurationManager.getProperty("command.login_page");
    private static final String SUCCESS_REGISTRATION = ConfigurationManager.getProperty("success.register");
    private static final String LOGIN_EXISTS_ERROR = ConfigurationManager.getProperty("attribute.error.register.login");
    private static final String EMAIL_EXISTS_ERROR = ConfigurationManager.getProperty("attribute.error.register.email");
    private static final String INCORRECT_PASSWORD_ERROR = ConfigurationManager.getProperty("attribute.error.register.password");
    private final UserService userService = UserService.getInstance();
    private final CryptUtil cryptUtil = CryptUtil.getInstance();

    @Override
    public Page execute(SessionRequestContent content) throws ServiceException {

        String login = content.getRequestParameter(User.LOGIN);
        if (userService.checkLoginExists(login)) {
            return new Page(REGISTER_PAGE + LOGIN_EXISTS_ERROR, true);
        }

        String email = content.getRequestParameter(User.EMAIL);
        if (userService.checkEmailExists(email)) {
            return new Page(REGISTER_PAGE + EMAIL_EXISTS_ERROR, true);
        }

        String password = content.getRequestParameter(User.PASSWORD);
        String confirmPassword = content.getRequestParameter(User.CONFIRM_PASSWORD);
        if (!password.equals(confirmPassword)) {
            return new Page(REGISTER_PAGE + INCORRECT_PASSWORD_ERROR, true);
        }
        password = cryptUtil.cryptPassword(password);

        String firstName = content.getRequestParameter(User.FIRST_NAME);
        String lastName = content.getRequestParameter(User.LAST_NAME);

        User user = new User(0, UserRole.CLIENT, login, password, email, firstName, lastName);

        userService.addUser(user);

        return new Page(LOGIN_PAGE_COMMAND + SUCCESS_REGISTRATION, true);
    }
}

