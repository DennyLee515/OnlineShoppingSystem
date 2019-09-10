package servlet;


import javax.servlet.ServletException;
import java.io.IOException;

public class ViewCartCommand extends FrontCommand {
    @Override
    public void process() throws ServletException, IOException {

        forward("/jsp/cart.jsp");
    }

}
