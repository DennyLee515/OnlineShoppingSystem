package mapper;

import domain.*;
import util.DBConnection;
import util.IdentityMap;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: CoffeeWeb
 * @description: Data mapper for cart
 * @author: DennyLee
 * @create: 2019-09-02 23:54
 **/
public class CartDetailMapper extends DataMapper {

    /**
     * insert a cart item to table cart
     *
     * @param domainObject
     * @return
     * @throws Exception
     */
    @Override
    public boolean insert(DomainObject domainObject) {
        CartDetail cartDetail = (CartDetail) domainObject;
        String insertCart = "INSERT INTO public.cart_detail " +
                "(cart_detail_id, product_id, amount, sub_total, cart_id, category_id)" +
                "VALUES(?,?,?,?,?,?)";
        int result = 0;
        try {
            PreparedStatement preparedStatement = DBConnection.prepare(insertCart);
            preparedStatement.setString(1, cartDetail.getId());
            preparedStatement.setString(2, cartDetail.getProduct().getId());
            preparedStatement.setInt(3, cartDetail.getProductAmount());
            preparedStatement.setDouble(4, cartDetail.getTotalPrice());
            preparedStatement.setString(5, cartDetail.getCart().getId());
            preparedStatement.setString(6, cartDetail.getCategory().getId());
            result = preparedStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result != 0;
    }

    @Override
    public boolean delete(DomainObject domainObject) {
        CartDetail cartDetail = (CartDetail) domainObject;
        String deleteCart = "DELETE FROM public.cart_detail WHERE cart_detail_id = ?";
        int result = 0;
        try {
            PreparedStatement preparedStatement = DBConnection.prepare(deleteCart);
            preparedStatement.setString(1, cartDetail.getId());
            result = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result != 0;
    }

    @Override
    public boolean update(DomainObject domainObject) {
        CartDetail cartDetail = (CartDetail) domainObject;
        String updateCartById = "UPDATE public.cart_detail SET " +
                "product_id = ?, amount = ?, sub_total = ?, cart_id = ?, category_id = ?" +
                "WHERE cart_detail_id = ?";
        int result = 0;
        try {
            PreparedStatement preparedStatement = DBConnection.prepare(updateCartById);
            preparedStatement.setString(1, cartDetail.getProduct().getId());
            preparedStatement.setInt(2, cartDetail.getProductAmount());
            preparedStatement.setDouble(3, cartDetail.getTotalPrice());
            preparedStatement.setString(4, cartDetail.getCart().getId());
            preparedStatement.setString(5, cartDetail.getId());
            preparedStatement.setString(6, cartDetail.getCategory().getId());
            result = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }


        return result != 0;
    }

    public CartDetail findCartById(DomainObject domainObject) {
        CartDetail cartDetail = (CartDetail) domainObject;
        String findCartById = "SELECT * FROM public.cartDetail WHERE cart_id = ?";
        try {
            PreparedStatement preparedStatement = DBConnection.prepare(findCartById);
            preparedStatement.setString(1, cartDetail.getId());
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                CartDetail result = new CartDetail();
                IdentityMap<CartDetail> identityMap = IdentityMap.getInstance(result);
                result.setCartId(resultSet.getString(1));

                Product product1 = new Product();
                product1.setProductId(resultSet.getString(2));
                ProductMapper productMapper = new ProductMapper();
                result.setProduct(productMapper.findProductById(product1));

                result.setProductAmount(resultSet.getInt(3));
                result.setTotalPrice(resultSet.getDouble(4));

                Cart cart = new Cart();
                cart.setCartId(resultSet.getString(5));
                CartMapper cartMapper = new CartMapper();
                result.setCart(cartMapper.findCartById(cart));

                Category category = new Category();
                category.setCategoryId(resultSet.getString(6));
                CategoryMapper categoryMapper = new CategoryMapper();
                result.setCategory(categoryMapper.findCategoryById(category));

                identityMap.put(result.getId(), result);

                return result;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public CartDetail findProductInCart(Cart cart, Product product, Category category) {
        String findProductInCart = "SELECT * FROM public.cart_detail " +
                "WHERE product_id=? AND cart_id=? and category_id = ?;";
        try {
            PreparedStatement preparedStatement = DBConnection.prepare(findProductInCart);
            preparedStatement.setString(1, product.getId());
            preparedStatement.setString(2, cart.getId());
            preparedStatement.setString(3, category.getId());
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                CartDetail result = new CartDetail();

                result.setCartId(resultSet.getString(1));

                Product product1 = new Product();
                product1.setProductId(resultSet.getString(2));
                ProductMapper productMapper = new ProductMapper();
                result.setProduct(productMapper.findProductById(product1));

                result.setProductAmount(resultSet.getInt(3));
                result.setTotalPrice(resultSet.getDouble(4));

                Cart cart1 = new Cart();
                cart.setCartId(resultSet.getString(5));
                CartMapper cartMapper = new CartMapper();
                result.setCart(cartMapper.findCartById(cart1));

                Category category1 = new Category();
                category1.setCategoryId(resultSet.getString(6));
                CategoryMapper categoryMapper = new CategoryMapper();
                result.setCategory(categoryMapper.findCategoryById(category1));

                return result;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<CartDetail> findCartDetailByCartId(Cart cart) {
        String findCartById = "SELECT * FROM public.cart_detail WHERE cart_id = ?";
        List<CartDetail> result = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = DBConnection.prepare(findCartById);
            preparedStatement.setString(1, cart.getId());
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                CartDetail cartDetail1 = new CartDetail();
                IdentityMap<CartDetail> identityMap = IdentityMap.getInstance(cartDetail1);

                cartDetail1.setCartId(resultSet.getString(1));

                Product product1 = new Product();
                product1.setProductId(resultSet.getString(2));
                ProductMapper productMapper = new ProductMapper();
                cartDetail1.setProduct(productMapper.findProductById(product1));

                cartDetail1.setProductAmount(resultSet.getInt(3));
                cartDetail1.setTotalPrice(resultSet.getDouble(4));

                Cart cart1 = new Cart();
                cart.setCartId(resultSet.getString(5));
                CartMapper cartMapper = new CartMapper();
                cartDetail1.setCart(cartMapper.findCartById(cart1));

                Category category = new Category();
                category.setCategoryId(resultSet.getString(6));
                CategoryMapper categoryMapper = new CategoryMapper();
                cartDetail1.setCategory(categoryMapper.findCategoryById(category));

                identityMap.put(cartDetail1.getId(), cartDetail1);
                result.add(cartDetail1);
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
