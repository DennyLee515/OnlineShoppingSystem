package domain;/**
 * Created by DennyLee on 2019/9/1.
 */

import java.util.UUID;

/**
 * @program: CoffeeWeb
 * @description: Order details of an order
 * @author: DennyLee
 * @create: 2019-09-01 23:28
 **/
public class OrderDetail extends DomainObject {
    //Order an order detail belongs to
    private Order order;
    //order detail id
    private String orderDetailId;
    //the product of the order detail item
    private Product product;
    //the product amount of the detail item
    private int productAmount;

    //constructor
    public OrderDetail() {
    }

    //constructor with order, product, product amount
    public OrderDetail(Order order, Product product, int productAmount) {
        this.order = order;
        orderDetailId = UUID.randomUUID().toString();
        this.product = product;
        this.productAmount = productAmount;
    }

    //getter and setter methods
    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public String getId() {
        return orderDetailId;
    }

    public void setOrderDetailId(String orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getProductAmount() {
        return productAmount;
    }

    public void setProductAmount(int productAmount) {
        this.productAmount = productAmount;
    }
}
