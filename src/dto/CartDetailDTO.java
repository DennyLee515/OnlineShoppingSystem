package dto;

import com.google.gson.Gson;
import domain.Cart;
import domain.Category;

/**
 * @program: CoffeeWeb
 * @description:
 * @author: DennyLee
 * @create: 2019-10-10 00:36
 **/
public class CartDetailDTO {

    private String cartDetailId;

    private ProductDTO productDTO;

    private int amount;

    private double totalPrice;



    private CategoryDTO categoryDTO;

    public String getCartDetailId() {
        return cartDetailId;
    }

    public void setCartDetailId(String cartDetailId) {
        this.cartDetailId = cartDetailId;
    }

    public ProductDTO getProductDTO() {
        return productDTO;
    }

    public void setProductDTO(ProductDTO productDTO) {
        this.productDTO = productDTO;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public CategoryDTO getCategoryDTO() {
        return categoryDTO;
    }

    public void setCategoryDTO(CategoryDTO categoryDTO) {
        this.categoryDTO = categoryDTO;
    }

    public static String serialize(CategoryDTO categoryDTO){
        Gson gson = new Gson();
        return gson.toJson(categoryDTO);

    }

    public static CategoryDTO deserialize(String jsonString){
        Gson gson = new Gson();
        return gson.fromJson(jsonString, CategoryDTO.class);
    }
}
