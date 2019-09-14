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
        String[] category = request.getParameterValues("category");
        double price = Double.parseDouble(request.getParameter("price"));
        int weight = Integer.parseInt(request.getParameter("weight"));
        int inventory = Integer.parseInt(request.getParameter("inventory"));

        Product product = new Product(name, info, price, weight, inventory);
        ProductService productService = new ProductService();
        boolean result = productService.insertProduct(product);
        if (!result) {
            request.setAttribute("errMsg", "Add new product fail.");
            forward("/jsp/error.jsp");
        }
        CategoryService categoryService = new CategoryService();

        if (category.length > 0) {
            for (String s : category) {
                Category category1 = new Category();
                category1.setCategoryName(s);
                category1 = categoryService.findCategoryByName(category1);

                result = productService.addRelation(product, category1) && result;
            }
        }

        if (result) {
            redirect("frontservlet?command=AdminProduct");
        } else {
            request.setAttribute("errMsg", "Add to category fail.");
            forward("/jsp/error.jsp");
        }
    }
}
