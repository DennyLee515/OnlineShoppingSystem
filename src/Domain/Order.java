package Domain;/**
 * Created by DennyLee on 2019/9/1.
 */

import java.util.Date;

/**
 * @program: CoffeeWeb
 * @description: Order
 * @author: DennyLee
 * @create: 2019-09-01 22:51
 **/
public class Order extends DomainObject{
    private int orderId;
    private User user;
    private double totalPrice;
    private Date orderTime;

    public Order() {
    }

    public Order(int orderId, User user, double totalPrice, Date orderTime) {
        this.orderId = orderId;
        this.user = user;
        this.totalPrice = totalPrice;
        this.orderTime = orderTime;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }
}
