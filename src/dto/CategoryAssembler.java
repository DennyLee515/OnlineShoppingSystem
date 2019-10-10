package dto;


import domain.Category;
import service.CategoryService;

public class CategoryAssembler {

    public static CategoryDTO createCategoryDTO(Category category){
        CategoryDTO result = new CategoryDTO();
        result.setCategoryId(category.getCategoryId());
        result.setCategoryName(category.getCategoryName());
        return result;
    }


    public static boolean createCategory(CategoryDTO categoryDTO){
        Category category = new Category();

        category.setCategoryId(categoryDTO.getCategoryId());
        category.setCategoryName(categoryDTO.getCategoryName());

        return new CategoryService().newCategory(category);
    }

    public static boolean updateCategory(CategoryDTO categoryDTO){
        Category category = new Category();

        category.setCategoryId(categoryDTO.getCategoryId());
        category.setCategoryName(categoryDTO.getCategoryName());

        return new CategoryService().updateCategory(category);
    }

    public static boolean deleteCategory(CategoryDTO categoryDTO){
        Category category = new Category();

        category.setCategoryId(categoryDTO.getCategoryId());
        category.setCategoryName(categoryDTO.getCategoryName());

        return new CategoryService().deleteCategory(category);
    }

}
