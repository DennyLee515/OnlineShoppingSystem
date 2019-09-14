package service;

import domain.Category;
import domain.Product;
import mapper.CategoryMapper;
import util.IdentityMap;
import util.UnitOfWork;

import java.util.List;

/**
 * @program: CoffeeWeb
 * @description:
 * @author: DennyLee
 * @create: 2019-09-06 22:47
 **/
public class CategoryService {
    private CategoryMapper categoryMapper;

    public CategoryService() {
        categoryMapper = new CategoryMapper();
    }

    public List<Category> getAllCategories() {
        return categoryMapper.getAllCategories();
    }

    public Category findCategroyById(Category category) {
        IdentityMap<Category> identityMap = new IdentityMap<>();
        Category categoryFinded = identityMap.get(category.getId());

        if (categoryFinded != null) {
            return categoryFinded;
        } else {
            return categoryMapper.findCategoryById(category);
        }

    }

    public Category findCategoryByName(Category category) {
        return categoryMapper.findCategoryByName(category);
    }


    public boolean insertCategory(Category category) {
        UnitOfWork.newCurrent();
        UnitOfWork.getCurrent().registerNew(category);
        return UnitOfWork.getCurrent().commit();
    }

    public boolean updateCategory(Category category) {
        UnitOfWork.newCurrent();
        UnitOfWork.getCurrent().registerDirty(category);
        return UnitOfWork.getCurrent().commit();
    }

    public boolean deleteCategory(Category category) {
        UnitOfWork.newCurrent();
        UnitOfWork.getCurrent().registerDelete(category);
        return UnitOfWork.getCurrent().commit();
    }

    public List<Category> findCategoryByProduct(Product product) {
            return categoryMapper.findCategoryByProduct(product);
    }

}
