package servlet;

import domain.Order;
import security.AppSession;
import service.OrderService;
import util.Params;

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
        if (AppSession.isAuthenticated()){
            if(AppSession.hasRole(Params.CLERK_ROLE) || AppSession.hasRole(Params.MANAGER_ROLE)){
                //get all categories
                OrderService orderService = new OrderService();
                List<Order> orders = orderService.getAllOrders();
                request.setAttribute("orders", orders);
                forward("/jsp/admin/orderManage.jsp");
            }
        }else{
            redirect("frontservlet?command=ForwardAdminLogin");
        }
    }
}
