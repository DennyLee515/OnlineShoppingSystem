package domain;/**
 * Created by DennyLee on 2019/9/1.
 */

import java.util.UUID;

/**
 * @program: CoffeeWeb
 * @description: Admin object
 * @author: DennyLee
 * @create: 2019-09-01 22:55
 **/
public class Admin extends DomainObject {
    private String aId;
    private String aUsername;
    private String adminEmail;
    private String adminFname;
    private String adminLname;
    private String adminPassword;
    private int departmentId;

    public Admin() {
    }

    public Admin(String adminUsername, String adminEmail, String adminFname, String
            adminLname, String adminPassword, int departmentId) {
        this.aId = UUID.randomUUID().toString();
        this.aUsername = adminUsername;
        this.adminEmail = adminEmail;
        this.adminFname = adminFname;
        this.adminLname = adminLname;
        this.adminPassword = adminPassword;
        this.departmentId = departmentId;
    }

    @Override
    public String getId() {
        return aId;
    }

    public void setAdminId(String adminId) {
        this.aId = adminId;
    }

    public String getAdminUsername() {
        return aUsername;
    }

    public void setAdminUsername(String adminUsername) {
        this.aUsername = adminUsername;
    }

    public String getAdminEmail() {
        return adminEmail;
    }

    public void setAdminEmail(String adminEmail) {
        this.adminEmail = adminEmail;
    }

    public String getAdminFname() {
        return adminFname;
    }

    public void setAdminFname(String adminFname) {
        this.adminFname = adminFname;
    }

    public String getAdminLname() {
        return adminLname;
    }

    public void setAdminLname(String adminLname) {
        this.adminLname = adminLname;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }
}
