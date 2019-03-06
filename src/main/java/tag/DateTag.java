package tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.time.LocalDate;

public class DateTag extends TagSupport {
    @Override
    public int doStartTag() throws JspException {
        try {
            LocalDate currentDate = LocalDate.now();
            String date = currentDate.toString();
            pageContext.getOut().write(date);
        } catch (IOException e) {
            throw new JspException(e.getMessage(), e);
        }
        return SKIP_BODY;
    }
}
