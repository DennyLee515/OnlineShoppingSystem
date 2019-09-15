package servlet;

import domain.Category;
import service.CategoryService;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.List;

/**
 * view all categories
 */
public class ViewCategoryCommand extends FrontCommand{

    @Override
    public void process() throws ServletException, IOException {
        //get categories
        CategoryService categoryService = new CategoryService();
        List<Category> category = categoryService.getAllCategories();
        //return result
        if (category.isEmpty()){
            request.setAttribute("errMsg", "No category exists");
            forward("/jsp/error.jsp");
        }
        request.setAttribute("categories", category);
        forward("/jsp/viewCategory.jsp");
    }
}
