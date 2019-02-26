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
        initParams = {@WebInitParam(name = "defaultLocale", value = "ru-RU"),
                @WebInitParam(name = "varLocale", value = "en-US"),
                @WebInitParam(name = "varLocaleParam", value = "en")}
)
public class LocaleFilter implements Filter {
    private static final String LOCALE_ATTRIBUTE = "locale";
    private String varLocaleParam;
    private Locale defaultLocale;
    private Locale varLocale;

    @Override
    public void init(FilterConfig filterConfig) {
        varLocaleParam = filterConfig.getInitParameter("varLocaleParam");
        defaultLocale = Locale.forLanguageTag(filterConfig.getInitParameter("defaultLocale"));
        varLocale = Locale.forLanguageTag(filterConfig.getInitParameter("varLocale"));
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

        if (httpRequest.getParameterMap().containsKey(LOCALE_ATTRIBUTE)) {
            String sLocale = httpRequest.getParameterMap().get(LOCALE_ATTRIBUTE)[0];
            Locale locale = varLocaleParam.equals(sLocale) ? varLocale : defaultLocale;
            setLocale(servletResponse, session, locale);
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
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