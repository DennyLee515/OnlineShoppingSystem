package domain;

import java.util.UUID;

/**
 * @program: CoffeeWeb
 * @description:
 * @author: DennyLee
 * @create: 2019-09-13 22:25
 **/
public class Staff extends DomainObject{
    protected String staffId;
    protected String staffUName;
    protected String staffPassword;

    public Staff() {
    }

    public Staff(String staffUName, String staffPassword) {
        this.staffId = UUID.randomUUID().toString();
        this.staffUName = staffUName;
        this.staffPassword = staffPassword;
    }

    @Override
    public String getId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getStaffUName() {
        return staffUName;
    }

    public void setStaffUName(String staffUName) {
        this.staffUName = staffUName;
    }

    public String getStaffPassword() {
        return staffPassword;
    }

    public void setStaffPassword(String staffPassword) {
        this.staffPassword = staffPassword;
    }
}
