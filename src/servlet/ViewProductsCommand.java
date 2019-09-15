package servlet;

import domain.Product;
import service.ProductService;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.List;

/**
 * @program: CoffeeWeb
 * @description: View products by customers
 * @author: DennyLee
 * @create: 2019-09-06 00:12
 **/
public class ViewProductsCommand extends FrontCommand {
    @Override
    public void process() throws ServletException, IOException {
        //get available products
        ProductService productService = new ProductService();
        List<Product> products = productService.getAllAvailableProducts();
        //return result
        if (products.isEmpty()) {
            request.setAttribute("errMsg", "There is no product.");
            forward("/jsp/error.jsp");
        }
        request.setAttribute("products", products);
        forward("/jsp/viewProducts.jsp");
    }
}
