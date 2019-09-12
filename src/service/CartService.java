package service;

import domain.Cart;
import domain.Product;
import domain.User;
import mapper.CartMapper;
import mapper.UserMapper;
import util.IdentityMap;

import java.util.List;

public class CartService {
    private CartMapper cartMapper;
    private UserMapper userMapper;

    public CartService() {
        cartMapper = new CartMapper();
        userMapper = new UserMapper();
    }

    public boolean AddToCart(User user, Product product, int amount) {
        try {
            Cart cartFinded = cartMapper.findProductInCart(user, product);
            Boolean result;
            if (cartFinded != null) {
                cartFinded.setProductAmount(cartFinded.getProductAmount() + amount);
                result = updateCart(cartFinded);
            } else {
                Cart newCart = new Cart(product, amount, product.getPrice() * amount, user);
                result = insertCart(newCart);
            }
            return result;
        } catch (Exception e) {
            System.out.println("Fail to add products to the cart.");
            return false;
        }
    }

    public boolean insertCart(Cart cart) {
        try {
            return cartMapper.insert(cart);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Insert cart service fail.");
            return false;
        }
    }

    public boolean updateCart(Cart cart) {
        try {
            return cartMapper.update(cart);
        } catch (Exception e) {
            System.out.println("Update cart service fail.");
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteCart() {
        return false;
    }

    public List<Cart> findCartByUser(User user) {
        try {
            return cartMapper.findCartByUserId(user);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Find cart by user service fail.");
        }
        return null;
    }
}
