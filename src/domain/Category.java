package domain;/**
 * Created by DennyLee on 2019/9/1.
 */

import java.util.UUID;

/**
 * @program: CoffeeWeb
 * @description: Category
 * @author: DennyLee
 * @create: 2019-09-01 23:23
 **/
public class Category extends DomainObject {

    private String categoryId;
    private String categoryName;

    public Category() {
    }

    public Category(String categoryName) {
        this.categoryId = UUID.randomUUID().toString();
        this.categoryName = categoryName;
    }

    @Override
    public String getId() {
        return categoryId;
    }

    public String getCategoryId(){return categoryId;}

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
