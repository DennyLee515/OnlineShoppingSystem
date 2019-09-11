package servlet;

import domain.Category;
import service.CategoryService;

import javax.servlet.ServletException;
import java.io.IOException;

public class AdminDeleteCategoryCommand extends FrontCommand{

    @Override
    public void process() throws ServletException, IOException {

        // get delete category id
        // cate service findById
        // delete
        String id = request.getParameter("del_category");
        CategoryService categoryService = new CategoryService();
        Category category = new Category();
        category.setCategoryId(id);
        try {
            category = categoryService.getCategroyById(category);
            categoryService.deleteCategory(category);
            //prompt to front?

        } catch (Exception e) {
            e.printStackTrace();
        }


//        String id = request.getParameter("product");
//        int amount = Integer.valueOf(request.getParameter("amount"));
//        ProductService productService = new ProductService();
//        Product product = new Product();
//        product.setProductId(id);
//        product = productService.findProductByID(product);
//        CartService cartService = new CartService();

    }
}
