package servlet;

import domain.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @program: CoffeeWeb
 * @description: user login
 * @author: DennyLee
 * @create: 2019-09-12 14:41
 **/
public class UserLoginCommand extends FrontCommand {
    @Override
    public void process() throws ServletException, IOException {
        forward("/jsp/user/userLogin.jsp");
    }

}
