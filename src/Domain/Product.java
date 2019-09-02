package Domain;/**
 * Created by DennyLee on 2019/9/1.
 */

import java.util.Date;
import java.util.UUID;

/**
 * @program: CoffeeWeb
 * @description: Product
 * @author: DennyLee
 * @create: 2019-09-01 20:11
 **/
public class Product extends DomainObject{
    private String productId;
    private String productName;
    private String info;
    private double price;
    private int weight;
    private Date createdAt;
    public Product() {
    }

    public Product(String pName, String info, double price, int weight) {
        this.productId = UUID.randomUUID().toString();
        this.productName = pName;
        this.info = info;
        this.price = price;
        this.weight = weight;
        this.createdAt = new Date();
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
