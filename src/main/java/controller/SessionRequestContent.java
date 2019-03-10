package controller;

import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * Contains parameters and attributes from http request.
 *
 * @author George Kvirikashvili
 */
public class SessionRequestContent {
    private Map<String, Object> requestAttributes = new HashMap<>();
    private Map<String, String[]> requestParameters = new HashMap<>();
    private Map<String, Object> sessionAttributes = new HashMap<>();
    private String realPath;

    private boolean requestAttributesChanged;
    private boolean sessionAttributesChanged;

    private boolean sessionInvalidated = false;

    /**
     * Gets request parameter.
     *
     * @param paramName the param name
     * @return the request parameter
     */
    public String getRequestParameter(String paramName) {
        return requestParameters.get(paramName) != null && requestParameters.get(paramName).length > 0 ? requestParameters.get(paramName)[0] : null;
    }

    /**
     * Gets request attribute.
     *
     * @param attributeName the attribute name
     * @return the request attribute
     */
    public Object getRequestAttribute(String attributeName) {
        return requestAttributes.get(attributeName);
    }

    /**
     * Gets real path to directory with temporary files.
     *
     * @return the real path
     */
    public String getRealPath() {
        return realPath;
    }

    /**
     * Sets session invalidated.
     *
     * @param sessionInvalidated the session invalidated
     */
    public void setSessionInvalidated(boolean sessionInvalidated) {
        this.sessionInvalidated = sessionInvalidated;
    }

    /**
     * Sets request attribute.
     *
     * @param name  the name
     * @param value the value
     */
    public void setRequestAttribute(String name, Object value) {
        if (!requestAttributesChanged) {
            this.requestAttributes = new HashMap<>();
            this.requestAttributesChanged = true;
        }
        this.requestAttributes.put(name, value);
    }

    /**
     * Sets session attribute.
     *
     * @param name  the name
     * @param value the value
     */
    public void setSessionAttribute(String name, Object value) {
        if (!sessionAttributesChanged) {
            this.sessionAttributes = new HashMap<>();
            this.sessionAttributesChanged = true;
        }
        sessionAttributes.put(name, value);
    }

    /**
     * Extract values from http request.
     *
     * @param request the request
     */
    void extractValues(HttpServletRequest request) {
        if (ServletFileUpload.isMultipartContent(request)) {
            ServletContext context = request.getSession().getServletContext();
            realPath = context.getRealPath("");
        }

        this.requestParameters = request.getParameterMap();

        Enumeration<String> attributeNames = request.getAttributeNames();
        while (attributeNames.hasMoreElements()) {
            String attributeName = attributeNames.nextElement();
            this.requestAttributes.put(attributeName, request.getAttribute(attributeName));
        }
        this.requestAttributesChanged = false;

        HttpSession session = request.getSession();
        Enumeration<String> sessionAttributeNames = session.getAttributeNames();
        while (sessionAttributeNames.hasMoreElements()) {
            String attributeName = sessionAttributeNames.nextElement();
            this.sessionAttributes.put(attributeName, session.getAttribute(attributeName));
        }
        this.sessionAttributesChanged = false;
    }

    /**
     * Insert attributes to http request.
     *
     * @param request the request
     */
    void insertAttributes(HttpServletRequest request) {
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
}
