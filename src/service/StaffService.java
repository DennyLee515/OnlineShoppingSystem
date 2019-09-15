package service;

import domain.Staff;
import mapper.StaffMapper;
import util.IdentityMap;
import util.UnitOfWork;

/**
 * @program: CoffeeWeb
 * @description: Staff service to manager logic method related to staff
 * @author: DennyLee
 * @create: 2019-09-14 00:54
 **/
public class StaffService {
    private StaffMapper staffMapper;

    public StaffService() {
        staffMapper = new StaffMapper();
    }

    /**
     * create a new staff, apply unit of work
     *
     * @param staff Staff
     * @return result
     */
    public boolean insert(Staff staff) {
        UnitOfWork.newCurrent();
        UnitOfWork.getCurrent().registerNew(staff);
        return UnitOfWork.getCurrent().commit();
    }

    /**
     * update a staff, apply unit of work
     *
     * @param staff Staff
     * @return result
     */
    public boolean update(Staff staff) {
        UnitOfWork.newCurrent();
        UnitOfWork.getCurrent().registerDirty(staff);
        return UnitOfWork.getCurrent().commit();
    }

    /**
     * delete a staff, apply unit of work
     *
     * @param staff Staff
     * @return result
     */
    public boolean delete(Staff staff) {
        UnitOfWork.newCurrent();
        UnitOfWork.getCurrent().registerDelete(staff);
        return UnitOfWork.getCurrent().commit();
    }

    /**
     * find a staff by id, identity map applied
     * @param staff Staff
     * @return a staff object or null
     */
    public Staff findStaffById(Staff staff) {
        IdentityMap<Staff> identityMap = IdentityMap.getInstance(staff);
        Staff staffFinded = identityMap.get(staff.getId());
        if (staffFinded != null) {
            return staffFinded;
        }
        return staffMapper.findStaffById(staff);
    }
}
