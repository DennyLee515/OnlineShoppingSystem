package servlet;

import domain.Category;
import service.CategoryService;
import servlet.FrontCommand;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.List;

/**
 * @program: CoffeeWeb
 * @description:
 * @author: DennyLee
 * @create: 2019-09-12 15:46
 **/
public class AdminCategoryCommand extends FrontCommand {
    @Override
    public void process() throws ServletException, IOException {
        CategoryService categoryService = new CategoryService();
        List<Category> category = categoryService.getAllCategories();
        request.setAttribute("categories", category);
        forward("/jsp/admin/categoryManage.jsp");
    }
}
