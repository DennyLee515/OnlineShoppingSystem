package servlet;

import servlet.FrontCommand;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * @program: CoffeeWeb
 * @description: Manage all orders by admin
 * @author: DennyLee
 * @create: 2019-09-12 15:45
 **/
public class AdminOrderCommand extends FrontCommand {
    @Override
    public void process() throws ServletException, IOException {
        // TODO: 2019/9/15 implement in feature2
        forward("/jsp/admin/orderManage.jsp");

    }
}
