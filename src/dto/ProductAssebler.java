package dto;

import domain.Category;
import domain.Product;
import service.CategoryService;
import service.ProductService;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
        result.setCreatedAt(product.getCreatedAt());
        result.setInventory(product.getInventory());
        List<Category> categories = new CategoryService().findCategoryByProduct(product);
        List<CategoryDTO> categoryDTOs = new ArrayList<>();
        for (Category category: categories
             ) {
            categoryDTOs.add(CategoryAssembler.createCategoryDTO(category));
        }
        result.setCategoryDTO(categoryDTOs);
        return result;
    }

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
