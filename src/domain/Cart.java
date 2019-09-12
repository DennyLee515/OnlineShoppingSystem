package domain;/**
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
    private User user;
    private Category category;

    public Cart(){}

    public Cart(Product product, int productAmount, double totalPrice,User user, Category category) {
        this.cartId = UUID.randomUUID().toString();
        this.product = product;
        this.productAmount = productAmount;
        this.totalPrice = totalPrice;
        this.user  = user;
        this.category = category;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getCartId() {
        return cartId;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
