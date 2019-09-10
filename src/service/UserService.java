package service;

import domain.Cart;
import domain.User;
import mapper.UserMapper;
import util.IdentityMap;

/**
 * @program: CoffeeWeb
 * @description:
 * @author: DennyLee
 * @create: 2019-09-06 22:54
 **/
public class UserService {
    private UserMapper userMapper;
    public UserService(){
        userMapper =new UserMapper();
    }

    public boolean insertUser(User user) throws Exception{
        return userMapper.insert(user);
    }

    public boolean deleteUser(){
        return false;
    }

    public boolean updateUser(){
        return false;
    }

    public User findUserById(User user) throws Exception{
        IdentityMap<User> identityMap = IdentityMap.getInstance(user);
        User userFinded = identityMap.get(user.getId());
        if (userFinded != null){
            System.out.println(userFinded.getUsername());
            return userFinded;
        }else{
            return userMapper.findUserById(user);
        }
    }

    public User findUserByName(User user) {
        try {
            return userMapper.findUserByName(user);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


}
