package servlet;

import domain.Category;
import service.CategoryService;

import javax.servlet.ServletException;
import java.io.IOException;

public class AdminEditCategoryCommand extends FrontCommand {
    @Override
    public void process() throws ServletException, IOException {

        // get modify category id
        String id = request.getParameter("category");
        String name = request.getParameter("categoryName");

        // category service findById
        CategoryService categoryService = new CategoryService();
        Category category = new Category();
        category.setCategoryId(id);
        category = categoryService.findCategroyById(category);
        category.setCategoryName(name);

        // update
        boolean result = categoryService.updateCategory(category);
        //return result
        if (result){
            redirect("frontservlet?command=AdminCategory");
        }else {
            request.setAttribute("errMsg", "Edit category fail.");
            forward("/jsp/error.jsp");
        }
    }
}
