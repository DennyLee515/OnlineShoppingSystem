package servlet;

import domain.Category;
import domain.Product;
import service.CategoryService;
import service.ProductService;
import servlet.FrontCommand;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.List;

/**
 * handle requests to manage categories by create, delete and edit
 */
public class AdminManageCategoryCommand extends FrontCommand {

    @Override
    public void process() throws ServletException, IOException {
        String method = request.getParameter("method");
        String categoryId;
        Category category;
        CategoryService categoryService;

        switch (method) {
            case "create":
                forward("/jsp/admin/newCategory.jsp");
                break;
            case "delete":
                categoryId = request.getParameter("category");
                category = new Category();
                category.setCategoryId(categoryId);
                categoryService = new CategoryService();
                boolean result = categoryService.deleteCategory(category);
                if (result){
                    redirect("frontservlet?command=AdminCategory");
                }else{
                    request.setAttribute("errMsg", "Delete category failed");
                    forward("/jsp/error.jsp");
                }
                break;
            case "edit":
                //edit a category
                categoryId = request.getParameter("category");
                category = new Category();
                category.setCategoryId(categoryId);
                categoryService = new CategoryService();
                category = categoryService.findCategroyById(category);
                request.setAttribute("category", category);
                forward("/jsp/admin/editCategory.jsp");
                break;
            case"view":
                //find all products in a category
                categoryId = request.getParameter("category");
                category = new Category();
                category.setCategoryId(categoryId);
                categoryService = new CategoryService();
                category = categoryService.findCategroyById(category);
                ProductService productService = new ProductService();
                List<Product> products = productService.findProductByCategory(category);
                request.setAttribute("category",category);
                request.setAttribute("products",products);
                forward("/jsp/admin/viewCategoryProducts.jsp");
                break;
            default:
                System.out.println("Wrong category manage method input");
        }

    }
}