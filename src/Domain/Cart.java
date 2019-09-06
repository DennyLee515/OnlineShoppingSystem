package Domain;/**
 * Created by DennyLee on 2019/9/1.
 */

import java.util.UUID;

/**
 * @program: CoffeeWeb
 * @description:
 * @author: DennyLee
 * @create: 2019-09-01 23:30
 **/
public class Cart extends DomainObject {
    private String cartId;
    private Product product;
    private int productAmount;
    private double totalPrice;

    public Cart(){}

    public Cart(Product product, int productAmount, double totalPrice) {
        this.cartId = UUID.randomUUID().toString();
        this.product = product;
        this.productAmount = productAmount;
        this.totalPrice = totalPrice;
    }

    @Override
    public String getId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
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

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
