package Mapper;

import Domain.DomainObject;
import Domain.Product;
import Util.DBConnection;

import java.sql.PreparedStatement;
import java.sql.Timestamp;

/**
 * @program: CoffeeWeb
 * @description:
 * @author: DennyLee
 * @create: 2019-09-02 23:56
 **/
public class ProductMapper extends DataMapper {
    @Override
    public boolean insert(DomainObject domainObject) {
        Product product = (Product) domainObject;
        String insertProduct = "INSERT INTO public.product " +
                "(product_id, product_name, info, price, weight, created_at)" +
                "VALUES(?,?,?,?,?,?)";
        int result = 0;
        try {
            PreparedStatement preparedStatement = DBConnection.prepare(insertProduct);
            preparedStatement.setString(1, product.getProductId());
            preparedStatement.setString(2, product.getProductName());
            preparedStatement.setString(3, product.getInfo());
            preparedStatement.setDouble(4, product.getPrice());
            preparedStatement.setInt(5, product.getWeight());
            preparedStatement.setTimestamp(6, new Timestamp(product.getCreatedAt().getTime()));
            result = preparedStatement.executeUpdate();
            DBConnection.close(preparedStatement);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result != 0;
    }

    @Override
    public boolean delete(DomainObject domainObject) throws Exception {
        return false;
    }

    @Override
    public boolean update(DomainObject domainObject) throws Exception {
        return false;
    }
}
