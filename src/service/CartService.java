package service;

import domain.*;
import mapper.CartDetailMapper;
import mapper.CartMapper;
import mapper.UserMapper;

import java.util.List;

public class CartService {
    private CartDetailMapper cartDetailMapper;
    private UserMapper userMapper;
    private CartMapper cartMapper;

    public CartService() {
        cartDetailMapper = new CartDetailMapper();
        userMapper = new UserMapper();
        cartMapper = new CartMapper();
    }

    public boolean AddToCart(User user, Product product, int amount, Category category) {
        try {
            Cart cart = findCartByUserId(user);
            CartDetail cartDetailFinded = cartDetailMapper.findProductInCart(cart, product,
                    category);
            boolean result;
            if (cartDetailFinded != null) {
                cartDetailFinded.setProductAmount(cartDetailFinded.getProductAmount() + amount);
                result = updateCart(cartDetailFinded);
            } else {
                CartDetail newCartDetail = new CartDetail(product, amount,
                        product.getPrice() * amount, cart, category);
                result = insertCartDetail(newCartDetail);
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean insertCart(Cart cart) {
        return cartMapper.insert(cart);
    }

    public boolean insertCartDetail(CartDetail cartDetail){
        return cartDetailMapper.insert(cartDetail);
    }

    public boolean updateCart(CartDetail cartDetail) {
        try {
            return cartDetailMapper.update(cartDetail);
        } catch (Exception e) {
            System.out.println("Update cartDetail service fail.");
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteCart() {
        return false;
    }

    public List<CartDetail> findCartDetailByUserId(User user) {
        Cart cart = findCartByUserId(user);
        return cartDetailMapper.findCartDetailByCartId(cart);

    }

    public Cart findCartByUserId(User user) {
        return cartMapper.findCartByUserId(user);
    }
}
