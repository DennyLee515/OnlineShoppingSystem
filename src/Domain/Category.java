package Domain;/**
 * Created by DennyLee on 2019/9/1.
 */

/**
 * @program: CoffeeWeb
 * @description: Category
 * @author: DennyLee
 * @create: 2019-09-01 23:23
 **/
public class Category extends DomainObject {

    private int categoryId;
    private String categoryName;

    public Category() {
    }

    public Category(int categoryId, String categoryName) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
