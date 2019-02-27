package command.impl;

import command.Command;
import controller.Page;
import controller.SessionRequestContent;
import resource.ConfigurationManager;
import service.UserService;

public class RegisterCommand implements Command {
    private static final String REGISTER_PAGE = ConfigurationManager.getProperty("command.register.page");
    private static final String NEWS_COMMAND = ConfigurationManager.getProperty("command.news");
    private static final String LOGIN_EXISTS_ERROR = "&errorRegistration=error.register.login";
    private static final String EMAIL_EXISTS_ERROR = "&errorRegistration=error.register.email";
    private static final String INCORRECT_PASSWORD_ERROR = "errorRegistration=error.register.password";
    private final UserService userService = UserService.getInstance();
//    private final LoginValidator validator = new LoginValidator();

    @Override
    public Page execute(SessionRequestContent content) {
//
//        String login = content.getRequestParameter(User.LOGIN);
//        if (userService.checkUsernameOnDuplicate(username)) {
//            return new Page(REGISTER_PAGE + LOGIN_EXISTS_ERROR, true);
//        }
//
//        String email = content.getRequestParameter(User.EMAIL);
//        if (userService.checkEmailOnDuplicate(email)) {
//            return new Page(REGISTER_PAGE + EMAIL_EXISTS_ERROR, true);
//        }
//
//        String password = content.getRequestParameter(User.PASS);
//        if (!validator.validatePassword(password)) {
//            return new Page(REGISTER_PAGE + INCORRECT_PASSWORD_ERROR, true);
//        }
//
//        String firstName = content.getRequestParameter(User.FIRST_NAME);
//        String lastName = content.getRequestParameter(User.LAST_NAME);
//
//        User user = new User(0, UserRole.CLIENT.getId(), login, password, email, firstName, lastName);
//
//        userService.saveUser(user);

        return new Page(NEWS_COMMAND, true);

    }
}

