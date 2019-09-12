package servlet;

import domain.Category;
import service.CategoryService;
import servlet.FrontCommand;

import javax.servlet.ServletException;
import java.io.IOException;

public class AdminEditCategoryCommand extends FrontCommand {
    @Override
    public void process() throws ServletException, IOException {

        // get modify category id
        // cate service findById
        // update
        String id = request.getParameter("mod_category");
        CategoryService categoryService = new CategoryService();
        Category category = new Category();
        category.setCategoryId(id);
        try {
            category = categoryService.getCategroyById(category);
            categoryService.updateCategory(category);
            //prompt to front?

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
