package servlet;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * @program: CoffeeWeb
 * @description:
 * @author: DennyLee
 * @create: 2019-09-07 15:20
 **/
public class ViewShopCommand extends FrontCommand{

    @Override
    public void process() throws ServletException, IOException {
        forward("/jsp/shop.jsp");
    }
}
