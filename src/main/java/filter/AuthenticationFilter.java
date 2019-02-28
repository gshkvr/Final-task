package filter;

import entity.impl.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@WebFilter(
        filterName = "AuthenticationFilter",
        urlPatterns = "/*"
)
public class AuthenticationFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        HttpSession session = httpRequest.getSession(true);

        if (session.getAttribute(User.TABLE_NAME) == null && httpRequest.getCookies() != null) {
            List<Cookie> cookies = new LinkedList<>(Arrays.asList(httpRequest.getCookies()));
            String user = getFromCookies(cookies, User.TABLE_NAME);
            if (user != null) {
                session.setAttribute(User.TABLE_NAME, user);
            }
            String userRole = getFromCookies(cookies, User.USER_ROLE);
            if (userRole != null) {
                session.setAttribute(User.USER_ROLE, userRole);
            }
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void init(FilterConfig filterConfig) {}

    @Override
    public void destroy() {}

    private String getFromCookies(List<Cookie> cookies, String name) {
        String cookie = null;
        Optional<Cookie> anyCookie = cookies.stream()
                .filter(c -> c.getName().equals(name))
                .findFirst();
        if (anyCookie.isPresent()) {
            cookie = anyCookie.get().getValue();
        }
        return cookie;
    }
}
