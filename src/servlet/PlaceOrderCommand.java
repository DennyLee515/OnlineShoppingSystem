package servlet;

import domain.*;
import service.CartService;
import service.OrderService;
import util.Params;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.List;

/**
 * @program: CoffeeWeb
 * @description:
 * @author: DennyLee
 * @create: 2019-09-27 20:02
 **/
public class PlaceOrderCommand extends FrontCommand {
    @Override
    public void process() throws ServletException, IOException {
        String address = request.getParameter("address");
        User user = (User)request.getSession().getAttribute(Params.USER);
        Double totalPrice = 0.0;
        Order order = new Order(user,totalPrice,address,Params.PENDING);
        CartService cartService = new CartService();
        List<CartDetail> cartDetails = cartService.findCartDetailByUserId(user);
        OrderService orderService = new OrderService();
        boolean result = true;
        for (CartDetail cartDetail:cartDetails){
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setOrder(order);
            orderDetail.setProduct(cartDetail.getProduct());
            orderDetail.setProductAmount(cartDetail.getProductAmount());
            orderDetail.setProductCategory(cartDetail.getCategory());
            totalPrice =
                    totalPrice + cartDetail.getProduct().getPrice()*cartDetail.getProductAmount();

            result = result&&orderService.insertOrderDetail(orderDetail);
        }
        order.setTotalPrice(totalPrice);
        if (result && orderService.insertOrder(order) && cartService.clearCartByUser(user)){
        forward("/jsp/user/orderSuccess.jsp");}else {
            request.setAttribute("ErrMsg","Fail to place the order!");
            forward("/jsp/error.jsp");
        }
    }
}