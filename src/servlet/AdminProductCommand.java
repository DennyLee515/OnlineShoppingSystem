package servlet;

import domain.Product;
import service.ProductService;
import servlet.FrontCommand;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.List;

/**
 * @program: CoffeeWeb
 * @description: manage all product by admin
 * @author: DennyLee
 * @create: 2019-09-12 15:46
 **/
public class AdminProductCommand extends FrontCommand {
    @Override
    public void process() throws ServletException, IOException {
        //get all products
        ProductService productService = new ProductService();
        List<Product> products = productService.getAll();
        //return result
        request.setAttribute("products", products);
        forward("/jsp/admin/productManage.jsp");
    }
}
