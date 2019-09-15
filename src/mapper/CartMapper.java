package mapper;

import domain.Cart;
import domain.DomainObject;
import domain.User;
import sun.dc.pr.PRError;
import util.DBConnection;
import util.IdentityMap;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @program: CoffeeWeb
 * @description: Data mapper for cart
 * @author: DennyLee
 * @create: 2019-09-14 14:12
 **/
public class CartMapper extends DataMapper {
    /**
     * insert a cart to cart table
     *
     * @param domainObject Cart
     * @return result
     */
    @Override
    public boolean insert(DomainObject domainObject) {
        Cart cart = (Cart) domainObject;
        String insertNewCart = "INSERT INTO public.cart " +
                "(cart_id, user_id)" +
                "VALUES (?,?)";
        int result = 0;
        try {
            PreparedStatement preparedStatement = DBConnection.prepare(insertNewCart);
            preparedStatement.setString(1, cart.getId());
            preparedStatement.setString(2, cart.getUser().getId());
            result = preparedStatement.executeUpdate();
            DBConnection.close(preparedStatement);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result != 0;
    }

    /**
     * delete a cart from cart table
     *
     * @param domainObject Cart
     * @return result
     */
    @Override
    public boolean delete(DomainObject domainObject) {
        Cart cart = (Cart) domainObject;
        String deletCategoryById = "DELETE FROM public.cart WHERE cart_id = ?";
        int result = 0;
        try {
            PreparedStatement preparedStatement = DBConnection.prepare(deletCategoryById);
            preparedStatement.setString(1, cart.getId());
            result = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result != 0;
    }

    /**
     * update a cart from cart table
     *
     * @param domainObject Cart
     * @return result
     */
    @Override
    public boolean update(DomainObject domainObject) {
        Cart cart = (Cart) domainObject;
        String updateCartById = "UPDATE public.cart SET " +
                "user_id =? WHERE cart_id = ?";
        int result = 0;
        try {
            PreparedStatement preparedStatement = DBConnection.prepare(updateCartById);
            preparedStatement.setString(1, cart.getUser().getId());
            preparedStatement.setString(2, cart.getId());
            result = preparedStatement.executeUpdate();

            DBConnection.close(preparedStatement);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result != 0;
    }

    /**
     * find a cart by cart id in cart table
     *
     * @param domainObject Cart
     * @return a Cart object or null
     */
    public Cart findCartById(DomainObject domainObject) {
        Cart cart = (Cart) domainObject;
        String findCartById = "SELECT * FROM public.cart WHERE cart_id = ?";

        try {
            PreparedStatement preparedStatement = DBConnection.prepare(findCartById);
            preparedStatement.setString(1, cart.getId());
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                Cart cart1 = new Cart();
                IdentityMap<Cart> identityMap = IdentityMap.getInstance(cart1);

                cart1.setCartId(resultSet.getString(1));
                User user = new User();
                user.setUserId(resultSet.getString(2));
                UserMapper userMapper = new UserMapper();
                user = userMapper.findUserById(user);
                cart1.setUser(user);

                identityMap.put(cart1.getId(), cart1);
                return cart1;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * find a cart by user_id in cart table
     *
     * @param domainObject User
     * @return a Cart object or null
     */
    public Cart findCartByUserId(DomainObject domainObject) {
        User user = (User) domainObject;
        String findCartById = "SELECT * FROM public.cart WHERE user_id = ?";

        try {
            PreparedStatement preparedStatement = DBConnection.prepare(findCartById);
            preparedStatement.setString(1, user.getId());
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                Cart cart1 = new Cart();
                IdentityMap<Cart> identityMap = IdentityMap.getInstance(cart1);

                cart1.setCartId(resultSet.getString(1));
                User user1 = new User();
                user.setUserId(resultSet.getString(2));
                UserMapper userMapper = new UserMapper();
                user1 = userMapper.findUserById(user1);
                cart1.setUser(user1);

                identityMap.put(cart1.getId(), cart1);
                return cart1;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
