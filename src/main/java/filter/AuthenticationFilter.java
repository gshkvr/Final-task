package filter;

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
    private static final String USER_ATTRIBUTE = "user";

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        HttpSession session = httpRequest.getSession(true);

        if (session.getAttribute(USER_ATTRIBUTE) == null && httpRequest.getCookies() != null) {
            List<Cookie> cookies = new LinkedList<>(Arrays.asList(httpRequest.getCookies()));
            String user = getUserFromCookies(cookies);
            if (user != null) {
                session.setAttribute(USER_ATTRIBUTE, user);
            }
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void init(FilterConfig filterConfig) {}

    @Override
    public void destroy() {}

    private String getUserFromCookies(List<Cookie> cookies) {
        String user = null;
        Optional<Cookie> anyCookie = cookies.stream()
                .filter(c -> c.getName().equals(USER_ATTRIBUTE))
                .findFirst();
        if (anyCookie.isPresent()) {
            user = anyCookie.get().getValue();
        }
        return user;
    }
}
