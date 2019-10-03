package servlet;

import domain.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import security.AppSession;
import service.UserService;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * @program: CoffeeWeb
 * @description:
 * @author: DennyLee
 * @create: 2019-10-01 23:10
 **/
public class LoginCommand extends FrontCommand {
    @Override
    public void process() throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        ByteSource salt = ByteSource.Util.bytes(username);
        String encryptedPassword = new SimpleHash("MD5",password,salt,1024).toHex();
        UsernamePasswordToken token = new UsernamePasswordToken(username, encryptedPassword);
        token.setRememberMe(true);
        Subject currentUser = SecurityUtils.getSubject();
        String target = null;
        try {
            currentUser.login(token);
            User user = new User();
            user.setUsername(username);
            user = new UserService().findUserByName(user);
            AppSession.init(user);
            target = "/jsp/user/userHome.jsp";
        } catch (AuthenticationException e) {
            request.setAttribute("ErrMsg", "Log in failed");
            target = "/jsp/error.jsp";
        } finally {
            forward(target);
        }
    }
}
