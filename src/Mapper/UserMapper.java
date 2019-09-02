package Mapper;

import Domain.DomainObject;
import Domain.User;
import Util.DBConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: CoffeeWeb
 * @description:
 * @author: DennyLee
 * @create: 2019-09-02 00:27
 **/
public class UserMapper extends DataMapper {
    @Override
    public boolean insert(DomainObject domainObject) {
        User user = (User) domainObject;
        String insertUser = "INSERT INTO public.user " +
                "(user_id, user_firstname, user_lastname,username,user_password, birthday, " +
                "user_email, user_address) VALUES (?,?,?,?,?,?,?,?);";
        int result = 0;
        try {
            PreparedStatement preparedStatement = DBConnection.prepare(insertUser);
            preparedStatement.setString(1, user.getUserId());
            preparedStatement.setString(2, user.getuFname());
            preparedStatement.setString(3, user.getuLname());
            preparedStatement.setString(4, user.getUsername());
            preparedStatement.setString(5, user.getuPassword());
            preparedStatement.setTimestamp(6, new Timestamp(user.getBirthday().getTime()));
            preparedStatement.setString(7, user.getUserEmail());
            preparedStatement.setString(8, user.getAddress());

            result = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (result == 0)
            return false;
        else
            return true;
    }

    @Override
    public boolean delete(DomainObject domainObject) throws Exception {
        User user = (User) domainObject;
        String deleteAdminById = "DELETE FROM public.user WHERE user_id = ?";
        int result = 0;
        try {
            PreparedStatement preparedStatement = DBConnection.prepare(deleteAdminById);
            preparedStatement.setString(1, user.getUserId());

            result = preparedStatement.executeUpdate();
            DBConnection.close(preparedStatement);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result != 0;
    }

    @Override
    public boolean update(DomainObject domainObject) throws Exception {
        User user = (User) domainObject;
        int result = 0;
        String updateUserById = "UPDATE public.user SET user_firstname=?, user_lastname=?," +
                "username=?, user_password=?, birthday=?, user_email=?, user_address=? " +
                "WHERE user_id = ?";
        PreparedStatement preparedStatement = DBConnection.prepare(updateUserById);
        preparedStatement.setString(1, user.getuFname());
        preparedStatement.setString(2, user.getuLname());
        preparedStatement.setString(3, user.getUsername());
        preparedStatement.setString(4, user.getuPassword());
        preparedStatement.setTimestamp(5, new Timestamp(user.getBirthday().getTime()));
        preparedStatement.setString(6, user.getUserEmail());
        preparedStatement.setString(7, user.getAddress());
        preparedStatement.setString(8, user.getUserId());
        result = preparedStatement.executeUpdate();
        DBConnection.close(preparedStatement);
        return result != 0;
    }

    public List<User> findUserById(User user) {
        String findUserById = "SELECT * From public.user WHERE userId = ?";
        List<User> result = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = DBConnection.prepare(findUserById);
            preparedStatement.setString(1, user.getUserId());
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                User user1 = new User();
                user1.setUserId(resultSet.getString(1));
                user1.setuFname(resultSet.getString(2));
                user1.setuLname(resultSet.getString(3));
                user1.setUsername(resultSet.getString(4));
                user1.setuPassword(resultSet.getString(5));
                user1.setBirthday(resultSet.getTimestamp(6));
                user1.setUserEmail(resultSet.getString(7));
                user1.setAddress(resultSet.getString(8));
                result.add(user1);
                DBConnection.close(preparedStatement);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
