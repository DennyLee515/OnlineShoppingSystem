package domain;

import java.util.UUID;

/**
 * @program: CoffeeWeb
 * @description:
 * @author: DennyLee
 * @create: 2019-09-14 14:00
 **/
public class Cart extends DomainObject{
    private String cartId;
    private User user;

    public Cart() {
    }

    public Cart(User user) {
        this.cartId = UUID.randomUUID().toString();
        this.user = user;
    }

    @Override
    public String getId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
