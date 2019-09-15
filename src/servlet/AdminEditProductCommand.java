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
        String[] category = null;
        category = request.getParameterValues("category");
        double price = Double.parseDouble(request.getParameter("price"));
        int weight = Integer.parseInt(request.getParameter("weight"));
        int inventory = Integer.parseInt(request.getParameter("inventory"));

        Product product = new Product();
        product.setProductId(productId);
        ProductService productService = new ProductService();
        product = productService.findProductByID(product);
        product.setProductName(name);
        product.setInfo(info);
        product.setPrice(price);
        product.setWeight(weight);
        product.setInventory(inventory);

        boolean result = productService.updateProduct(product);


        productService.deleteAllRelations(product);
        CategoryService categoryService = new CategoryService();

        if (category != null && category.length > 0) {
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
            request.setAttribute("errMsg", "Edit product fail.");
            forward("/jsp/error.jsp");
        }
    }
}
