package dto;

import com.google.gson.Gson;
import domain.Product;

import java.util.Date;
import java.util.List;

public class ProductDTO {

    //product id
    private String productId;
    //product name
    private String productName;
    //product info
    private String info;
    //product price
    private double price;
    //product weight
    private int weight;
    //product create time
    private String createdAt;
    //product inventory
    private int inventory;

    private List<String> categories;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
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

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    public static String serialize(ProductDTO productDTO){
        Gson gson = new Gson();
        return gson.toJson(productDTO);

    }

    public static ProductDTO deserialize(String jsonString){
        Gson gson = new Gson();
        return gson.fromJson(jsonString, ProductDTO.class);
    }
}
