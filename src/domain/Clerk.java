package domain;

import java.util.Date;

/**
 * @program: CoffeeWeb
 * @description:
 * @author: DennyLee
 * @create: 2019-09-13 22:34
 **/
public class Clerk extends Staff {
    private String clerkFistname;
    private String clerkLastName;
    private TimeRange timeRange;

    public Clerk() {
    }

    public Clerk( String staffUName, String staffPassword, String clerkFistname,
                 String clerkLastName, Date startDate,Date endDate) {
        super( staffUName, staffPassword);
        this.clerkFistname = clerkFistname;
        this.clerkLastName = clerkLastName;
        this.timeRange = new TimeRange(startDate,endDate);
    }

    public String getClerkFistname() {
        return clerkFistname;
    }

    public void setClerkFistname(String clerkFistname) {
        this.clerkFistname = clerkFistname;
    }

    public String getClerkLastName() {
        return clerkLastName;
    }

    public void setClerkLastName(String clerkLastName) {
        this.clerkLastName = clerkLastName;
    }

    public TimeRange getTimeRange() {
        return timeRange;
    }

    public void setTimeRange(TimeRange timeRange) {
        this.timeRange = timeRange;
    }
}
