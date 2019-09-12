package servlet;

import domain.Category;
import service.CategoryService;

import javax.servlet.ServletException;
import java.io.IOException;

public class AdminEditCategoryCommand extends FrontCommand {
    @Override
    public void process() throws ServletException, IOException {

        // get modify category id
        // cate service findById
        // update
        String id = request.getParameter("category");
        String name = request.getParameter("categoryName");
        System.out.println(id);
        System.out.println(name);
        CategoryService categoryService = new CategoryService();
        Category category = new Category();
        category.setCategoryId(id);

        category = categoryService.findCategroyById(category);

        category.setCategoryName(name);
        boolean result = categoryService.updateCategory(category);
        //prompt to front?
        if (result){
            redirect("frontservlet?command=AdminCategory");
        }else {
            //todo:foward to error page;
            System.out.println("Edit category fail.");
        }
    }
}
