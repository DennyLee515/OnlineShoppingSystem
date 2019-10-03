package servlet;

import domain.Manager;
import domain.Staff;
import service.StaffService;
import servlet.FrontCommand;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @program: CoffeeWeb
 * @description: admin login
 * @author: DennyLee
 * @create: 2019-09-12 14:42
 **/
public class AdminLoginCommand extends FrontCommand {
    @Override
    public void process() throws ServletException, IOException {
        HttpSession session = request.getSession();
        Manager manager = new Manager();
        manager.setStaffUName("manager");
        StaffService staffService = new StaffService();
        manager = (Manager)staffService.findStaffById(manager);
        session.setAttribute("admin",manager);
        forward("/jsp/admin/adminHome.jsp");
    }
}
