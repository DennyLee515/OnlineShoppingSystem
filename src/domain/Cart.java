package domain;/**
 * Created by DennyLee on 2019/9/1.
 */

import java.util.UUID;

/**
 * @program: CoffeeWeb
 * @description: Shopping cart item object
 * @author: DennyLee
 * @create: 2019-09-01 23:30
 **/
public class Cart extends DomainObject {
    //cart id
    private String cartId;
    //product in the cart
    private Product product;
    //amount of the product
    private int productAmount;
    //total price of the product
    private double totalPrice;
    //the user own the cart
    private User user;
    //the category of the product
    private Category category;

    //constructor
    public Cart() {
    }

    //constructor with product, amount, price, user, category
    public Cart(Product product, int productAmount, double totalPrice, User user, Category category) {
        this.cartId = UUID.randomUUID().toString();
        this.product = product;
        this.productAmount = productAmount;
        this.totalPrice = totalPrice;
        this.user = user;
        this.category = category;
    }

    //getter and setter methods
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
