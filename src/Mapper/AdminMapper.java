package Mapper;

import Domain.Admin;
import Domain.DomainObject;
import Util.DBConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: CoffeeWeb
 * @description:
 * @author: DennyLee
 * @create: 2019-09-02 21:49
 **/
public class AdminMapper extends DataMapper {
    @Override
    public boolean insert(DomainObject domainObject) throws Exception {
        Admin admin = (Admin) domainObject;
        String insertAdmin = "INSERT INTO public.admin " +
                "(admin_id, admin_username, admin_email,admin_firstname,admin_lastname, " +
                "admin_password, department_id) VALUES (?,?,?,?,?,?,?);";
        int result = 0;

        PreparedStatement preparedStatement = DBConnection.prepare(insertAdmin);
        preparedStatement.setString(1, admin.getAdminId());
        preparedStatement.setString(2, admin.getAdminUsername());
        preparedStatement.setString(3, admin.getAdminEmail());
        preparedStatement.setString(4, admin.getAdminFname());
        preparedStatement.setString(5, admin.getAdminLname());
        preparedStatement.setString(6, admin.getAdminPassword());
        preparedStatement.setInt(7, admin.getDepartmentId());
        result = preparedStatement.executeUpdate();
        DBConnection.close(preparedStatement);

        return result != 0;
    }

    @Override
    public boolean delete(DomainObject domainObject) throws Exception {
        Admin admin = (Admin) domainObject;
        String deleteAdminById = "DELETE FROM public.admin WHERE admin_id = ?";
        int result = 0;

        PreparedStatement preparedStatement = DBConnection.prepare(deleteAdminById);
        preparedStatement.setString(1, admin.getAdminId());

        result = preparedStatement.executeUpdate();
        DBConnection.close(preparedStatement);

        return result != 0;
    }

    @Override
    public boolean update(DomainObject domainObject) throws Exception {
        Admin admin = (Admin) domainObject;
        int result = 0;
        String updateAdminById = "UPDATE public.admin SET admin_username, admin_email," +
                "admin_firstname,admin_lastname,admin_password, department_id VALUES (?,?,?,?,?,?)";
        PreparedStatement preparedStatement = DBConnection.prepare(updateAdminById);
        preparedStatement.setString(1, admin.getAdminUsername());
        preparedStatement.setString(2, admin.getAdminEmail());
        preparedStatement.setString(3, admin.getAdminFname());
        preparedStatement.setString(4, admin.getAdminLname());
        preparedStatement.setString(5, admin.getAdminPassword());
        preparedStatement.setInt(6, admin.getDepartmentId());

        result = preparedStatement.executeUpdate();
        DBConnection.close(preparedStatement);
        return result != 0;
    }

    public List<Admin> findAdminById(Admin admin) {
        String findUserById = "SELECT * From public.admin WHERE admin_id = ?";
        List<Admin> result = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = DBConnection.prepare(findUserById);
            preparedStatement.setString(1, admin.getAdminId());
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Admin admin1 = new Admin();
                admin1.setAdminId(resultSet.getString(1));
                admin1.setAdminUsername(resultSet.getString(2));
                admin1.setAdminEmail(resultSet.getString(3));
                admin1.setAdminFname(resultSet.getString(4));
                admin1.setAdminLname(resultSet.getString(5));
                admin1.setAdminPassword(resultSet.getString(6));
                admin1.setDepartmentId(resultSet.getInt(7));
                result.add(admin1);
                DBConnection.close(preparedStatement);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
