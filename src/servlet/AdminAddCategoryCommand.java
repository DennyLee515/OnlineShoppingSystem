package servlet;

import domain.Category;
import service.CategoryService;

import javax.servlet.ServletException;
import java.io.IOException;

public class AdminAddCategoryCommand extends FrontCommand{

    @Override
    public void process() throws ServletException, IOException {
        String categoryName = request.getParameter("add_category");
        Category category = new Category();
        category.setCategoryName(categoryName);

        CategoryService categoryService = new CategoryService();
        categoryService.insertCategory(category);

        //return add category result to front-end ?

    }
//
//    String productName= request.getParameter("name");
//    List<Product> products = new ArrayList<>();
//    ProductService productService = new ProductService();
//    products = productService.findProductByName(productName);
//        request.setAttribute("products", products);
//    forward("/jsp/viewProducts.jsp");
}
