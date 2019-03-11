package command.impl.common;

import controller.Page;
import controller.SessionRequestContent;
import org.testng.Assert;
import org.testng.annotations.Test;
import resource.ConfigurationManager;

public class LogoutCommandTest {
    private static final SessionRequestContent CONTENT = new SessionRequestContent();
    private static final String NEWS_COMMAND = ConfigurationManager.getProperty("command.news.page");
    private static final Page PAGE = new Page(NEWS_COMMAND, true);

    @Test
    public void testExecute() {
        LogoutCommand logoutCommand = new LogoutCommand();
        Page actual = logoutCommand.execute(CONTENT);
        Assert.assertEquals(actual, PAGE);
    }
}