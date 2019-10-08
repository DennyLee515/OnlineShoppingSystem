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
 * @create: 2019-10-01 14:04
 **/
public class AdminManageOrderCommand extends FrontCommand {
    @Override
    public void process() throws ServletException, IOException {
        if (AppSession.isAuthenticated()){
            if(AppSession.hasRole(Params.CLERK_ROLE) || AppSession.hasRole(Params.MANAGER_ROLE)){
                //get parameters
                String method = request.getParameter("method");
                String orderId = request.getParameter("order");
                Order order = new Order();
                order.setOrderId(orderId);

                switch (method) {
                    case "view":
                        List<OrderDetail> orderDetails =
                                new OrderService().findOrderDetailsByOrderId(order);
                        request.setAttribute("order",order);
                        request.setAttribute("orderDetails",orderDetails);
                        forward("/jsp/admin/viewOrderDetail.jsp");
                        break;
                    case "update":
                        order = new OrderService().findOrderById(order);
                        String updateMethod = request.getParameter("update");
                        switch (updateMethod){
                            case "confirm":
                                order.setStatus(Params.CONFIRMED);
                                break;
                            case "ship":
                                order.setStatus(Params.SHIPPED);
                                break;
                            case "cancel":
                                order.setStatus(Params.CANCELLED);
                                break;
                        }

                        boolean result = new OrderService().updateOrderById(order);
                        if (result)
                            forward("/jsp/admin/updateOrder.jsp");
                        break;

                    default:
                        System.out.println("Wrong product manage method input");
                }
            }
        }else{
            redirect("frontservlet?command=ForwardAdminLogin");
        }
    }
}
