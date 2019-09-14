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
 * @create: 2019-09-07 15:51
 **/
public class ViewCategoryProductCommand extends FrontCommand{
    @Override
    public void process() throws ServletException, IOException {
        String categoryId = request.getParameter("category");
        Category category = new Category();
        category.setCategoryId(categoryId);
        CategoryService categoryService = new CategoryService();
        category = categoryService.findCategroyById(category);
        if (category==null){
            request.setAttribute("errMsg", "The category no longer exists");
            forward("/jsp/error.jsp");
        }

        ProductService productService = new ProductService();
        List<Product> products = productService.findProductByCategory(category);
        if (products==null){
            request.setAttribute("errMsg", "No Product in this category");
            forward("/jsp/error.jsp");
        }
        request.setAttribute("products",products);
        request.setAttribute("category",category);
        forward("/jsp/viewProductsInCategory.jsp");
    }
}
