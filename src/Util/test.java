package Util;

import Domain.Admin;
import Domain.User;
import Mapper.AdminMapper;
import Mapper.DataMapper;
import Mapper.UserMapper;
import sun.awt.windows.WPrinterJob;

import java.util.Date;
import java.util.List;

/**
 * @program: CoffeeWeb
 * @description:
 * @author: DennyLee
 * @create: 2019-09-02 21:25
 **/
public class test {
    public static void main(String args[]){
//        Date date = new Date();
//        User user = new User(2,"firstname","lastname","username","password",date,"email","address");
//        UserMapper userMapper = new UserMapper();
//        userMapper.insert(user);
        Admin admin = new Admin("username0","email0","first1","last1","pw1",1);
        AdminMapper adminMapper = new AdminMapper();
        adminMapper.insert(admin);


//        AdminMapper adminMapper1 = new AdminMapper();
//        List<Admin> result = adminMapper1.findUserById(2);
//        System.out.println(result.get(0).getAdminLname());
    }
}
