package service;

import domain.Category;
import domain.Product;
import mapper.CategoryMapper;
import util.IdentityMap;

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
        try {
            return categoryMapper.getAllCategories();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Category findCategroyById(Category category) {
        try {
            IdentityMap<Category> identityMap = new IdentityMap<>();
            Category categoryFinded = identityMap.get(category.getId());

            if (categoryFinded != null) {
                return categoryFinded;
            } else {
                return categoryMapper.findCategoryById(category);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Category findCategoryByName(Category category) {
        try {
            return categoryMapper.findCategoryByName(category);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    public boolean insertCategory(Category category) {
        try {
            Category cateFinded = findCategoryByName(category);

            if (cateFinded == null) {
                return categoryMapper.insert(category);
            }

        } catch (Exception e) {
            System.out.println("Fail to add the new category.");
        }
        return false;
    }

    public boolean updateCategory(Category category) {

        boolean result;
        try {
            result = categoryMapper.update(category);
            return result;
        } catch (Exception e) {
            System.out.println("Fail to update category.");
            return false;
        }
    }

    public boolean deleteCategory(Category category) {
        boolean result;
        try {
            result = categoryMapper.delete(category);
            return result;
        } catch (Exception e) {
            System.out.println("Fail to delete category.");
            return false;
        }
    }

    public List<Category> findCategoryByProduct(Product product){
        try {
            return categoryMapper.findCategoryByProduct(product);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
