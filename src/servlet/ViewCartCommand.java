package servlet;


import domain.CartDetail;
import domain.User;
import security.AppSession;
import service.CartService;
import service.UserService;
import util.Params;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * view shopping cart
 */
public class ViewCartCommand extends FrontCommand {
    @Override
    public void process() throws ServletException, IOException {

        if (AppSession.isAuthenticated()) {
            if (AppSession.hasRole(Params.CUSTOMER_ROLE)) {
                //find a cart by user
                CartService cartService = new CartService();
                User user = AppSession.getUser();
                List<CartDetail> cartDetails = cartService.findCartDetailByUserId(user);
                //return result
                request.setAttribute("cartDetails", cartDetails);
                forward("/jsp/user/cart.jsp");
            }
        }else {
            redirect("frontservlet?command=UserLogin");
        }
    }

}
