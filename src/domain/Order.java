package domain;/**
 * Created by DennyLee on 2019/9/1.
 */

import java.util.Date;
import java.util.UUID;

/**
 * @program: CoffeeWeb
 * @description: Order object
 * @author: DennyLee
 * @create: 2019-09-01 22:51
 **/
public class Order extends DomainObject {
    //order id
    private String orderId;
    //the user a order belongs to
    private User user;
    //total price of order
    private double totalPrice;
    //date of the order
    private Date orderTime;

    //constructor
    public Order() {
    }

    //constructor with user, total price, order time
    public Order(User user, double totalPrice, Date orderTime) {
        this.orderId = UUID.randomUUID().toString();
        this.user = user;
        this.totalPrice = totalPrice;
        this.orderTime = orderTime;
    }

    //getter and setter method
    @Override
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
