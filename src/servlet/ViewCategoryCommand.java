package servlet;

import domain.Category;
import service.CategoryService;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.List;

public class ViewCategoryCommand extends FrontCommand{

    @Override
    public void process() throws ServletException, IOException {
        CategoryService categoryService = new CategoryService();
        List<Category> category = categoryService.getAllCategories();
        request.setAttribute("categories", category);
        forward("/jsp/viewCategory.jsp");
    }
}
