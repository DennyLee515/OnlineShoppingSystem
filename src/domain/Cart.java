package domain;

import mapper.CartMapper;

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
        if (this.user == null){
            load();
        }
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    private void load() {
        CartMapper cartMapper = new CartMapper();
        Cart record = cartMapper.findCartById(this);

        if (this.user == null) {
            this.user = record.getUser();
        }

    }
}


