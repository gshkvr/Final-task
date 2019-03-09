package filter;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.File;
import java.io.IOException;
import java.util.*;

@WebFilter(
        filterName = "FileFilter",
        urlPatterns = "/*",
        initParams = {@WebInitParam(name = "defaultLocale", value = "ru-RU")}
)
public class FileFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;

        if (ServletFileUpload.isMultipartContent(request)) {
            Map<String, String[]> requestParameters = new HashMap<>();
            try {
                DiskFileItemFactory factory = new DiskFileItemFactory();
                ServletContext context = request.getSession().getServletContext();
                File repository = (File) context.getAttribute(ServletContext.TEMPDIR);

                factory.setRepository(repository);
                ServletFileUpload upload = new ServletFileUpload(factory);
                List<FileItem> formItems = upload.parseRequest(request);
                if (formItems != null && formItems.size() > 0) {
                    for (FileItem item : formItems) {
                        if (item.isFormField()) {
                            String name = item.getFieldName();
                            String value = item.getString();
                            String[] values = requestParameters.get(name);
                            if (values == null) {
                                requestParameters.put(name, new String[]{value});
                            } else {
                                int length = values.length;
                                String[] newValues = new String[length + 1];
                                System.arraycopy(values, 0, newValues, 0, length);
                                newValues[length] = value;
                                requestParameters.put(name, newValues);
                            }
                        } else {
                            request.setAttribute(item.getFieldName(), item);
                        }
                    }
                }
            } catch (FileUploadException e) {
                throw new ServletException("Cannot parse multipart request", e);
            }
            filterChain.doFilter(wrapRequest(request, requestParameters), servletResponse);
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void destroy() {

    }

    private HttpServletRequest wrapRequest(HttpServletRequest request, final Map<String, String[]> parameterMap) {
        return new HttpServletRequestWrapper(request) {
            public Map<String, String[]> getParameterMap() {
                return parameterMap;
            }

            public String[] getParameterValues(String name) {
                return parameterMap.get(name);
            }

            public String getParameter(String name) {
                String[] params = getParameterValues(name);
                return params != null && params.length > 0 ? params[0] : null;
            }

            public Enumeration<String> getParameterNames() {
                return Collections.enumeration(parameterMap.keySet());
            }
        };
    }
}
