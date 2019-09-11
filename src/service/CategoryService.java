package service;

import domain.Category;
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
    public CategoryService(){
        categoryMapper = new CategoryMapper();
    }

    public List<Category> getAllCategories(){
        return categoryMapper.findAll();
    }

    public Category getCategroyById(Category category) throws Exception{
        IdentityMap<Category> identityMap = new IdentityMap<>();
        Category categoryFinded = identityMap.get(category.getId());

        if (categoryFinded != null){
            return categoryFinded;
        }

        return categoryMapper.findCategoryById(category);
    }

    public boolean insertCategory(Category category) {

        try {
            Category cateFinded = (Category) categoryMapper.findCategoryByName(category.getCategoryName());
            Boolean result;

            // find cate by name; if exist , Mapper  update
        if (cateFinded != null) {
            cateFinded.setCategoryName(category.getCategoryName());
            result = updateCategory(cateFinded);
        }
            // if not exist, new cate obj, Mapper insert
        else {
            Category newCate = category;
            result = insertCategory(category);
        }
        return result;
        }
             // catch fail add, prompt->
        catch (Exception e){
            System.out.println("Fail to add the new category.");
            return false;
        }
    }

    public boolean updateCategory(Category category){
        return false;
    }

    public boolean deleteCategory(Category category){
        return false;
    }
}
