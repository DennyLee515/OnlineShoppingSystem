package dto;

import domain.Cart;
import domain.CartDetail;
import domain.Category;
import domain.Product;
import service.CartService;
import service.ProductService;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: CoffeeWeb
 * @description:
 * @author: DennyLee
 * @create: 2019-10-10 00:39
 **/
public class CartAssembler {
    public static CartDTO createCartDTO(Cart cart){
        CartDTO result = new CartDTO();
        result.setCartId(cart.getId());
        result.setCustomerDTO(CustomerAssembler.createCustomerDTO(cart.getCustomer()));
        List<CartDetail> cartDetails = new CartService().findCartDetailByCartId(cart);
        List<CartDetailDTO> cartDetailDTOs = new ArrayList<>();
        for (CartDetail cartDetail: cartDetails
             ) {
            cartDetailDTOs.add(createCartDetailDTO(cartDetail));
        }
        result.setCartDetailDTOs(cartDetailDTOs);
        return result;
    }

    private static CartDetailDTO createCartDetailDTO(CartDetail cartDetails){
        CartDetailDTO result = new CartDetailDTO();
        result.setCartDetailId(cartDetails.getId());
        result.setProductDTO(ProductAssebler.createProductDTO(cartDetails.getProduct()));
        result.setCategoryDTO(CategoryAssembler.createCategoryDTO(cartDetails.getCategory()));
        result.setAmount(cartDetails.getProductAmount());
        result.setTotalPrice(cartDetails.getTotalPrice());
        return result;
    }

    public static boolean addCartDetail(CartDTO cartDTO){
        Cart cart = new Cart();
        cart.setCartId(cartDTO.getCartId());
        cart = new CartService().findCartById(cart);
        List<CartDetailDTO> cartDetailDTOs = cartDTO.getCartDetailDTOs();
        boolean result= true;
        for (CartDetailDTO cartDetailDTO: cartDetailDTOs
        ) {
            CartDetail cartDetail = new CartDetail();
            cartDetail.setCartDetailId(cartDetailDTO.getCartDetailId());
            cartDetail.setCart(cart);
            Product product = new Product();
            product.setProductId(cartDetailDTO.getProductDTO().getProductId());
            cartDetail.setProduct(new ProductService().findProductByID(product));
            cartDetail.setProductAmount(cartDetailDTO.getAmount());
            cartDetail.setTotalPrice(cartDetailDTO.getTotalPrice());
            result = result && new CartService().insertCartDetail(cartDetail);
        }
        return result;
    }

    public static boolean updateCartDetail(CartDTO cartDTO){
        Cart cart = new Cart();
        cart.setCartId(cartDTO.getCartId());
        CartService cartService = new CartService();
        cart = cartService.findCartById(cart);
        boolean result= cartService.deleteAllCartDetails(cart);
        List<CartDetailDTO> cartDetailDTOs = cartDTO.getCartDetailDTOs();
        for (CartDetailDTO cartDetailDTO: cartDetailDTOs
        ) {
            CartDetail cartDetail = new CartDetail();
            cartDetail.setCartDetailId(cartDetailDTO.getCartDetailId());
            cartDetail.setCart(cart);
            Product product = new Product();
            product.setProductId(cartDetailDTO.getProductDTO().getProductId());
            cartDetail.setProduct(new ProductService().findProductByID(product));
            cartDetail.setProductAmount(cartDetailDTO.getAmount());
            cartDetail.setTotalPrice(cartDetailDTO.getTotalPrice());
            result = result && new CartService().insertCartDetail(cartDetail);
        }
        return result;
    }

}
