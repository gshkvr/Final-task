package filter;

import builder.impl.UserBuilderImpl;
import resource.ConfigurationManager;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Set;

@WebFilter(
        filterName = "AccessFilter",
        urlPatterns = "/*"
)
public class AccessFilter implements Filter {
    private static final String COMMAND = "command";
    private static final String ADMIN = "admin";
    private static final String CLIENT = "client";
    private static final String LOGIN_REDIRECT = ConfigurationManager.getProperty("command.login_page");
    private static final String NEWS_REDIRECT = ConfigurationManager.getProperty("command.news_page");
    private final Set<String> unauthorizedCommands = Set.of("news_page", "login_page", "login", "register_page",
            "register", "error_page", "message_page");
    private final Set<String> clientCommands = Set.of("news_page", "add_request_page", "add_request", "logout",
            "wanted", "missing", "error_page", "message_page");
    private final Set<String> adminCommands = Set.of("news_page", "users", "admin_user", "delete_user",
            "add_news_page", "add_news", "edit_news", "edit_news_page", "show_request_page", "decline_request",
            "accept_request", "logout", "error_page", "message_page");

    @Override
    public void init(FilterConfig filterConfig) {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
        HttpSession session = httpRequest.getSession(true);

        String command = httpRequest.getParameter(COMMAND);
        String role = (String) session.getAttribute(UserBuilderImpl.USER_ROLE);
        String redirectPage = null;
        if (command != null) {
            switch (role == null ? "" : role) {
                case ADMIN:
                    if (!isAdminCommand(command)) {
                        redirectPage = NEWS_REDIRECT;
                    }
                    break;
                case CLIENT:
                    if (!isClientCommand(command)) {
                        redirectPage = NEWS_REDIRECT;
                    }
                    break;
                default:
                    if (!isUnauthorizedCommand(command)) {
                        redirectPage = LOGIN_REDIRECT;
                    }
                    break;
            }
        }
        if (redirectPage != null) {
            httpResponse.sendRedirect(redirectPage);
            return;
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
    }

    private boolean isAdminCommand(String command) {
        return adminCommands.contains(command);
    }

    private boolean isClientCommand(String command) {
        return clientCommands.contains(command);
    }

    private boolean isUnauthorizedCommand(String command) {
        return unauthorizedCommands.contains(command);
    }
}