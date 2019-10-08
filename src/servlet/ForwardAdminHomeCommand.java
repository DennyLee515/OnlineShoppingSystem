package servlet;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * @program: CoffeeWeb
 * @description: .
 * @author: DennyLee
 * @create: 2019-10-03 00:30
 **/
public class ForwardAdminHomeCommand extends FrontCommand {
    @Override
    public void process() throws ServletException, IOException {
        forward("/jsp/admin/adminHome.jsp");
    }
}
