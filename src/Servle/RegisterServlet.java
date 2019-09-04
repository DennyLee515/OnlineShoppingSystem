package Servle;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: CoffeeWeb
 * @description:
 * @author: DennyLee
 * @create: 2019-09-03 16:04
 **/
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private  static final long serialVersionUID = 1L;

    public RegisterServlet(){
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String username = req.getParameter("username");
        String firstname = req.getParameter("firstName");
        String lastname= req.getParameter("lastName");
        String password = req.getParameter("password");

        String birth = req.getParameter("birthday");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date birthday = sdf.parse(birth);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        String email =req.getParameter("email");
        String address = req.getParameter("address");




    }
}
