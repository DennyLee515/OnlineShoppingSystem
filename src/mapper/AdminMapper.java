package mapper;

import domain.Admin;
import domain.DomainObject;
import util.DBConnection;
import util.IdentityMap;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: CoffeeWeb
 * @description: Data mapper for admain object
 * @author: DennyLee
 * @create: 2019-09-02 21:49
 **/
public class AdminMapper extends DataMapper {
    /**
     * insert an admin to table admin
     *
     * @param domainObject
     * @return boolean
     * @throws Exception
     */
    @Override
    public boolean insert(DomainObject domainObject){
        Admin admin = (Admin) domainObject;
        String insertAdmin = "INSERT INTO public.admin " +
                "(admin_id, admin_username, admin_email,admin_firstname,admin_lastname, " +
                "admin_password, department_id) VALUES (?,?,?,?,?,?,?);";
        int result = 0;
        try{
            PreparedStatement preparedStatement = DBConnection.prepare(insertAdmin);
            preparedStatement.setString(1, admin.getId());
            preparedStatement.setString(2, admin.getAdminUsername());
            preparedStatement.setString(3, admin.getAdminEmail());
            preparedStatement.setString(4, admin.getAdminFname());
            preparedStatement.setString(5, admin.getAdminLname());
            preparedStatement.setString(6, admin.getAdminPassword());
            preparedStatement.setInt(7, admin.getDepartmentId());
            result = preparedStatement.executeUpdate();
            DBConnection.close(preparedStatement);
            return result
        }catch (Exception e){
            e.printStackTrace();
        }
        return result != 0;
    }

    /**
     * delete an admin from admin table by id
     *
     * @param domainObject
     * @return boolean
     * @throws Exception
     */
    @Override
    public boolean delete(DomainObject domainObject{
        Admin admin = (Admin) domainObject;
        String deleteAdminById = "DELETE FROM public.admin WHERE admin_id = ?";
        int result = 0;

        try{

        }catch (Exception e){
            e.printStackTrace();
        }
        PreparedStatement preparedStatement = DBConnection.prepare(deleteAdminById);
        preparedStatement.setString(1, admin.getId());

        result = preparedStatement.executeUpdate();
        DBConnection.close(preparedStatement);

        return result != 0;
    }

    /**
     * update an admin from table admin
     *
     * @param domainObject
     * @return boolean
     * @throws Exception
     */
    @Override
    public boolean update(DomainObject domainObject) {
        Admin admin = (Admin) domainObject;
        int result = 0;
        String updateAdminById = "UPDATE public.admin SET admin_username, admin_email," +
                "admin_firstname,admin_lastname,admin_password, department_id VALUES (?,?,?,?,?,?)";
        try{

        }catch (Exception e){
            e.printStackTrace();
        }
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

    /**
     * find an admin by id
     *
     * @param domainObject
     * @return if finded,return an admin object, if not, return null
     * @throws Exception
     */
    public Admin findAdminById(DomainObject domainObject) {
        Admin admin = (Admin) domainObject;
        String findUserById = "SELECT * From public.admin WHERE admin_id = ?";
        try{

        }catch (Exception e){
            e.printStackTrace();
        }
        PreparedStatement preparedStatement = DBConnection.prepare(findUserById);
        preparedStatement.setString(1, admin.getId());
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            Admin result = new Admin();
            IdentityMap<Admin> identityMap = IdentityMap.getInstance(result);
            result.setAdminId(resultSet.getString(1));
            result.setAdminUsername(resultSet.getString(2));
            result.setAdminEmail(resultSet.getString(3));
            result.setAdminFname(resultSet.getString(4));
            result.setAdminLname(resultSet.getString(5));
            result.setAdminPassword(resultSet.getString(6));
            result.setDepartmentId(resultSet.getInt(7));

            identityMap.put(result.getId(), result);
            DBConnection.close(preparedStatement);
            return result;
        } else {
            DBConnection.close(preparedStatement);
            return null;
        }
    }
}
