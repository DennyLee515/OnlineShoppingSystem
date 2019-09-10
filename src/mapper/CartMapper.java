package mapper;

import domain.Cart;
import domain.DomainObject;
import domain.Product;
import domain.User;
import util.DBConnection;
import util.IdentityMap;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: CoffeeWeb
 * @description:
 * @author: DennyLee
 * @create: 2019-09-02 23:54
 **/
public class CartMapper extends DataMapper {


    @Override
    public boolean insert(DomainObject domainObject) throws Exception {
        Cart cart = (Cart) domainObject;
        String insertCart = "INSERT INTO public.cart " +
                "(cart_id, product_id, product_amount, total_price, user_id)" +
                "VALUES(?,?,?,?,?)";
        int result = 0;

        PreparedStatement preparedStatement = DBConnection.prepare(insertCart);
        preparedStatement.setString(1, cart.getId());
        preparedStatement.setString(2, cart.getProduct().getId());
        preparedStatement.setInt(3, cart.getProductAmount());
        preparedStatement.setDouble(4, cart.getTotalPrice());
        preparedStatement.setString(5, cart.getUser().getId());
        result = preparedStatement.executeUpdate();

        return result != 0;
    }

    @Override
    public boolean delete(DomainObject domainObject) throws Exception {
        Cart cart = (Cart) domainObject;
        String deleteCart = "DELETE FROM public.cart WHERE cart_id = ?";
        int result = 0;
        PreparedStatement preparedStatement = DBConnection.prepare(deleteCart);
        preparedStatement.setString(1, cart.getId());
        result = preparedStatement.executeUpdate();

        return result != 0;
    }

    @Override
    public boolean update(DomainObject domainObject) throws Exception {
        Cart cart = (Cart) domainObject;
        String updateCartById = "UPDATE public.cart SET " +
                "product_id = ?, product_amount = ?, total_price = ?, user_id = ?" +
                "WHERE cart_id = ?";
        int result = 0;

        PreparedStatement preparedStatement = DBConnection.prepare(updateCartById);
        preparedStatement.setString(1, cart.getProduct().getId());
        preparedStatement.setInt(2, cart.getProductAmount());
        preparedStatement.setDouble(3, cart.getTotalPrice());
        preparedStatement.setString(4, cart.getUser().getId());
        preparedStatement.setString(5, cart.getId());
        result = preparedStatement.executeUpdate();

        return result != 0;
    }

    public Cart findCartById(DomainObject domainObject) throws Exception {
        Cart cart = (Cart) domainObject;
        String findCartById = "SELECT * FROM public.cart WHERE cart_id = ?";

        PreparedStatement preparedStatement = DBConnection.prepare(findCartById);
        preparedStatement.setString(1, cart.getId());
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            Cart result = new Cart();
            IdentityMap<Cart> identityMap = IdentityMap.getInstance(result);
            result.setCartId(resultSet.getString(1));
            Product product1 = new Product();
            product1.setProductId(resultSet.getString(2));
            ProductMapper productMapper = new ProductMapper();
            result.setProduct(productMapper.findProductById(product1));
            result.setProductAmount(resultSet.getInt(3));
            result.setTotalPrice(resultSet.getDouble(4));
            User user = new User();
            user.setUserId(resultSet.getString(5));
            UserMapper userMapper = new UserMapper();
            result.setUser(userMapper.findUserById(user));
            identityMap.put(result.getId(), result);

            return result;
        }else {
            return null;
        }
    }

    public Cart findProductInCart(User user, Product product) throws Exception {
        String findProductInCart = "SELECT * FROM public.cart " +
                "WHERE product_id=? AND user_id=?;";

        PreparedStatement preparedStatement = DBConnection.prepare(findProductInCart);
        preparedStatement.setString(1, product.getId());
        preparedStatement.setString(2, user.getId());
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            Cart result = new Cart();
            result.setCartId(resultSet.getString(1));
            Product product1 = new Product();
            product1.setProductId(resultSet.getString(2));
            ProductMapper productMapper = new ProductMapper();
            result.setProduct(productMapper.findProductById(product1));
            result.setProductAmount(resultSet.getInt(3));
            result.setTotalPrice(resultSet.getDouble(4));
            User user1 = new User();
            user1.setUserId(resultSet.getString(5));
            UserMapper userMapper = new UserMapper();
            result.setUser(userMapper.findUserById(user1));

            return result;
        } else {
            return null;
        }
    }

    public List<Cart> findCartByUserId(User user) throws Exception{
        String findCartById = "SELECT * FROM public.cart WHERE user_id = ?";
        List<Cart> result = new ArrayList<>();
        PreparedStatement preparedStatement = DBConnection.prepare(findCartById);
        preparedStatement.setString(1, user.getId());
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            Cart cart1 = new Cart();
            IdentityMap<Cart> identityMap = IdentityMap.getInstance(cart1);
            cart1.setCartId(resultSet.getString(1));
            Product product1 = new Product();
            product1.setProductId(resultSet.getString(2));
            ProductMapper productMapper = new ProductMapper();
            cart1.setProduct(productMapper.findProductById(product1));
            cart1.setProductAmount(resultSet.getInt(3));
            cart1.setTotalPrice(resultSet.getDouble(4));
            User user1 = new User();
            user1.setUserId(resultSet.getString(5));
            UserMapper userMapper = new UserMapper();
            cart1.setUser(userMapper.findUserById(user1));
            identityMap.put(cart1.getId(), cart1);
            result.add(cart1);
        }
        return result;
    }
}
