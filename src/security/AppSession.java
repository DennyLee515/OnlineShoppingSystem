package security;

import domain.Customer;
import domain.Staff;
import org.apache.shiro.SecurityUtils;
import util.Params;

/**
 * @program: CoffeeWeb
 * @description:
 * @author: DennyLee
 * @create: 2019-10-01 22:21
 **/
public class AppSession {

    public static boolean hasRole(String role){
        return SecurityUtils.getSubject().hasRole(role);
    }

    public static boolean isAuthenticated(){
        return SecurityUtils.getSubject().isAuthenticated();
    }

    public static void  init(Customer customer){
        SecurityUtils.getSubject().getSession().setAttribute(Params.USER_ATTRIBUTE_NAME, customer);
    }

    public static Customer getUser(){
        return (Customer)SecurityUtils.getSubject().getSession().getAttribute(Params.USER_ATTRIBUTE_NAME);
    }

    public static void  init(Staff staff){
        SecurityUtils.getSubject().getSession().setAttribute(Params.STAFF_ATTRIBUTE_NAME,staff);
    }

    public static Staff getStaff(){
        return (Staff) SecurityUtils.getSubject().getSession().getAttribute(Params.STAFF_ATTRIBUTE_NAME);
    }

    public static void logout(){
         SecurityUtils.getSubject().logout();
    }

    public static String getSessionId(){
        return SecurityUtils.getSubject().getSession().getId().toString();
    }
}
