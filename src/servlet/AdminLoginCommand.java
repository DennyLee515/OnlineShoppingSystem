package servlet;

import servlet.FrontCommand;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * @program: CoffeeWeb
 * @description:
 * @author: DennyLee
 * @create: 2019-09-12 14:42
 **/
public class AdminLoginCommand extends FrontCommand {
    @Override
    public void process() throws ServletException, IOException {
        forward("/jsp/admin/adminHome.jsp");
    }
}
