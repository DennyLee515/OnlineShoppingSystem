package Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program: CoffeeWeb
 * @description:
 * @author: DennyLee
 * @create: 2019-09-05 23:53
 **/
@WebServlet("/frontservlet")
public class FrontServlet extends HttpServlet {
    private static final long serialVersioinUID = 1L;

    public FrontServlet(){
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        FrontCommand command = getCommand(req);
        command.init(getServletContext(),req,resp);
        command.process();
    }

    private FrontCommand getCommand(HttpServletRequest req){
        try{
            return (FrontCommand) getCommandClass(req).newInstance();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    private Class getCommandClass(HttpServletRequest req){
        Class result;

        final String commandClassName = "Servlet." + (String)req.getParameter("command")+ "Command";

        System.out.println(commandClassName);
        try {
            result = Class.forName(commandClassName);
            System.out.println(commandClassName);
        }catch (ClassNotFoundException e){
            e.printStackTrace();
            result = null;
        }
        return result;
    }
}
