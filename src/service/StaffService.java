package service;

import domain.Staff;
import mapper.StaffMapper;

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
        return staffMapper.insert(staff);
    }

    public boolean update(Staff staff) {
        return staffMapper.update(staff);
    }

    public boolean delete(Staff staff) {
        return staffMapper.delete(staff);
    }

    public Staff findStaffById(Staff staff) {
        return staffMapper.findStaffById(staff);
    }
}
