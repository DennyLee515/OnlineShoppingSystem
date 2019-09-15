package mapper;

import domain.Clerk;
import domain.DomainObject;
import domain.TimeRange;
import util.DBConnection;
import util.IdentityMap;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;

/**
 * @program: CoffeeWeb
 * @description: Data mapper for clerk
 * @author: DennyLee
 * @create: 2019-09-13 22:56
 **/
public class ClerkMapper extends DataMapper {
    /**
     * insert a clerk into clerk table
     *
     * @param domainObject Clerk
     * @return result
     */
    @Override
    public boolean insert(DomainObject domainObject) {
        Clerk clerk = (Clerk) domainObject;
        String insertClerk = "INSERT INTO public.clerk " +
                "(clerk_id,clerk_username,clerk_password,clerk_fname,clerk_lname,start_date," +
                "end_date) " +
                "VALUES(?,?,?,?,?,?,?)";
        int result = 0;
        try {
            PreparedStatement preparedStatement = DBConnection.prepare(insertClerk);
            preparedStatement.setString(1, clerk.getId());
            preparedStatement.setString(2, clerk.getStaffUName());
            preparedStatement.setString(3, clerk.getStaffPassword());
            preparedStatement.setString(4, clerk.getClerkFirstname());
            preparedStatement.setString(5, clerk.getClerkLastName());
            preparedStatement.setTimestamp(6,
                    new Timestamp(clerk.getTimeRange().getStartDate().getTime()));
            preparedStatement.setTimestamp(7,
                    new Timestamp(clerk.getTimeRange().getEndDate().getTime()));
            result = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result != 0;
    }

    /**
     * delete a clerk from clerk table
     *
     * @param domainObject Clerk
     * @return result
     */
    @Override
    public boolean delete(DomainObject domainObject) {
        Clerk clerk = (Clerk) domainObject;
        String deleteClerkById = "DELETE FROM public.clerk WHERE clerk_id = ?";
        int result = 0;
        try {
            PreparedStatement preparedStatement = DBConnection.prepare(deleteClerkById);
            preparedStatement.setString(1, clerk.getId());

            result = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result != 0;
    }

    /**
     * update a clerk from clerk table
     *
     * @param domainObject Clerk
     * @return result
     */
    @Override
    public boolean update(DomainObject domainObject) {
        Clerk clerk = (Clerk) domainObject;
        String updateClerkById = "UPDATE public.clerk SET " +
                "clerk_username = ?, clerk_password = ?, clerk_fname = ?, clerk_lname = ?, " +
                "start_date = ?, end_date=? WHERE clerk_id = ?";
        int result = 0;
        try {
            PreparedStatement preparedStatement = DBConnection.prepare(updateClerkById);
            preparedStatement.setString(1, clerk.getStaffUName());
            preparedStatement.setString(2, clerk.getStaffPassword());
            preparedStatement.setString(3, clerk.getClerkFirstname());
            preparedStatement.setString(4, clerk.getClerkLastName());
            preparedStatement.setTimestamp(5,
                    new Timestamp(clerk.getTimeRange().getStartDate().getTime()));
            preparedStatement.setTimestamp(6,
                    new Timestamp(clerk.getTimeRange().getEndDate().getTime()));
            preparedStatement.setString(7, clerk.getId());

            result = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result != 0;
    }

    /**
     * find a clerk from table clerk by id
     *
     * @param domainObject Clerk
     * @return Clerk object or null
     */
    public Clerk findClerkById(DomainObject domainObject) {
        Clerk clerk = (Clerk) domainObject;
        String findClerkById = "SELECT * FROM public.clerk WHERE clerk_id = ?";

        try {
            PreparedStatement preparedStatement = DBConnection.prepare(findClerkById);
            preparedStatement.setString(1, clerk.getId());
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                Clerk clerk1 = new Clerk();
                IdentityMap<Clerk> identityMap = IdentityMap.getInstance(clerk1);

                clerk1.setStaffId(resultSet.getString(1));
                clerk1.setStaffUName(resultSet.getString(2));
                clerk1.setStaffPassword(resultSet.getString(3));
                clerk1.setClerkFirstname(resultSet.getString(4));
                clerk1.setClerkLastName(resultSet.getString(5));
                clerk1.setTimeRange(new TimeRange(resultSet.getTimestamp(6),
                        resultSet.getTimestamp(7)));
                identityMap.put(clerk1.getId(), clerk1);

                DBConnection.close(preparedStatement);
                return clerk1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
