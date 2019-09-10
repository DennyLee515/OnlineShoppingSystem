package domain;/**
 * Created by DennyLee on 2019/9/1.
 */

import java.util.Date;
import java.util.UUID;

/**
 * @program: CoffeeWeb
 * @description: Order
 * @author: DennyLee
 * @create: 2019-09-01 22:51
 **/
public class Order extends DomainObject{
    private String orderId;
    private User user;
    private double totalPrice;
    private Date orderTime;

    public Order() {
    }

    public Order(User user, double totalPrice, Date orderTime) {
        this.orderId = UUID.randomUUID().toString();
        this.user = user;
        this.totalPrice = totalPrice;
        this.orderTime = orderTime;
    }

    public String getId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
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
