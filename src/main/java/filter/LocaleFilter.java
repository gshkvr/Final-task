package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

@WebFilter(
        filterName = "LocaleFilter",
        urlPatterns = "/*",
        initParams = {@WebInitParam(name = "defaultLocale", value = "ru-RU")}
)
public class LocaleFilter implements Filter {
    private static final String LOCALE_ATTRIBUTE = "locale";
    private static final String RU = "ru";
    private static final String EN = "en";
    private static final Locale RU_LOCALE = new Locale("ru", "RU");
    private static final Locale EN_LOCALE = new Locale("en", "US");
    private Locale defaultLocale;

    @Override
    public void init(FilterConfig filterConfig) {
        defaultLocale = Locale.forLanguageTag(filterConfig.getInitParameter("defaultLocale"));
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        HttpSession session = httpRequest.getSession(true);

        if (httpRequest.getCookies() != null) {
            List<Cookie> cookies = new LinkedList<>(Arrays.asList(httpRequest.getCookies()));
            Locale locale = getLocaleFromCookies(cookies);
            if (locale == null) {
                locale = defaultLocale;
            }
            setLocale(servletResponse, session, locale);
        }

        String queryString = httpRequest.getQueryString();
        queryString = queryString == null ? "" : queryString;

        if (queryString.contains(LOCALE_ATTRIBUTE)) {
            int index = queryString.indexOf(LOCALE_ATTRIBUTE);
            String sLocale = queryString.substring(index + 7, index + 9);
            Locale locale = getLocale(sLocale);
            setLocale(servletResponse, session, locale);
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
    }

    private Locale getLocale(String sLocale) {
        if (RU.equals(sLocale)) {
            return RU_LOCALE;
        } else if (EN.equals(sLocale)) {
            return EN_LOCALE;
        } else {
            return defaultLocale;
        }
    }

    private void setLocale(ServletResponse servletResponse, HttpSession session, Locale locale) {
        session.setAttribute(LOCALE_ATTRIBUTE, locale);
        servletResponse.setLocale(locale);
        addLocaleCookie((HttpServletResponse) servletResponse, locale);
    }

    private void addLocaleCookie(HttpServletResponse httpResponse, Locale locale) {
        Cookie localeCookie = new Cookie(LOCALE_ATTRIBUTE, locale.toString());
        localeCookie.setPath("/");
        httpResponse.addCookie(localeCookie);
    }

    private Locale getLocaleFromCookies(List<Cookie> cookies) {
        Locale locale = null;
        Optional<Cookie> anyCookie = cookies.stream()
                .filter(c -> c.getName().equals(LOCALE_ATTRIBUTE))
                .findFirst();
        if (anyCookie.isPresent()) {
            String sLocale = anyCookie.get().getValue();
            sLocale = sLocale.replaceAll("_", "-");
            locale = Locale.forLanguageTag(sLocale);
        }
        return locale;
    }
}