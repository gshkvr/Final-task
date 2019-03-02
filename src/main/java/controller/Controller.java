package controller;

import command.Command;
import command.CommandFactory;
import command.exception.CommandException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import resource.ConfigurationManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Controller", urlPatterns = "/controller")
@MultipartConfig
public class Controller extends HttpServlet {
    private static final Logger LOGGER = LogManager.getLogger(Controller.class);
    private static final String ERROR_COMMAND = ConfigurationManager.getProperty("command.error");
    private static final CommandFactory commandFactory = CommandFactory.getInstance();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request,
                                HttpServletResponse response)
            throws ServletException, IOException {

        Page page;
        try {
            SessionRequestContent sessionRequestContent = new SessionRequestContent();
            sessionRequestContent.extractValues(request);
            Command command = commandFactory.defineCommand(sessionRequestContent);
            page = command.execute(sessionRequestContent);
            sessionRequestContent.insertAttributes(request);
            if (sessionRequestContent.isCookiesChanged()) {
                sessionRequestContent.getCookies().forEach(response::addCookie);
            }

            if (page.isForRedirect()) {
                redirect(page, request, response);
            } else {
                forward(page, request, response);
            }
        } catch (CommandException e) {
            LOGGER.fatal(e.getMessage(), e);
            page = new Page(ERROR_COMMAND, true);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page.getUrl());
            dispatcher.forward(request, response);
        }
    }

    private void forward(Page page, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = page.getUrl();
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(url);
        requestDispatcher.forward(request, response);
    }

    private void redirect(Page page, HttpServletRequest request, HttpServletResponse response) throws IOException {
        String url = page.getUrl();
        String contextPath = request.getContextPath();
        response.sendRedirect(contextPath + url);
    }
}
