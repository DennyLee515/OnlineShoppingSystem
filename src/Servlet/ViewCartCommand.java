package Servlet;


import Service.CartService;

import javax.servlet.ServletException;
import java.io.IOException;

public class ViewCartCommand extends FrontCommand {
    @Override
    public void process() throws ServletException, IOException {
        request.setAttribute("products", products);
        forward("/jsp/viewProducts.jsp");
    }
}
}
