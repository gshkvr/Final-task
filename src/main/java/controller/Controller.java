package controller;

import command.Command;
import command.CommandFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Controller", urlPatterns = "/controller")
public class Controller extends HttpServlet {
    private static final CommandFactory commandFactory = CommandFactory.INSTANCE;

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
        SessionRequestContent sessionRequestContent = new SessionRequestContent();
        sessionRequestContent.extractValues(request);
        Command command = commandFactory.defineCommand(request);
        Page page = command.execute(sessionRequestContent);
        sessionRequestContent.insertAttributes(request);
        if (sessionRequestContent.isCookiesChanged()) {
            sessionRequestContent.getCookies().forEach(response::addCookie);
        }
        if (page != null) {
            if (page.isForRedirect()) {
                response.sendRedirect(request.getContextPath() + page.getUrl());
            } else {
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page.getUrl());
                dispatcher.forward(request, response);
            }
        } else {
//            LOGGER.fatal(e.getMessage(), e);
//            page = new Page(ERROR_PAGE);
//            forward(page, request, response);
        }
    }
}
