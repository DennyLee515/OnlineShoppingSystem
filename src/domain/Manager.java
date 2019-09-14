package domain;/**
 * Created by DennyLee on 2019/9/1.
 */

/**
 * @program: CoffeeWeb
 * @description: Admin object
 * @author: DennyLee
 * @create: 2019-09-01 22:55
 **/
public class Manager extends Staff {

    private String managerEmail;


    public Manager() {
        super();
    }

    public Manager(String staffUName, String staffPassword, String managerEmail) {
        super(staffUName, staffPassword);
        this.managerEmail = managerEmail;
    }

    public String getManagerEmail() {
        return managerEmail;
    }

    public void setManagerEmail(String managerEmail) {
        this.managerEmail = managerEmail;
    }
}
