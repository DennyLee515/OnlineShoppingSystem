package servlet;

import domain.Product;
import service.ProductService;
import servlet.FrontCommand;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.List;

/**
 * @program: CoffeeWeb
 * @description:
 * @author: DennyLee
 * @create: 2019-09-12 15:46
 **/
public class AdminProductManageCommand extends FrontCommand {
    @Override
    public void process() throws ServletException, IOException {
        ProductService productService = new ProductService();
        List<Product> products = productService.getAll();
        request.setAttribute("products", products);
        forward("/jsp/admin/productManage.jsp");
    }
}
