package servlet;

import domain.Order;
import domain.User;
import service.OrderService;
import util.Params;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.List;

/**
 * @program: CoffeeWeb
 * @description:
 * @author: DennyLee
 * @create: 2019-09-27 23:49
 **/
public class ViewOrderCommand extends FrontCommand{
    @Override
    public void process() throws ServletException, IOException {
        User user =(User)request.getSession().getAttribute(Params.USER);
        OrderService orderService = new OrderService();
        List<Order> orders = orderService.findOrderByUser(user);
        request.setAttribute("orders",orders);
        forward("/jsp/user/viewOrders.jsp");

    }
}
