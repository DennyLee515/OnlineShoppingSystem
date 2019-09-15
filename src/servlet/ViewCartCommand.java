package servlet;


import domain.CartDetail;
import domain.User;
import service.CartService;
import service.UserService;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.List;

/**
 * view shopping cart
 */
public class ViewCartCommand extends FrontCommand {
    @Override
    public void process() throws ServletException, IOException {
        //find a cart by user
        CartService cartService = new CartService();
        //TODO: update user by using session.
        User user = new User();
        user.setUsername("username");
        UserService userService = new UserService();
        user = userService.findUserByName(user);

        List<CartDetail> cartDetails = cartService.findCartDetailByUserId(user);
        //return result
        request.setAttribute("cartDetails", cartDetails);
        forward("/jsp/user/cart.jsp");
    }

}
