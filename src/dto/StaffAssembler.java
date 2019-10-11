package dto;

import domain.Clerk;
import domain.Manager;
import domain.Staff;
import domain.TimeRange;
import service.StaffService;
import service.facade.StaffServiceBean;
import util.Params;

/**
 * @program: CoffeeWeb
 * @description:Functions of StaffDTO
 * @author: DennyLee
 * @create: 2019-10-10 01:29
 **/
public class StaffAssembler {
    /**
     * create StaffDTO from staff
     * @param staff Staff
     * @return StaffDTO
     */
    public static StaffDTO createStaffDTO(Staff staff){
        StaffDTO staffDTO = new StaffDTO();
        if (staff instanceof Manager){
            Manager manager = (Manager)staff;
            staffDTO.setType(Params.MANAGER_ROLE);
            staffDTO.setId(manager.getId());
            staffDTO.setUsername(manager.getStaffUName());
            staffDTO.setPassword(manager.getStaffPassword());
            staffDTO.setManagerEmail(manager.getManagerEmail());
        }else if (staff instanceof Clerk){
            Clerk clerk = (Clerk)staff;
            staffDTO.setType(Params.CLERK_ROLE);
            staffDTO.setId(clerk.getId());
            staffDTO.setUsername(clerk.getStaffUName());
            staffDTO.setPassword(clerk.getStaffPassword());
            staffDTO.setClerkFirstname(clerk.getClerkFirstname());
            staffDTO.setClerkLastname(clerk.getClerkLastName());
            staffDTO.setStartDate(clerk.getTimeRange().getStartDate());
            staffDTO.setEndDate(clerk.getTimeRange().getEndDate());
        }
        return staffDTO;
    }

    public static boolean createStaff(StaffDTO staffDTO){
        String type = staffDTO.getType();
        if (type.equals(Params.MANAGER_ROLE)){
            Manager manager = new Manager();
            manager.setStaffUName(staffDTO.getUsername());
            manager.setStaffPassword(staffDTO.getPassword());
            manager.setStaffId(staffDTO.getId());
            manager.setManagerEmail(staffDTO.getManagerEmail());
            return new StaffService().insert(manager);
        }else if (type.equals(Params.CLERK_ROLE)){
            Clerk clerk = new Clerk();
            clerk.setStaffUName(staffDTO.getUsername());
            clerk.setStaffPassword(staffDTO.getPassword());
            clerk.setStaffId(staffDTO.getId());
            clerk.setClerkFirstname(staffDTO.getClerkFirstname());
            clerk.setClerkLastName(staffDTO.getClerkLastname());
            clerk.setTimeRange(new TimeRange(staffDTO.getStartDate(),staffDTO.getEndDate()));
            return new StaffService().insert(clerk);
        }
        return false;
    }

    public static boolean updateStaff(StaffDTO staffDTO){
        String type = staffDTO.getType();
        if (type.equals(Params.MANAGER_ROLE)){
            Manager manager = new Manager();
            manager.setStaffUName(staffDTO.getUsername());
            manager.setStaffPassword(staffDTO.getPassword());
            manager.setStaffId(staffDTO.getId());
            manager.setManagerEmail(staffDTO.getManagerEmail());
            return new StaffService().update(manager);
        }else if (type.equals(Params.CLERK_ROLE)){
            Clerk clerk = new Clerk();
            clerk.setStaffUName(staffDTO.getUsername());
            clerk.setStaffPassword(staffDTO.getPassword());
            clerk.setStaffId(staffDTO.getId());
            clerk.setClerkFirstname(staffDTO.getClerkFirstname());
            clerk.setClerkLastName(staffDTO.getClerkLastname());
            clerk.setTimeRange(new TimeRange(staffDTO.getStartDate(),staffDTO.getEndDate()));
            return new StaffService().update(clerk);
        }
        return false;
    }

    public static boolean deleteStaff(StaffDTO staffDTO){
        String type = staffDTO.getType();
        if (type.equals(Params.MANAGER_ROLE)){
            Manager manager = new Manager();
            manager.setStaffUName(staffDTO.getUsername());
            manager.setStaffPassword(staffDTO.getPassword());
            manager.setStaffId(staffDTO.getId());
            manager.setManagerEmail(staffDTO.getManagerEmail());
            return new StaffService().delete(manager);
        }else if (type.equals(Params.CLERK_ROLE)){
            Clerk clerk = new Clerk();
            clerk.setStaffUName(staffDTO.getUsername());
            clerk.setStaffPassword(staffDTO.getPassword());
            clerk.setStaffId(staffDTO.getId());
            clerk.setClerkFirstname(staffDTO.getClerkFirstname());
            clerk.setClerkLastName(staffDTO.getClerkLastname());
            clerk.setTimeRange(new TimeRange(staffDTO.getStartDate(),staffDTO.getEndDate()));
            return new StaffService().delete(clerk);
        }
        return false;
    }

}
