package command.impl.page;

import com.google.protobuf.ServiceException;
import command.Command;
import controller.Page;
import controller.SessionRequestContent;
import resource.ConfigurationManager;
import service.NewsService;

public class NewsPageCommand implements Command {
    private static final String NEWS_PAGE = ConfigurationManager.getProperty("page.news");
    private static final String NEWS_COMMAND = ConfigurationManager.getProperty("command.news_page");
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
