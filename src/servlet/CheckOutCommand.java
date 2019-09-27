package servlet;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * @program: CoffeeWeb
 * @description:
 * @author: DennyLee
 * @create: 2019-09-27 22:47
 **/
public class CheckOutCommand extends FrontCommand {
    @Override
    public void process() throws ServletException, IOException {
        forward("/jsp/user/placeOrder.jsp");
    }
}
