package dto;

import com.google.gson.Gson;
import domain.Staff;

import java.util.Date;

/**
 * @program: CoffeeWeb
 * @description:
 * @author: DennyLee
 * @create: 2019-10-10 01:25
 **/
public class StaffDTO {
    private String username;
    private String password;
    private String id;
    private Date startDate;
    private Date endDate;
    private String managerEmail;
    private String clerkFirstname;
    private String clerkLastname;
    private String type;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getManagerEmail() {
        return managerEmail;
    }

    public void setManagerEmail(String managerEmail) {
        this.managerEmail = managerEmail;
    }

    public String getClerkFirstname() {
        return clerkFirstname;
    }

    public void setClerkFirstname(String clerkFirstname) {
        this.clerkFirstname = clerkFirstname;
    }

    public String getClerkLastname() {
        return clerkLastname;
    }

    public void setClerkLastname(String clerkLastname) {
        this.clerkLastname = clerkLastname;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public static String serialize(StaffDTO staffDTO){
        Gson gson = new Gson();
        return gson.toJson(staffDTO);

    }

    public static StaffDTO deserialize(String jsonString){
        Gson gson = new Gson();
        return gson.fromJson(jsonString, StaffDTO.class);
    }


}
