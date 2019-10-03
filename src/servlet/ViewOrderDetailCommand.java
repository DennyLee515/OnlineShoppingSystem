package servlet;

import domain.Order;
import domain.OrderDetail;
import security.AppSession;
import service.OrderService;
import util.Params;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.List;

/**
 * @program: CoffeeWeb
 * @description:
 * @author: DennyLee
 * @create: 2019-09-28 13:46
 **/
public class ViewOrderDetailCommand extends FrontCommand{
    @Override
    public void process() throws ServletException, IOException {
        if (AppSession.isAuthenticated()){
            if (AppSession.hasRole(Params.CUSTOMER_ROLE)){
                String orderId = request.getParameter("order");
                OrderService orderService = new OrderService();
                Order order = new Order();
                order.setOrderId(orderId);
                List<OrderDetail> orderDetails = orderService.findOrderDetailsByOrderId(order);
                request.setAttribute("orderDetails",orderDetails);
                forward("/jsp/user/viewOrderDetail.jsp");
            }
        }else {
            redirect("frontservlet?command=ForwardUserHome");
        }
    }
}
