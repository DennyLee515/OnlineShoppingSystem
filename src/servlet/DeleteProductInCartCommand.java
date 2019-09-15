package servlet;

import domain.CartDetail;
import service.CartService;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * @program: CoffeeWeb
 * @description: delete a product in cart
 * @author: DennyLee
 * @create: 2019-09-14 22:48
 **/
public class DeleteProductInCartCommand extends FrontCommand {
    @Override
    public void process() throws ServletException, IOException {
        //get parameters
        String cartDetailId = request.getParameter("cartDetail");

        //delete cart detail by id
        CartDetail cartDetail = new CartDetail();
        cartDetail.setCartDetailId(cartDetailId);
        CartService cartService = new CartService();
        boolean result = cartService.deleteCartDetail(cartDetail);

        //return result
        if (result){
            redirect("frontservlet?command=ViewCart");
        }else {
            request.setAttribute("errMsg","Delete product failed.");
            forward("/jsp/error.jsp");
        }
    }
}
