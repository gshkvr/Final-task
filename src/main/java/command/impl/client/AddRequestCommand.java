package command.impl.client;

import command.Command;
import controller.Page;
import controller.SessionRequestContent;
import entity.impl.Request;
import exception.ServiceException;
import org.apache.commons.fileupload.FileItem;
import resource.ConfigurationManager;
import service.RequestService;

import java.io.File;


public class AddRequestCommand implements Command {
    private static final String REQUEST_PAGE_COMMAND = ConfigurationManager.getProperty("command.add_request_page");
    private static final String NEWS_PAGE_COMMAND = ConfigurationManager.getProperty("command.news_page");
    private static final String REQUEST_SHOW_COMMAND = ConfigurationManager.getProperty("command.show_request_page");
    private static final String FILE_SIZE_ERROR = ConfigurationManager.getProperty("attribute.error.request.file_size");
    private static final String NAME_ERROR = ConfigurationManager.getProperty("attribute.error.request.name");
    private final static String IMAGES_DIRECTORY = ConfigurationManager.getProperty("images.directory");
    private final RequestService requestService = RequestService.getInstance();

    @Override
    public Page execute(SessionRequestContent content) throws ServiceException {

        String name = content.getRequestParameter(Request.REQUEST_NAME);
        if (name == null || "".equals(name)) {
            return new Page(REQUEST_PAGE_COMMAND + NAME_ERROR, true);
        }

        FileItem item = content.getFileParts().get(0);
        String fileName = new File(item.getName()).getName();
        String filePath = IMAGES_DIRECTORY + File.separator + fileName;
        String extractPath = content.getRealPath() + filePath;
        File storeFile = new File(extractPath);
        try {
            item.write(storeFile);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Request request = new Request(0, name, filePath);
        requestService.addRequest(request);

        return new Page(REQUEST_SHOW_COMMAND, true);
    }

}
