package service;

import domain.Staff;
import mapper.StaffMapper;
import util.IdentityMap;
import util.UnitOfWork;

/**
 * @program: CoffeeWeb
 * @description:
 * @author: DennyLee
 * @create: 2019-09-14 00:54
 **/
public class StaffService {
    private StaffMapper staffMapper;

    public StaffService() {
        staffMapper = new StaffMapper();
    }

    public boolean insert(Staff staff) {
        UnitOfWork.newCurrent();
        UnitOfWork.getCurrent().registerNew(staff);
        return UnitOfWork.getCurrent().commit();
    }

    public boolean update(Staff staff) {
        UnitOfWork.newCurrent();
        UnitOfWork.getCurrent().registerDirty(staff);
        return UnitOfWork.getCurrent().commit();
    }

    public boolean delete(Staff staff) {
        UnitOfWork.newCurrent();
        UnitOfWork.getCurrent().registerDelete(staff);
        return UnitOfWork.getCurrent().commit();
    }

    public Staff findStaffById(Staff staff) {
        IdentityMap<Staff> identityMap = IdentityMap.getInstance(staff);
        Staff staffFinded = identityMap.get(staff.getId());
        if (staffFinded != null) {
            return staffFinded;
        }
        return staffMapper.findStaffById(staff);
    }
}
