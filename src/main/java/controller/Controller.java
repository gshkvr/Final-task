package controller;

import command.Command;
import command.CommandFactory;
import exception.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Controller", urlPatterns = "/controller")
public class Controller extends HttpServlet {
    private static final Logger LOGGER = LogManager.getLogger(Controller.class);
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
        try {
            SessionRequestContent sessionRequestContent = new SessionRequestContent();
            sessionRequestContent.extractValues(request);
            Command command = commandFactory.defineCommand(request);
            Page page = command.execute(sessionRequestContent);
            sessionRequestContent.insertAttributes(request);
            if (sessionRequestContent.isCookiesChanged()) {
                sessionRequestContent.getCookies().forEach(response::addCookie);
            }

            if (page.isForRedirect()) {
                response.sendRedirect(request.getContextPath() + page.getUrl());
            } else {
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page.getUrl());
                dispatcher.forward(request, response);
            }
        } catch (ServiceException e) {
            LOGGER.fatal(e.getMessage(), e);
            e.printStackTrace();
        }
    }
}
