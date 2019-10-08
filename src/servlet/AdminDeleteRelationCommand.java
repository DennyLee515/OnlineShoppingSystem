package servlet;

import domain.Category;
import domain.Product;
import security.AppSession;
import service.CategoryService;
import service.ProductService;
import util.Params;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * @program: CoffeeWeb
 * @description: delete a relation between a product and a category
 * @author: DennyLee
 * @create: 2019-09-12 23:15
 **/
public class AdminDeleteRelationCommand extends FrontCommand {
    @Override
    public void process() throws ServletException, IOException {
        if (AppSession.isAuthenticated()){
            if(AppSession.hasRole(Params.CLERK_ROLE) || AppSession.hasRole(Params.MANAGER_ROLE)){
                //get parameters
                String categoryId = request.getParameter("category");
                String productId = request.getParameter("product");

                //find category by id
                Category category = new Category();
                category.setCategoryId(categoryId);
                CategoryService categoryService = new CategoryService();
                categoryService.findCategroyById(category);

                //find product by id
                Product product = new Product();
                product.setProductId(productId);
                ProductService productService = new ProductService();
                productService.findProductByID(product);

                //delete relation
                boolean result = productService.deleteRelation(product, category);

                if (result){
                    redirect("frontservlet?command=AdminCategory");
                }else{
                    request.setAttribute("errMsg", "Delete relation fail.");
                    forward("/jsp/error.jsp");
                }
            }
        }else{
            redirect("frontservlet?command=ForwardAdminLogin");
        }
    }
}
