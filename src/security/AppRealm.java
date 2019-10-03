package security;

import domain.Clerk;
import domain.Manager;
import domain.Staff;
import domain.User;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.subject.PrincipalCollection;
import service.StaffService;
import service.UserService;
import util.Params;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: CoffeeWeb
 * @description:
 * @author: DennyLee
 * @create: 2019-10-01 22:14
 **/
public class AppRealm extends JdbcRealm {
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
        final String username = usernamePasswordToken.getUsername();

        User user = new User();
        user.setUsername(username);
        user = new UserService().findUserByName(user);
        Staff manager = new Manager();
        manager.setStaffUName(username);
        manager = new StaffService().findStaffByName(manager);
        Staff clerk = new Clerk();
        clerk.setStaffUName(username);
        clerk = new StaffService().findStaffByName(clerk);

        if (user != null) {
            return new SimpleAuthenticationInfo(user.getId(), user.getuPassword(), getName());
        }
        return null;
    }

    @Override
    protected AuthorizationInfo getAuthorizationInfo(PrincipalCollection principals) {
        Set<String> roles = new HashSet<>();
        if (principals.isEmpty()) {
            System.out.println("Given principals to authorize are empty");
            return null;
        }

        String id = (String) principals.getPrimaryPrincipal();
        User user = new User();
        user.setUserId(id);
        user = new UserService().findUserById(user);
        Staff manager = new Manager();
        manager.setStaffId(id);
        manager = new StaffService().findStaffById(manager);
        Staff clerk = new Clerk();
        clerk.setStaffId(id);
        clerk = new StaffService().findStaffById(clerk);
        if (user != null) {
            roles.add(Params.CUSTOMER_ROLE);
            return new SimpleAuthorizationInfo(roles);
        } else if (manager != null) {
            roles.add(Params.MANAGER_ROLE);
            return new SimpleAuthorizationInfo(roles);
        } else if (clerk != null) {
            roles.add(Params.CLERK_ROLE);
            return new SimpleAuthorizationInfo(roles);
        } else {
            System.out.println("No account found for user with id " + id);
            return null;
        }
    }
}
