package controller;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.*;

public class SessionRequestContent {
    private Map<String, Object> requestAttributes = new HashMap<>();
    private Map<String, String[]> requestParameters = new HashMap<>();
    private Map<String, Object> sessionAttributes = new HashMap<>();
    private List<FileItem> fileParts = new ArrayList<>();
    private String realPath;

    private boolean requestAttributesChanged;
    private boolean sessionAttributesChanged;

    private boolean sessionInvalidated = false;

    public String getRequestParameter(String paramName) {
        return requestParameters.get(paramName) != null && requestParameters.get(paramName).length > 0 ? requestParameters.get(paramName)[0] : null;
    }

    public List<FileItem> getFileParts() {
        return fileParts;
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

    void extractValues(HttpServletRequest request) throws ServletException {
        if (ServletFileUpload.isMultipartContent(request)) {
            try {
                DiskFileItemFactory factory = new DiskFileItemFactory();
                ServletContext context = request.getSession().getServletContext();
                File repository = (File) context.getAttribute(ServletContext.TEMPDIR);
                realPath = context.getRealPath("");
                factory.setRepository(repository);
                ServletFileUpload upload = new ServletFileUpload(factory);
                List<FileItem> formItems = upload.parseRequest(request);
                if (formItems != null && formItems.size() > 0) {
                    for (FileItem item : formItems) {
                        if (item.isFormField()) {
                            String name = item.getFieldName();
                            String value = item.getString();
                            String[] values = this.requestParameters.get(name);
                            if (values == null) {
                                this.requestParameters.put(name, new String[]{value});
                            } else {
                                int length = values.length;
                                String[] newValues = new String[length + 1];
                                System.arraycopy(values, 0, newValues, 0, length);
                                newValues[length] = value;
                                this.requestParameters.put(name, newValues);
                            }
                        } else {
                            fileParts.add(item);
                        }
                    }
                }
            } catch (FileUploadException e) {
                throw new ServletException("Cannot parse multipart request", e);
            }
        } else {
            this.requestParameters = request.getParameterMap();
        }

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
