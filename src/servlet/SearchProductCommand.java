package servlet;

import domain.Product;
import service.ProductService;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * search a product
 */
public class SearchProductCommand extends FrontCommand{
    @Override
    public void process() throws ServletException, IOException {
        //get parameters
        String productName= request.getParameter("name");

        //find product by name
        Product product = new Product();
        ProductService productService = new ProductService();
        product.setProductName(productName);
        product = productService.findProductByName(product);
        List<Product> products = new ArrayList<>();
        products.add(product);

        //return result
        if (product==null){
            request.setAttribute("errMsg", "Cannot find the product");
            forward("/jsp/error.jsp");
        }
        request.setAttribute("products", products);
        forward("/jsp/viewProducts.jsp");

    }
}
