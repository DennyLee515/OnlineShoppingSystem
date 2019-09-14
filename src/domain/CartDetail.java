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
public class CartDetail extends DomainObject {
    //cart id
    private String cartId;
    //product in the cart
    private Product product;
    //amount of the product
    private int productAmount;
    //total price of the product
    private double totalPrice;
    //the cart a cart detail belongs to
    private Cart cart;
    //the category of the product
    private Category category;

    //constructor
    public CartDetail() {
    }

    //constructor with product, amount, price, user, category
    public CartDetail(Product product, int productAmount, double totalPrice, Cart cart,
                      Category category) {
        this.cartId = UUID.randomUUID().toString();
        this.product = product;
        this.productAmount = productAmount;
        this.totalPrice = totalPrice;
        this.cart = cart;
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

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
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
