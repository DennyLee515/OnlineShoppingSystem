package dto;

import domain.Product;
import service.ProductService;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: CoffeeWeb
 * @description:
 * @author: DennyLee
 * @create: 2019-10-09 13:45
 **/
public class ProductAssebler {

    public static ProductDTO createProductDTO(Product product){
        ProductDTO result = new ProductDTO();
        result.setProductName(product.getProductName());
        result.setProductId(product.getProductId());
        result.setInfo(product.getInfo());
        result.setPrice(product.getPrice());
        result.setWeight(product.getWeight());
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        result.setCreatedAt(sdf.format(product.getCreatedAt()));
        result.setInventory(product.getInventory());
        return result;
    }

//    private boolean writeCategory(CategoryDTO categoryDTO, Product product){
//        for (String category:
//             ) {
//
//        }
//    }
    public static boolean createProduct(ProductDTO productDTO){
        Product product = new Product();

        product.setProductId(productDTO.getProductId());
        product.setProductName(productDTO.getProductName());
        product.setInfo(productDTO.getInfo());
        product.setPrice(productDTO.getPrice());
        product.setWeight(productDTO.getWeight());
        product.setCreatedAt(new Date());
        product.setInventory(productDTO.getInventory());

        return new ProductService().insertProduct(product);
    }

    public static boolean updateProduct(ProductDTO productDTO){
        Product product = new Product();

        product.setProductId(productDTO.getProductId());
        product.setProductName(productDTO.getProductName());
        product.setInfo(productDTO.getInfo());
        product.setPrice(productDTO.getPrice());
        product.setWeight(productDTO.getWeight());
        product.setCreatedAt(new Date());
        product.setInventory(productDTO.getInventory());

        return new ProductService().updateProduct(product);
    }

    public static boolean deleteProduct(ProductDTO productDTO){
        Product product = new Product();

        product.setProductId(productDTO.getProductId());
        product.setProductName(productDTO.getProductName());
        product.setInfo(productDTO.getInfo());
        product.setPrice(productDTO.getPrice());
        product.setWeight(productDTO.getWeight());
        product.setCreatedAt(new Date());
        product.setInventory(productDTO.getInventory());

        return new ProductService().deleteProduct(product);
    }
}
