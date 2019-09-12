package servlet;

import servlet.FrontCommand;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * @program: CoffeeWeb
 * @description:
 * @author: DennyLee
 * @create: 2019-09-12 15:46
 **/
public class AdminCategoryManageCommand extends FrontCommand {
    @Override
    public void process() throws ServletException, IOException {
        forward("/jsp/admin/categoryManage.jsp");
    }
}
