package servlet;

import domain.Clerk;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import security.AppSession;
import service.StaffService;
import util.Params;

import javax.servlet.ServletException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: CoffeeWeb
 * @description:
 * @author: DennyLee
 * @create: 2019-10-02 22:56
 **/
public class AdminAddStaffCommand extends FrontCommand {
    @Override
    public void process() throws ServletException, IOException {
        if (AppSession.isAuthenticated()){
            if(AppSession.hasRole(Params.CLERK_ROLE) || AppSession.hasRole(Params.MANAGER_ROLE)){
                String firstname = request.getParameter("firstName");
                String lastname = request.getParameter("lastName");
                String username = request.getParameter("username");
                String password = request.getParameter("password");

                Date startDate = null ,endDate = null;
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                try {
                    startDate = simpleDateFormat.parse(request.getParameter("startDate"));
                    endDate = simpleDateFormat.parse(request.getParameter("endDate"));
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                ByteSource salt = ByteSource.Util.bytes(username);
                String encryptedPassword = new SimpleHash("MD5", password, salt, 1024).toHex();

                Clerk clerk = new Clerk(username,encryptedPassword,firstname,lastname,startDate,endDate);
                StaffService staffService = new StaffService();
                staffService.insert(clerk);

                redirect("frontservlet?command=ForwardAdminHome");
            }
        }else{
            redirect("frontservlet?command=ForwardAdminLogin");
        }
    }
}
