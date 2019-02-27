package controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

public class SessionRequestContent {
    private Map<String, Object> requestAttributes = new HashMap<>();
    private Map<String, String[]> requestParameters = new HashMap<>();
    private Map<String, Object> sessionAttributes = new HashMap<>();
    private List<Cookie> cookies;

    private boolean requestAttributesChanged;
    private boolean sessionAttributesChanged;
    private boolean cookiesChanged;

    private boolean sessionInvalidated = false;

    public Map<String, Object> getRequestAttributes() {
        return requestAttributes;
    }

    public Map<String, String[]> getRequestParameters() {
        return requestParameters;
    }

    public String getRequestParameter(String paramName) {
        return requestParameters.get(paramName) != null && requestParameters.get(paramName).length > 0 ? requestParameters.get(paramName)[0] : null;
    }

    public Map<String, Object> getSessionAttributes() {
        return sessionAttributes;
    }

    public boolean isRequestAttributesChanged() {
        return requestAttributesChanged;
    }

    public boolean isSessionAttributesChanged() {
        return sessionAttributesChanged;
    }

    public boolean isSessionInvalidated() {
        return sessionInvalidated;
    }

    public List<Cookie> getCookies() {
        return cookies;
    }

    public boolean isCookiesChanged() {
        return cookiesChanged;
    }

    public void setSessionInvalidated(boolean sessionInvalidated) {
        this.sessionInvalidated = sessionInvalidated;
    }

    public void setRequestAttribute(String name, Object value) {
        if (!requestAttributesChanged) {
            this.requestAttributes = new HashMap<>();
            this.requestAttributesChanged = true;
        }
        this.requestAttributes.put(name, value);
    }

    public void setSessionAttribute(String name, Object value) {
        if (!sessionAttributesChanged) {
            this.sessionAttributes = new HashMap<>();
            this.sessionAttributesChanged = true;
        }
        sessionAttributes.put(name, value);
    }

    public void extractValues(HttpServletRequest request) {
        Enumeration<String> attributeNames = request.getAttributeNames();
        while (attributeNames.hasMoreElements()) {
            String attributeName = attributeNames.nextElement();
            this.requestAttributes.put(attributeName, request.getAttribute(attributeName));
        }
        this.requestAttributesChanged = false;
        this.requestParameters = request.getParameterMap();
        HttpSession session = request.getSession();
        Enumeration<String> sessionAttributeNames = session.getAttributeNames();
        while (sessionAttributeNames.hasMoreElements()) {
            String attributeName = sessionAttributeNames.nextElement();
            this.sessionAttributes.put(attributeName, session.getAttribute(attributeName));
        }
        this.sessionAttributesChanged = false;
        this.cookies = new LinkedList<>();
        this.cookiesChanged = false;
    }

    public void insertAttributes(HttpServletRequest request) {
        if (requestAttributesChanged) {
            requestAttributes.forEach(request::setAttribute);
        }
        HttpSession session = request.getSession();
        if (sessionInvalidated) {
            session.invalidate();
        } else {
            if (sessionAttributesChanged) {
                sessionAttributes.forEach(session::setAttribute);
            }
        }
    }

    public void setCookie(Cookie cookie) {
        this.cookiesChanged = true;
        this.cookies.add(cookie);
    }

}
