package mapper;

import domain.Category;
import domain.DomainObject;
import domain.Product;
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
public class CategoryMapper extends DataMapper {


    @Override
    public boolean insert(DomainObject domainObject) throws Exception {
        Category category = (Category) domainObject;
        String insertNewCategory = "INSERT INTO public.category " +
                "(category_id, category_name)" +
                "VALUES (?,?)";
        int result = 0;

        PreparedStatement preparedStatement = DBConnection.prepare(insertNewCategory);
        preparedStatement.setString(1, category.getId());
        preparedStatement.setString(2, category.getCategoryName());
        result = preparedStatement.executeUpdate();
        DBConnection.close(preparedStatement);

        return result != 0;
    }

    @Override
    public boolean delete(DomainObject domainObject) throws Exception {
        Category category = (Category) domainObject;
        String deletCategoryById = "DELETE FROM public.category WHERE category_id = ?";
        int result = 0;

        PreparedStatement preparedStatement = DBConnection.prepare(deletCategoryById);
        preparedStatement.setString(1, category.getId());
        result = preparedStatement.executeUpdate();

        return result != 0;
    }

    @Override
    public boolean update(DomainObject domainObject) throws Exception {
        Category category = (Category) domainObject;
        String updateCategoryById = "UPDATE public.category SET " +
                "category_name=? WHERE category_id = ?";
        int result = 0;

        PreparedStatement preparedStatement = DBConnection.prepare(updateCategoryById);
        preparedStatement.setString(1, category.getCategoryName());
        preparedStatement.setString(2, category.getId());
        result = preparedStatement.executeUpdate();

        DBConnection.close(preparedStatement);
        return result != 0;
    }

    public Category findCategoryById(DomainObject domainObject) throws Exception {
        Category category = (Category) domainObject;
        String findCategoryById = "SELECT * FROM public.category WHERE category_id = ?";

        PreparedStatement preparedStatement = DBConnection.prepare(findCategoryById);
        preparedStatement.setString(1, category.getId());
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            Category result = new Category();
            IdentityMap<Category> identityMap = IdentityMap.getInstance(result);
            result.setCategoryId(resultSet.getString(1));
            result.setCategoryName(resultSet.getString(2));
            identityMap.put(result.getId(), result);
            return result;
        } else {
            return null;
        }
    }


    public List<Category> findAll() throws Exception {
        String findCategoryById = "SELECT * FROM public.category";
        List<Category> result = new ArrayList<>();

        PreparedStatement preparedStatement = DBConnection.prepare(findCategoryById);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Category category1 = new Category();
            IdentityMap<Category> identityMap = IdentityMap.getInstance(category1);

            category1.setCategoryId(resultSet.getString(1));
            category1.setCategoryName(resultSet.getString(2));

            identityMap.put(category1.getId(), category1);
            result.add(category1);
        }
        return result;
    }


    public Category findCategoryByName(DomainObject domainObject) throws Exception {
        Category category = (Category)domainObject;
        String findCategoryByCategoryName = "SELECT * FROM public.category WHERE " +
                "category_name = ?";

        PreparedStatement preparedStatement =
                DBConnection.prepare(findCategoryByCategoryName);
        preparedStatement.setString(1, category.getCategoryName());
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            Category result = new Category();
            IdentityMap<Category> identityMap = IdentityMap.getInstance(result);

            result.setCategoryId(resultSet.getString(1));
            result.setCategoryName(resultSet.getString(2));

            //register it into identityMap
            identityMap.put(result.getId(), result);
            DBConnection.close(preparedStatement);
            return result;
        } else {
            DBConnection.close(preparedStatement);
            return null;
        }
    }

    public List<Category> findCategoryByProduct(DomainObject domainObject) throws Exception{
        Product product = (Product)domainObject;
        String findCategoryByProduct = "SELECT category_id FROM public.product_category WHERE " +
                "product_id = ?";
        PreparedStatement preparedStatement = DBConnection.prepare(findCategoryByProduct);
        preparedStatement.setString(1,product.getId());
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Category> result = new ArrayList<>();
        while (resultSet.next()){
            Category category = new Category();
            category.setCategoryId(resultSet.getString(1));

            result.add(findCategoryById(category));
        }
        return result;
    }

}
