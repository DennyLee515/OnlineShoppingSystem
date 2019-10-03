package servlet;

import domain.Cart;
import domain.User;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import service.CartService;
import service.UserService;

import javax.servlet.ServletException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * @program: CoffeeWeb
 * @description:
 * @author: DennyLee
 * @create: 2019-10-02 22:56
 **/
public class RegisterCommand extends FrontCommand {
    @Override
    public void process() throws ServletException, IOException {
        String firstname = request.getParameter("firstName");
        String lastname = request.getParameter("lastName");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String address = request.getParameter("address");

        Date birthday = null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            birthday = simpleDateFormat.parse(request.getParameter("birthday"));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        ByteSource salt = ByteSource.Util.bytes(username);
        String encryptedPassword = new SimpleHash("MD5", password, salt, 1024).toHex();

        User user = new User(firstname, lastname, username, encryptedPassword, birthday, email,
                address);
        UserService userService = new UserService();
        userService.insertUser(user);

        Cart cart = new Cart(user);
        CartService cartService = new CartService();
        cartService.newCart(cart);

        redirect("frontservlet?command=UserLogin");
    }
}
