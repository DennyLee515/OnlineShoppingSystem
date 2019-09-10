package domain;/**
 * Created by DennyLee on 2019/9/1.
 */

import java.util.UUID;

/**
 * @program: CoffeeWeb
 * @description:
 * @author: DennyLee
 * @create: 2019-09-01 23:28
 **/
public class OrderDetail extends DomainObject{
    private String OrderId;
    private Product product;
    private int productAmount;

    public OrderDetail() {
    }

    public OrderDetail(Product product, int productAmount) {
        OrderId = UUID.randomUUID().toString();
        this.product = product;
        this.productAmount = productAmount;
    }

    @Override
    public String getId() {
        return OrderId;
    }

    public void setOrderId(String orderId) {
        OrderId = orderId;
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
