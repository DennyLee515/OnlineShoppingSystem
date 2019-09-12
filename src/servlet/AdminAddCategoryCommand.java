package servlet;

import domain.Category;
import service.CategoryService;
import servlet.FrontCommand;

import javax.servlet.ServletException;
import java.io.IOException;

public class AdminAddCategoryCommand extends FrontCommand {

    @Override
    public void process() throws ServletException, IOException {
        String categoryName = request.getParameter("add_category");
        Category category = new Category();
        category.setCategoryName(categoryName);

        CategoryService categoryService = new CategoryService();
        categoryService.insertCategory(category);

        //return add category result to front-end ?

    }

}
