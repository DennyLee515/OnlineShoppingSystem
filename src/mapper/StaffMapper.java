package mapper;

import domain.Clerk;
import domain.DomainObject;
import domain.Manager;
import domain.Staff;

/**
 * @program: CoffeeWeb
 * @description:
 * @author: DennyLee
 * @create: 2019-09-13 23:25
 **/
public class StaffMapper extends DataMapper {
    private ClerkMapper clerkMapper = new ClerkMapper();
    private ManagerMapper managerMapper = new ManagerMapper();


    @Override
    public boolean insert(DomainObject domainObject) {
        boolean result = false;
        if (domainObject instanceof Manager) {
            result = managerMapper.insert(domainObject);
        } else if (domainObject instanceof Clerk) {
            result = clerkMapper.insert(domainObject);
        }
        return result;
    }

    @Override
    public boolean delete(DomainObject domainObject) {
        String id = domainObject.getId();
        Staff staff = null;
        Manager manager = new Manager();
        manager.setStaffId(id);
        Clerk clerk = new Clerk();
        clerk.setStaffId(id);

        boolean result = false;
        if (result = clerkMapper.delete(clerk)) {
            return result;
        } else if (result = managerMapper.delete(manager)) {
            return result;
        } else {
            return result;
        }
    }

    @Override
    public boolean update(DomainObject domainObject) {
        boolean result = false;
        if (result = clerkMapper.update(domainObject)) {
            return result;
        } else if (result = clerkMapper.update(domainObject)) {
            return result;
        } else {
            return result;
        }
    }

    public Staff findStaffById(DomainObject domainObject) {
        String id = domainObject.getId();
        Staff staff = null;
        Manager manager = new Manager();
        manager.setStaffId(id);
        Clerk clerk = new Clerk();
        clerk.setStaffId(id);

        staff = managerMapper.findManagerById(manager);
        if (staff != null) {
            return staff;
        }
        staff = clerkMapper.findClerkById(clerk);
        if (staff != null) {
            return staff;
        }
        return staff;
    }
}
