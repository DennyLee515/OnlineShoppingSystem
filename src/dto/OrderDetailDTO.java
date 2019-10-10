package dto;

import com.google.gson.Gson;

/**
 * @program: CoffeeWeb
 * @description:
 * @author: DennyLee
 * @create: 2019-10-09 23:04
 **/
public class OrderDetailDTO {


    private ProductDTO product;

    private  int amount;

    private CategoryDTO category;

    public ProductDTO getProduct() {
        return product;
    }

    public void setProduct(ProductDTO product) {
        this.product = product;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public CategoryDTO getCategory() {
        return category;
    }

    public void setCategory(CategoryDTO category) {
        this.category = category;
    }

    public static String serialize(OrderDetailDTO orderDetailDTO){
        Gson gson = new Gson();
        return gson.toJson(orderDetailDTO);

    }

    public static OrderDetailDTO deserialize(String jsonString){
        Gson gson = new Gson();
        return gson.fromJson(jsonString, OrderDetailDTO.class);
    }
}
