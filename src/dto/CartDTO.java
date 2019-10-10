package dto;

import com.google.gson.Gson;

import java.util.List;

/**
 * @program: CoffeeWeb
 * @description:
 * @author: DennyLee
 * @create: 2019-10-10 00:35
 **/
public class CartDTO {
    private String cartId;

    private CustomerDTO customerDTO;

    private List<CartDetailDTO> cartDetailDTOs;

    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

    public CustomerDTO getCustomerDTO() {
        return customerDTO;
    }

    public void setCustomerDTO(CustomerDTO customerDTO) {
        this.customerDTO = customerDTO;
    }

    public static String serialize(CartDTO cartDTO){
        Gson gson = new Gson();
        return gson.toJson(cartDTO);

    }

    public List<CartDetailDTO> getCartDetailDTOs() {
        return cartDetailDTOs;
    }

    public void setCartDetailDTOs(List<CartDetailDTO> cartDetailDTOs) {
        this.cartDetailDTOs = cartDetailDTOs;
    }

    public static CartDTO deserialize(String jsonString){
        Gson gson = new Gson();
        return gson.fromJson(jsonString, CartDTO.class);
    }
}
