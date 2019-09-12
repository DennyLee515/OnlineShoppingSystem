package servlet;

import domain.Category;
import domain.Product;
import javafx.css.CssMetaData;
import service.CategoryService;
import service.ProductService;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @program: CoffeeWeb
 * @description:
 * @author: DennyLee
 * @create: 2019-09-13 00:05
 **/
public class AdminAddRelationCommand extends FrontCommand {
    @Override
    public void process() throws ServletException, IOException {
        String productId =  request.getParameter("product");
        String[] category = request.getParameterValues("category");
        Product product = new Product();
        product.setProductId(productId);
        ProductService productService = new ProductService();
        product = productService.findProductByID(product);

        CategoryService categoryService = new CategoryService();
        boolean result = true;

        if(category.length>0){
            for (String s : category) {
                Category category1 = new Category();
                category1.setCategoryName(s);
                category1 = categoryService.findCategoryByName(category1);

                result = productService.addRelation(product,category1) && result;
            }
        }
        if (result){
            redirect("frontservlet?command=AdminProduct");
        }else{
            // TODO: forward err
        }

    }
}
