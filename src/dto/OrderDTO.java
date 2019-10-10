package dto;

import com.google.gson.Gson;

import java.util.Date;
import java.util.List;

public class OrderDTO {

    private String orderId;

    private String orderedById;

    private double totalPrice;

    private Date time;

    private String address;

    private String status;

    private Date updateTime;

    private List<OrderDetailDTO> orderDetails;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCustomer() {
        return orderedById;
    }

    public void setCustomer(String customer) {
        this.orderedById = customer;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public List<OrderDetailDTO> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetailDTO> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public static String serialize(OrderDTO orderDTO){
        Gson gson = new Gson();
        return gson.toJson(orderDTO);

    }

    public static OrderDTO deserialize(String jsonString){
        Gson gson = new Gson();
        return gson.fromJson(jsonString, OrderDTO.class);
    }
}
