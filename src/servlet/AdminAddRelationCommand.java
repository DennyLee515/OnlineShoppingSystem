package servlet;

import domain.Category;
import domain.Product;
import javafx.css.CssMetaData;
import security.AppSession;
import service.CategoryService;
import service.ProductService;
import util.Params;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @program: CoffeeWeb
 * @description: add a relation between a product and a category
 * @author: DennyLee
 * @create: 2019-09-13 00:05
 **/
public class AdminAddRelationCommand extends FrontCommand {
    @Override
    public void process() throws ServletException, IOException {
        if (AppSession.isAuthenticated()){
            if(AppSession.hasRole(Params.CLERK_ROLE) || AppSession.hasRole(Params.MANAGER_ROLE)){
                //get parameters
                String productId =  request.getParameter("product");
                String[] category = request.getParameterValues("category");
                //find product by id
                Product product = new Product();
                product.setProductId(productId);
                ProductService productService = new ProductService();
                product = productService.findProductByID(product);

                CategoryService categoryService = new CategoryService();
                boolean result = true;
                //for all categories
                if(category.length>0){
                    for (String s : category) {
                        //find category by id
                        Category category1 = new Category();
                        category1.setCategoryName(s);
                        category1 = categoryService.findCategoryByName(category1);
                        //add relation
                        result = productService.addRelation(product,category1) && result;
                    }
                }
                if (result){
                    redirect("frontservlet?command=AdminProduct");
                }else{
                    request.setAttribute("errMsg", "Add relation fail.");
                    forward("/jsp/error.jsp");
                }
            }
        }else{
            redirect("frontservlet?command=ForwardAdminLogin");
        }
    }
}
