package mapper;

import domain.Cart;
import domain.DomainObject;
import domain.User;
import util.DBConnection;
import util.IdentityMap;

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
    public boolean insert(DomainObject domainObject) throws Exception {
        User user = (User) domainObject;
        String insertUser = "INSERT INTO public.user " +
                "(user_id, user_firstname, user_lastname,username,user_password, birthday, " +
                "user_email, user_address) VALUES (?,?,?,?,?,?,?,?);";
        int result = 0;

        PreparedStatement preparedStatement = DBConnection.prepare(insertUser);
        preparedStatement.setString(1, user.getId());
        preparedStatement.setString(2, user.getuFname());
        preparedStatement.setString(3, user.getuLname());
        preparedStatement.setString(4, user.getUsername());
        preparedStatement.setString(5, user.getuPassword());
        preparedStatement.setTimestamp(6, new Timestamp(user.getBirthday().getTime()));
        preparedStatement.setString(7, user.getUserEmail());
        preparedStatement.setString(8, user.getAddress());

        result = preparedStatement.executeUpdate();

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

        PreparedStatement preparedStatement = DBConnection.prepare(deleteAdminById);
        preparedStatement.setString(1, user.getId());

        result = preparedStatement.executeUpdate();
        DBConnection.close(preparedStatement);

        return result != 0;
    }

    @Override
    public boolean update(DomainObject domainObject) throws Exception {
        User user = (User) domainObject;
        int result = 0;
        String updateUserById = "UPDATE public.user SET user_firstname=?, user_lastname=?," +
                "username=?, user_password=?, birthday=?, user_email=?, user_address=?" +
                "WHERE user_id = ?";
        PreparedStatement preparedStatement = DBConnection.prepare(updateUserById);
        preparedStatement.setString(1, user.getuFname());
        preparedStatement.setString(2, user.getuLname());
        preparedStatement.setString(3, user.getUsername());
        preparedStatement.setString(4, user.getuPassword());
        preparedStatement.setTimestamp(5, new Timestamp(user.getBirthday().getTime()));
        preparedStatement.setString(6, user.getUserEmail());
        preparedStatement.setString(7, user.getAddress());
        preparedStatement.setString(8, user.getId());
        result = preparedStatement.executeUpdate();
        DBConnection.close(preparedStatement);
        return result != 0;
    }

    public User findUserById(User user) throws Exception {
        String findUserById = "SELECT * From public.user WHERE user_id = ?";
        PreparedStatement preparedStatement = DBConnection.prepare(findUserById);
        preparedStatement.setString(1, user.getId());
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            User result = new User();
            IdentityMap<User> identityMap = IdentityMap.getInstance(result);

            result.setUserId(resultSet.getString(1));
            result.setuFname(resultSet.getString(2));
            result.setuLname(resultSet.getString(3));
            result.setUsername(resultSet.getString(4));
            result.setuPassword(resultSet.getString(5));
            result.setBirthday(resultSet.getTimestamp(6));
            result.setUserEmail(resultSet.getString(7));
            result.setAddress(resultSet.getString(8));

            identityMap.put(result.getId(), result);
            DBConnection.close(preparedStatement);

            return result;
        } else {
            return null;
        }
    }

    public User findUserByName(User user) {
        String findUserById = "SELECT * From public.user WHERE username = ?";
        try {
            PreparedStatement preparedStatement = DBConnection.prepare(findUserById);
            preparedStatement.setString(1, user.getUsername());
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                User result = new User();
                IdentityMap<User> identityMap = IdentityMap.getInstance(result);

                result.setUserId(resultSet.getString(1));
                result.setuFname(resultSet.getString(2));
                result.setuLname(resultSet.getString(3));
                result.setUsername(resultSet.getString(4));
                result.setuPassword(resultSet.getString(5));
                result.setBirthday(resultSet.getTimestamp(6));
                result.setUserEmail(resultSet.getString(7));
                result.setAddress(resultSet.getString(8));

                identityMap.put(result.getId(), result);
                DBConnection.close(preparedStatement);

                return result;
            }else{
                System.out.println("Cannot find user by name" + user.getUsername());
                return null;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
