package service;

import domain.Admin;
import mapper.AdminMapper;
import util.IdentityMap;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: CoffeeWeb
 * @description:
 * @author: DennyLee
 * @create: 2019-09-06 22:55
 **/
public class AdminService {
    private AdminMapper adminMapper;

    public AdminService(){
        adminMapper = new AdminMapper();
    }

    public List<Admin> findAdmin(Admin admin){
        IdentityMap<Admin> identityMap = IdentityMap.getInstance(admin);
        Admin adminFinded = identityMap.get(admin.getId());
        if (adminFinded != null){
            List<Admin> result = new ArrayList<>();
            result.add(adminFinded);
            return result;
        }
        return adminMapper.findAdminById(admin);
    }
}
