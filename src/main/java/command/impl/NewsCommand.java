package command.impl;

import com.google.protobuf.ServiceException;
import command.Command;
import controller.Page;
import controller.SessionRequestContent;
import resource.ConfigurationManager;
import service.NewsService;

public class NewsCommand implements Command {
    private static final String NEWS_PAGE = ConfigurationManager.getProperty("page.news");
    private static final String NEWS_COMMAND = ConfigurationManager.getProperty("command.news");
    private static final String LOCALE_COMMAND= "localeCommand";

    @Override
    public Page execute(SessionRequestContent content) {
        try {
            content.setRequestAttribute("allNews", NewsService.getInstance().loadNews());
            content.setRequestAttribute(LOCALE_COMMAND, NEWS_COMMAND);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        return new Page(NEWS_PAGE);
    }
}
