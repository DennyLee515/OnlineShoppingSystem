package Mapper;

import Domain.Category;
import Domain.DomainObject;
import Util.DBConnection;

import java.sql.PreparedStatement;

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
        String insertNewCategory = "INSERT INTO public.category" +
                "（category_id, category_name)" +
                "VALUES (?,?)";
        int result = 0;

        PreparedStatement preparedStatement = DBConnection.prepare(insertNewCategory);
        preparedStatement.setString(1, category.getCategoryId());
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
        preparedStatement.setString(1, category.getCategoryId());
        result = preparedStatement.executeUpdate();

        return result != 0;
    }

    @Override
    public boolean update(DomainObject domainObject) throws Exception {
        Category category = (Category) domainObject;
        String updateCategoryById = "UPDATE public.category SET" +
                "category_name=? WHERE category_id = ?";
        int result = 0;

        PreparedStatement preparedStatement = DBConnection.prepare(updateCategoryById);
        preparedStatement.setString(1,category.getCategoryName());
        preparedStatement.setString(2,category.getCategoryId());
        result = preparedStatement.executeUpdate();

        DBConnection.close(preparedStatement);
        return result!= 0;
    }


}
