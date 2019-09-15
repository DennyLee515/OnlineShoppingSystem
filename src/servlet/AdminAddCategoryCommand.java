package servlet;

import domain.Category;
import service.CategoryService;

import javax.servlet.ServletException;
import java.io.IOException;
/**
 * @program: CoffeeWeb
 * @description: add a category by admin
 * @author: DennyLee
 * @create: 2019-09-07 18:01
 **/
public class AdminAddCategoryCommand extends FrontCommand {

    @Override
    public void process() throws ServletException, IOException {
        //get parameters and create new category object
        String categoryName = request.getParameter("categoryName");
        Category category = new Category(categoryName);
        CategoryService categoryService = new CategoryService();

        //find category by name
        if (categoryService.findCategoryByName(category)!=null){
            request.setAttribute("errMsg","Category name exists.");
            forward("/jsp/error.jsp");
        }else{
            //add category
            boolean result = categoryService.newCategory(category);

            //return add category result to front-end
            if (result){
                redirect("frontservlet?command=AdminCategory");
            }else {
                request.setAttribute("errMsg","Add category failed");
                forward("/jsp/error.jsp");
            }
        }
    }

}
