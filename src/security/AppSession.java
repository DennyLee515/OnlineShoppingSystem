package security;

import domain.User;
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

    public static void  init(User user){
        SecurityUtils.getSubject().getSession().setAttribute(Params.USER_ATTRIBUTE_NAME,user);
    }

    public static User getUser(){
        return (User)SecurityUtils.getSubject().getSession().getAttribute(Params.USER_ATTRIBUTE_NAME);
    }

    public static void logout(){
         SecurityUtils.getSubject().logout();
    }
}
