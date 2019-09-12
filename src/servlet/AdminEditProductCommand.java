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
 * @create: 2019-09-12 17:13
 **/
public class AdminEditProductCommand extends FrontCommand {
    @Override
    public void process() throws ServletException, IOException {
        String productId = request.getParameter("product");
        String name = request.getParameter("productName");
        String info = request.getParameter("info");
        String categoryName = request.getParameter("category");
        double price = Double.parseDouble(request.getParameter("price"));
        int weight = Integer.parseInt(request.getParameter("weight"));

        Product product = new Product();
        product.setProductId(productId);
        ProductService productService = new ProductService();
        product = productService.findProductByID(product);
        product.setProductName(name);
        product.setInfo(info);
        product.setPrice(price);
        product.setWeight(weight);

        Category category = new Category(categoryName);
        CategoryService categoryService = new CategoryService();
        categoryService.insertCategory(category);
        category = categoryService.findCategoryByName(category);
        product.setCategory(category);

        boolean result = productService.updateProduct(product);
        if (result) {
            redirect("frontservlet?command=AdminProduct");
        } else {
            //todo:foward to error page
            System.out.println("Edit product fail.");
        }
    }
}
