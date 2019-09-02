package Domain;/**
 * Created by DennyLee on 2019/9/1.
 */

/**
 * @program: CoffeeWeb
 * @description:
 * @author: DennyLee
 * @create: 2019-09-01 23:30
 **/
public class Cart extends DomainObject {
    private int cartId;
    private Product product;
    private int productAmount;
    private double totalPrice;
}
