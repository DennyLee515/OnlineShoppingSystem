package servlet;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * @program: CoffeeWeb
 * @description:
 * @author: DennyLee
 * @create: 2019-09-12 14:41
 **/
public class UserLoginCommand extends FrontCommand {
    @Override
    public void process() throws ServletException, IOException {
        forward("/jsp/user/userHome.jsp");
    }
}
