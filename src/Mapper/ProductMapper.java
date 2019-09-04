package Mapper;

import Domain.Category;
import Domain.DomainObject;
import Domain.Product;
import Util.DBConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

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
                "(product_id, product_name, info, price, weight, created_at, category_id)" +
                "VALUES(?,?,?,?,?,?,?)";
        int result = 0;
        try {
            PreparedStatement preparedStatement = DBConnection.prepare(insertProduct);
            preparedStatement.setString(1, product.getProductId());
            preparedStatement.setString(2, product.getProductName());
            preparedStatement.setString(3, product.getInfo());
            preparedStatement.setDouble(4, product.getPrice());
            preparedStatement.setInt(5, product.getWeight());
            preparedStatement.setTimestamp(6, new Timestamp(product.getCreatedAt().getTime()));
            preparedStatement.setInt(7,product.getCategoryId());
            result = preparedStatement.executeUpdate();

            DBConnection.close(preparedStatement);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result != 0;
    }

    @Override
    public boolean delete(DomainObject domainObject) throws Exception {
        Product product = (Product) domainObject;
        String deleteProductById = "DELETE FROM public.product WHERE product_id = ?";
        int result = 0;

        PreparedStatement preparedStatement = DBConnection.prepare(deleteProductById);
        preparedStatement.setString(1, product.getProductId());
        result = preparedStatement.executeUpdate();

        DBConnection.close(preparedStatement);
        return result != 0;
    }


    @Override
    public boolean update(DomainObject domainObject) throws Exception {
        Product product = (Product) domainObject;
        String updateProductById = "UPDATE public.product SET " +
                "product_name=?, info=?, price=?, weight=?, created_at=?, category_id=?" +
                "WHERE product_id=?";
        int result = 0;

        PreparedStatement preparedStatement = DBConnection.prepare(updateProductById);
        preparedStatement.setString(1,product.getProductName());
        preparedStatement.setString(2, product.getInfo());
        preparedStatement.setDouble(3, product.getPrice());
        preparedStatement.setInt(4,product.getWeight());
        preparedStatement.setTimestamp(5, new Timestamp(product.getCreatedAt().getTime()));
        preparedStatement.setInt(6, product.getCategoryId());
        preparedStatement.setString(7, product.getProductId());
        result = preparedStatement.executeUpdate();

        DBConnection.close(preparedStatement);
        return result!=0;
    }

    public List<Product> findProductByCategory(Category category){
        String findProductByCategoryId = "SELECT * FROM public.product WHERE category_id = ?";
        List<Product> result = new ArrayList<>();

        try{
            PreparedStatement preparedStatement = DBConnection.prepare(findProductByCategoryId);
            preparedStatement.setString(1,category.getCategoryId());
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                Product product1 = new Product();

                product1.setProductId(resultSet.getString(1));
                product1.setProductName(resultSet.getString(2));
                product1.setInfo(resultSet.getString(3));
                product1.setPrice(resultSet.getDouble(4));
                product1.setWeight(resultSet.getInt(5));
                product1.setCreatedAt(resultSet.getTimestamp(6));
                product1.setCategoryId(resultSet.getInt(7));

                result.add(product1);
            }
            DBConnection.close(preparedStatement);
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }


}
