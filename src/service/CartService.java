package service;

import domain.*;
import mapper.CartDetailMapper;
import mapper.CartMapper;
import mapper.ProductMapper;
import mapper.UserMapper;
import util.UnitOfWork;

import java.util.List;

/**
 * @program: CoffeeWeb
 * @description: Cart service to manager logic method related to cart
 * @author: DennyLee
 * @create: 2019-09-06 22:47
 **/
public class CartService {
    private CartDetailMapper cartDetailMapper;
    private CartMapper cartMapper;

    public CartService() {
        cartDetailMapper = new CartDetailMapper();
        cartMapper = new CartMapper();
    }

    /**
     * Add a product to cart, create new cart detail and related to cart
     *
     * @param user     User logged in
     * @param product  Product to add
     * @param amount   product amount
     * @param category product category
     * @return result
     */
    public boolean AddToCart(User user, Product product, int amount, Category category) {
        try {
            Cart cart = findCartByUserId(user);
            CartDetail cartDetailFinded = cartDetailMapper.findProductInCart(cart, product,
                    category);
            boolean result;
            if (cartDetailFinded != null) {
                //todo modify sub total
                cartDetailFinded.setProductAmount(cartDetailFinded.getProductAmount() + amount);
                cartDetailFinded.setTotalPrice(cartDetailFinded.getTotalPrice() + product.getPrice()*amount);
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

    /**
     * create a new cart, apply unit of work
     *
     * @param cart Cart
     * @return result
     */
    public boolean newCart(Cart cart) {
        UnitOfWork.newCurrent();
        UnitOfWork.getCurrent().registerNew(cart);
        return UnitOfWork.getCurrent().commit();
    }

    /**
     * delete a cart, apply unit of work
     *
     * @param cart Cart
     * @return result
     */
    public boolean deleteCart(Cart cart) {
        UnitOfWork.newCurrent();
        UnitOfWork.getCurrent().registerDelete(cart);
        return UnitOfWork.getCurrent().commit();
    }

    /**
     * create a new cart detail, apply unit of work
     *
     * @param cartDetail CartDetail
     * @return result
     */
    public boolean insertCartDetail(CartDetail cartDetail) {
        UnitOfWork.newCurrent();
        UnitOfWork.getCurrent().registerNew(cartDetail);
        return UnitOfWork.getCurrent().commit();
    }

    /**
     * update a cart detail, apply unit of work
     *
     * @param cartDetail CartDetail
     * @return result
     */
    public boolean updateCartDetail(CartDetail cartDetail) {
        UnitOfWork.newCurrent();
        UnitOfWork.getCurrent().registerDirty(cartDetail);
        return UnitOfWork.getCurrent().commit();
    }

    /**
     * delete a cart detail, apply unit of work
     *
     * @param cartDetail CartDetail
     * @return result
     */
    public boolean deleteCartDetail(CartDetail cartDetail) {
        UnitOfWork.newCurrent();
        UnitOfWork.getCurrent().registerDelete(cartDetail);
        return UnitOfWork.getCurrent().commit();
    }

    /**
     * find all cart details related to a user by user id
     *
     * @param user User
     * @return a list of CartDetail object or null
     */
    public List<CartDetail> findCartDetailByUserId(User user) {
        Cart cart = findCartByUserId(user);
        List<CartDetail> cartDetails = cartDetailMapper.findCartDetailByCartId(cart);
        for (CartDetail cartDetail:cartDetails) {
            Product product = cartDetail.getProduct();
            Category category = cartDetail.getCategory();
            ProductService productService = new ProductService();
            if (!productService.findRelation(product,category)){
                deleteCartDetail(cartDetail);
                cartDetails.remove(cartDetail);
            }
        }
        return cartDetails;
    }

    /**
     * find a cart related to a user by user id
     *
     * @param user User
     * @return a Cartobject or null
     */
    public Cart findCartByUserId(User user) {
        return cartMapper.findCartByUserId(user);
    }

    public boolean updatePrice(Product product) {
        ProductService productService = new ProductService();
        Product product1  = productService.findProductByID(product);
        return cartDetailMapper.updatePrice(product1);
    }

    public boolean clearCartByUser(User user){
        Cart cart = new Cart(user);
        boolean result = deleteCart(findCartByUserId(user)) && newCart(cart);
        return result;
    }
}
