package Mapper;

import Domain.Cart;
import Domain.DomainObject;
import Util.DBConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import static Util.DBConnection.prepare;

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
                "cart_id,product_id,amount,price " +
                "VALUES(?,?,?,?,?)";
        int result = 0;

        PreparedStatement preparedStatement = DBConnection.prepare(insertCart);
        preparedStatement.setString(1, cart.getId());
        preparedStatement.setString(2, cart.getProduct().getId());
        preparedStatement.setInt(3, cart.getProductAmount());
        preparedStatement.setDouble(4, cart.getTotalPrice());
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
        String updateCartById = "UPDATE public.cart SET" +
                "product_id = ?, amount = ?, total_price = ?" +
                "WHERE cart_id = ?";
        int result = 0;

        PreparedStatement preparedStatement = DBConnection.prepare(updateCartById);
        preparedStatement.setString(1,cart.getProduct().getId());
        preparedStatement.setInt(2,cart.getProductAmount());
        preparedStatement.setDouble(3,cart.getTotalPrice());
        preparedStatement.setString(4,cart.getId());
        result = preparedStatement.executeUpdate();

        return result!=0;
    }

    public List<Cart> findCartById(DomainObject domainObject) throws Exception{
        Cart cart = (Cart)domainObject;
        String findCartById = "SELECT * FROM public.cart WHERE cart_id = ?";
        List<Cart> result = new ArrayList<>();

        PreparedStatement preparedStatement = DBConnection.prepare(findCartById);
        preparedStatement.setString(1,cart.getId());
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()){
            Cart cartRow = new Cart();
            cartRow.setCartId(resultSet.getString(1));
            cartRow.setProduct(resultSet.getString(2));
            cartRow.setProductAmount(resultSet.getInt(3));
            cartRow.setTotalPrice(resultSet.getDouble(4));
            result.add(cartRow);
        }
        return result;
    }
}
