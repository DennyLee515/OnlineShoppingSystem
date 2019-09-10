package servlet;

import domain.Product;
import service.ProductService;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SearchProductCommand extends FrontCommand{
    @Override
    public void process() throws ServletException, IOException {
        String productName= request.getParameter("name");
        List<Product> products = new ArrayList<>();
        ProductService productService = new ProductService();
        products = productService.findProductByName(productName);
        request.setAttribute("products", products);
        forward("/jsp/viewProducts.jsp");

    }
}
