package domain;/**
 * Created by DennyLee on 2019/9/1.
 */

import java.util.Date;
import java.util.UUID;

/**
 * @program: CoffeeWeb
 * @description: Users
 * @author: DennyLee
 * @create: 2019-09-01 19:31
 **/
public class User extends DomainObject {
    private String userId;
    private String uFname;
    private String uLname;
    private String username;
    private String uPassword;
    private Date birthday;
    private String userEmail;
    private String address;

    public User() {
    }

    public User(String uFname, String uLname, String username, String uPassword, Date
            birthday, String userEmail, String address) {
        this.userId = UUID.randomUUID().toString();;
        this.uFname = uFname;
        this.uLname = uLname;
        this.username = username;
        this.uPassword = uPassword;
        this.birthday = birthday;
        this.userEmail = userEmail;
        this.address = address;
    }

    @Override
    public String getId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getuFname() {
        return uFname;
    }

    public void setuFname(String uFname) {
        this.uFname = uFname;
    }

    public String getuLname() {
        return uLname;
    }

    public void setuLname(String uLname) {
        this.uLname = uLname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getuPassword() {
        return uPassword;
    }

    public void setuPassword(String uPassword) {
        this.uPassword = uPassword;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


}
