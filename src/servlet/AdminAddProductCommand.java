package servlet;

import domain.Category;
import domain.Product;
import service.CategoryService;
import service.ProductService;

import javax.servlet.ServletException;
import java.io.IOException;

public class AdminAddProductCommand extends FrontCommand {
    @Override
    public void process() throws ServletException, IOException {
        String name = request.getParameter("productName");
        String info = request.getParameter("info");
        String categoryName = request.getParameter("category");
        double price = Double.parseDouble(request.getParameter("price"));
        int weight = Integer.parseInt(request.getParameter("weight"));
        int inventory = Integer.parseInt(request.getParameter("inventory"));

        Category category = new Category(categoryName);
        CategoryService categoryService = new CategoryService();
        categoryService.insertCategory(category);
        category = categoryService.findCategoryByName(category);

        Product product = new Product(name,info,price,weight,inventory);
        ProductService productService = new ProductService();
        boolean result = productService.insertProduct(product);
        if (result) {
            redirect("frontservlet?command=AdminProduct");
        } else {
            //todo:foward to error page
            System.out.println("Add product fail.");
        }
    }
}
