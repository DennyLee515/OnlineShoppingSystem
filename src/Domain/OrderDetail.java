package Domain;/**
 * Created by DennyLee on 2019/9/1.
 */

/**
 * @program: CoffeeWeb
 * @description:
 * @author: DennyLee
 * @create: 2019-09-01 23:28
 **/
public class OrderDetail extends DomainObject{
    private int OrderId;
    private Product product;
    private int productAmount;

    public OrderDetail() {
    }

    public OrderDetail(int orderId, Product product, int productAmount) {
        OrderId = orderId;
        this.product = product;
        this.productAmount = productAmount;
    }

    public int getOrderId() {
        return OrderId;
    }

    public void setOrderId(int orderId) {
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
