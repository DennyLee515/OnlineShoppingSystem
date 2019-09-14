package servlet;

import domain.CartDetail;
import service.CartService;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * @program: CoffeeWeb
 * @description:
 * @author: DennyLee
 * @create: 2019-09-14 22:48
 **/
public class DeleteProductInCartCommand extends FrontCommand {
    @Override
    public void process() throws ServletException, IOException {
        String cartDetailId = request.getParameter("cartDetail");
        System.out.println(cartDetailId);
        CartDetail cartDetail = new CartDetail();
        cartDetail.setCartDetailId(cartDetailId);
        CartService cartService = new CartService();
        boolean result = cartService.deleteCartDetail(cartDetail);
        if (result){
            redirect("frontservlet?command=ViewCart");
        }else {
            request.setAttribute("errMsg","Delete product failed.");
            forward("/jsp/error.jsp");
        }
    }
}
