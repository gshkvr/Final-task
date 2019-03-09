package controller;

import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

public class SessionRequestContent {
    private Map<String, Object> requestAttributes = new HashMap<>();
    private Map<String, String[]> requestParameters = new HashMap<>();
    private Map<String, Object> sessionAttributes = new HashMap<>();
    private String realPath;

    private boolean requestAttributesChanged;
    private boolean sessionAttributesChanged;

    private boolean sessionInvalidated = false;

    public String getRequestParameter(String paramName) {
        return requestParameters.get(paramName) != null && requestParameters.get(paramName).length > 0 ? requestParameters.get(paramName)[0] : null;
    }

    public Object getRequestAttribute(String attributeName) {
        return requestAttributes.get(attributeName);
    }

    public String getRealPath() {
        return realPath;
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
