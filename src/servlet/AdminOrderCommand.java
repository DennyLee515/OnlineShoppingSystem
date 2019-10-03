package servlet;

import domain.Order;
import service.OrderService;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.List;

/**
 * @program: CoffeeWeb
 * @description: Manage all orders by admin
 * @author: DennyLee
 * @create: 2019-09-12 15:45
 **/
public class AdminOrderCommand extends FrontCommand {
    @Override
    public void process() throws ServletException, IOException {
        //get all categories
        OrderService orderService = new OrderService();
        List<Order> orders = orderService.getAllOrders();
        request.setAttribute("orders", orders);
        forward("/jsp/admin/orderManage.jsp");

    }
}
