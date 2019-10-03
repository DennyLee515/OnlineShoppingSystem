package servlet;

import security.AppSession;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * @program: CoffeeWeb
 * @description:
 * @author: DennyLee
 * @create: 2019-10-02 00:41
 **/
public class LogoutCommand extends FrontCommand {
    @Override
    public void process() throws ServletException, IOException {
        AppSession.logout();
        forward("/index.jsp");
    }
}
