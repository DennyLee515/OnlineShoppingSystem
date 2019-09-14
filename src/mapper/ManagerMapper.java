package mapper;

import domain.DomainObject;
import domain.Manager;
import util.DBConnection;
import util.IdentityMap;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @program: CoffeeWeb
 * @description:
 * @author: DennyLee
 * @create: 2019-09-13 23:59
 **/
public class ManagerMapper extends DataMapper {
    @Override
    public boolean insert(DomainObject domainObject) {
        Manager manager = (Manager)domainObject;
        String insertManager = "INSERT INTO public.manager (manager_id, manager_username, " +
                "manager_password, manager_email) VALUES" +
                "(?,?,?,?)";
        int result = 0;
        try {
            PreparedStatement preparedStatement = DBConnection.prepare(insertManager);
            preparedStatement.setString(1,manager.getId());
            preparedStatement.setString(2,manager.getStaffUName());
            preparedStatement.setString(3,manager.getStaffPassword());
            preparedStatement.setString(4,manager.getManagerEmail());
            result = preparedStatement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
        return result!=0;
    }

    @Override
    public boolean delete(DomainObject domainObject) {
        Manager manager = (Manager)domainObject;
        String deleteManagerById = "DELETE FROM public.manager WHERE manager_id = ?";
        int result = 0;
        try {
            PreparedStatement preparedStatement = DBConnection.prepare(deleteManagerById);
            result = preparedStatement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
        return result!=0;
    }

    @Override
    public boolean update(DomainObject domainObject) {
        Manager manager = (Manager)domainObject;
        String updateManagerById = "UPDATE public.manager SET manager_username = ?, " +
                "manager_password = ?, manager_email = ? WHERE manager_id = ?";
        int result = 0;
        try{
            PreparedStatement preparedStatement = DBConnection.prepare(updateManagerById);
            preparedStatement.setString(1,manager.getStaffUName());
            preparedStatement.setString(2,manager.getStaffPassword());
            preparedStatement.setString(3,manager.getManagerEmail());
            preparedStatement.setString(4,manager.getId());

            result = preparedStatement.executeUpdate();

        }catch (Exception e){
            e.printStackTrace();
        }
        return result != 0;
    }

    public Manager findManagerById(DomainObject domainObject){
        Manager manager = (Manager)domainObject ;
        String findManagerById = "SELECT * FROM public.manager WHERE manager_id = ?";
        try {
            PreparedStatement preparedStatement = DBConnection.prepare(findManagerById);
            preparedStatement.setString(1,manager.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                Manager manager1 =new Manager();
                IdentityMap<Manager> identityMap = IdentityMap.getInstance(manager1);

                manager1.setStaffId(resultSet.getString(1));
                manager1.setStaffUName(resultSet.getString(2));
                manager1.setStaffPassword(resultSet.getString(3));
                manager1.setManagerEmail(resultSet.getString(4));

                identityMap.put(manager1.getId(),manager1);
                return manager1;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
