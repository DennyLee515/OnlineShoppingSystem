package servlet;

import javax.servlet.ServletException;
import java.io.IOException;

public class ViewCategoryCommand extends FrontCommand{

    @Override
    public void process() throws ServletException, IOException {
        forward("/jsp/viewCategory.jsp");
    }
}
