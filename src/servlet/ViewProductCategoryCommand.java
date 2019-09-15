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
 * @description: View products by category
 * @author: DennyLee
 * @create: 2019-09-12 22:08
 **/
public class ViewProductCategoryCommand extends FrontCommand {
    @Override
    public void process() throws ServletException, IOException {
        //get parameters
        String productId = request.getParameter("product");
        Product product = new Product();
        product.setProductId(productId);

        //find product by id
        ProductService productService = new ProductService();
        product = productService.findProductByID(product);
        if (product == null) {
            request.setAttribute("errMsg", "The product no longer exists");
            forward("/jsp/error.jsp");
        }

        //find categories related to a product
        CategoryService categoryService = new CategoryService();
        List<Category> categories = categoryService.findCategoryByProduct(product);
        if (categories.isEmpty()) {
            request.setAttribute("errMsg", "No roast can be select");
            forward("/jsp/error.jsp");
        }

        //return result
        request.setAttribute("categories", categories);
        request.setAttribute("product", product);
        forward("/jsp/viewRoast.jsp");
    }
}
