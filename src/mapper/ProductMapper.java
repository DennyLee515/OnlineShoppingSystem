package mapper;

import domain.Category;
import domain.DomainObject;
import domain.Product;
import util.DBConnection;
import util.IdentityMap;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
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
            preparedStatement.setString(1, product.getId());
            preparedStatement.setString(2, product.getProductName());
            preparedStatement.setString(3, product.getInfo());
            preparedStatement.setDouble(4, product.getPrice());
            preparedStatement.setInt(5, product.getWeight());
            preparedStatement.setTimestamp(6, new Timestamp(new Date().getTime()));
            preparedStatement.setString(7, product.getCategory().getId());
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
        preparedStatement.setString(1, product.getId());
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
        preparedStatement.setString(1, product.getProductName());
        preparedStatement.setString(2, product.getInfo());
        preparedStatement.setDouble(3, product.getPrice());
        preparedStatement.setInt(4, product.getWeight());
        preparedStatement.setTimestamp(5, new Timestamp(product.getCreatedAt().getTime()));
        preparedStatement.setString(6, product.getCategory().getId());
        preparedStatement.setString(7, product.getId());
        result = preparedStatement.executeUpdate();

        DBConnection.close(preparedStatement);
        return result != 0;
    }

    public List<Product> findProductByCategory(Category category) {
        String findProductByCategoryId = "SELECT * FROM public.product WHERE category_id = ?";
        List<Product> result = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = DBConnection.prepare(findProductByCategoryId);
            preparedStatement.setString(1, category.getId());
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Product product1 = new Product();
                IdentityMap<Product> identityMap = IdentityMap.getInstance(product1);

                product1.setProductId(resultSet.getString(1));
                product1.setProductName(resultSet.getString(2));
                product1.setInfo(resultSet.getString(3));
                product1.setPrice(resultSet.getDouble(4));
                product1.setWeight(resultSet.getInt(5));
                product1.setCreatedAt(resultSet.getTimestamp(6));
                Category category1 = new Category();
                category1.setCategoryId(resultSet.getString(7));
                CategoryMapper categoryMapper = new CategoryMapper();
                product1.setCategory(categoryMapper.findCategoryById(category1));

                identityMap.put(product1.getId(), product1);
                result.add(product1);
            }
            DBConnection.close(preparedStatement);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    public List<Product> findAll() {
        String findProduct = "SELECT * FROM public.product";
        List<Product> result = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = DBConnection.prepare(findProduct);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Product product1 = new Product();
                IdentityMap<Product> identityMap = IdentityMap.getInstance(product1);

                product1.setProductId(resultSet.getString(1));
                product1.setProductName(resultSet.getString(2));
                product1.setInfo(resultSet.getString(3));
                product1.setPrice(resultSet.getDouble(4));
                product1.setWeight(resultSet.getInt(5));
                product1.setCreatedAt(resultSet.getTimestamp(6));
                Category category1 = new Category();
                category1.setCategoryId(resultSet.getString(7));
                CategoryMapper categoryMapper = new CategoryMapper();
                product1.setCategory(categoryMapper.findCategoryById(category1));

                identityMap.put(product1.getId(), product1);
                result.add(product1);
            }
            DBConnection.close(preparedStatement);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public Product findProductById(Product product) {
        String findProductByCategoryId = "SELECT * FROM public.product WHERE product_id = ?";
        Product result = new Product();

        try {
            PreparedStatement preparedStatement = DBConnection.prepare(findProductByCategoryId);
            preparedStatement.setString(1, product.getId());
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {

                result.setProductId(resultSet.getString(1));
                result.setProductName(resultSet.getString(2));
                result.setInfo(resultSet.getString(3));
                result.setPrice(resultSet.getDouble(4));
                result.setWeight(resultSet.getInt(5));
                result.setCreatedAt(resultSet.getTimestamp(6));
                Category category1 = new Category();
                category1.setCategoryId(resultSet.getString(7));
                CategoryMapper categoryMapper = new CategoryMapper();
                result.setCategory(categoryMapper.findCategoryById(category1));
            } else {
                result = null;
            }
            DBConnection.close(preparedStatement);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<Product> findProductByName(String name) {
        String findProductByCategoryId = "SELECT * FROM public.product WHERE product_name = ?";
        List<Product> result = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = DBConnection.prepare(findProductByCategoryId);
            preparedStatement.setString(1, name);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Product product1 = new Product();
                IdentityMap<Product> identityMap = IdentityMap.getInstance(product1);

                product1.setProductId(resultSet.getString(1));
                product1.setProductName(resultSet.getString(2));
                product1.setInfo(resultSet.getString(3));
                product1.setPrice(resultSet.getDouble(4));
                product1.setWeight(resultSet.getInt(5));
                product1.setCreatedAt(resultSet.getTimestamp(6));
                Category category1 = new Category();
                category1.setCategoryId(resultSet.getString(7));
                CategoryMapper categoryMapper = new CategoryMapper();
                product1.setCategory(categoryMapper.findCategoryById(category1));

                identityMap.put(product1.getId(), product1);
                result.add(product1);
            }
            DBConnection.close(preparedStatement);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}

