package servlet;

import domain.Category;
import service.CategoryService;
import servlet.FrontCommand;

import javax.servlet.ServletException;
import java.io.IOException;

public class AdminAddCategoryCommand extends FrontCommand {

    @Override
    public void process() throws ServletException, IOException {
        String categoryName = request.getParameter("categoryName");
        Category category = new Category(categoryName);

        CategoryService categoryService = new CategoryService();
        boolean result = categoryService.insertCategory(category);

        //return add category result to front-end ?
        if (result){
            redirect("frontservlet?command=AdminCategory");
        }else {
            //todo:foward to error page
            System.out.println("Add category fail.");
        }
    }

}
