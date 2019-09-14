package service;

import domain.*;
import mapper.CartDetailMapper;
import mapper.CartMapper;
import mapper.UserMapper;
import util.UnitOfWork;

import java.util.List;

public class CartService {
    private CartDetailMapper cartDetailMapper;
    private CartMapper cartMapper;

    public CartService() {
        cartDetailMapper = new CartDetailMapper();
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
                result = updateCartDetail(cartDetailFinded);
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
        UnitOfWork.newCurrent();
        UnitOfWork.getCurrent().registerNew(cart);
        return UnitOfWork.getCurrent().commit();
    }

    public boolean deleteCart(Cart cart) {
        UnitOfWork.newCurrent();
        UnitOfWork.getCurrent().registerDelete(cart);
        return UnitOfWork.getCurrent().commit();
    }

    public boolean insertCartDetail(CartDetail cartDetail){
        UnitOfWork.newCurrent();
        UnitOfWork.getCurrent().registerNew(cartDetail);
        return UnitOfWork.getCurrent().commit();
    }

    public boolean updateCartDetail(CartDetail cartDetail) {
        UnitOfWork.newCurrent();
        UnitOfWork.getCurrent().registerDirty(cartDetail);
        return UnitOfWork.getCurrent().commit();
    }

    public boolean deleteCartDetail(CartDetail cartDetail) {
        UnitOfWork.newCurrent();
        UnitOfWork.getCurrent().registerDelete(cartDetail);
        return UnitOfWork.getCurrent().commit();
    }

    public List<CartDetail> findCartDetailByUserId(User user) {
        Cart cart = findCartByUserId(user);
        return cartDetailMapper.findCartDetailByCartId(cart);

    }

    public Cart findCartByUserId(User user) {
        return cartMapper.findCartByUserId(user);
    }
}
