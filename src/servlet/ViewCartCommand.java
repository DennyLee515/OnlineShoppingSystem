package servlet;


import domain.Cart;
import domain.User;
import service.CartService;
import service.UserService;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.List;

public class ViewCartCommand extends FrontCommand {
    @Override
    public void process() throws ServletException, IOException {
        CartService cartService = new CartService();
        //TODO: update user by using session.
        User user = new User();
        user.setUsername("username");
        UserService userService = new UserService();
        user = userService.findUserByName(user);

        List<Cart> carts = cartService.findCartByUser(user);

        request.setAttribute("carts", carts);
        forward("/jsp/user/cart.jsp");
    }

}
