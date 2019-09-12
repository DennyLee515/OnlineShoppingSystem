package servlet;

import domain.Category;
import domain.Product;
import service.CategoryService;
import service.ProductService;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * @program: CoffeeWeb
 * @description:
 * @author: DennyLee
 * @create: 2019-09-12 23:15
 **/
public class AdminDeleteRelationCommand extends FrontCommand {
    @Override
    public void process() throws ServletException, IOException {
        String categoryId = request.getParameter("category");
        String productId = request.getParameter("product");

        Category category = new Category();
        category.setCategoryId(categoryId);
        CategoryService categoryService = new CategoryService();
        categoryService.findCategroyById(category);

        Product product = new Product();
        product.setProductId(productId);
        ProductService productService = new ProductService();
        productService.findProductByID(product);

        boolean result = productService.deleteRelation(product, category);
        if (result){
            redirect("frontservlet?command=AdminCategory");
        }else{
            //todo:forward error page
        }
    }
}
