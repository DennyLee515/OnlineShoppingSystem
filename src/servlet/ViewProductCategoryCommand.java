package servlet;

import domain.Category;
import domain.Product;
import service.CategoryService;
import service.ProductService;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.List;

/**
 * @program: CoffeeWeb
 * @description:
 * @author: DennyLee
 * @create: 2019-09-12 22:08
 **/
public class ViewProductCategoryCommand extends FrontCommand {
    @Override
    public void process() throws ServletException, IOException {
        String productId = request.getParameter("product");
        Product product = new Product();
        product.setProductId(productId);
        ProductService productService = new ProductService();
        product = productService.findProductByID(product);

        CategoryService categoryService = new CategoryService();
        List<Category> categories = categoryService.findCategoryByProduct(product);

        request.setAttribute("categories",categories);
        request.setAttribute("product",product);
        forward("/jsp/viewRoast.jsp");
    }
}
