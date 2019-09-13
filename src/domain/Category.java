package domain;/**
 * Created by DennyLee on 2019/9/1.
 */

import java.util.UUID;

/**
 * @program: CoffeeWeb
 * @description: Category of the product
 * @author: DennyLee
 * @create: 2019-09-01 23:23
 **/
public class Category extends DomainObject {

    //category id
    private String categoryId;
    //category name
    private String categoryName;

    //instructor
    public Category() {
    }

    //instructor with category name
    public Category(String categoryName) {
        this.categoryId = UUID.randomUUID().toString();
        this.categoryName = categoryName;
    }

    //getter and setter methods
    @Override
    public String getId() {
        return categoryId;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
