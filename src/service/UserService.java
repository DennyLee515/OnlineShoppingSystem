package service;

import domain.User;
import mapper.DataMapper;
import mapper.UserMapper;
import util.IdentityMap;
import util.UnitOfWork;

/**
 * @program: CoffeeWeb
 * @description: user  service to manager logic method related to user
 * @author: DennyLee
 * @create: 2019-09-06 22:54
 **/
public class UserService {
    //private userMapper object;
    private UserMapper userMapper;

    //constructor
    public UserService() {
        userMapper = new UserMapper();
    }

    /**
     * create a user, apply unit of work
     *
     * @param user User
     * @return result
     */
    public boolean insertUser(User user) {
        UnitOfWork.newCurrent();
        UnitOfWork.getCurrent().registerNew(user);
        return UnitOfWork.getCurrent().commit();
    }

    /**
     * delete a user, apply unit of work
     *
     * @param user User
     * @return result
     */
    public boolean deleteUser(User user) {
        UnitOfWork.newCurrent();
        UnitOfWork.getCurrent().registerDelete(user);
        return UnitOfWork.getCurrent().commit();
    }

    /**
     * update a user, apply unit of work
     *
     * @param user User
     * @return result
     */
    public boolean updateUser(User user) {
        UnitOfWork.newCurrent();
        UnitOfWork.getCurrent().registerDirty(user);
        return UnitOfWork.getCurrent().commit();
    }

    /**
     * find a user by user id
     *
     * @param user User
     * @return a user object or null
     */
    public User findUserById(User user) {
        IdentityMap<User> identityMap = IdentityMap.getInstance(user);
        User userFinded = identityMap.get(user.getId());
        if (userFinded != null) {
            return userFinded;
        } else {
            return userMapper.findUserById(user);
        }
    }

    /**
     * find a user by username
     *
     * @param user User
     * @return a user object or null
     */
    public User findUserByName(User user) {
        try {
            return userMapper.findUserByName(user);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


}
